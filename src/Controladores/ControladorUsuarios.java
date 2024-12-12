/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import vistas.Login;
import vistas.AccesoR;
import conexion.Conexion;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelos.*;
import vistas.ProductosT;

/**
 *
 * @author danyv
 */
public class ControladorUsuarios {


    private Login vistaL;
    private Conexion con;
    private AccesoR vistaR;
    // Contructor para la vista de login
    public ControladorUsuarios(Login vistaL) {
        this.vistaL = vistaL;
    }
    // Contructor para la vista de Reguistros
    public ControladorUsuarios(AccesoR vistaR) {
        this.vistaR = vistaR;
    }
    
    public boolean acceso() throws SQLException{
        Usuarios modeloU = new Usuarios();
        modeloU.setUser(vistaL.getJuser());
        modeloU.setPassword(vistaL.getJpass());
        return Usuarios.acceso(con.getConexion(), modeloU);
    }
    
    public boolean registro() throws SQLException{
        Usuarios modeloU = new Usuarios();
        modeloU.setUser(vistaR.getjUsuario());
        String passwordE = modeloU.encriptarPassword(vistaR.getjPasswordCrea());
        modeloU.setPassword(passwordE);
        if(Usuarios.agregarUsuario(con.getConexion(), modeloU)){
            JOptionPane.showMessageDialog(null, "Se registro usuario", "Registro autorizado", 1);
        }else{
            JOptionPane.showMessageDialog(null, "No se registro usuario", "Registro denegado", 1);
        }
        return false;
    }
}
