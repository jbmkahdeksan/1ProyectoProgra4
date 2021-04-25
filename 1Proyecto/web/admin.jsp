<%-- 
    Document   : admin
    Created on : 24/04/2021, 09:51:12 PM
    Author     : ksand
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrador</title>
        <meta charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
        <link href="css/admin.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <div class="header">
            <h2>CursosLibres.com</h2>
            <p>Donde encontrarás cursos irónicamente útiles.</p>
            <div style="text-align: left">
                <center><h2>Pagina de Administrador</h2></center>

                Bienvenido/a <%=request.getAttribute("userName")%> </div>
        </div>
        <div class = "topbar">
            <a class="active" href="home">Inicio</a>
            <div class="Menu">
                <button class="BotonMenu">Cursos
                    <i class="fa fa-caret-down"></i>
                </button>
                <div class="Menu-Contenido">
                    <a href="#">Ver Cursos</a>
                    <a href="#">Buscar Cursos</a>
                    <a href="#">Agregar Cursos</a>
                </div> </div>
                <div class="Menu">
                <button class="BotonMenu">Profesores
                    <i class="fa fa-caret-down"></i>
                </button>
                <div class="Menu-Contenido">
                    <a href="#">Ver Profesores</a>
                    <a href="#">Buscar Profesores</a>
                    <a href="#">Agregar Profesores</a>
                </div>
                
            </div> </div> 

            
<div <%@include file = "footer.jsp"%>   </div>
    </body>
</html>
