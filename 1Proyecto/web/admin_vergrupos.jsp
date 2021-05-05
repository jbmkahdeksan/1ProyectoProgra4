<%-- 
    Document   : admin_vergrupos
    Created on : 01/05/2021, 09:12:23 PM
    Author     : ksand
--%>

<%@page import="Database.horarioDao"%>
<%@page import="Logic.horario"%>
<%@page import="Services.Service"%>
<%@page import="java.util.Iterator"%>
<%@page import="Logic.grupo"%>
<%@page import="java.util.List"%>
<%@page import="Logic.curso"%>
<%@page import="Database.grupoDao"%>
<%@page import="Database.cursoDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrador</title>
        <meta charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
        <link href="css/register.css" rel="stylesheet" type="text/css"/>
        <link href="css/forms_admin.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="header">
            <h2>CursosLibres.com</h2>
            <p>Donde encontrarás cursos irónicamente útiles.</p>
            <div style="text-align: left">
                <center><h2>Pagina de Administrador</h2></center>     
            </div>
            <%@include file="index_topbar.jsp"%>
            <h1>Grupos </h1>
            <div class="buscar">
                
            </div>
            <div>

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
                    <%
                        cursoDao cDao = new cursoDao();
                        grupoDao gDao = new grupoDao();
                        horarioDao hDao = new horarioDao();
                        curso c = new curso();
                        horario h = new horario();

                        int id = Integer.parseInt((String) request.getAttribute("id_edit"));
                        try {
                            c = (curso) cDao.read(id);

                        } catch (Exception e) {
                        }
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
                            switch (h.getDia()){
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
                                    dia= "No asignado";
                               
                            }


                    %>

                    <tbody>
                        <tr>
                            <td><%=g.getNum_grupo()%></td>
                            <td><%=c.getCurso() + ", " + c.getDescripcion()%></td>
                            <td><%=p.getNombre() + " " + p.getApellido1()%></td>
                            <td><b>Dia: </b><%=dia + " Hora: "+ h.getHora()+ ":00"%></td>
                            <td> 
                                <% if (dia.equals("No asignado")) {%>
                                <a class="Opciones" href="Controller_Grupos_Admin?accion=horario&num_grupo=<%=g.getNum_grupo()%>&curso_id=<%=g.getCurso_id()%>">Agregar Horario</a>
                                <a class="Opciones" href="Controller_Grupos_Admin?accion=editar&num_grupo=<%=g.getNum_grupo()%>&curso_id=<%=g.getCurso_id()%>">Editar</a>
                                <a class="Opciones" href="Controller_Grupos_Admin?accion=eliminar&num_grupo=<%=g.getNum_grupo()%>&curso_id=<%=g.getCurso_id()%>">Eliminar</a>
                                <%} else {%>
                                <a class="Opciones" href="Controller_Grupos_Admin?accion=editar&num_grupo=<%=g.getNum_grupo()%>&curso_id=<%=g.getCurso_id()%>">Editar</a>
                                <a class="Opciones" href="Controller_Grupos_Admin?accion=eliminar&num_grupo=<%=g.getNum_grupo()%>&curso_id=<%=g.getCurso_id()%>">Eliminar</a>
                                <%}%>
                            </td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
                <a href="cursos?accion=ver">Regresar</a>
            </div>
            <%@include file = "footer.jsp"%>
    </body>
</html>
