<%-- 
    Document   : top_bar
    Created on : Apr 17, 2021, 9:37:06 PM
    Author     : Joaquin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="wrapper">
            <div class="header">
                <h2>CursosLibres.com</h2>
                <p>Donde encontrarás cursos irónicamente útiles.</p>
            </div>
            <div class = "topbar">
              <a class="active" href="index.jsp">Inicio</a>
              <a href="login.jsp">Ingresar</a>   
              <div class="search-container">
                  <form action="#">
                        <input id="search" type="text" placeholder="Buscar curso..." name="search">
                        <button type="submit">🔍</button>
                  </form>                   
              </div>
            </div>            
        </div>    
    </body>
</html>
