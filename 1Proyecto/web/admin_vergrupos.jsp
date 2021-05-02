<%-- 
    Document   : admin_vergrupos
    Created on : 01/05/2021, 09:12:23 PM
    Author     : ksand
--%>

<%@page import="java.util.Iterator"%>
<%@page import="Logic.grupo"%>
<%@page import="java.util.List"%>
<%@page import="Logic.curso"%>
<%@page import="Database.grupoDao"%>
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
        <link href="css/register.css" rel="stylesheet" type="text/css"/>
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
       <h1>Grupos </h1>
                <div class="buscar">
                    <a class="Opciones" href="#">Agregar</a>
                    <form  class="formbuscar">
                        <input type="text" placeholder="Buscar grupo..." name ="buscar">
                        <input class="botonbuscar"type="submit" name="accion" value="Buscar">
                    </form> 
                    </div>
        <div>
                
                <table>
                    <thead>
                        <tr>
                            <th>N Grupo</th>
                            <th>Curso</th>
                            <th>Profesor</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <%                    
                        cursoDao cDao = new cursoDao();
                        grupoDao gDao = new grupoDao();
                        curso c = new curso();

                        int id = Integer.parseInt((String) request.getAttribute("id_edit"));
                        try {
                            c = (curso) cDao.read(id);

                        } catch (Exception e) {
                        }
                        List<grupo> listag = gDao.findByCurso(c);
                        Iterator<grupo> iter;
                        iter = listag.iterator();
                        grupo g = null;
                        while (iter.hasNext()) {
                            g = iter.next();

                    %>

                    <tbody>
                        <tr>
                            <td><%=g.getNum_grupo()%></td>
                            <td><%=c.getDescripcion()%></td>
                            <td><%=g.getProfesor_id()%></td>
                            <td>
                                <a class="Opciones" href="#">Ver Horarios</a>
                                <a class="Opciones" href="Controller_Grupos_Admin?accion=editar&num_grupo=<%=g.getNum_grupo()%>">Editar</a>
                                <a class="Opciones" href="Controller_Grupos_Admin?accion=eliminar&num_grupo=<%=g.getNum_grupo()%>&curso_id=<%=g.getCurso_id()%>">Eliminar</a>

                            </td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
                    <a href="listarcursos.jsp">Regresar</a>
            </div>
            <%@include file = "footer.jsp"%>
    </body>
</html>
