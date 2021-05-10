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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/profile.css" rel="stylesheet" type="text/css"/>
        <title>Matricula</title>
    </head>
    <body>
        <div class="header">
            <h2>CursosLibres.com</h2>
            <p>Donde encontrarás cursos irónicamente útiles.</p>
            <div style="text-align: left">
        </div>
        <%@include file="index_topbar.jsp"%>
        <div class="card">
            <%String msg = (String)request.getAttribute("mensaje");
              String color = (String) request.getAttribute("color");
            if (msg != null){
            %>
            <h4 style="color:<%out.print(color);%>;"><%out.print(msg);%></h4>
            <%}%>
            <a href="Controller_Historial">Ir a 'Mis Cursos'</a>
        </div>
    </body>
    <%@include file="footer.jsp"%>
</html>
