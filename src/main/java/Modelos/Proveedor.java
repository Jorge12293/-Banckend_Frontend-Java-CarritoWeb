/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;


import java.util.Objects;


/**
 *
 * @author JORGE
 */
public class Proveedor  {
    
    private int idproveedor;
    private String nombre;
    private String direccion;

    

    public Proveedor() {
    }

    public Proveedor(int idproveedor, String nombre, String direccion) {
        this.idproveedor = idproveedor;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.idproveedor;
        hash = 67 * hash + Objects.hashCode(this.nombre);
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
        final Proveedor other = (Proveedor) obj;
        if (this.idproveedor != other.idproveedor) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "idproveedor=" + idproveedor + ", nombre=" + nombre + ", direccion=" + direccion + '}';
    }

 

    

   


    



  
    
}
