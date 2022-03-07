/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Usuario;
import ModelosDao.UsuarioDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JORGE
 */
public class ControladorSesion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    UsuarioDao usuarioDao = new UsuarioDao();
    Usuario usuario = new Usuario();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("POST - ControladorSesion");
        String accion= request.getParameter("accion");
        
        if(accion.equals("Login")){
            post_login(request, response);
        }
        
        if(accion.equals("Logout")){
            post_logout(request, response);
        }
    }

    protected void post_login(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession session = request.getSession();
         
        String pass  = request.getParameter("txtPasswordS").trim();
        String correo = request.getParameter("txtEmailS").trim(); 
        
        usuario = usuarioDao.loguear(pass, correo);
        
        if(usuario != null){
            session.setAttribute("user",usuario);
            System.out.println("INICIO SESION");     
        }else{
            System.out.println("NO SE ENCONTRO USUARIO");            
        } 
        
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    
    protected void post_logout(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        request.getSession().invalidate();
        
        System.out.println("CERRAR SESION");  
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
