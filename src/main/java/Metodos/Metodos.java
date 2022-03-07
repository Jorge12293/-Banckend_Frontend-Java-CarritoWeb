/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Part;

/**
 *
 * @author JORGE
 */
public class Metodos {
    
    public Metodos() {
    
    }
    
    public String almacenarImagen(Part foto,String urlFicheroImagenes){
                try {
                    
                    String ruta ="";
                    
                    String fileName = Paths.get(foto.getSubmittedFileName()).getFileName().toString(); // MSIE fix.

                    File uploads = new File(urlFicheroImagenes);
                    uploads.mkdirs(); //Crea los directorios necesarios
                    
                    File file = File.createTempFile("cod"+1+"-", "-"+fileName, uploads); //Evita que hayan dos archivos con el mismo nombre
                    
                    try (InputStream input = foto.getInputStream()){
                        Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    }catch(Exception e){
                        System.out.println(e);
                    }
                    
                    ruta=String.valueOf(file.getName());
                    
                    return ruta;
                }catch(IOException ex){
                    Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null,ex);
                    return "img.png";                
                }
    }
    
    
    public boolean borrarImagen(String url,String nombre){
        System.out.println(url+""+nombre);
        File fichero = new File(url+""+nombre);
        if (fichero.delete()){
            System.out.println("El fichero ha sido borrado satisfactoriamente");
            return true;
        }else{
            System.out.println("El fichero no puede ser borrado");
            return false;
        }    
                
    }
    
    
    public Date ParseFecha(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;
    }
    
}
