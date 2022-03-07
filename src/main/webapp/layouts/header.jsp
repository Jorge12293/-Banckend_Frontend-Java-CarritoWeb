<%-- 
    Document   : header
    Created on : 5 dic. 2020, 22:59:27
    Author     : JORGE
--%>

<%@page import="Modelos.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <%
         HttpSession sesion = request.getSession();
         %>  
              <nav class="navbar navbar-expand-lg navbar-light bg-light">
            
            <a class="navbar-brand" href="#" style="font-family: fantasy;"> <i class="fas fa-laptop"></i> System Ventas </a>
            <%
           if(sesion.getAttribute("user") == null){
           %>
            <div class="btn-group">
                <button type="button" class="btn btn-outline-success dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  Ingresar <i class="fas fa-users"></i>
                </button>
                <div class="dropdown-menu dropdown-menu-right">
                   <button class="dropdown-item" data-toggle="modal" data-target="#iniciarModal">Iniciar Sesion</button>
                   <hr>
                   <button class="dropdown-item" data-toggle="modal" data-target="#registrarseModal">Registrarse</button>
                </div>
            </div>
           <% 
            }
           %>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav mr-auto">
         
          </ul>
        </div>
      </nav>
        
        
      <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="#" "> </a>
        
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                
              <a style="border: none" class="btn btn-outline-light" href="ControladorPrincipal?accion=inicio"> HOME <i class="fas fa-home"></i> </a> 
            
            </li>
            
 
            <li class="nav-item dropdown">
              <a style="border: none" class="btn btn-outline-light dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Mantenimiento <i class="fas fa-toolbox"></i>
              </a>
              <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                <a class="dropdown-item" href="ControladorProductos?accion=listarProducto"> Productos   </a>
                <a class="dropdown-item" href="#"> Usuarios    </a>
              </div>
            </li>
    
            <li class="nav-item">
              <a style="border: none" class="btn btn-outline-light" href="ControladorCatalogo?accion=listarProducto"> Catalogo <i class="fas fa-laptop"></i></a>
            </li>
           
            
    
            
            <li class="nav-item">
              <a style="border: none" class="btn btn-outline-light" href="ControladorCarrito?accion=carrito"> Carrito Compras <i class="fas fa-cart-arrow-down"></i></a>
            </li>
        
         
            <li class="nav-item">
              <a style="border: none" class="btn btn-outline-light" href="ControladorContacto?accion=contacto"> Contactanos: <i class="fas fa-id-badge"></i> </a>
            </li>

          </ul>
   
            
           <!--Dropdown se oculta en vista escritorio -->
           <div class="d-block d-sm-block d-md-none">
                  <div class="btn-group dropright">
                      <button type="button" class="btn btn-outline-light dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                           <i class="fas fa-user mr-2"></i> ADMIN
                      </button>
                      <div class="dropdown-menu dropdown-menu-right text-center">
                           <!-- <img src="../recursos/imgPerfil/user.png" alt="60" width="60"/>
                            <button class="dropdown-item" type="button">Action</button>
                            <button class="dropdown-item" type="button">Another action</button>
                            <div class="dropdown-divider"></div>-->
                            <button class="dropdown-item" type="button"><i class="fas fa-window-close"></i> Salir</button>
                         
                      </div>
                  </div>
         
           </div>
         
    
           
         </div>
        
        
         <%
         if(sesion.getAttribute("user") != null){
         %>
        <!--Dropdown se oculta en vista movil -->
        <div class="d-none d-sm-none d-md-block">
            <form action="ControladorSesion" method="POST">
                 
            <div class="btn-group">
                <button type="button" class="btn btn-outline-light dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="fas fa-user mr-2"> </i> <%= ((Usuario)sesion.getAttribute("user")).getNivel() %> 
                </button>
                <div class="dropdown-menu dropdown-menu-right text-center">
                <!--   <img src="recursos/imgPerfil/user.png" alt="60" width="60"/>
                       <div class="dropdown-divider"></div>-->
                    <button  type="submit" name="accion" value="Logout" class="dropdown-item"><i class="fas fa-window-close"></i> Salir</button>
                </div>
            </div>
             </form> 
        </div> 
        <%
          }
        %>
      </nav>
<!-- ======================================================= SUBMENUS FRAMES ==================================================== 

        <div id="submenu" style="height: 82.7vh; width: 100vw; " >
            <iframe  src="paginas/inicio.jsp" id="frame" name="myFrame" style="height:100%; width:100%">
                
            </iframe>
        </div> -->
