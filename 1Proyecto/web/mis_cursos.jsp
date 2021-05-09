<%-- 
    Document   : mis_cursos
    Created on : May 9, 2021, 8:16:01 AM
    Author     : Joaquin
--%>

<%@page import="Logic.matricula"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
        <link href="css/register.css" rel="stylesheet" type="text/css"/>
        <link href="css/forms_admin.css" rel="stylesheet" type="text/css"/>
        <title>Mis Cursos</title>
    </head>
    <div class="header">
        <h2>CursosLibres.com</h2>
        <p>Donde encontrarás cursos irónicamente útiles.</p>
    </div>
    <%@include file="index_topbar.jsp"%>
    <body>
        <h2>Historial de cursos de ${Estudiante.nombre} ${Estudiante.apellido1} ${Estudiante.apellido2}</h2>
        <table style="margin: auto; margin-bottom: 60px;">
            <thead style="border-bottom: 2px solid brown">
                <tr>
                    <th>Nombre Curso</th>
                    <th>Horario</th>
                    <th>Profesor</th>
                    <th>Estado</th>
                    <th>Nota</th>
                </tr>
            </thead>
            <tbody>
                <% String current = (String) session.getAttribute("historico");
                    out.print(current);
                 %>
            </tbody>
        </table>
            <div style="margin: auto;"><a href="#">EXPORTAR A PDF</a></div>    
            
    </body>
    <%@include file="footer.jsp"%>
</html>
