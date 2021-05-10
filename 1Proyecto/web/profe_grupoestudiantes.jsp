<%-- 
    Programación 4
    I Ciclo - 2021
    Proyecto 1 - Cursos Libres.com
    117440348 - Joaquin Barrientos Monge
    A00144883 - Kathy Sandoval Blandon
--%>

<%@page import="Services.Service"%>
<%@page import="java.util.Iterator"%>
<%@page import="Logic.matricula"%>
<%@page import="java.util.List"%>
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
                    List<matricula> matriculas = (List<matricula>) request.getAttribute("ListaMatricula");
                    Iterator<matricula> iter;                    
                    iter = matriculas.iterator();
                    matricula m = null;
                        while (iter.hasNext()) {
                            Estudiante e = new Estudiante();
                            m = iter.next();
                            e = Service.instance().buscar_estudiante(Integer.toString(m.getEstudiante_id()));
    
                            
                    %>

                    <tbody>
                        <tr>
                            <td><%=e.getNombre()%></td>
                            <td><%=e.getApellido1() + " " + e.getApellido2()%></td>
                            <td><%=m.getNota()%></td>
                            <td> 
                                <a class="Opciones" href="Controller_Estud_Profe?accion=nota&num_grupo=<%=m.getGrupo_num()%>&curso_id=<%=m.getCurso_id()%>&estudiante_id=<%=m.getEstudiante_id()%>">Actualizar Nota</a>
                            </td>
                        </tr>
                         <%}%>
                    </tbody>
                </table>
            </div>
            <%@include file = "footer.jsp"%>
    </body>
</html>
