<%-- 
    Document   : editcurso
    Created on : 25/04/2021, 01:25:32 PM
    Author     : ksand
--%>

<%@page import="Logic.curso"%>
<%@page import="java.lang.String"%>
<%@page import="Database.cursoDao"%>
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

                Bienvenido/a <%=request.getAttribute("userName")%> </div>
        </div>
        <div class = "topbar">
            <a class="active" href="home">Inicio</a>
            <a href="Controller_Cursos_Admin?accion=listar">Cursos</a>
            <a href="Controller_Profesores_Admin?accion=listar">Profesores</a>

        </div>
        <div id="wrapper"> 
            <div id="EditarCurso">
                <%
                    cursoDao cDao = new cursoDao();
                    curso c = new curso();
                    int id=Integer.parseInt((String) request.getAttribute("id_edit"));
                    try {
                        c = (curso) cDao.read(id);
                    } catch (Exception e) {
                    }

                %>

                <p> <strong>Editar curso</strong></p>
                <p>Por favor llenar los siguientes campos para editar el curso</p>
                <form action="Administrador">
                    <div class="container">
                        <input type="hidden" name="id_curso" value="<%=c.getCurso()%>">
                        <label for="descripcion"><b>Descripcion</b></label>
                        <input type="text"  name="descripcion" required value="<%=c.getDescripcion()%>">
                        <label for="areatematica"><b>Area Tematica</b></label>
                        <input type="number" name="area_tematica_id" required value="<%=c.getArea_tematica_id()%>">

                        <input type="submit" name="accion" value="Actualizar">
                        <a href="Controller_Cursos_Admin?accion=listar">Regresar</a>

                </form>
            </div>
        </div>
    </div>

    <div> <%@include file = "footer.jsp"%>   </div>
</body>
</html>
