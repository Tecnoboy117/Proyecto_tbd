/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author josea
 */
public class Compradetalle {
   private int cantidad;
    private double precioc;
    private String cvproducto;
    private int cvcompra;

    // Constructor
    public Compradetalle(int cantidad, double precioc, String cvproducto, int cvcompra) {
        this.cantidad = cantidad;
        this.precioc = precioc;
        this.cvproducto = cvproducto;
        this.cvcompra = cvcompra;
    }

    // Getters y Setters
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioc() {
        return precioc;
    }

    public void setPrecioc(double precioc) {
        this.precioc = precioc;
    }

    public String getCvproducto() {
        return cvproducto;
    }

    public void setCvproducto(String cvproducto) {
        this.cvproducto = cvproducto;
    }

    public int getCvcompra() {
        return cvcompra;
    }

    public void setCvcompra(int cvcompra) {
        this.cvcompra = cvcompra;
    } 
}
