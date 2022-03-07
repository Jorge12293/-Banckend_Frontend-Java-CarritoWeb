<%-- 
    Document   : catalogo
    Created on : 22 nov. 2020, 20:18:50
    Author     : JORGE
--%>

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
         %>   
        <h1>Producto Disponibles</h1>  
    
        <hr>
        <div class="container ">
            
            <diV class="row">
                
                <c:forEach var="prod" items="${listaProductos}" varStatus="i">
                    
            
                   <div class="card m-4  " style="width: 14rem;">
                       <img class="card-img-top" src="./ficheroImagenes/productos/${ prod.foto }"  alt="Card image cap" height="150" >
                      <div class="card-body">
                        <h5 class="card-title">${prod.nombre}</h5>
                        <p class="card-text">
                            <span class="badge badge-secondary">Precio: ${ prod.precio}  </span>
                            <span class="badge badge-secondary">Color: ${ prod.color} </span>                       
                        </p>
                        
                        <%
                        if(sesion.getAttribute("user") != null){
                        %>
                         <a href="ControladorCarrito?accion=sumarItem&id=${prod.idproducto}" class="btn btn-primary btn-block">Agregar a Carrito <i class="fas fa-cart-arrow-down"></i> </a>
                         <%
                            }
                        %>
                      </div>
                    </div>  
                  
                </c:forEach>
            </diV>   

      
          
        </div> 
         

        
        <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
     <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    
    </body>
</html>
