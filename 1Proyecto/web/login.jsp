<%-- 
    Document   : login
    Created on : 18/04/2021, 02:05:49 PM
    Author     : ksand
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Ingresar</title>
        <meta charset="UTF-8">        
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="header">
                <h2>CursosLibres.com</h2>
                <p>Donde encontrarás cursos irónicamente útiles.</p>
        </div>
        <div class = "topbar">
            <a href="home">Inicio</a>
            <a class="active" href="login.jsp">Ingresar</a>   
        </div>
        <div id="wrapper"> 
            <div id = "Bienvenido">  
                <p> <strong>Ingreso</strong></p>
                <p>Ingresa su numero de cedula y contraseña.</p>

                <form action="Ingresar" method="POST">
                    <div class="iconologin">
                        <img src="images/login.png" alt="Avatar" class="icono">
                    </div>
                    <div class="container">
                        <label for="cedula"><b>Cédula</b></label>
                        <input type="text" placeholder="Ingrese su cédula" id="cedula" name="cedula" required>
                        <label for="contrasena"><b>Contraseña</b></label>
                        <input type="password" placeholder="Ingrese su contraseña" id="contrasena" name="contrasena" required>
                        <button type="submit">Ingresar</button>
                        <div class="container">
                            <span class="registro">¿No tienes cuenta? <a href="register.jsp">Registrate aquí</a></span>
                        </div>
                </form>
            </div>
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
