<%-- 
    Document   : listarcursos
    Created on : 25/04/2021, 11:07:58 AM
    Author     : ksand
--%>

<%@page import="Services.Service"%>
<%@page import="Logic.area_tematica"%>
<%@page import="java.util.Iterator"%>
<%@page import="Logic.curso"%>
<%@page import="java.util.List"%>
<%@page import="Database.cursoDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cursos</title>
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
                <center><h2>Pagina de Administrador</h2></center>  
            </div>
            <%@include file="index_topbar.jsp"%>

            <div>
                <h1>Cursos </h1>
                <div class="buscar">
                    <a class="Opciones" href="addcurso.jsp">Agregar</a>
                    <form  class="formbuscar" action="CursosAdmin">
                        <input type="text" placeholder="Buscar curso..." name ="buscar">
                        <input class="botonbuscar"type="submit" name="accion" value="Buscar">
                    </form> 
                    <%

                    %>
                </div>
                <table>
                    <thead>
                        <tr>
                            <th>ID Curso</th>
                            <th>Descripcion</th>
                            <th>Area Tematica</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <%                   
                        List<curso> cursos_oferta = (List<curso>) request.getAttribute("ListaCursos");
                    System.out.println("Lista de cursos en oferta: " + cursos_oferta);
                    Iterator<curso> iter;                    
                    iter = cursos_oferta.iterator();
                    curso c = null;
                        while (iter.hasNext()) {
                            area_tematica at = new area_tematica();
                            c = iter.next();
                            at = Service.instance().buscar_at(c.getArea_tematica_id());

                    %>
                    <tbody>
                        <tr>
                            <td><%=c.getCurso()%></td>
                            <td><%=c.getDescripcion()%></td>
                            <td><%=at.getId_area()+ ", " + at.getDescripcion() %></td>
                            <td>
                                <a class="Opciones" href="Grupos_Admin?accion=agregargrupo&id_curso=<%=c.getCurso()%>">Agregar grupo</a>
                                <a class="Opciones" href="Grupos_Admin?accion=VerGrupos&id_curso=<%=c.getCurso()%>">Ver Grupos</a>
                                
                                <a class="Opciones" href="CursosAdmin?accion=editar&id_curso=<%=c.getCurso()%>">Editar </a>
                                <a class="Opciones" href="CursosAdmin?accion=eliminar&id_curso=<%=c.getCurso()%>"">Eliminar</a>

                            </td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
            </div>
            <%@include file = "footer.jsp"%>
    </body>
</html>
