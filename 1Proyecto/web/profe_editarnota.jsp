<%-- 
    Document   : profe_editarnota
    Created on : 05/05/2021, 10:05:46 PM
    Author     : ksand
--%>

<%@page import="Services.Service"%>
<%@page import="Logic.curso"%>
<%@page import="Database.EstudiantesDAO"%>
<%@page import="Logic.matricula"%>
<%@page import="Database.matriculaDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profesores</title>
        <meta charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/default.css" rel="stylesheet" type="text/css"/> 
        <link href="css/register.css" rel="stylesheet" type="text/css"/>
        <link href="css/forms_admin.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
       <div class="header">
            <h2>CursosLibres.com</h2>
            <p>Donde encontrarás cursos irónicamente útiles.</p>
            <div style="text-align: left">
                <center><h2>Pagina de Profesores</h2></center>     
        </div>
        <%@include file="index_topbar.jsp"%>
        <div id="wrapper"> 
            <div id="EditarGrupo">
                <%
                    matriculaDao cDao = new matriculaDao();
                    EstudiantesDAO eDao = new EstudiantesDAO();
                    
                    matricula m = new matricula();
                    Estudiante ex = null;
                    curso c = null;
  
                    
                    int num_grupo=Integer.parseInt((String) request.getAttribute("id_g_edit"));
                    int curso_id=Integer.parseInt((String) request.getAttribute("id_c_edit"));
                    int estudiante_id=Integer.parseInt((String) request.getAttribute("id_e_edit"));

                    try {
                        m = (matricula) cDao.readall(estudiante_id, num_grupo, curso_id);
                        ex = (Estudiante) eDao.read(Integer.toString(estudiante_id));
                        c = (curso) Service.instance().getCurso_int(curso_id);
                    } catch (Exception e) {
                    }

                %>

                <p> <strong>Editar nota</strong></p>
                <p>Por favor llenar los siguientes campos para actualizar la nota.</p>
                <p>Si el estudiante no se presento introduzca un 1 en la nota si el curso ya esta concluido.</p>
                <form  class ="admin" action="Profe_Estud">
                    <div class="container">
                        <input type="hidden" name="grupo_num" value="<%=m.getGrupo_num()%>">
                        <label for="estudiante_ids"><b>Estudiante</b></label>
                        <input type="hidden" name="estudiante_id" value="<%=m.getEstudiante_id()%>">
                        <input type="text" name="estudiante_ids" value ="<%=ex.getNombre() + " " + ex.getApellido1()%>" readonly><br>
                        <label for="curso"><b>Curso</b></label><br>
                        <input type="hidden" name="curso_id" value="<%=m.getCurso_id()%>">
                        <input type="text" name="curso_ids" value ="<%=c.getDescripcion()%>" readonly><br>
                        <label for="notas"><b>Nota</b></label><br>
                        <input type="number" name="nota" required>
                        <input type="submit" name="accion" value="Actualizar">
                        <a href="Controller_Estud_Profe?accion=ver&num_grupo=<%=m.getGrupo_num()%>&curso_id=<%=m.getCurso_id()%>">Regresar</a>

                </form>
            </div>
        </div>
    </div>

    <div> <%@include file = "footer.jsp"%>   </div>
    </body>
</html>
