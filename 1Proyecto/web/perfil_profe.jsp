<%-- 
    Document   : estudiante
    Created on : Apr 30, 2021, 5:01:08 PM
    Author     : Joaquin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <title>Estudiante</title>
        <link href="css/profile.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="header">
            <h2>CursosLibres.com</h2>
            <p>Donde encontrarás cursos irónicamente útiles.</p>
        </div>
        <%@include file="index_topbar.jsp"%>
        <%usuario usu = (usuario) session.getAttribute("Usuario");%>
        <div class="card">
            <h1>${profesor.getNombre()}</h1>
            <p class="title">Profesor/a de CursosLibres.com</p>
            <p style="float:left;">Información:</p>
            <ul style="float:left;">
                <li><strong>Identificación: </strong>${profesor.getId_profesor()}</li>
                <li><strong>Nombre completo: </strong>
                    ${profesor.getNombre()}
                    ${profesor.getApellido1()} 
                    ${profesor.getApellido2()} 
                </li>                
                <li><strong>Correo: </strong>${profesor.getE_mail()}</li>
                <li><strong>Teléfono: </strong>${profesor.getTelefono()}</li>
            </ul>
            <p style="float:left;">Credenciales:</p>
            <ul style="float:left;">
                <li><strong>ID: </strong><%out.print(usu.getId());%></li>
                <li><strong>Clave: </strong><%out.print(usu.getClave());%></li>
            </ul>
        </div>
    </body>
    <%@include file="footer.jsp"%>
</html>
