/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;



import java.util.Date;
;
import java.util.Objects;

/**
 *
 * @author JORGE
 */
public class Factura  {

        
   private int idfactura;

    private Date fecha;
   
    private double subtotal;

    private double totalcompra;

    private String formapago;

    private int idusuario;
 

    public Factura() {
    }

    
    
    
    /**
     * @param idfactura the idfactura to set
     */
    public void setIdfactura(int idfactura) {
        this.idfactura = idfactura;
    }

    /**
     * @return the idusuario
     */
    public int getIdusuario() {
        return idusuario;
    }

    /**
     * @param idusuario the idusuario to set
     */
    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }



  

    public Factura (int idfactura, Date fecha, double subtotal, double totalcompra, String formapago) {
        this.idfactura = idfactura;
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.totalcompra = totalcompra;
        this.formapago = formapago;
    }

    public int getIdfactura() {
        return idfactura;
    }

    
    
  

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotalcompra() {
        return totalcompra;
    }

    public void setTotalcompra(double totalcompra) {
        this.totalcompra = totalcompra;
    }

    public String getFormapago() {
        return formapago;
    }

    public void setFormapago(String formapago) {
        this.formapago = formapago;
    }

   
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.getFecha());
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.getSubtotal()) ^ (Double.doubleToLongBits(this.getSubtotal()) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.getTotalcompra()) ^ (Double.doubleToLongBits(this.getTotalcompra()) >>> 32));
        hash = 59 * hash + Objects.hashCode(this.getFormapago());
        hash = 59 * hash + Objects.hashCode(this.getIdusuario());
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
        final Factura other = (Factura) obj;
        if (Double.doubleToLongBits(this.getSubtotal()) != Double.doubleToLongBits(other.getSubtotal())) {
            return false;
        }
        if (Double.doubleToLongBits(this.getTotalcompra()) != Double.doubleToLongBits(other.getTotalcompra())) {
            return false;
        }
        if (!Objects.equals(this.formapago, other.formapago)) {
            return false;
        }
        if (!Objects.equals(this.idfactura, other.idfactura)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.idusuario, other.idusuario)) {
            return false;
        }
   
        return true;
    }

    @Override
    public String toString() {
        return "Factura{" + ", fecha=" + getFecha() + ", subtotal=" + getSubtotal() + ", totalcompra=" + getTotalcompra() + ", formapago=" + getFormapago() + ", idusuario=" + getIdusuario() + '}';
    }

    
    

}
