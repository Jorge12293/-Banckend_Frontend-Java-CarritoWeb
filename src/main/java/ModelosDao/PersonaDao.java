/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelosDao;


import Conexion.Conexion;
import Interfaces.interfacePersona;
import Modelos.Persona;
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
public class PersonaDao implements interfacePersona{
    
    Conexion conexion = new Conexion();
    Connection connection;
    PreparedStatement ps;
    ResultSet rs;
  

    @Override
    public List listar() {
        
        List<Persona> lista = new ArrayList<>();
        String sql="select * from personas";
        try {
            connection = conexion.getConection();
            ps=connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Persona per = new Persona();
                per.setIdpersona(rs.getInt("idpersona"));
                per.setCedula(rs.getString("cedula"));
                per.setNombre(rs.getString("nombre"));
                per.setApellido(rs.getString("apellido"));
                per.setEmail(rs.getString("email"));
                per.setTelefono(rs.getString("telefono"));
                per.setCiudad(rs.getString("ciudad"));
                per.setDireccion(rs.getString("direccion"));
                per.setProvincia(rs.getString("provincia"));
                per.setSexo(rs.getString("sexo"));
                per.setFechanacimiento(rs.getDate("fechanacimiento"));
                lista.add(per);
            }
        } catch (SQLException e) {
            System.out.println("ERROR");
            System.out.println(e);
        }
        
        return lista;
    
    }

    @Override
    public Persona list(int id) {
    
      String sql="select * from personas where idpersona="+id;
       Persona pers = new Persona();
       try {
            connection = conexion.getConection();
            ps=connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
               pers.setIdpersona(rs.getInt("idpersona"));
               pers.setCedula(rs.getString("cedula"));
               pers.setNombre(rs.getString("nombre"));
               pers.setApellido(rs.getString("apellido"));
               pers.setEmail(rs.getString("email"));
               pers.setTelefono(rs.getString("telefono"));
               pers.setCiudad(rs.getString("ciudad"));
               pers.setDireccion(rs.getString("direccion"));
               pers.setProvincia(rs.getString("provincia"));
               pers.setSexo(rs.getString("sexo"));
               pers.setFechanacimiento(rs.getDate("fechanacimiento"));
        
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return pers;
  
    }

    @Override
    public boolean add(Persona per) {
        System.out.println(per);
        java.sql.Date sqlDate = new java.sql.Date(per.getFechanacimiento().getTime());
        String sql ="insert into personas(cedula, nombre, apellido, email, telefono, ciudad, direccion, provincia, sexo, fechanacimiento) VALUES ('"+per.getCedula()+"','"+per.getNombre()+"','"+per.getApellido()+"','"+per.getEmail()+"','"+per.getTelefono()+"','"+per.getCiudad()+"','"+per.getDireccion()+"','"+per.getProvincia()+"','"+per.getSexo()+"','"+sqlDate+"')";
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
    
    public int idPersonAdd (Persona per) {
       
        int idPersona=0;
        
        java.sql.Date sqlDate = new java.sql.Date(per.getFechanacimiento().getTime());
        String sql ="insert into personas(cedula, nombre, apellido, email, telefono, ciudad, direccion, provincia, sexo, fechanacimiento) VALUES ('"+per.getCedula()+"','"+per.getNombre()+"','"+per.getApellido()+"','"+per.getEmail()+"','"+per.getTelefono()+"','"+per.getCiudad()+"','"+per.getDireccion()+"','"+per.getProvincia()+"','"+per.getSexo()+"','"+sqlDate+"')";
        try {
            connection = conexion.getConection();
            ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            int affectedRows = ps.executeUpdate();
       
            
            if (affectedRows == 0) {
               throw new SQLException("Creating user failed, no rows affected.");
           }

           try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
               if (generatedKeys.next()) {
                   idPersona=generatedKeys.getInt(1);
               }
               else {
                   throw new SQLException("Creating user failed, no ID obtained.");
               }
           }
            
        
        } catch (SQLException e) {
             System.out.println(e);
             return idPersona;
        }
        return idPersona;
    }
    
  
    @Override
    public boolean edit(Persona per) {
        String sql = "update personas set cedula='"+per.getCedula()+"', nombre='"+per.getNombre()+"', apellido='"+per.getApellido()+"', email='"+per.getEmail()+"', telefono='"+per.getTelefono()+"', ciudad='"+per.getCiudad()+"', direccion='"+per.getDireccion()+"', provincia='"+per.getProvincia()+"', sexo='"+per.getSexo()+"', fechanacimiento='"+per.getFechanacimiento()+"'  WHERE idpersona="+per.getIdpersona();
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
         String sql ="delete from personas where idpersona="+id;
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
