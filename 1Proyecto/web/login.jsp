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
    </head>
    <body>
        <%@include file = "top_bar.jsp"%>
        <div id="wrapper">
            <p> <strong>¡Bienvenido!</strong></p>
            <p>Ingresa su numero de cedula y contraseña.</p>
            <form>
                <div class="iconologin">
                    <img src="images/login.png" alt="Avatar" class="icono">
                </div>
                <div class="container">
                    <label for="cedula"><b>Cédula</b></label>
                    <input type="text" placeholder="Ingrese su cédula" name="cedula" required>

                    <label for="contrasena"><b>Contraseña</b></label>
                    <input type="password" placeholder="Ingrese su contraseña" name="contrasena" required>
                    <button type="submit">Ingresar</button>


            </form>
        </div>
    </body>
</html>
