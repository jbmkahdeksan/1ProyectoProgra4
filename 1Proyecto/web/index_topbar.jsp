<%-- 
    Document   : index_topbar
    Created on : Apr 24, 2021, 8:26:29 PM
    Author     : Joaquin
--%>

<%@page import="Servlets.Controller_Logout"%>
<%@page import="Logic.Estudiante"%>
<%@page import="Logic.profesor"%>
<%@page import="Logic.administrador"%>
<%@page import="Logic.usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
    </head>
    <body>
        <div class = "topbar">  
            <a href="home">Inicio</a>            
            <%usuario u = (usuario) session.getAttribute("Usuario");
                System.out.println(u);%>
            <%if (u == null) {%>
            <a href="login.jsp">Ingresar</a> 
            <%} else {%>               
            <%if (u.getRol_id() == 1) {%>
            <jsp:useBean class="Logic.administrador" id="administrador" scope="session"></jsp:useBean>
            <a class="active" href="admin.jsp">Perfil de ${administrador.getNombre()}</a>
            <div class="dropdown">
                <button class="dropbtn">Opciones de Administrador</button>
                <div class="dropdown-content">
                    <a href="#">Profesores</a>
                    <a href="#">Cursos</a>
                </div>
            </div> 
            <%}%>
            <%if (u.getRol_id() == 2) {%>
            <jsp:useBean class="Logic.profesor" id="profesor" scope="session"></jsp:useBean>
            <a class="active" href="#">Perfil de ${profesor.getNombre()}</a>
            <div class="dropdown">
                <button class="dropbtn">Opciones de Profesor</button>
                <div class="dropdown-content">
                    <a href="#">Grupos</a>
                </div>
            </div>
            <%}%>
            <%if (u.getRol_id() == 3) {%>
            <jsp:useBean class="Logic.Estudiante" id="Estudiante" scope="session"></jsp:useBean>
            <a class="active" href="#">Perfil de ${Estudiante.getNombre()}</a>
            <div class="dropdown">
                <button class="dropbtn">Opciones de Estudiantes</button>
                <div class="dropdown-content">
                    <a href="#">Historial de cursos</a>
                </div>
            </div>
            <%}%>
            <a href="CerrarSesion">Cerrar sesión</a>
            <%}%>   
            <%String myURI = request.getRequestURI(); System.out.println(myURI); %>
            <%if (myURI.equals("/1Proyecto/index.jsp") || myURI.equals("/1Proyecto/")){%>
            <div class="search-container">
                <form>
                    <input type="text" placeholder="Buscar curso..." name ="search">
                    <button type="submit">🔍</i></button>
                </form>
            </div>
            <%}%>           
        </div>

    </body>
</html>
