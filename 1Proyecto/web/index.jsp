<%-- 
    Programación 4
    I Ciclo - 2021
    Proyecto 1 - Cursos Libres.com
    117440348 - Joaquin Barrientos Monge
    A00144883 - Kathy Sandoval Blandon
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="Logic.curso"%>
<%@page import="Servlets.Controller_Index"%>
<%@page import="Logic.usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head> 
        <title>Cursos Libres (Proyecto 1)</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
    </head>
    
    
    <body>
        <div class="header">
            <h2>CursosLibres.com</h2>
            <p>Donde encontrarás cursos irónicamente útiles.</p>
        </div>
        <%@include file="index_topbar.jsp"%>
        <h1>Nuestro catálogo de cursos</h1>
        <div id="wrapper">
            <div>
                <div>
                   <ul>
                    <%
                    List<curso> cursos_oferta = (List<curso>) request.getAttribute("ListaCursos");
                    System.out.println("Lista de cursos en oferta: " + cursos_oferta);
                    Iterator<curso> iter;                    
                    iter = cursos_oferta.iterator();
                    curso c = null;
                    while (iter.hasNext()) {
                        c = iter.next();
                    %>
                        <li>
                            <img src="images/cursos/<%=c.getCurso()%>.jpg">
                            <span style="vertical-align:middle"><strong><%out.print(c.getDescripcion());%></strong></span>
                            <small>
                                <a id="info" href="grupos_curso?codigo=<%=c.getCurso()%>"><strong>Más información</strong></a>
                            </small>
                        </li>
                        <%}%>
                    </ul>
                </div>  
            </div>


        </div>  
    </body>
    <%@include file="footer.jsp"%>
</html>
