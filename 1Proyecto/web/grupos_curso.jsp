<%-- 
    Document   : grupos_curso
    Created on : May 3, 2021, 7:03:03 PM
    Author     : Joaquin
--%>

<%@page import="Services.Service"%>
<%@page import="java.util.Iterator"%>
<%@page import="Logic.grupo"%>
<%@page import="Logic.horario"%>
<%@page import="Database.horarioDao"%>
<%@page import="Database.grupoDao"%>
<%@page import="Database.cursoDao"%>
<%@page import="Logic.grupo_aux"%>
<%@page import="java.util.List"%>
<%@page import="Logic.curso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
        <link href="css/register.css" rel="stylesheet" type="text/css"/>
        <link href="css/forms_admin.css" rel="stylesheet" type="text/css"/>
        <title>CursosLibres.com</title>
    </head>

    <body>
        <div class="header">
            <h2>CursosLibres.com</h2>
            <p>Donde encontrarás cursos irónicamente útiles.</p>
            <div style="text-align: left">
            </div>
            <%@include file="index_topbar.jsp"%>

            <%curso c = (curso) request.getAttribute("curso_actual");%>
            <h1><%out.print(c.getDescripcion());%></h1>
            <table>
                <thead>
                    <tr>
                        <th>N° Grupo</th>
                        <th>Curso</th>
                        <th>Profesor</th>
                        <th>Horario</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>


                    <%
                        cursoDao cDao = new cursoDao();
                        grupoDao gDao = new grupoDao();
                        horarioDao hDao = new horarioDao();
                        horario h = new horario();
                        
                        List<grupo> listag = gDao.findByCurso(c);
                        Iterator<grupo> iter;
                        iter = listag.iterator();
                        grupo g = null;
                        while (iter.hasNext()) {
                            profesor p = new profesor();

                            g = iter.next();
                            p = Service.instance().buscar_profesor(g.getProfesor_id());
                            try {
                                h = (horario) hDao.read(g.getNum_grupo(), g.getCurso_id());
                            } catch (Exception e) {
                                h = new horario();
                            }
                            String dia = "";
                            switch (h.getDia()) {
                                case 1:
                                    dia = "Lunes";
                                    break;
                                case 2:
                                    dia = "Martes";
                                    break;
                                case 3:
                                    dia = "Miercoles";
                                    break;
                                case 4:
                                    dia = "Jueves";
                                    break;
                                case 5:
                                    dia = "Viernes";
                                    break;
                                case 6:
                                    dia = "Sabado";
                                    break;
                                case 7:
                                    dia = "Domingo";
                                    break;
                                default:
                                    dia = "No asignado";

                            }

                    %>
                    <tr>
                        <td><%out.print(g.getNum_grupo());%></td>
                        <td><%out.print(c.getDescripcion());%></td>
                        <td><%out.print(p.getNombre() + " " + p.getApellido1());%></td>
                        <td><%out.print("Dia: " + dia + " Hora: " + h.getHora() + ":00");%></td>
                        <td>
                            <a class="Opciones" href="#">Matricular</a>
                        </td>
                    </tr>
                    <%}%>

                </tbody>
            </table>

    </body>
    <%@include file="footer.jsp"%>
</html>
