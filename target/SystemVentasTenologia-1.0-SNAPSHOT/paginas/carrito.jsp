<%-- 
    Document   : carrito
    Created on : 24 nov. 2020, 00:10:51
    Author     : JORGE
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="Modelos.Detalle"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        
        <!-- FONTAWESOME -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.0/css/all.css" integrity="sha384-aOkxzJ5uQz7WBObEZcHvV5JvRW3TUc2rNPA7pe3AwnsUohiw1Vj2Rgx2KSOkF5+h" crossorigin="anonymous">
      
    </head>
    <body>
      <jsp:include page="../layouts/header.jsp" flush="true" /> 
      <%
         HttpSession sesion = request.getSession();
         double subtotal = 0;
         DecimalFormat df = new DecimalFormat("00.00");
      %>  
    <jsp:useBean id="prod" class="ModelosDao.ProductoDao" scope="page"></jsp:useBean> 
      <div class="container mt-5">
        <div class="row">
            <div class="col-9">
           <nav class="navbar navbar-light bg-light">
                <a class="navbar-brand"><h1>Carrito de Compras <i class="fas fa-cart-arrow-down"></i></h1></a>
           </nav>               
                <table class="table">
                        <thead>
                          <tr>
                            <th scope="col">Producto</th>
                            <th scope="col">Cantidad</th>
                            <th scope="col">Precio Unitario</th>
                            <th scope="col">Total</th>
                            <th scope="col">Accion</th>
                          </tr>
                        </thead>

                       <tbody>
                          <c:forEach var="detall" items="${listaDetalles}" varStatus="i">
                          <tr>
                            <td> <img src="ficheroImagenes/productos/${prod.getProducto(detall.idproducto).foto} " height="80" width="80"> </td>
                           
                            <td>${detall.cantidad}</td>
                            <td> ${ detall.precio}</td>
                            <td>${detall.precio * detall.cantidad}</td>
                            <td><a class="btn btn-danger" href="ControladorCarrito?accion=eliminarItem&id=${detall.idproducto}"><i class="fas fa-trash-alt"></i>  </a> </td>
                                                   
                           </tr>
                           </c:forEach>
                        </tbody>
                        
  
                </table>
            </div>
            <div class="col-3">
                <div class="card" style="width: 18rem;">
                <div class="card-header text-center">
                    <h4> FACTURA </h4>
                 <%  
                   if( sesion.getAttribute("listaDetalles") != null){                
                    List<Detalle> listadell =(List<Detalle>)sesion.getAttribute("listaDetalles");
                    for (Detalle detalle : listadell) {
                      subtotal = subtotal + (detalle.getCantidad() * detalle.getPrecio());
                    }
 
                   }else{
                       subtotal=0;
                   }
                  %>
                    
                    
                </div>
                <ul class="list-group list-group-flush">
                  <li class="list-group-item"> <h5> Subtotal: <span class="badge badge-secondary"><%=  df.format(subtotal) %> $</span></h5>    </li>
                  <li class="list-group-item">  <h5> Envio: <span class="badge badge-secondary">Gratis</span></h5> </li>
                  <li class="list-group-item">  <h5> IVA(12%): <span class="badge badge-secondary"><%=   df.format(subtotal* 0.12 ) %> $</span></h5>  </li>
                  <li class="list-group-item">  <h5> Total: <span class="badge badge-secondary"> <%=  df.format(subtotal + (subtotal * 0.12)) %> $</span></h5>  </li>
                </ul>
                
                
             
                <button type="button" class="btn btn-primary btn-block" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo"> Realizar Pago <i class="fas fa-cash-register"></i> </button>

              </div>
               
            </div>
        </div>
        

         
    </div>
        
      
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
     <form action="controladorCarrito">
         <div class="modal-header" style="background:black ">
         <h5 class="modal-title" id="exampleModalLabel" style="color: white"><i class="fas fa-cash-register"></i> Realizar Compra</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true" style="color: white">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">Tipo de Pago:</label>
            <select name="txtTipopago" id="txtCategoria" class="form-control">
                    <option value="Efectivo">Efectivo</option>
                    <option value="Tarjeta">  Tarjeta</option>
   
              </select>
          </div>
         
      
      </div>
      <div class="modal-footer" style="background:black ">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
        <button type="submit" name="accion" value="realizarCompra" class="btn btn-primary">Comprar</button>
      </div>
        </form>
    </div>
  </div>
</div>

    <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
     
    </body>
</html>
