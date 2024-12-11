/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import conexion.Conexion;
import java.sql.SQLException;
import login.*;
import modelos.*;

/**
 *
 * @author danyv
 */
public class ControladorUsuarios {

    private Usuarios modeloU;
    private Login vistaL;
    private Conexion con;
    private AccesoR vistaR;
    // Contructor para la vista de login
    public ControladorUsuarios(Usuarios modeloU, Login vistaL) {
        this.modeloU = modeloU;
        this.vistaL = vistaL;
    }
    // Contructor para la vista de Reguistros
    public ControladorUsuarios(Usuarios modeloU, AccesoR vistaR) {
        this.modeloU = modeloU;
        this.vistaR = vistaR;
    }
    
    public boolean acceso() throws SQLException{
        modeloU.setUser(vistaL.getJuser());
        modeloU.setPassword(vistaL.getJpass());
        if(Usuarios.acceso(con.getConexion(), modeloU)){
            System.out.println("Se ingreso correctamente");
        }else{
            System.out.println("No se pudo ingresar");
        }
        return false;
    }
    
    public boolean registro() throws SQLException{
        modeloU.setUser(vistaR.getjUsuario());
        modeloU.setPassword(vistaR.getjPasswordCrea());
        if(Usuarios.agregarUsuario(con.getConexion(), modeloU)){
            System.out.println("Se registro usuario");
        }else{
            System.out.println("No se registro usuario");
        }
        return false;
    }
}
