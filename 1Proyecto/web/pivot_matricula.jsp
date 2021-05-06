<%-- 
    Document   : pivot_matricula
    Created on : May 5, 2021, 9:36:36 PM
    Author     : Joaquin
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
            <a href="#">Ir a 'Mis Cursos'</a>
        </div>
    </body>
    <%@include file="footer.jsp"%>
</html>
