/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelos.Empresa;
import java.util.List;


/**
 *
 * @author JORGE
 */
public interface interfaceEmpresa {
    public List listar();
    public Empresa list(int id);
    public boolean add(Empresa emp);
    public boolean edit(Empresa emp);
     public boolean eliminar(int id); 
}
