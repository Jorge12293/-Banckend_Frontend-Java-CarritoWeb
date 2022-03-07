/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelos.Factura;
import java.util.List;


/**
 *
 * @author JORGE
 */
public interface interfaceFactura {
    public List listar();
    public Factura list(int id);
    public boolean add(Factura fact);
    public boolean edit(Factura fact);
     public boolean eliminar(int id);
}
