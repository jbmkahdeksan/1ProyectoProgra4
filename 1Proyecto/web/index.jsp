<%-- 
    Document   : index
    Created on : Apr 17, 2021, 7:40:09 PM
    Author     : Joaquin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head> 
        <title>Cursos Libres (Proyecto 1)</title>
        <meta charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="header">
                <h2>CursosLibres.com</h2>
                <p>Donde encontrarás cursos irónicamente útiles.</p>
        </div>
        <div class = "topbar">
            <a class="active" href="home">Inicio</a>
            <a href="login.jsp">Ingresar</a>
            <a href="admin.jsp">Administrador</a>
        </div>
        <div id="wrapper">
            <table>
                
            </table>  
        </div>  
        <%@include file = "footer.jsp"%>
    </body>
</html>
