/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author josea
 */
public class Producto {
    private String cvproducto;
    private String nombre;
    private String marca;
    private int existencias;
    private double preciov;
    private double precioc;
    private double preciovo;
    private int estado;
    private int oferta;

    // Constructor
    public Producto(String cvproducto, String nombre, String marca, int existencias, double preciov, double precioc, double preciovo, int estado, int oferta) {
        this.cvproducto = cvproducto;
        this.nombre = nombre;
        this.marca = marca;
        this.existencias = existencias;
        this.preciov = preciov;
        this.precioc = precioc;
        this.preciovo = preciovo;
        this.estado = estado;
        this.oferta = oferta;
    }

    // Getters y Setters
    public String getCvproducto() {
        return cvproducto;
    }

    public void setCvproducto(String cvproducto) {
        this.cvproducto = cvproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public double getPreciov() {
        return preciov;
    }

    public void setPreciov(double preciov) {
        this.preciov = preciov;
    }

    public double getPrecioc() {
        return precioc;
    }

    public void setPrecioc(double precioc) {
        this.precioc = precioc;
    }

    public double getPreciovo() {
        return preciovo;
    }

    public void setPreciovo(double preciovo) {
        this.preciovo = preciovo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getOferta() {
        return oferta;
    }

    public void setOferta(int oferta) {
        this.oferta = oferta;
    }

}
