<%-- 
    Document   : editprofesor
    Created on : 25/04/2021, 06:26:31 PM
    Author     : ksand
--%>

<%@page import="Database.ProfesorDAO"%>
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
            <div id="EditarCurso">
                <%
                    ProfesorDAO dao= new ProfesorDAO();
                    profesor p = new profesor();
                    int id=Integer.parseInt((String) request.getAttribute("id_edit"));
                    try {
                        p = (profesor) dao.read(id);
                    } catch (Exception e) {
                    }

                %>

                <p> <strong>Editar profesor</strong></p>
                <p>Por favor llenar los siguientes campos para editar el profesor</p>
                <form action="AdminProfes">
                    <div class="container">
                        <input type="hidden" name="id_profesor" value="<%=p.getId_profesor() %>">
                        <label for="usuario"><b>ID Usuario</b></label>
                        <input type="text"  name="usuario_id" required value="<%=p.getUsuario_id()%>">
                        <label for="apellido_1"><b>Primer Apellido</b></label>
                        <input type="text"  name="apellido1" required value="<%=p.getApellido1()%>">
                        <label for="apellido_2"><b>Segundo Apellido</b></label>
                        <input type="text"  name="apellido2" required value="<%=p.getApellido2()%>">
                        <label for="nombre1"><b>Nombre</b></label>
                        <input type="text"  name="nombre" required value="<%=p.getNombre()%>">
                        <label for="telefono1"><b>Telefono</b></label>
                        <input type="text"  name="telefono" required value="<%=p.getTelefono()%>">
                        <label for="Correo1"><b>Correo</b></label>
                        <input type="text"  name="e_mail" required value="<%=p.getE_mail()%>">
                        <input type="submit" name="accion" value="Actualizar">
                        <a href="Controller_Profesores_Admin?accion=listar">Regresar</a>

                </form>
            </div>
        </div>
    </div>

    <div> <%@include file = "footer.jsp"%>   </div>
    </body>
</html>
