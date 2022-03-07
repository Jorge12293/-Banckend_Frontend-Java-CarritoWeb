/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelosDao;


import Conexion.Conexion;
import Interfaces.interfaceDetalle;
import Modelos.Detalle;
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
public class DetalleDao  implements interfaceDetalle{
    
    Conexion conexion = new Conexion();
    Connection connection;
    PreparedStatement ps;
    ResultSet rs;
    

    @Override
    public List listar() {
    
        List<Detalle> lista = new ArrayList<>();
        String sql="select * from detalles";
        try {
            connection = conexion.getConection();
            ps=connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                
                Detalle detll = new Detalle();
                detll.setIddetalle(rs.getInt("iddetalle"));
                detll.setIdfactura(rs.getInt("idfactura"));
                detll.setIdproducto(rs.getInt("idproducto"));  
                detll.setCantidad(rs.getInt("catidad"));
                detll.setPrecio(rs.getDouble("precio"));
               
                lista.add(detll);
            }
        } catch (SQLException e) {
            System.out.println("ERROR");
            System.out.println(e);
        }
        
        return lista;
        
    }

    @Override
    public Detalle list(int id) {
    
       String sql="select * from detalles where iddetalle="+id;
       Detalle detll = new Detalle();
       try {
            connection = conexion.getConection();
            ps=connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                
               detll.setIddetalle(rs.getInt("idpersona"));
               detll.setIdfactura(rs.getInt("idfactura"));
               detll.setIdproducto(rs.getInt("idproducto"));
               detll.setCantidad(rs.getInt("cantidad"));
               detll.setPrecio(rs.getDouble("precio"));
    
        
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return detll;
  
        
    }

    @Override
    public boolean add(Detalle det) {
   
        //java.sql.Date sqlDate = new java.sql.Date(per.getFechanacimiento().getTime());
   
        String sql ="insert into detalles(idfactura,idproducto,cantidad,precio) VALUES ('"+det.getIdfactura()+"','"+det.getIdproducto()+"','"+det.getCantidad()+"','"+det.getPrecio()+"')";
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
    public boolean edit(Detalle det) {
    
        String sql=" update detalles set  idfactura='"+det.getIdfactura()+"', idproducto='"+det.getIdproducto()+"', cantidad='"+det.getCantidad()+"', precio='"+det.getPrecio()+"' WHERE iddetalle="+det.getIddetalle();   
	     
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
    
        String sql ="delete from detalles where iddetalle="+id;
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
