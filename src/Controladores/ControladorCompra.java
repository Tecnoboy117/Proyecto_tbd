/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import conexion.Conexion;
import vistas.ProductosT;

/**
 *
 * @author danyv
 */
public class ControladorCompra {
    private ProductosT sistema;
    private Conexion con;

    public ControladorCompra(ProductosT sistema) {
        this.sistema = sistema;
    }
}
