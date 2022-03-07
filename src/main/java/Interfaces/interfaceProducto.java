/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelos.Producto;
import java.util.List;

/**
 *
 * @author JORGE
 */
public interface interfaceProducto {
    public List listar();
    public List filtrar(String busqueda);
    public Producto getProducto(int id);
    public boolean add(Producto prod);
    public boolean edit(Producto prod);
    public boolean eliminar(int id);
}
