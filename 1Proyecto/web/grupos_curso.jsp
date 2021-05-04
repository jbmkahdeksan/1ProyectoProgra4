<%-- 
    Document   : grupos_curso
    Created on : May 3, 2021, 7:03:03 PM
    Author     : Joaquin
--%>

<%@page import="Logic.curso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <body>
        <div class="header">
            <h2>CursosLibres.com</h2>
            <p>Donde encontrarás cursos irónicamente útiles.</p>
            <div style="text-align: left">
            </div>
            <%@include file="index_topbar.jsp"%>

            <%curso c = (curso) request.getAttribute("curso_actual");%>

            <h1><%out.print(c.getDescripcion());%></h1>

            <table>
                <thead>
                    <tr>
                        <th>N° Grupo</th>
                        <th>Curso</th>
                        <th>Profesor</th>
                        <th>Horario</th>
                        <th>Acciones</th>
                    </tr>
                </thead>


            </table>

    </body>
    <%@include file="footer.jsp"%>
</html>
