<%-- 
    Document   : productos
    Created on : 22 nov. 2020, 20:17:52
    Author     : JORGE
--%>

<%@page import="Modelos.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  
        <title>JSP Page</title>
  
         <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
       
        <!-- JQUERY -->
        <script src="https://code.jquery.com/jquery-3.3.1.min.js" type="text/javascript"></script>
        
        <!-- FONTAWESOME -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.0/css/all.css" integrity="sha384-aOkxzJ5uQz7WBObEZcHvV5JvRW3TUc2rNPA7pe3AwnsUohiw1Vj2Rgx2KSOkF5+h" crossorigin="anonymous">
      
        <script type="text/javascript">
            //Cargar primero el Html
             
            $(document).ready(function(){
                $('table .edit').on('click', function(){
                   var idd = $(this).parent().find('#id').val();
                   $.ajax({
                      type: 'GET',
                      url: 'ControladorProductos',
                      data: { accion:'editarProducto', id:idd },
                      dataType:'json',
                      contentType: 'application/json',
                      success: function (result){
                          $('#modalActualizarProducto #txtIdproductoA').val(result.idproducto);
                          $('#modalActualizarProducto #txtNombreA').val(result.nombre);
                          $('#modalActualizarProducto #txtModeloA').val(result.modelo);
                          $('#modalActualizarProducto #txtColorA').val(result.color);
                          $('#modalActualizarProducto #txtFotoA').val(result.foto);
                          $('#modalActualizarProducto #txtCategoriaA').val(result.categoria);
                          $('#modalActualizarProducto #txtOrigenA').val(result.origen);
                          $('#modalActualizarProducto #txtPrecioA').val(result.precio);
                          $('#modalActualizarProducto #txtStockA').val(result.stock);
                          $('#modalActualizarProducto #txtProveedorA').val(result.idproveedor);
                    
                      }
                   });
                });
            });
        </script>
    </head>
    <body>
        <jsp:include page="../layouts/header.jsp" flush="true" />
        
        <jsp:useBean id="prov" class="ModelosDao.ProveedoresDao" scope="page"></jsp:useBean>
                                    
        <div class="container-fluid mt-2">
            

 <!-- =================================== LISTADO DE  PRODUCTOS =================================== -->             
                 
          <div class="row">
               <div class="col-9">
                    <h1>LISTA DE PRODUCTOS </h1> 
                </div>
                <div class="col-3">
                     <form action="ControladorProductos" method="POST" class="form-inline">
                        <input type="search" name="txtBusqueda" placeholder="Buscar" class="form-control">
                        <button type="submit" name="accion" value="filtrarProductos" class="btn btn-outline-success" type="submit">Buscar</button>
                    </form>
              </div>
              <div class="col-10">
                  <table class="table">
                        <thead class="thead-dark">
                          <tr>
                            <th scope="col">NOMBRE</th>
                            <th scope="col">MODELO</th>
                            <th scope="col">COLOR</th>
                            <th scope="col">FOTO</th>
                            <th scope="col">CATEGORIA</th>
                            <th scope="col">ORIGEN</th>
                            <th scope="col">PRECIO</th>
                            <th scope="col">STOCK</th>
                            <th scope="col">PROVEEDOR</th>
                            <th scope="col">ACCIONES</th>
                          </tr>
                        </thead>
                      
                        <tbody>
                          <c:forEach var="prod" items="${listaProductos}" varStatus="i">
                          <tr>
                            <td>${prod.nombre}</td>
                            <td>${prod.modelo}</td>
                            <td>${prod.color}</td>
                            <td><img src="ficheroImagenes/productos/${prod.foto} " height="80" width="80"></td>
                            <td>${prod.categoria}</td>
                            <td>${prod.origen}</td>
                            <td>${prod.precio}</td>                                               
                            <td>${prod.stock}</td>
                            <td>${prov.getProveedor(prod.idproveedor).nombre}</td>
                            <td>
                               <button type="button" class="btn btn-secondary edit" data-toggle="modal" data-target="#modalActualizarProducto">
                                    Editar
                                </button>
                                <a class="btn btn-danger" href="ControladorProductos?accion=eliminarProducto&idProducto=${prod.idproducto}">ELIMINAR</a>
                                <input type="hidden" name="id" id="id" value="${prod.idproducto}">
                            </td>
                          </tr>
                          </c:forEach>
                        </tbody>
                      </table>
                  
              </div>
              <div class="col-2">

                          <!-- Button trigger modal -->
                          <button type="button" class="btn btn-primary mb-2" data-toggle="modal" data-target="#modalAgregarProducto">
                              Agregar Productos
                          </button>
                          <form action="ControladorProductos" method="POST">                                                                                                                 
                             <button type="submit" name="accion" value="exportarProductoPDF" class="btn btn-danger"><img src="./recursos/img/pdf.jpg" height="20px" width="20px" alt=""/> EXPORTAR PDF</button>  
                          </form>     
              </div>
              
          </div>
          
        </div>     
          
 <!-- =================================== MODAL AGREGAR PRODUCTO =================================== -->           
