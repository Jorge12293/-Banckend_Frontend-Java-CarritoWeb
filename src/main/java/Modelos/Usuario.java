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
public class Usuario{
    
    private int idusuario;
    private String password;
    private String nivel;
    private int idempresa;
    private int idpersona;

    public Usuario() {
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(int idempresa) {
        this.idempresa = idempresa;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }


    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.getIdusuario();
        hash = 47 * hash + Objects.hashCode(this.getPassword());
        hash = 47 * hash + Objects.hashCode(this.getNivel());
        hash = 47 * hash + Objects.hashCode(this.getIdempresa());
        hash = 47 * hash + Objects.hashCode(this.getIdpersona());
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
        final Usuario other = (Usuario) obj;
        if (this.getIdusuario() != other.getIdusuario()) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.nivel, other.nivel)) {
            return false;
        }
        if (!Objects.equals(this.idempresa, other.idempresa)) {
            return false;
        }
        if (!Objects.equals(this.idpersona, other.idpersona)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idusuario=" + idusuario + ", password=" + password + ", nivel=" + nivel + ", idempresa=" + idempresa + ", idpersona=" + idpersona + '}';
    }

       
}
