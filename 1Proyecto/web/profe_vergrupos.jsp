<%-- 
    Document   : profe_vergrupos
    Created on : 02/05/2021, 08:40:19 PM
    Author     : ksand
--%>

<%@page import="Services.Service"%>
<%@page import="Database.cursoDao"%>
<%@page import="Logic.curso"%>
<%@page import="Logic.horario"%>
<%@page import="java.util.Iterator"%>
<%@page import="Database.grupoDao"%>
<%@page import="Logic.grupo"%>
<%@page import="java.util.List"%>
<%@page import="Database.ProfesorDAO"%>
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
    </head>
    <body>
        <div class="header">
            <h2>CursosLibres.com</h2>
            <p>Donde encontrarás cursos irónicamente útiles.</p>

            <div style="text-align: left">

                <center><h2>Pagina de Profesores</h2></center>  

            </div>
            
            <%@include file="index_topbar.jsp"%>
            <h1>Grupos </h1>
            <div class="buscar">
                <form  class="formbuscar">
                    <input type="text" placeholder="Buscar grupo..." name ="buscar">
                    <input class="botonbuscar"type="submit" name="accion" value="Buscar">
                </form> 
            </div>
            <div>

                <table>
                    <thead>
                        <tr>
                            <th>N° Grupo</th>
                            <th>Curso</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <%
                        ProfesorDAO pDao = new ProfesorDAO();
                        grupoDao gDao = new grupoDao();

                        profesor p = new profesor();


                        int id = Integer.parseInt((String) request.getAttribute("id_edit"));
                        try {
                            p = (profesor) pDao.read(id);

                        } catch (Exception e) {
                        }
                        List<grupo> listag = gDao.findByProfesor(p);
                        Iterator<grupo> iter;
                        iter = listag.iterator();
                        grupo g = null;
                        while (iter.hasNext()) {
                            curso c = new curso();
                            cursoDao cDao = new cursoDao();
                            g = iter.next();
                            c= Service.instance().buscar_curso(g.getCurso_id());
                                                   
                            
                    %>

                    <tbody>
                        <tr>
                            <td><%=g.getNum_grupo()%></td>
                            <td><%=c.getDescripcion()%></td>
                            <td> 
                                <a class="Opciones" href="Controller_Estud_Profe?accion=ver&num_grupo=<%=g.getNum_grupo()%>&curso_id=<%=g.getCurso_id()%>">Ver Estudiantes</a>
                            </td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
            </div>
            <%@include file = "footer.jsp"%>
    </body>
</html>