<div class="modal fade" id="modalAgregarProducto" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-xl">
    <div class="modal-content">
      <form action="ControladorProductos" enctype="multipart/form-data" method="POST"> 
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Agregar Poducto</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          
          <div class="row">
           
              <div class="col-6">
                  
                      
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
                                <label for="txtModelo">Modelo:</label>
                            </div>
                            <div class="col-9">
                                <input type="text" class="form-control" id="txtModelo" name="txtModelo" required="true">
                            </div>
                        </div>
                    </div> 
                  
                  
                    <div class="form-group">
                        <div class="row">
                            <div class="col-3">
                                <label for="txtColor">Color:</label>
                            </div>
                            <div class="col-9">
                                <input type="text" class="form-control" id="txtColor" name="txtColor" required="true">
                            </div>
                        </div>
                    </div> 
                  
                     <div class="form-group">
                        <div class="row">
                            <div class="col-3">
                                <label for="txtCategoria">Categoria:</label>
                            </div>
                            <div class="col-9">
                                  <select name="txtCategoria" id="txtCategoria" class="form-control">
                                    <option value="Televisores">Camara</option>
                                    <option value="Celulares">Celular</option>
                                    <option value="Computadoras">Computador</option>
                                    <option value="Otros">Otros</option>
                                  </select>
                            </div>
                        </div>
                    </div> 

                    <div class="form-group">
                        <div class="row">
                            <div class="col-3">
                                <label for="txtOrigen">Origen:</label>
                            </div>
                            <div class="col-9">
                                <input type="text" class="form-control" id="txtOrigen" name="txtOrigen" required="true">
                            </div>
                        </div>
                    </div>
                  
                  
                  
              </div>
              <div class="col-6">
                  
                  <div class="form-group">
                        <div class="row">
                            <div class="col-3">
                                <label for="txtPrecio">Precio:</label>
                            </div>
                            <div class="col-9">
                                <input type="number" id="txtPrecio" name="txtPrecio" class="form-control" required="true">
                            </div>
                        </div>
                    </div> 
                  
                  
                    <div class="form-group">
                        <div class="row">
                            <div class="col-3">
                                <label for="txtStock">Stock:</label>
                            </div>
                            <div class="col-9">
                                <input type="number" id="txtStock" name="txtStock" class="form-control" required="true">
                            </div>
                        </div>
                    </div> 
                  
                    <div class="form-group">
                        <div class="row">
                            <div class="col-3">
                                <label for="txtProveedor">Proveedor:</label>
                            </div>
                            <div class="col-9">
                                  <select name="txtProveedor" id="txtProveedor" class="form-control">
                                       <c:forEach var="provee" items="${prov.listar()}" varStatus="i">
                                        <option value="${provee.idproveedor}" >${provee.nombre}</option>
                                      </c:forEach>
                                  </select>
                            </div>
                        </div>
                    </div> 
                 
                    <div class="form-group">
                        <div class="row">
                            <div class="col-3">
                                <label for="txtFoto">Foto:</label>
                            </div>
                            <div class="col-9">
                                <input type = "file" id="txtFoto" name="txtFoto" required="true">
                            </div>
                        </div>
                    </div> 
                          	
                  
              </div>
          </div>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
        <button type="submit" name="accion" value="agregarProducto" class="btn btn-primary"> Guardar Registro </button>   
      </div>
      </form>
    </div>
  </div>
