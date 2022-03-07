/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelos.Detalle;
import java.util.List;


/**
 *
 * @author JORGE
 */
public interface interfaceDetalle {
     public List listar();
    public Detalle list(int id);
    public boolean add(Detalle det);
    public boolean edit(Detalle det);
     public boolean eliminar(int id);
}
