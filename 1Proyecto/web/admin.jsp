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
        <link href="css/profile.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <div class="header">
            <h2>CursosLibres.com</h2>
            <p>Donde encontrarás cursos irónicamente útiles.</p>
            <div style="text-align: left">
        </div>
        <%@include file="index_topbar.jsp" %>
         <%usuario usu = (usuario) session.getAttribute("Usuario");%>
        <div class="card">
            <h1> Bienvenido/a, ${administrador.getNombre()}</h1>
            <p class="title">Administrador de CursosLibres.com</p>
            <p style="float:left;">Información:</p>
            <ul style="float:left;">
                <li><strong>Identificación: </strong>${administrador.getId_administrador()}</li>
                <li><strong>Nombre completo: </strong>
                    ${administrador.getNombre()}
                    ${administrador.getApellido1()} 
                    ${administrador.getApellido2()} 
                </li>                
                <li><strong>Correo: </strong>${administrador.getE_mail()}</li>
                <li><strong>Teléfono: </strong>${administrador.getTelefono()}</li>
            </ul>
            <p style="float:left;">Credenciales:</p>
            <ul style="float:left;">
                <li><strong>ID: </strong><%out.print(usu.getId());%></li>
                <li><strong>Clave: </strong><%out.print(usu.getClave());%></li>
            </ul>
        </div>
        
    </body><%@include file = "footer.jsp"%>  
</html>
