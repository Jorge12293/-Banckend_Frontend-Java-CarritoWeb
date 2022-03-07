/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JORGE
 */
public class Conexion {
    Connection conn;
    public Conexion(){
        try {
            Class.forName("org.postgresql.Driver");
            String url= "jdbc:postgresql://localhost:5433/bd_systemventas";
            conn = DriverManager.getConnection(url,"postgres","jorgerivera");
            if(conn != null){
                System.out.println("Conexion Exitosa");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConection(){
        return conn;
    }
}
