<%-- 
    Document   : addprofesores
    Created on : 25/04/2021, 06:26:16 PM
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
        <link href="css/register.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <div class="header">
            <h2>CursosLibres.com</h2>
            <p>Donde encontrarás cursos irónicamente útiles.</p>
            <div style="text-align: left">
                <center><h2>Pagina de Administrador</h2></center>
        </div>
         <%@include file="index_topbar.jsp"%>
        <div id="wrapper"> 
            <div class="adminfunc" id="AddProfesor">
                <p> <strong>Agregar nuevo</strong></p>
                <p>Por favor llenar los siguientes campos para agregar un profesor nuevo. </p>
                <form action="AdminProfes">
                    <div class="container">
                        <label for="ID Profesor"><b>ID Profesor </b></label>
                        <input type="number"  name="id_profesor" required>
                        <label for="usuario"><b>ID_Usuario</b></label>
                        <input type="text"  name="usuario_id" required>
                         <label for="apellido_1"><b>Primer Apellido</b></label>
                        <input type="text"  name="apellido1" required>
                        <label for="apellido_2"><b>Segundo Apellido</b></label>
                        <input type="text"  name="apellido2" required>
                        <label for="nombres"><b>Nombre</b></label>
                        <input type="text"  name="nombre" required>
                        <label for="telefonso"><b>Telefono</b></label>
                        <input type="text"  name="telefono" required>
                        <label for="correos"><b>Correo</b></label>
                        <input type="text"  name="e_mail" required>
                        <input type="submit" name="accion" value="Agregar" href="profesores.jsp">
                </form>
            </div>
            </div>
        </div>
            
                <div> <%@include file = "footer.jsp"%>   </div>
    </body>
</html>