<!-- ======================================================= Modal Registrarse ==================================================== -->
<div class="modal fade" id="registrarseModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      
        <form action="controladorUsuario" method="POST">
          
      <div class="modal-header" style="background: black; color: white">
        <h5 class="modal-title" id="exampleModalLabel"> Registrarse</h5>
        <button style="color: white" type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      
      <div class="modal-body">
            <div class="form-group">
            <div class="row">
                <div class="col-3">
                    <label for="txtCedula">Cedula:</label>
                </div>
                <div class="col-9">
                    <input type="text" class="form-control" id="txtCedula" name="txtCedula" required="true">
                </div>
            </div>
            </div>              
            <div class="form-group">
            <div class="row">
                <div class="col-3">
                    <label for="txtNombre">Nombre:</label>
                </div>
                <div class="col-9">
                    <input type="text" class="form-control" id="txtNombre" name="txtNombre" required="true">
                </div>
            </div>
            </div>
            <div class="form-group">
            <div class="row">
                <div class="col-3">
                    <label for="txtApellido">Apellido:</label>
                </div>
                <div class="col-9">
                    <input type="text" class="form-control" id="txtApellido" name="txtApellido" required="true">
                </div>
            </div>
            </div>
            <div class="form-group">
            <div class="row">
                <div class="col-3">
                    <label for="txtEmail">Email:</label>
                </div>
                <div class="col-9">
                    <input type="email" class="form-control" id="txtEmail" name="txtEmail" required="true">
                </div>
            </div>
            </div>
           <div class="form-group">
            <div class="row">
                <div class="col-3">
                    <label for="txtTelefono">Telefono:</label>
                </div>
                <div class="col-9">
                    <input type="text" class="form-control" id="txtTelefono" name="txtTelefono" required="true">
                </div>
            </div>
            </div>
           <div class="form-group">
            <div class="row">
                <div class="col-3">
                    <label for="txtCiudad">Ciudad:</label>
                </div>
                <div class="col-9">
                    <input type="text" class="form-control" id="txtCiudad" name="txtCiudad" required="true">
                </div>
            </div>  
            </div>
           <div class="form-group">
            <div class="row">
                <div class="col-3">
                    <label for="txtDireccion">Dirección:</label>
                </div>
                <div class="col-9">
                    <input type="text" class="form-control" id="txtDireccion" name="txtDireccion" required="true">
                </div>
            </div>  
            </div>
          
            <div class="form-group">
                <div class="row">
                    <div class="col-3">
                        <label for="txtProvincia">Provincia:</label>
                    </div>
                    <div class="col-9">
                        <input type="text" class="form-control" id="txtProvincia" name="txtProvincia" required="true">
                    </div>
                </div>  
            </div>
            
          <div class="form-group">
                <div class="row">
                    <div class="col-3">
                        <label for="txtSexo">Sexo:</label>
                    </div>
                    <div class="col-9">
                            <input type="radio" id="male" name="txtSexo" value="Hombre">
                            <label for="Hombre">Hombre</label><br>
                            <input type="radio" id="Mujer" name="txtSexo" value="Mujer">
                            <label for="Mujer">Mujer</label><br>
                            <input type="radio" id="other" name="txtSexo" value="Otro">
                            <label for="Otro">Otro</label>
                     
                    </div>
                </div>  
            </div>
          
            <div class="form-group">
                <div class="row">
                    <div class="col-3">
                        <label for="txtFechanacimiento">Fecha de Nacimiento :</label>
                    </div>
                    <div class="col-9">
                        <input  type="date" id="start" class="form-control" id="txtFechanacimineto" name="txtFechanacimiento" required="true">
                    </div>
                </div>  
            </div>
          
            <div class="form-group">
            <div class="row">
                <div class="col-3">
                    <label for="pass1">Contraseña:</label>
                </div>
                <div class="col-9">
                    <input type="password" class="form-control" id="pass1" name="txtPassword" required="true">
                </div>
            </div>
            </div>
            <div class="form-group">
            <div class="row">
                <div class="col-3">
                    <label for="pass2">Repita Contraseña:</label>
                </div>
                <div class="col-9">
                    <input type="password" class="form-control" id="pass2" name="txtPassword2" required="true">
                </div>
            </div>
            </div>
            
      </div>
            
            
      <div class="modal-footer" style="background: black; color: white">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
        <button type="submit" name="accion" value="AgregarUsuario" class="btn btn-primary">Guardar</button>
      </div>
      </form>
    </div>
  </div>
</div>

<!-- ======================================================= Modal Iniciar Sesion==================================================== -->

<div class="modal fade" id="iniciarModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
       
        
    <form action="ControladorSesion" method="POST">
      <div class="modal-header" style="background: black; color: white">
        <h5 class="modal-title" id="exampleModalLabel">Iniciar Sesion</h5>
        <button style="color: white" type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
            <div class="form-group">
            <div class="row">
                <div class="col-3">
                    <label for="txtEmailS">Email:</label>
                </div>
                <div class="col-9">
                    <input type="email" class="form-control" id="txtEmailS" name="txtEmailS" required="true">
                </div>
            </div>
            </div>
          
            <div class="form-group">
            <div class="row">
                <div class="col-3">
                    <label for="txtPasswordS">Contraseña:</label>
                </div>
                <div class="col-9">
                    <input type="password" class="form-control" id="txtPasswordS" name="txtPasswordS" required="true">
                </div>
            </div>
           </div>
        </div>
      <div class="modal-footer" style="background: black; color: white">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
        <button type="submit" name="accion" value="Login" class="btn btn-primary">Ingresar</button>
      </div>
    </form>
    </div>
  </div>
</div>
  
    </body>
</html>
