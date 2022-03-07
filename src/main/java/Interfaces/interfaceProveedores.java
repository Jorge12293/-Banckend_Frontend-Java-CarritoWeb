/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelos.Proveedor;
import java.util.List;


/**
 *
 * @author JORGE
 */
public interface interfaceProveedores {
    public List listar();
    public Proveedor getProveedor(int id);
    public boolean add(Proveedor prove);
    public boolean edit(Proveedor prove);
     public boolean eliminar(int id);
}
