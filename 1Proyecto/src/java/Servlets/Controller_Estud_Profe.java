/*
    Programación 4
    I Ciclo - 2021
    Proyecto 1 - Cursos Libres.com
    117440348 - Joaquin Barrientos Monge
    A00144883 - Kathy Sandoval Blandon
 */
package Servlets;

import Database.EstudiantesDAO;
import Database.cursoDao;
import Database.matriculaDao;
import Logic.Estudiante;
import Logic.curso;
import Logic.matricula;
import Models.Model_curso;
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
@WebServlet(name = "Profe_Estud", urlPatterns = {"/Profe_Estud"})
public class Controller_Estud_Profe extends HttpServlet {
     String listaestudiantes = "profe_grupoestudiantes.jsp";
     String notas = "profe_editarnota.jsp";
     Estudiante e = new Estudiante();
     EstudiantesDAO eDao = new EstudiantesDAO();
    Model_curso model;
    matriculaDao mdao = new matriculaDao();
    matricula m = new matricula();

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
            out.println("<title>Servlet Controller_Estud_Profe</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controller_Estud_Profe at " + request.getContextPath() + "</h1>");
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
        Service s = Service.instance();

        if (action.equalsIgnoreCase("ver")) {
            
            int num_grupo = Integer.parseInt(request.getParameter("num_grupo"));
            int curso_id = Integer.parseInt(request.getParameter("curso_id"));
            m.setGrupo_num(num_grupo);
            m.setCurso_id(curso_id);
            List<matricula> matricula = mdao.findByMatricula(m);
            request.setAttribute("ListaMatricula", matricula);

            request.getRequestDispatcher(listaestudiantes).forward(request, response);

        }else if (action.equalsIgnoreCase("nota")) {
            request.setAttribute("id_g_edit", request.getParameter("num_grupo"));
            request.setAttribute("id_c_edit", request.getParameter("curso_id"));
            request.setAttribute("id_e_edit", request.getParameter("estudiante_id"));
            acceso = notas;
        } else if (action.equalsIgnoreCase("Actualizar")) {
            int grupo_num = Integer.parseInt(request.getParameter("grupo_num"));
            int curso_id = Integer.parseInt(request.getParameter("curso_id"));
            int estudiante_id = Integer.parseInt(request.getParameter("estudiante_id"));
            int nota = Integer.parseInt(request.getParameter("nota"));
            int estado = 0; 
            if (nota < 70){
                estado = 103;
            } else if (nota >= 70){
                estado = 101;
            } else if (nota == -1){
                estado = 102;
            }
            m.setGrupo_num(grupo_num);
            m.setCurso_id(curso_id);
            m.setEstudiante_id(estudiante_id);
            m.setEstado_id(estado);
            m.setNota(nota);
            try {
                mdao.update(m);

            } catch (Exception e) {
                
            }
            List<matricula> matricula = mdao.findByMatricula(m);
            request.setAttribute("ListaMatricula", matricula);
            request.getRequestDispatcher(listaestudiantes).forward(request, response);
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
