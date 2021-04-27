<%-- 
    Document   : profesores
    Created on : 25/04/2021, 06:26:03 PM
    Author     : ksand
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="Logic.profesor"%>
<%@page import="Logic.profesor"%>
<%@page import="Database.ProfesorDAO"%>
<%@page import="Database.cursoDao"%>
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
                <center><h2>Pagina de Administrador</h2></center>
            </div>
            <%@include file="index_topbar.jsp"%>
            <div class="adminfunc">
                <h1>Profesores</h1>
                <div class="buscar">
                    <a class="Opciones" href="addprofesor.jsp">Agregar</a>
                    <form id="formbuscar">
                        <input type="text" placeholder="Buscar profesor/a..." name ="buscar">
                        <input id="botonbuscar"type="submit" name="accion" value="Buscar">
                    </form> 
                </div>
                <table>
                    <thead>
                        <tr>
                            <th>ID Profesor</th>
                            <th>ID Usuario</th>
                            <th>Primer Apellido</th>
                            <th>Segundo Apellido</th>
                            <th>Nombre</th>
                            <th>Telefono</th>
                            <th>Correo</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <%
                        ProfesorDAO dao = new ProfesorDAO();
                        Iterator<profesor> iter;
                        List<profesor> lista = dao.findAll();
                        iter = lista.iterator();
                        profesor p = null;
                        while (iter.hasNext()) {
                            p = iter.next();
                    %>
                    <tbody>
                        <tr>
                            <td><%out.print(p.getId_profesor());%></td>
                            <td><%out.print(p.getUsuario_id());%></td>
                            <td><%out.print(p.getApellido1());%></td>
                            <td><%out.print(p.getApellido2());%></td>
                            <td><%out.print(p.getNombre());%></td>
                            <td><%out.print(p.getTelefono());%></td>
                            <td><%out.print(p.getE_mail());%></td>
                            <td>
                                <a class="Opciones" >Ver Especialidades</a>
                                <a class="Opciones" href="Controller_Profesores_Admin?accion=editar&id_profesor=<%=p.getId_profesor()%>">Editar </a>
                                <a class="Opciones" href="Controller_Profesores_Admin?accion=eliminar&id_profesor=<%=p.getId_profesor()%>"">Eliminar</a>

                            </td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
            </div>
            <%@include file = "footer.jsp"%> 
    </body>
</html>
