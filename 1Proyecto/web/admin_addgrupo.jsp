<%-- 
    Programación 4
    I Ciclo - 2021
    Proyecto 1 - Cursos Libres.com
    117440348 - Joaquin Barrientos Monge
    A00144883 - Kathy Sandoval Blandon
--%>

<%@page import="Logic.curso"%>
<%@page import="Database.area_tematicaDao"%>
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
                   
                    curso c = new curso();
  
                    
                    int id=Integer.parseInt((String) request.getAttribute("id_edit"));
                    try {
                        c = (curso) cDao.read(id);
                        
                    } catch (Exception e) {
                    }

                %>

                <p> <strong>Agregar grupo</strong></p>
                <p>Por favor llenar los siguientes campos para agregar un grupo nuevo al curso: <%=c.getDescripcion()%>.</p>
                <form  class ="admin" action="Grupos_Admin">
                    <div class="container">
                        <label for="cursoid"><b>Curso: </b></label>
                        <input type="text" name="cursoidshow" value ="<%=c.getDescripcion()%>" readonly><br>
                        <label for="numgrupo"><b>Numero de grupo</b></label>
                        <input type="number"  name="num_grupo" required><br>
                        <input type="hidden" name="curso_id" value="<%=c.getCurso()%>">
                        <label for="prodesorid"><b>ID del profesor</b></label><br>
                        <input type="number"  name="profesor_id" required>
                        <input type="submit" name="accion" value="Agregar">
                        <a href="cursos?accion=ver">Regresar</a>
                     
                </form>
            </div>
        </div>
    </div>

    <div> <%@include file = "footer.jsp"%>   </div>
    </body>
</html>
