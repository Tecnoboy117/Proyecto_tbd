/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.util.Date;

/**
 *
 * @author josea
 */
public class Compra {
private int cvcompra;
    private Date fecha;
    private double total;
    private double subtotal;
    private double iva;
    private int estado;

    // Constructor
    public Compra(int cvcompra, Date fecha, double total, double subtotal, double iva, int estado) {
        this.cvcompra = cvcompra;
        this.fecha = fecha;
        this.total = total;
        this.subtotal = subtotal;
        this.iva = iva;
        this.estado = estado;
    }

    // Getters y Setters
    public int getCvcompra() {
        return cvcompra;
    }

    public void setCvcompra(int cvcompra) {
        this.cvcompra = cvcompra;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
