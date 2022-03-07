/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelosDao;


import Conexion.Conexion;
import Interfaces.interfaceFactura;
import Modelos.Factura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author JORGE
 */
public class FacturaDao implements interfaceFactura {
    
    Conexion conexion = new Conexion();
    Connection connection;
    PreparedStatement ps;
    ResultSet rs;
    

    @Override
    public List listar() {
    
        List<Factura> lista = new ArrayList<>();
        String sql="select * from facturas";
        try {
            connection = conexion.getConection();
            ps=connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                
                Factura fact = new Factura();
                fact.setIdfactura(rs.getInt("idfactura"));
                fact.setIdusuario(rs.getInt("idusuario"));
                fact.setFecha(rs.getDate("fecha"));  
                fact.setSubtotal(rs.getDouble("subtotal"));
                fact.setTotalcompra(rs.getDouble("totalcompra"));
                fact.setFormapago(rs.getString("formapago"));
               
                lista.add(fact);
            }
        } catch (SQLException e) {
            System.out.println("ERROR");
            System.out.println(e);
        }
        
        return lista;
        
    }

    @Override
    public Factura list(int id) {
    
        String sql="select * from facturas where idfactura="+id;
       Factura fact = new Factura();
       try {
            connection = conexion.getConection();
            ps=connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                
               fact.setIdfactura(rs.getInt("idfactura"));
               fact.setIdusuario(rs.getInt("idusuario"));
               fact.setFecha(rs.getDate("fecha"));
               fact.setSubtotal(rs.getDouble("subtotal"));
               fact.setTotalcompra(rs.getDouble("totalcompra"));
               fact.setFormapago(rs.getString("formapago"));
    
        
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return fact;
        
        
    }

    @Override
    public boolean add(Factura fact) {
    
        String sql ="insert into facturas(idusuario,fecha,subtotal,totalcompra,formapago) VALUES ('"+fact.getIdusuario()+"','"+fact.getFecha()+"','"+fact.getSubtotal()+"','"+fact.getTotalcompra()+"','"+fact.getFormapago()+"')";                                                              
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
    
    
     public int addId(Factura fact) {
        int idFactura = 0;
        String sql ="insert into facturas(idusuario,fecha,subtotal,totalcompra,formapago) VALUES ('"+fact.getIdusuario()+"','"+fact.getFecha()+"','"+fact.getSubtotal()+"','"+fact.getTotalcompra()+"','"+fact.getFormapago()+"')";                                                              
        try {
            connection = conexion.getConection();
            ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            int affectedRows = ps.executeUpdate();
        
           if (affectedRows == 0) {
               throw new SQLException("Creating user failed, no rows affected.");
           }

           try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
               if (generatedKeys.next()) {
                   idFactura=generatedKeys.getInt(1);
               }
               else {
                   throw new SQLException("Creating user failed, no ID obtained.");
               }
           }
            
            
        } catch (SQLException e) {
             System.out.println(e);
             return 0;
        }
        
        return idFactura;

    }
     
     


    @Override
    public boolean edit(Factura fact) {
    
       String sql=" update facturas set  idusuario='"+fact.getIdusuario()+"', fecha='"+fact.getFecha()+"', subtotal='"+fact.getSubtotal()+"', totalcompra='"+fact.getTotalcompra()+"', formapago='"+fact.getFormapago()+"' WHERE idfactura="+fact.getIdfactura();   
	     
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
    
         String sql ="delete from facturas where idfactura="+id;
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
