<%-- 
    Document   : addcurso
    Created on : 25/04/2021, 12:32:54 PM
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
        <div class = "topbar">
            <a class="active" href="home">Inicio</a>
            <a href="Controller_Cursos_Admin?accion=listar">Cursos</a>
            <a href="Controller_Profesores_Admin?accion=listar">Profesores</a>
                
            </div>
        <div id="wrapper"> 
            <div id="AddCurso">
                <p> <strong>Crear curso nuevo</strong></p>
                <p>Por favor llenar los siguientes campos para crear un curso nuevo. </p>
                <form action="Administrador">
                    <div class="container">
                        <label for="ID Curso"><b>ID Curso</b></label>
                        <input type="number"  name="id_curso" required>
                        <label for="descripcion"><b>Descripcion</b></label>
                        <input type="text"  name="descripcion" required>
                        <label for="areatematica"><b>Area Tematica</b></label>
                        <input type="number" name="area_tematica_id" required>     
                        <input type="submit" name="accion" value="Agregar" href="listarcursos.jsp">
                        
                </form>
            </div>
            </div>
        </div>
            
                <div> <%@include file = "footer.jsp"%>   </div>
    </body>
</html>
