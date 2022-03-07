/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelosDao;


import Conexion.Conexion;
import Interfaces.interfaceUsuario;
import Modelos.Usuario;
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

     
public class UsuarioDao implements interfaceUsuario {

    Conexion conexion = new Conexion();
    Connection connection;
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public List listar() {
    
        List<Usuario> lista = new ArrayList<>();
        String sql="select * from usuarios";
        try {
            connection = conexion.getConection();
            ps=connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){        
                Usuario usu = new Usuario();
                usu.setIdusuario(rs.getInt("idusuario"));
                usu.setIdpersona(rs.getInt("idpersona"));
                usu.setNivel(rs.getString("nivel"));
                usu.setPassword(rs.getString("password")); 
                usu.setIdempresa(rs.getInt("idempresa"));
                lista.add(usu);
            }
        } catch (SQLException e) {
            System.out.println("ERROR");
            System.out.println(e);
        }
        
        return lista;
        
    }

    @Override
    public Usuario getUsuario(int id) {
        
       String sql="select * from usuarios where idusuario ="+id;
       Usuario usu = new Usuario();
       try {
            connection = conexion.getConection();
            ps=connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                
               usu.setIdusuario(rs.getInt("idusuario"));
               usu.setIdpersona(rs.getInt("idpersona"));
               usu.setPassword(rs.getString("password"));
               usu.setNivel(rs.getString("nivel"));
               usu.setIdempresa(rs.getInt("idempresa"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return usu;
    
    }

    @Override
    public boolean add(Usuario usu) {
    
        String sql ="insert into usuarios(idpersona,password,nivel,idempresa) VALUES ('"+usu.getIdpersona()+"','"+usu.getPassword()+"','"+usu.getNivel()+"','"+usu.getIdempresa()+"')";
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
    public boolean edit(Usuario usu) {
    
       String sql=" update usuarios set  idpersona='"+usu.getIdpersona()+"', password='"+usu.getPassword()+"', nivel='"+usu.getNivel()+"', idempresa='"+usu.getIdempresa()+"' WHERE idusuario="+usu.getIdusuario();   
	     
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
         String sql ="delete from usuarios where idusuario="+id;
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
    public Usuario loguear(String pass, String correo) {
     Usuario user = null;
     String sql = "select * from usuarios where password like '"+pass+"' and idpersona  in (select idpersona from personas where email like '"+correo+"')";   
     
     try {
            connection = conexion.getConection();
            ps=connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
               user = new Usuario();
               user.setIdusuario(rs.getInt("idusuario"));
               user.setIdpersona(rs.getInt("idpersona"));
               user.setPassword(rs.getString("password"));
               user.setNivel(rs.getString("nivel"));
               user.setIdempresa(rs.getInt("idempresa"));
            }
        } catch (SQLException e) {
            System.out.println("ERROR LOGUEAR USUARIO "+e);
            return user;
        }catch (Exception e) {
            System.out.println("ERROR GENERAL LOGUEAR USUARIO "+e);
            return user;
        }
        
        return user;
    
    }


    
    
    
    
}
