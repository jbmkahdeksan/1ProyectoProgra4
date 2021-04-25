<%-- 
    Document   : index_topbar
    Created on : Apr 24, 2021, 8:26:29 PM
    Author     : Joaquin
--%>

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
        <div class="header">
                <h2>CursosLibres.com</h2>
                <p>Donde encontrarás cursos irónicamente útiles.</p>
        </div>
        <div class = "topbar">  
            <a class="active" href="home">Inicio</a>
            
            <%usuario u = (usuario) session.getAttribute("Usuario"); System.out.println(u);%>
            <%if (u == null){%>
            <a href="login.jsp">Ingresar</a> 
            <%}else{%>
                <a href="#">Cerrar sesión</a>
                <%if(u.getRol_id()==1){%>
                    <%administrador a = (administrador) session.getAttribute("Administrador");
                    if(a == null){
                        System.out.println("a es NULL :(");
                    }                    
                    %>
                    <a href="#">Perfil de </a>
                <%}%>
                <%if(u.getRol_id()==2){%>
                    <%profesor p = (profesor) session.getAttribute("Profesor");%>
                    <a href="#">Perfil de <%p.getNombre();%></a>
                <%}%>
                <%if(u.getRol_id()==3){%>
                    <%Estudiante e = (Estudiante) session.getAttribute("Profesor");%>
                    <a href="#">Perfil de <%e.getNombre();%></a>
                <%}%>
            <%}%>                 
            <div class="search-container">
                <form>
                    <input type="text" placeholder="Buscar curso..." name ="search">
                    <button type="submit">🔍</i></button>
                </form>
            </div>
        </div>
    </body>
</html>
