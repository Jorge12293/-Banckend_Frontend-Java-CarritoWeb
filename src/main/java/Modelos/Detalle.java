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
public class Detalle {

 
    private int  iddetalle;
    private int cantidad;
    private double precio;
    private int idfactura;
    private int idproducto;

    public Detalle() {
    }

    public Detalle(int iddetalle) {
        this.iddetalle = iddetalle;
    }

    public Detalle(int iddetalle, int cantidad, double precio) {
        this.iddetalle = iddetalle;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Detalle(int iddetalle, int cantidad, double precio, int idfactura, int idproducto) {
        this.iddetalle = iddetalle;
        this.cantidad = cantidad;
        this.precio = precio;
        this.idfactura = idfactura;
        this.idproducto = idproducto;
    }

    public int getIddetalle() {
        return iddetalle;
    }

    public void setIddetalle(int iddetalle) {
        this.iddetalle = iddetalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(int idfactura) {
        this.idfactura = idfactura;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.iddetalle;
        hash = 79 * hash + this.cantidad;
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
        hash = 79 * hash + this.idfactura;
        hash = 79 * hash + this.idproducto;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Detalle other = (Detalle) obj;
        if (this.iddetalle != other.iddetalle) {
            return false;
        }
        if (this.cantidad != other.cantidad) {
            return false;
        }
        if (Double.doubleToLongBits(this.precio) != Double.doubleToLongBits(other.precio)) {
            return false;
        }
        if (this.idfactura != other.idfactura) {
            return false;
        }
        if (this.idproducto != other.idproducto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Detalle{" + "iddetalle=" + iddetalle + ", cantidad=" + cantidad + ", precio=" + precio + ", idfactura=" + idfactura + ", idproducto=" + idproducto + '}';
    }




  
    
}