</div>

 <!-- =================================== MODAL ACTULIZAR PRODUCTO =================================== -->  
<div class="modal fade" id="modalActualizarProducto" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-xl">
    <div class="modal-content">
      <form action="ControladorProductos" method="POST">  
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">ACTULIZAR PRODUCTO</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        
        
                      <div class="row">
                        
                          <div class="col-6">


                                   <div class="form-group">
                                    <div class="row">
                                        <div class="col-3">
                                            <label for="txtNombreA">Nombre:</label>
                                        </div>
                                        <div class="col-9">
                                            <input type="text" class="form-control" id="txtNombreA" name="txtNombreA">
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-3">
                                            <label for="txtModeloA">Modelo:</label>
                                        </div>
                                        <div class="col-9">
                                            <input type="text" class="form-control" id="txtModeloA" name="txtModeloA" >
                                        </div>
                                    </div>
                                </div> 


                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-3">
                                            <label for="txtColorA">Color:</label>
                                        </div>
                                        <div class="col-9">
                                            <input type="text" class="form-control" id="txtColorA" name="txtColorA">
                                        </div>
                                    </div>
                                </div> 

                                 <div class="form-group">
                                    <div class="row">
                                        <div class="col-3">
                                            <label for="txtCategoriaA">Categoria:</label>
                                        </div>
                                        <div class="col-9">
                                            <input type="text" class="form-control" id="txtCategoriaA" name="txtCategoriaA">                 
                                        </div>
                                    </div>
                                </div> 

                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-3">
                                            <label for="txtOrigenA">Origen:</label>
                                        </div>
                                        <div class="col-9">
                                            <input type="text" class="form-control" id="txtOrigenA" name="txtOrigenA" >
                                        </div>
                                    </div>
                                </div>



                          </div>
                          <div class="col-6">

                              <div class="form-group">
                                    <div class="row">
                                        <div class="col-3">
                                            <label for="txtPrecioA">Precio:</label>
                                        </div>
                                        <div class="col-9">
                                            <input type="number" class="form-control" id="txtPrecioA" name="txtPrecioA" >
                                        </div>
                                    </div>
                                </div> 


                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-3">
                                            <label for="txtStockA">Stock:</label>
                                        </div>
                                        <div class="col-9">

                                            <input type="number" class="form-control" id="txtStockA" name="txtStockA" >
                                        </div>
                                    </div>
                                </div> 

                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-3">
                                            <label for="txtProveedorA">Proveedor:</label>
                                        </div>
                                        <div class="col-9">
                                           <select name="txtProveedorA" id="txtProveedorA" class="form-control">
                                                <c:forEach var="provee" items="${prov.listar()}" varStatus="i">
                                                    <option value="${provee.idproveedor}" >${provee.nombre}</option>
                                                 </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                </div> 

                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-3">
                                            <label for="txtFotoA">Foto:</label>
                                        </div>
                                        <div class="col-9">
                                            <input type="text" class="form-control" id="txtFotoA" name="txtFotoA" readonly="true">
                                        </div>
                                    </div>
                                </div> 

                              <input type="hidden" id="txtIdproductoA" name="txtIdproductoA" >
                          </div>
                      </div> 

                 
   
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="submit" name="accion" value="actualizarProducto" class="btn btn-primary"> Actualizar</button>                
      </div>
      </form>
    </div>
  </div>
</div>
   
    <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
     
    </body>
</html>
