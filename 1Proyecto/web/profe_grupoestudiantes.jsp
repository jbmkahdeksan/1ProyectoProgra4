<%-- 
    Document   : profe_grupoestudiantes
    Created on : 04/05/2021, 09:50:18 PM
    Author     : ksand
--%>

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
            <h1>Estudiantes</h1>
            <div class="buscar">
                <form  class="formbuscar">
                    <input type="text" placeholder="Buscar estudiante..." name ="buscar">
                    <input class="botonbuscar"type="submit" name="accion" value="Buscar">
                </form> 
            </div>
            <table>
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Apellidos</th>
                            <th>Nota</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <%
                                    
                            
                    %>

                    <tbody>
                        <tr>
                            <td><%%></td>
                            <td><%%></td>
                            <td><%%></td>
                            <td> 
                                <a class="Opciones" href="#">Actualizar Nota</a>
                            </td>
                        </tr>
                        
                    </tbody>
                </table>
            </div>
            <%@include file = "footer.jsp"%>
    </body>
</html>
