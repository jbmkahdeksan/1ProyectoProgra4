<%-- 
    Document   : admin_editargrupo
    Created on : 01/05/2021, 10:08:32 PM
    Author     : ksand
--%>

<%@page import="Logic.grupo"%>
<%@page import="Database.grupoDao"%>
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
            <div id="EditarGrupo">
                <%
                    grupoDao gDao = new grupoDao();
                    grupo g = new grupo();
  
                    
                    int id=Integer.parseInt((String) request.getAttribute("id_g_edit"));
                    int id_c=Integer.parseInt((String) request.getAttribute("id_c_edit"));
                    try {
                        g = (grupo) gDao.read(id, id_c);
                        
                    } catch (Exception e) {
                    }

                %>

                <p> <strong>Editar grupo</strong></p>
                <p>Por favor llenar los siguientes campos para editar el grupo.</p>
                <form  class ="admin" action="Grupos_Admin">
                    <div class="container">
                        <input type="hidden" name="num_grupo" value="<%=g.getNum_grupo()%>">
                        <label for="idcurso"><b>ID Curso</b></label>
                        <input type="number"  name="curso_id" required value="<%=g.getCurso_id()%>"><br>
                        <label for="idprofesor"><b>ID Profesor</b></label><br>
                        <input type="number" name="profesor_id" required value="<%=g.getProfesor_id()%>">

                        <input type="submit" name="accion" value="Actualizar">
                        <a href="Controller_Grupos_Admin?accion=VerGrupos&id_curso=<%=g.getCurso_id()%>">Regresar</a>

                </form>
            </div>
        </div>
    </div>

    <div> <%@include file = "footer.jsp"%>   </div>
    </body>
</html>
