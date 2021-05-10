<%-- 
    Programación 4
    I Ciclo - 2021
    Proyecto 1 - Cursos Libres.com
    117440348 - Joaquin Barrientos Monge
    A00144883 - Kathy Sandoval Blandon
--%>

<%@page import="Database.cursoDao"%>
<%@page import="Logic.curso"%>
<%@page import="Database.grupoDao"%>
<%@page import="Logic.grupo"%>
<%@page import="Database.horarioDao"%>
<%@page import="Logic.horario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrador</title>
        <meta charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
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
            <div id="wrapper"> 
                <div id="EditarCurso">
                    <%
                        horarioDao hDao = new horarioDao();
                        cursoDao cDao = new cursoDao();
                        horario h = new horario();
                        grupo g = new grupo();
                        curso c = new curso();
                        grupoDao gDao = new grupoDao();

                        int id = Integer.parseInt((String) request.getAttribute("id_g_edit"));
                        int id_c = Integer.parseInt((String) request.getAttribute("id_c_edit"));
                        try {
                            g = (grupo) gDao.read(id, id_c);
                            c = (curso) cDao.read(id_c);
                            h = (horario) hDao.read(id, id_c);

                        } catch (Exception e) {
                        }

                    %>

                    <p> <strong>Agregar grupo</strong></p>
                    <p>Por favor llenar los siguientes campos para agregar un horario nuevo al grupo <b><%=g.getNum_grupo() + ", Curso: " + c.getDescripcion()%></b>.</p>
                    <form  class ="admin" action="Grupos_Admin">
                        <div class="container">
                            <label for="cursoid"><b>Curso: </b></label>
                            <input type="text" name="grupo_curso_id" value ="<%=c.getCurso()%>" readonly><br>
                            <label for="cursoid"><b>Grupo: </b></label>
                            <input type="text" name="grupo_num" value ="<%=g.getNum_grupo()%>" readonly><br>
                            <label for="numgrupo"><b>Dia</b></label><br>
                            <input type="text"  placeholder="Nombre del dia. Ej: Lunes"name="dia" required>
                            <label for="prodesorid"><b>Hora</b></label><br>
                            <input type="number"  placeholder="Formato 24 horas"name="hora" required>
                            <input type="submit" name="accion" value="Agregar Horario">
                            <a href="listarcursos.jsp">Regresar</a>
                    </form>
                </div>
            </div>
        </div>

        <div> <%@include file = "footer.jsp"%>   </div>

    </body>
</html>
