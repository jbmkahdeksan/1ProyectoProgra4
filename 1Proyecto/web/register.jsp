<%-- 
    Document   : register
    Created on : 18/04/2021, 03:39:43 PM
    Author     : ksand
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registro</title>
        <meta charset="UTF-8">        
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
        <link href="css/register.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file = "top_bar.jsp"%>
        <div id="wrapper"> 
            <div id = "Bienvenido">  
                <p> <strong>Registro</strong></p>
                <p>Por favor llenar los siguientes campos para registrarse. </p>
                <form>
                    <div class="container">
                        <label for="cedula"><b>Cédula</b></label>
                        <input type="text" placeholder="Ingrese su cédula" name="cedula" required>
                        <label for="nombre"><b>Nombre</b></label>
                        <input type="text" placeholder="Nombre" name="nombre" required>
                        <label for="correo"><b>Correo electronico</b></label>
                        <input type="text" placeholder="Correo electronico" name="correo" required>
                        <label for="telefono"><b>Teléfono</b></label>
                        <input type="text" placeholder="Número de télefono" name="telefono" required>
                        <button type="submit">Registrar</button>
                        <div class="container">
                            <span class="registro">¿Ya tienes cuenta? <a href="login.jsp">Ingresa aquí</a></span>
                        </div>

                </form>
            </div>
        </div>
    </body>
</html>
