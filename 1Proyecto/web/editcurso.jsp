<%-- 
    Document   : editcurso
    Created on : 25/04/2021, 01:25:32 PM
    Author     : ksand
--%>

<%@page import="Database.area_tematicaDao"%>
<%@page import="Logic.area_tematica"%>
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
        <link href="css/forms_admin.css" rel="stylesheet" type="text/css"/>

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
                    cursoDao cDao = new cursoDao();
                    area_tematicaDao areaDao= new area_tematicaDao();
                    curso c = new curso();
  
                    
                    int id=Integer.parseInt((String) request.getAttribute("id_edit"));
                    try {
                        c = (curso) cDao.read(id);
                        
                    } catch (Exception e) {
                    }

                %>

                <p> <strong>Editar curso</strong></p>
                <p>Por favor llenar los siguientes campos para editar el curso</p>
                <form  class ="admin" action="Administrador">
                    <div class="container">
                        <input type="hidden" name="id_curso" value="<%=c.getCurso()%>">
                        <label for="descripcion"><b>Descripcion</b></label>
                        <input type="text"  name="descripcion" required value="<%=c.getDescripcion()%>">
                        <label for="areatematica"><b>Area Tematica</b></label><br>
                        <label for="areatematica2" >(Cambie el numero del area usando las referencias)</label><br>
                        <input type="number" name="area_tematica_id" placeholder="100, Redes 200, Base de Datos 300, Idiomas" required value="<%=c.getArea_tematica_id()%>">

                        <input type="submit" name="accion" value="Actualizar">
                        <a href="cursos?accion=ver">Regresar</a>

                </form>
            </div>
        </div>
    </div>

    <div> <%@include file = "footer.jsp"%>   </div>
</body>
</html>
