/*
    Programación 4
    I Ciclo - 2021
    Proyecto 1 - Cursos Libres.com
    117440348 - Joaquin Barrientos Monge
    A00144883 - Kathy Sandoval Blandon
 */
package Servlets;

import Database.cursoDao;
import Database.grupoDao;
import Logic.curso;
import Logic.grupo;
import Logic.horario;
import Logic.profesor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ksand
 */
public class Controller_Grupos_Profe extends HttpServlet {
    String listarcursos = "listarcursos.jsp";
    String vergrupos = "profe_vergrupos.jsp";
    String editargrupos = "admin_editargrupo.jsp";
    String agregargrupo = "admin_addgrupo.jsp";
    curso c = new curso();
    grupo g = new grupo();
    horario h = new horario();
    profesor p = new profesor();
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
            out.println("<title>Servlet Controller_Grupos_Profe</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controller_Grupos_Profe at " + request.getContextPath() + "</h1>");
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
            request.setAttribute("id_edit", request.getParameter("profesor_id"));
            int id = Integer.parseInt((String) request.getAttribute("id_edit"));
            p.setId_profesor(id);
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
