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
        <%usuario usu = (usuario) session.getAttribute("Usuario");%>
        <div class="card">
            <h1>${profesor.getNombre()}</h1>
            <p class="title">Profesor/a de CursosLibres.com</p>
            <p>Información:</p>
            <ul>
                <li><strong>Identificación: </strong>${profesor.getId_profesor()}</li>
                <li><strong>Nombre completo: </strong>
                    ${profesor.getNombre()}
                    ${profesor.getApellido1()} 
                    ${profesor.getApellido2()} 
                </li>                
                <li><strong>Correo: </strong>${profesor.getE_mail()}</li>
                <li><strong>Teléfono: </strong>${profesor.getTelefono()}</li>
            </ul>
            <p>Credenciales:</p>
            <ul>
                <li><strong>ID: </strong><%out.print(usu.getId());%></li>
                <li><strong>Clave: </strong><%out.print(usu.getClave());%></li>
            </ul>
        </div>
    </body>
    <%@include file="footer.jsp"%>
</html>
