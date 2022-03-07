/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Metodos.ExportarPdf;
import Metodos.Metodos;
import Modelos.Producto;
import ModelosDao.ProductoDao;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


/**
 *
 * @author JORGE
 */
@MultipartConfig
public class ControladorProductos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    ProductoDao productoDao = new ProductoDao();
    Producto producto;
    String urlFicheroImagenes ="C:\\Users\\JORGE\\Desktop\\PORTAFOLIO PROYECTOS\\PROYECTOS PORTAFOLIO\\JSP\\Proyecto SystemVentasTecnologia\\SystemVentasTenologia\\src\\main\\webapp\\ficheroImagenes\\productos\\";
    int idProducto = 0;
    List<Producto> listaProductos;
    Metodos metods = new Metodos();
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        System.out.println("POST-GET-ControladorProductos");  
      
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
        
        System.out.println("GET-ControladorProductos");
        String accion= request.getParameter("accion");
        
        if(accion.equals("listarProducto")){
            get_listar_productos(request, response);
        }
        
        
        if(accion.equals("editarProducto")){
            get_editar_productos(request, response);
        }
        
          if(accion.equals("eliminarProducto")){
            get_eliminar_productos(request, response);
        }
        
       
    }
    protected void get_listar_productos(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        listaProductos = productoDao.listar();
     
        request.setAttribute("listaProductos",listaProductos);
        request.getRequestDispatcher("paginas/productos.jsp").forward(request, response);
    }
    
    protected void get_eliminar_productos(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        idProducto = Integer.parseInt(request.getParameter("idProducto"));
        
        Producto pro = productoDao.getProducto(idProducto);
        metods.borrarImagen(urlFicheroImagenes,pro.getFoto());
        
        productoDao.eliminar(idProducto);
        
        listaProductos = productoDao.listar();
     
        request.setAttribute("listaProductos",listaProductos);
        request.getRequestDispatcher("paginas/productos.jsp").forward(request, response);
    }
    
  
    
      protected void get_editar_productos(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("application/json");
        idProducto = Integer.parseInt(request.getParameter("id").trim());
        producto = productoDao.getProducto(idProducto);
        
        Gson gson = new Gson();
        PrintWriter writer =  response.getWriter();
        writer.print(gson.toJson(producto));
        writer.flush();
        writer.close();
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
        System.out.println("POST-ControladorProductos");
        
        String accion= request.getParameter("accion");
        
        if(accion.equals("agregarProducto")){
            post_agregar_Producto(request, response);
        }
        
        if(accion.equals("actualizarProducto")){
            post_actualizar_Producto(request, response);
        }
        
        if(accion.equals("filtrarProductos")){
            post_filtrar_Producto(request, response);
        }
        
        if(accion.equals("exportarProductoPDF")){
            post_exportar_ProductoPDF(request, response);
        }
        
        
        
    }
    protected void post_exportar_ProductoPDF(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
            String nomFile = dateFormat.format(new Date());
            String variable1="Content-Disposition";
            String variable2="attachment; filename=Productos_"+nomFile+".pdf";
            response.setHeader(variable1, variable2);

            ExportarPdf exportarPDF = new ExportarPdf(listaProductos);
            exportarPDF.export(response);
        
        request.setAttribute("listaProductos",listaProductos);
        request.getRequestDispatcher("paginas/productos.jsp").forward(request, response);
    }
    
    protected void post_filtrar_Producto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String txtBusqueda = request.getParameter("txtBusqueda");
        listaProductos = productoDao.filtrar(txtBusqueda);
        
        request.setAttribute("listaProductos",listaProductos);
        request.getRequestDispatcher("paginas/productos.jsp").forward(request, response);
    }
    
    protected void post_agregar_Producto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
             Part foto = request.getPart("txtFoto");
             String ruta="";
             ruta=metods.almacenarImagen(foto,urlFicheroImagenes);
              
             String nombre = request.getParameter("txtNombre"); 
             String modelo = request.getParameter("txtModelo"); 
             String color = request.getParameter("txtColor"); 
             String categoria = request.getParameter("txtCategoria"); 
             String origen = request.getParameter("txtOrigen"); 
             double precio = Double.parseDouble(String.valueOf(request.getParameter("txtPrecio").trim()  ));
             int stock = Integer.parseInt(  String.valueOf(request.getParameter("txtStock").trim()  ));
             int idproveedor = Integer.parseInt(  String.valueOf(request.getParameter("txtProveedor").trim()  )); 
             
             Producto prod = new Producto();
             prod.setNombre(nombre);
             prod.setModelo(modelo);
             prod.setColor(color);
             prod.setFoto(ruta);
             prod.setCategoria(categoria);
             prod.setOrigen(origen);
             prod.setPrecio(precio);
             prod.setStock(stock);
             prod.setIdproveedor(idproveedor);
             
             productoDao.add(prod);
       
            listaProductos = productoDao.listar();
            
            
            request.setAttribute("listaProductos",listaProductos);
            request.getRequestDispatcher("paginas/productos.jsp").forward(request, response);
        
    }
    
        protected void post_actualizar_Producto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
             String nombre = request.getParameter("txtNombreA"); 
             String modelo = request.getParameter("txtModeloA"); 
             String color = request.getParameter("txtColorA"); 
             String foto = request.getParameter("txtFotoA"); 
             String categoria = request.getParameter("txtCategoriaA"); 
             String origen = request.getParameter("txtOrigenA"); 
             double precio = Double.parseDouble(String.valueOf(request.getParameter("txtPrecioA").trim()  ));
             int stock = Integer.parseInt(  String.valueOf(request.getParameter("txtStockA").trim()  ));
             int idproveedor = Integer.parseInt(  String.valueOf(request.getParameter("txtProveedorA").trim()  )); 
             
             Producto prod = new Producto();
             prod.setIdproducto(idProducto);
             prod.setNombre(nombre);
             prod.setModelo(modelo);
             prod.setColor(color);
             prod.setFoto(foto);
             prod.setCategoria(categoria);
             prod.setOrigen(origen);
             prod.setPrecio(precio);
             prod.setStock(stock);
             prod.setIdproveedor(idproveedor);
             
             
            productoDao.edit(prod);
            
            listaProductos = productoDao.listar();
        
            request.setAttribute("listaProductos",listaProductos);
            request.getRequestDispatcher("paginas/productos.jsp").forward(request, response);
        
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
