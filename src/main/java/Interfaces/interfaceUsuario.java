/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelos.Usuario;
import java.util.List;

/**
 *
 * @author JORGE
 */
public interface interfaceUsuario {
    public List listar();
    public Usuario getUsuario(int id);
    public boolean add(Usuario usu);
    public boolean edit(Usuario usu);
   public boolean eliminar(int id);
   public Usuario loguear (String pass, String coorreo);


   
}
