/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;


import java.util.Date;
import java.util.List;
import java.util.Objects;


/**
 *
 * @author JORGE
 */
public class Empresa {
    
    private int idempresa;

    private String nombre;

    private String ruc;

    private String direccion;

    private String email;

    private String telefono;

    private Date horaabre;

    private Date horacierra;

    private String logo;


    public Empresa() {
    }

    public Empresa(Integer idempresa) {
        this.idempresa = idempresa;
    }

    public Empresa(Integer idempresa, String nombre, String ruc, String direccion, String email, String telefono, Date horaabre, Date horacierra, String logo) {
        this.idempresa = idempresa;
        this.nombre = nombre;
        this.ruc = ruc;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
        this.horaabre = horaabre;
        this.horacierra = horacierra;
        this.logo = logo;
    }

    public Integer getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Integer idempresa) {
        this.idempresa = idempresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getHoraabre() {
        return horaabre;
    }

    public void setHoraabre(Date horaabre) {
        this.horaabre = horaabre;
    }

    public Date getHoracierra() {
        return horacierra;
    }

    public void setHoracierra(Date horacierra) {
        this.horacierra = horacierra;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

 
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.idempresa;
        hash = 23 * hash + Objects.hashCode(this.nombre);
        hash = 23 * hash + Objects.hashCode(this.ruc);
        hash = 23 * hash + Objects.hashCode(this.direccion);
        hash = 23 * hash + Objects.hashCode(this.email);
        hash = 23 * hash + Objects.hashCode(this.telefono);
        hash = 23 * hash + Objects.hashCode(this.horaabre);
        hash = 23 * hash + Objects.hashCode(this.horacierra);
        hash = 23 * hash + Objects.hashCode(this.logo);
 
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
        final Empresa other = (Empresa) obj;
        if (this.idempresa != other.idempresa) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.ruc, other.ruc)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        if (!Objects.equals(this.logo, other.logo)) {
            return false;
        }
        if (!Objects.equals(this.horaabre, other.horaabre)) {
            return false;
        }
        if (!Objects.equals(this.horacierra, other.horacierra)) {
            return false;
        }
     
        return true;
    }



    @Override
    public String toString() {
        return "models.Empresa[ idempresa=" + idempresa + " ]";
    }
    
}
