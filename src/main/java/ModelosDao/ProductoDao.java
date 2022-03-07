/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelosDao;

import Conexion.Conexion;
import Modelos.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Interfaces.interfaceProducto;

/**
 *
 * @author JORGE
 */
public class ProductoDao implements interfaceProducto{

    Conexion conexion = new Conexion();
    Connection connection;
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public List listar() {
        
        List<Producto> lista = new ArrayList<>();
        String sql="select * from productos";
        try {
            connection = conexion.getConection();
            ps=connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Producto prod = new Producto();
                prod.setIdproducto(rs.getInt("idproducto"));
                prod.setNombre(rs.getString("nombre"));
                prod.setModelo(rs.getString("modelo"));
                prod.setColor(rs.getString("color"));
                prod.setFoto(rs.getString("foto"));
                prod.setCategoria(rs.getString("categoria"));
                prod.setOrigen(rs.getString("origen"));
                prod.setPrecio(rs.getDouble("precio"));
                prod.setStock(rs.getInt("stock"));
                prod.setIdproveedor(rs.getInt("idproveedor"));
                lista.add(prod);
            }
        } catch (SQLException e) {
            System.out.println("ERROR LISTAR PRODUCTO "+e);
        }
        return lista;
    }

    @Override
    public Producto getProducto(int id) {
       String sql="select * from productos where idproducto="+id;
       Producto prod = null;
       try {
            connection = conexion.getConection();
            ps=connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                prod = new Producto();
                prod.setIdproducto(rs.getInt("idproducto"));
                prod.setNombre(rs.getString("nombre"));
                prod.setModelo(rs.getString("modelo"));
                prod.setColor(rs.getString("color"));
                prod.setFoto(rs.getString("foto"));
                prod.setCategoria(rs.getString("categoria"));
                prod.setOrigen(rs.getString("origen"));
                prod.setPrecio(rs.getDouble("precio"));
                prod.setStock(rs.getInt("stock"));
                prod.setIdproveedor(rs.getInt("idproveedor"));
        
            }
        } catch (SQLException e) {
            System.out.println("ERROR GET PRODUCTO "+e);
            return null;
        }
        
        return prod;
    }

    @Override
    public boolean add(Producto prod) {
       
        String sql ="insert into productos(nombre,modelo,color,foto,categoria,origen,precio,stock,idproveedor) VALUES ('"+prod.getNombre()+"','"+prod.getModelo()+"','"+prod.getColor()+"','"+prod.getFoto()+"','"+prod.getCategoria()+"','"+prod.getOrigen()+"','"+prod.getPrecio()+"','"+prod.getStock()+"','"+prod.getIdproveedor()+"')"; 
        try {
            connection = conexion.getConection();
            ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
             System.out.println("ERROR ADD PRODUCTOS "+e);
             return false;
        }
        return true; 
    }

    @Override
    public boolean edit(Producto prod) {
        String sql=" update productos set  nombre='"+prod.getNombre()+"', modelo='"+prod.getModelo()+"', color='"+prod.getColor()+"', foto='"+prod.getFoto()+"', categoria='"+prod.getCategoria()+"', origen='"+prod.getOrigen()+"', precio='"+prod.getPrecio()+"', stock='"+prod.getStock()+"', idproveedor='"+prod.getIdproveedor()+"' WHERE idproducto="+prod.getIdproducto();   
        try {
            connection = conexion.getConection();
            ps= connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
             System.out.println("ERROR EDIT PRODUCTO "+e);
             return false;
        }
        return true;
   }

    @Override
    public boolean eliminar(int id) {
        String sql ="delete from productos where idproducto="+id;
        try {
            connection = conexion.getConection();
            ps= connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
             System.out.println("EROOR ELIMINAR PRODUCTO "+e);
             return false;
        }
        return true;  
    }
    @Override
    public List filtrar(String busqueda) {
       List<Producto> lista = new ArrayList<>();
       String sql="select * from productos where nombre like '%"+busqueda+"%' or modelo  like'%"+busqueda+"%' or color  like'%"+busqueda+"%'  or categoria  like'%"+busqueda+"%' ";

        try {
            connection = conexion.getConection();
            ps= connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Producto prod = new Producto();
                prod.setIdproducto(rs.getInt("idproducto"));
                prod.setNombre(rs.getString("nombre"));
                prod.setModelo(rs.getString("modelo"));
                prod.setColor(rs.getString("color"));
                prod.setFoto(rs.getString("foto"));
                prod.setCategoria(rs.getString("categoria"));
                prod.setOrigen(rs.getString("origen"));
                prod.setPrecio(rs.getDouble("precio"));
                prod.setStock(rs.getInt("stock"));
                prod.setIdproveedor(rs.getInt("idproveedor"));
                lista.add(prod);
            }
        } catch (SQLException e) {
            System.out.println("ERROR FILTRAR PRODUCTO "+e);
            lista = null;
            return lista;
        }
      return lista;
    }
    
   // METODO ADICIONALES ===================================================> 
    public boolean restar(int id) {
    
       String sql="update productos set stock=stock-1 where idproducto="+id;
       Producto prod = new Producto();
       try {
            connection = conexion.getConection();
            ps=connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERRRRRRRRRRRRRRRRRRRROR");
            System.out.println(e);
            return false;
        }
        
        return true;
    }
    
   public double precio(int id) {
      double precio=0;
       String sql="select precio from productos where idproducto="+id;
       Producto prod = new Producto();
       try {
            connection = conexion.getConection();
            ps=connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                precio = rs.getDouble("precio");
               
            }
        } catch (SQLException e) {
            System.out.println("ERRRRRRRRRRRRRRRRRRRROR");
            System.out.println(e);
        }
        
        return precio;
    }
   
   
   public String imagen(int id) {
       String imagen = "";
       String sql="select foto from productos where idproducto="+id;
       Producto prod = new Producto();
       try {
            connection = conexion.getConection();
            ps=connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                imagen = rs.getString("foto");
               
            }
        } catch (SQLException e) {
            System.out.println("ERRRRRRRRRRRRRRRRRRRROR");
            System.out.println(e);
        }
        
        return imagen;
    }
   
    public int stock(int id) {
       int stock = 0;
       String sql="select stock from productos where idproducto="+id;

       try {
            connection = conexion.getConection();
            ps=connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                stock = rs.getInt("stock");
               
            }
        } catch (SQLException e) {
            System.out.println("ERRRRRRRRRRRRRRRRRRRROR");
            System.out.println(e);
        }
        
        return stock;
    }
    
    public List filtrarBusquedad(String texto) {
       List<Producto> lista = new ArrayList<>();
       Producto prod = new Producto();
       //select * from persona where idx like '%1%' or nombrex='%1%' or dnix='%1%'; (DA ERROR POR EL NUMERO ENTERO)
       String sql="select * from productos where nombre like '%"+texto+"%' or modelo  like'%"+texto+"%' or color  like'%"+texto+"%'  or categoria  like'%"+texto+"%' ";

        try {
            connection = conexion.getConection();
            ps= connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                prod.setIdproducto(rs.getInt("idproducto"));
                prod.setNombre(rs.getString("nombre"));
                prod.setModelo(rs.getString("modelo"));
                prod.setColor(rs.getString("color"));
                prod.setFoto(rs.getString("foto"));
                prod.setCategoria(rs.getString("categoria"));
                prod.setOrigen(rs.getString("origen"));
                prod.setPrecio(rs.getDouble("precio"));
                prod.setStock(rs.getInt("stock"));
                prod.setIdproveedor(rs.getInt("idproveedor"));
                lista.add(prod);
            }
        } catch (SQLException e) {
            System.out.println("ERROR FILTRAR PRODUCTO "+e);
        }
        
        return lista;
    }

    
    
    
    
}
