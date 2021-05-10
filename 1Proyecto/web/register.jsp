<%-- 
    Programación 4
    I Ciclo - 2021
    Proyecto 1 - Cursos Libres.com
    117440348 - Joaquin Barrientos Monge
    A00144883 - Kathy Sandoval Blandon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registro</title>
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
            <a href="login.jsp">Ingresar</a>             
            <a class="active">Registrarse</a>
        </div>
        <div id="wrapper"> 
            <div id = "Bienvenido">  
                <p> <strong>Registro</strong></p>
                <% String error = (String) request.getAttribute("Error");%>
                <%if (error != null){%>
                <p style="color:red"> <%out.print(error);}%> </p>
                <p>Por favor llenar los siguientes campos para registrarse. </p>
                <form action="ServicioFormulario" method="POST">
                    <div class="container">
                        <label for="cedula"><b>Cédula</b></label>
                        <input type="text" placeholder="Ingrese su cédula" name="cedula" required>
                        <label for="nombre"><b>Nombre</b></label>
                        <input type="text" placeholder="Ingrese su nombre" name="nombre" required>
                        <label for="apellido1"><b>Primer Apellido</b></label>
                        <input type="text" placeholder="Ingrese su primer apellido" name="apellido1" required>
                        <label for="apellido2"><b>Segundo Apellido</b></label>
                        <input type="text" placeholder="Ingrese su segundo apellido" name="apellido2" >
                        <label for="correo"><b>Correo electronico</b></label>
                        <input type="text" placeholder="Ingrese su email" name="correo" required>
                        <label for="telefono"><b>Teléfono</b></label>
                        <input type="text" placeholder="Ingrese su número de teléfono" name="telefono" required>
                        <button class="boton" type="submit">Registrar</button>
                        <div class="container">
                            <span class="registro">¿Ya tienes cuenta? <a href="login.jsp">Ingresa aquí</a></span>
                        </div>
                </form>
            </div>
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
