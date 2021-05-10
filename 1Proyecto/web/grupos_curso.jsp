<%-- 
    Programación 4
    I Ciclo - 2021
    Proyecto 1 - Cursos Libres.com
    117440348 - Joaquin Barrientos Monge
    A00144883 - Kathy Sandoval Blandon
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
            <%curso c = (curso) request.getAttribute("curso_actual");
              usuario ux = (usuario) session.getAttribute("Usuario"); %> 
            <h1><%out.print(c.getDescripcion());%></h1>
            <table>
                <thead>
                    <tr>
                        <th>N° Grupo</th>
                        <th>Curso</th>
                        <th>Profesor</th>
                        <th>Horario</th>
                        <%if(ux == null || ux.getRol_id() == 3){%>
                        <th>Acciones</th>
                        <%}%>
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
                        <%if(ux == null || ux.getRol_id() == 3){%>
                        <td>
                            <a class="Opciones" href="Controller_Matricula?codgrupo=<%=g.getNum_grupo()%>&codcurso=<%=c.getCurso()%>">Matricular</a>
                        </td>
                        <%}%>
                    </tr>
                    <%}%>

                </tbody>
            </table>

    </body>
    <%@include file="footer.jsp"%>
</html>
