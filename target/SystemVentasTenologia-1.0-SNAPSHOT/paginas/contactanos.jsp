<%-- 
    Document   : contactanos
    Created on : 24 nov. 2020, 00:32:18
    Author     : JORGE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <div class="container">
        <div class="jumbotron jumbotron-fluid">
            <div class="container">
              <h1 class="display-4">Austro TECH</h1>
              <p class="lead">La mejor empresa en tecnologia a nivel nacional</p>
            </div>
          </div>
        </div>
        <div class="container">
          
           
           
            <div class="row">
     
                 <div class="col-6">
                     <div class="card" style="color:slategray">
                        <h5><i class="fas fa-map"></i> Ubicación:<small> Av. España y Calle Vieja </small> </h5>
                       <h5><i class="fas fa-users-cog"></i> Atendemós: <small> 8:00am - 9pm</small> </h5>
                       <h5> <i class="fas fa-envelope-open"></i> Email: <small> Astrotech.@Hotmail.com </small> </h5>
                       <h5> <i class="fas fa-phone-square"></i>Telefonos: <small> 095272728 - 498123 </small> </h5>
                       <h5> <i class="fas fa-users"></i> Redes Sociales: 
                           <a href="#" style="color: #00a2f3" title="Twither">  <i class="fab fa-twitter-square"></i></a>
                           <a href="#" style="color: #4867aa" title="Facbook">  <i class="fab fa-facebook"></i></a>
                           <a href="#" style="color: #a61f85" title="Instagram"> <i class="fab fa-instagram"></i></a>
                           <a href="#" style="color: #4bc75a" title="Whatsapp">  <i class="fab fa-whatsapp-square"></i></a>
                          
                           </h5>
                   </div>
                  </div>

                
                  <div class="col-6" style="border: 1px solid #000000;
                                            -moz-border-radius: 7px;
                                            -webkit-border-radius: 7px;
                                            padding: 10px;">
                   <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2369.329832421276!2d-79.00625584647108!3d-2.8962687160507423!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x91cd18095fc7e881%3A0xafd08fd090de6ff7!2sCuenca!5e0!3m2!1ses!2sec!4v1604682773813!5m2!1ses!2sec" width="100%" height="100%" frameborder="0" style="border:0;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>   
                </div>
                
                </div>    

      

            </div>
     
        </div>
     
     <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
     <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    
    </body>
</html>
