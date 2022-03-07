/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelosDao;


import Conexion.Conexion;
import Interfaces.interfaceProveedores;
import Modelos.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author JORGE
 */
public class ProveedoresDao implements interfaceProveedores {

    Conexion conexion = new Conexion();
    Connection connection;
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public List listar() {
        List<Proveedor> lista = new ArrayList<>();
        String sql="select * from proveedores";
        try {
            connection = conexion.getConection();
            ps=connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                
                Proveedor prov = new Proveedor();
                prov.setIdproveedor(rs.getInt("idproveedor"));
                prov.setNombre(rs.getString("nombre"));
                prov.setDireccion(rs.getString("direccion"));
               
                lista.add(prov);
            }
        } catch (SQLException e) {
            System.out.println("ERROR EN LISTAR PROVEEDORES "+e);
            return lista;
        }
        
        return lista;
    }

    @Override
    public Proveedor getProveedor(int id) {
    
       String sql="select * from proveedores where idproveedor="+id;
       Proveedor prov = new Proveedor();
       try {
            connection = conexion.getConection();
            ps=connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                
               prov.setIdproveedor(rs.getInt("idproveedor"));
               prov.setNombre(rs.getString("nombre"));
               prov.setDireccion(rs.getString("direccion"));
        
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return prov;
        
    }

    @Override
    public boolean add(Proveedor prove) {
    
        String sql ="insert into proveedores(nombre,direccion) VALUES ('"+prove.getNombre()+"','"+prove.getDireccion()+"')";                                                              
        try {
            connection = conexion.getConection();
            ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
             System.out.println(e);
             return false;
        }
        return true;
        
        
    }

    @Override
    public boolean edit(Proveedor prove) {
    
       String sql=" update proveedores set  nombre='"+prove.getNombre()+"', direccion='"+prove.getDireccion()+"'  WHERE idproveedor="+prove.getIdproveedor();   
	     
        try {
            connection = conexion.getConection();
            ps= connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
             System.out.println(e);
             return false;
        }
        return true;
        
    }

    @Override
    public boolean eliminar(int id) {
        String sql ="delete from proveedores where idproveedor="+id;
         try {
            connection = conexion.getConection();
            ps= connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
             System.out.println(e);
             return false;
        }
        return true;    
    }
    
}
