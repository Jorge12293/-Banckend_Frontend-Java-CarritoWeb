/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelosDao;


import Conexion.Conexion;
import Interfaces.interfaceEmpresa;
import Modelos.Empresa;
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
public class EmpresaDao implements interfaceEmpresa {
    
    Conexion conexion = new Conexion();
    Connection connection;
    PreparedStatement ps;
    ResultSet rs;
    

    @Override
    public List listar() {
        List<Empresa> lista = new ArrayList<>();
        String sql="select * from empresa";
        try {
            connection = conexion.getConection();
            ps=connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                
                Empresa emp = new Empresa();
                emp.setIdempresa(rs.getInt("idempresa"));
                emp.setNombre(rs.getString("nombre"));
                emp.setRuc(rs.getString("ruc"));  
                emp.setDireccion(rs.getString("direccion"));
                emp.setEmail(rs.getString("email"));
                emp.setTelefono(rs.getString("telefono"));
                emp.setHoraabre(rs.getDate("horaabre"));  
                emp.setHoracierra(rs.getDate("horacierra"));
                emp.setLogo(rs.getString("logo"));
               
                lista.add(emp);
            }
        } catch (SQLException e) {
            System.out.println("ERROR");
            System.out.println(e);
        }
        
        return lista;
   }

    @Override
    public Empresa list(int id) {
    
       String sql="select * from empresa where idempresa="+id;
       Empresa emp = new Empresa();
       try {
            connection = conexion.getConection();
            ps=connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                
               emp.setIdempresa(rs.getInt("idempresa"));
               emp.setNombre(rs.getString("nombre"));
               emp.setRuc(rs.getString("ruc"));
               emp.setDireccion(rs.getString("direccion"));
               emp.setEmail(rs.getString("email"));
               emp.setTelefono(rs.getString("telefono"));
               emp.setHoraabre(rs.getDate("horaabre"));
               emp.setHoracierra(rs.getDate("horacierra"));
               emp.setLogo(rs.getString("logo"));
    
        
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return emp;
  
        
    }

    @Override
    public boolean add(Empresa emp) {
    
        String sql ="insert into empresa(nombre,ruc,direccion,email,telefono,horaabre,horacierra) VALUES ('"+emp.getNombre()+"','"+emp.getRuc()+"','"+emp.getDireccion()+"','"+emp.getEmail()+"','"+emp.getTelefono()+"' ,'"+emp.getHoraabre()+"' ,'"+emp.getHoracierra()+"' , '"+emp.getLogo()+"')";                                                              
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
    public boolean edit(Empresa emp) {
    
       String sql = "update empresa set nombre='"+emp.getNombre()+"', ruc='"+emp.getRuc()+"', direccion='"+emp.getDireccion()+"', email='"+emp.getEmail()+"', telefono='"+emp.getTelefono()+"', horaabre='"+emp.getHoraabre()+"', horacierra='"+emp.getHoracierra()+"', logo='"+emp.getLogo()+"'  WHERE idempresa="+emp.getIdempresa();
        
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
    
         String sql ="delete from empresa where idempresa="+id;
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
