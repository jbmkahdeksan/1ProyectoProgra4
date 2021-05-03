/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Database.cursoDao;
import Database.grupoDao;
import Logic.curso;
import Logic.grupo;
import Logic.horario;
import Services.Service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ksand
 */
@WebServlet(name = "Grupos_Admin", urlPatterns = {"/Grupos_Admin"})
public class Controller_Grupos_Admin extends HttpServlet {

    String listarcursos = "listarcursos.jsp";
    String vergrupos = "admin_vergrupos.jsp";
    String editargrupos = "admin_editargrupo.jsp";
    String agregargrupo = "admin_addgrupo.jsp";
    curso c = new curso();
    grupo g = new grupo();
    horario h = new horario();
    cursoDao cDao = new cursoDao();
    grupoDao gDao = new grupoDao();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controller_Grupos_Admin</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controller_Grupos_Admin at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");

        if (action.equalsIgnoreCase("VerGrupos")) {
            request.setAttribute("id_edit", request.getParameter("id_curso"));
            System.out.println(request.getAttribute("id_edit"));
            int id = Integer.parseInt((String) request.getAttribute("id_edit"));
            c.setCurso(id);
            acceso = vergrupos;
        } else if (action.equalsIgnoreCase("agregargrupo")) {
            request.setAttribute("id_edit", request.getParameter("id_curso"));
            System.out.println(request.getAttribute("id_edit"));

            acceso = agregargrupo;
        } else if (action.equalsIgnoreCase("Agregar")) {
            int num_grupo = Integer.parseInt(request.getParameter("num_grupo"));
            int curso_id = Integer.parseInt(request.getParameter("curso_id"));
            int profesor_id = Integer.parseInt(request.getParameter("profesor_id"));

            g.setNum_grupo(num_grupo);
            g.setCurso_id(curso_id);
            g.setProfesor_id(profesor_id);

            try {

                Service.instance().addGrupo(g);

            } catch (Exception e) {
            }
            request.setAttribute("id_edit", request.getParameter("curso_id"));
            System.out.println(request.getAttribute("id_edit"));
            acceso = vergrupos;

        } else if (action.equalsIgnoreCase("editar")) {
            request.setAttribute("id_g_edit", request.getParameter("num_grupo"));
            request.setAttribute("id_c_edit", request.getParameter("curso_id"));
            System.out.println(request.getAttribute("id_g_edit"));

            acceso = editargrupos;
        } else if (action.equalsIgnoreCase("Actualizar")) {
            int num_grupo = Integer.parseInt(request.getParameter("num_grupo"));
            int curso_id = Integer.parseInt(request.getParameter("curso_id"));
            int profesor_id = Integer.parseInt(request.getParameter("profesor_id"));
            g.setNum_grupo(num_grupo);
            g.setCurso_id(curso_id);
            g.setProfesor_id(profesor_id);
            try {
                Service.instance().updateGrupo(g);

            } catch (Exception e) {
            }
            request.setAttribute("id_edit", request.getParameter("curso_id"));
            System.out.println(request.getAttribute("id_edit"));
            acceso = vergrupos;
        } else if (action.equalsIgnoreCase("eliminar")) {

            int num_grupo = Integer.parseInt(request.getParameter("num_grupo"));
            String curso_id = request.getParameter("curso_id");
            g.setNum_grupo(num_grupo);

            try {

                gDao.delete(g);

            } catch (Exception e) {
            }
            request.setAttribute("id_edit", curso_id);
            acceso = vergrupos;
        } else if (action.equalsIgnoreCase("Buscar")) {
            String filtro = request.getParameter("buscar");
            grupo gf = new grupo();

            List<grupo> lista = gDao.findByCurso(c);

            acceso = vergrupos;
        } else if (action.equalsIgnoreCase("horario")) {
            request.setAttribute("id_g_edit", request.getParameter("num_grupo"));
            request.setAttribute("id_c_edit", request.getParameter("curso_id"));

            acceso = "admin_addhorario.jsp";
        } else if (action.equalsIgnoreCase("Agregar Horario")) {
            int grupo_curso_id = Integer.parseInt(request.getParameter("grupo_curso_id"));
            int grupo_num = Integer.parseInt(request.getParameter("grupo_num"));
            String dia_s = request.getParameter("dia");
            int dia = 0;
            switch (dia_s) {
                case "Lunes":
                    dia = 1;
                    break;
                case "Martes":
                    dia = 2;
                    break;
                case "Miercoles":
                    dia = 3;
                    break;
                case "Jueves":
                    dia = 4;
                    break;
                case "Viernes":
                    dia = 5;
                    break;
                case "Sabado":
                    dia = 6;
                    break;
                case "Domingo":
                    dia = 7;
                    break;
                default:
                    dia = 0;
            }

            int hora = Integer.parseInt(request.getParameter("hora"));

            h.setGrupo_num(grupo_num);
            h.setGrupo_curso_id(grupo_curso_id);
            h.setDia(dia);
            h.setHora(hora);
            try {

                Service.instance().addHorario(h);

            } catch (Exception e) {
            }
            request.setAttribute("id_edit", request.getParameter("grupo_curso_id"));
            System.out.println(request.getAttribute("id_edit"));
            acceso = vergrupos;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
