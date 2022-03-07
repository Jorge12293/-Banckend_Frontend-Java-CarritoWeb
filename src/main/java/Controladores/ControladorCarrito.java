/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Detalle;
import ModelosDao.DetalleDao;
import ModelosDao.FacturaDao;
import ModelosDao.ProductoDao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JORGE
 */
public class ControladorCarrito extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    int idProducto = 0;
    
    List<Detalle> listaDetalle = new ArrayList<>(); 
    
    ProductoDao productoDao = new ProductoDao();
    DetalleDao detalleDao = new DetalleDao();
    FacturaDao facturaDao = new FacturaDao();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String accion= request.getParameter("accion");
        
        if(accion.equals("carrito")){
            carrito_productos(request, response);
        }
        
        if(accion.equals("sumarItem")){
            sumar_Item(request, response);
        }
        
        if(accion.equals("eliminarItem")){
            eliminar_Item(request, response);
        }
        
 
    }

    protected void carrito_productos(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        if(session.getAttribute("listaDetalles") != null){
            System.out.println("LISTA DETALLE con CONTENIDO");
            System.out.println(session.getAttribute("listaDetalles"));
            listaDetalle =(List<Detalle>)session.getAttribute("listaDetalles");
            System.out.println(session.getAttribute("listaDetalles"));
            session.setAttribute("listaDetalles",listaDetalle);
            request.getRequestDispatcher("paginas/carrito.jsp").forward(request, response);
     
        }else{
            System.out.println("LISTA DETALLE VACIA");
            listaDetalle.clear();
            request.getRequestDispatcher("paginas/carrito.jsp").forward(request, response);
        }
        
    }
    
    protected void sumar_Item(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("listaDetalles") != null) {
          System.out.println("Listado de Detalles" + session.getAttribute("listaDetalles"));
          listaDetalle =(List<Detalle>)session.getAttribute("listaDetalles");
        }else{
          listaDetalle.clear();
        }
       
       
        idProducto = Integer.parseInt(request.getParameter("id").trim());
        boolean sumarDetalle = false;
        
        if(!listaDetalle.isEmpty() || listaDetalle == null){
            for (Detalle detalle : listaDetalle) { 
                if(idProducto == detalle.getIdproducto() ){
                    detalle.setCantidad(detalle.getCantidad()+1);
                    sumarDetalle=true;
                }      
            }
        }
        
        if(sumarDetalle==false){
           Detalle detalle = new Detalle(); 
           detalle.setIdproducto(idProducto);
           detalle.setCantidad(1);
           detalle.setPrecio(productoDao.getProducto(idProducto).getPrecio());
       
           listaDetalle.add(detalle);
        }
        

        session.setAttribute("listaDetalles",listaDetalle); 
        request.getRequestDispatcher("paginas/carrito.jsp").forward(request, response);
    }
    
    
     protected void eliminar_Item(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("listaDetalles") != null) {
          listaDetalle =(List<Detalle>)session.getAttribute("listaDetalles");
          
          idProducto = Integer.parseInt(request.getParameter("id").trim());
          
          for (Detalle detalle : listaDetalle) {
            if (detalle.getIdproducto() == idProducto ) {
                listaDetalle.remove(detalle);
                break;
            }
          }
          
        }else{
          listaDetalle.clear();
        }
       

        session.setAttribute("listaDetalles",listaDetalle); 
        request.getRequestDispatcher("paginas/carrito.jsp").forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
