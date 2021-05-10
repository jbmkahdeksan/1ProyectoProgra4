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
        <%usuario us = (usuario) session.getAttribute("Usuario");%>
        <div class="card">
            <h1>${Estudiante.getNombre()}</h1>
            <p class="title">Estudiante de CursosLibres.com</p>
            <p>Información:</p>
            <ul>
                <li><strong>Identificación: </strong>${Estudiante.getId_estudiante()}</li>
                <li><strong>Nombre completo: </strong>
                    ${Estudiante.getNombre()}
                    ${Estudiante.getApellido1()} 
                    ${Estudiante.getApellido2()} 
                </li>                
                <li><strong>Correo: </strong>${Estudiante.getE_mail()}</li>
                <li><strong>Teléfono: </strong>${Estudiante.getTelefono()}</li>
            </ul>
            <p>Credenciales:</p>
            <ul>
                <li><strong>ID: </strong><%out.print(us.getId());%></li>
                <li><strong>Clave: </strong><%out.print(us.getClave());%></li>
            </ul>
        </div>
    </body>
    <%@include file="footer.jsp"%>
</html>
