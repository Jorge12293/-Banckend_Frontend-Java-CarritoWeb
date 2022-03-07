/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author JORGE
 */
public class Producto {
    
    private int idproducto;
    private String nombre;
    private String modelo;
    private String color;
    private String foto;
    private String categoria;
    private String origen;
    private double precio;  
    private int stock;  
    private int idproveedor;

    public Producto() {
    }
    
    public Producto(int idproducto, String nombre, String modelo, String color, String foto, String categoria, String origen, double precio, int stock, int idproveedor) {
        this.idproducto = idproducto;
        this.nombre = nombre;
        this.modelo = modelo;
        this.color = color;
        this.foto = foto;
        this.categoria = categoria;
        this.origen = origen;
        this.precio = precio;
        this.stock = stock;
        this.idproveedor = idproveedor;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    @Override
    public String toString() {
        return "Producto{" + "idproducto=" + idproducto + ", nombre=" + nombre + ", modelo=" + modelo + ", color=" + color + ", foto=" + foto + ", categoria=" + categoria + ", origen=" + origen + ", precio=" + precio + ", stock=" + stock + ", idproveedor=" + idproveedor + '}';
    }

   
    
    
}
