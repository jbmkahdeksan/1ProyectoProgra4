/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Database.cursoDao;
import Logic.curso;
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
@WebServlet(name = "Administrador", urlPatterns = {"/Administrador"})
public class Controller_Cursos_Admin extends HttpServlet {

    String listarcursos = "listarcursos.jsp";
    String agregarcursos = "addcurso.jsp";
    String editarcursos = "editcurso.jsp";
    curso c = new curso();
    cursoDao cDao = new cursoDao();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controller_Admin</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controller_Admin at " + request.getContextPath() + "</h1>");
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

        if (action.equalsIgnoreCase("listar")) {
            acceso = listarcursos;
        } else if (action.equalsIgnoreCase("Agregar")) {
            int id_curso = Integer.parseInt(request.getParameter("id_curso"));
            String descripcion = request.getParameter("descripcion");
            int area_tematica_id = Integer.parseInt(request.getParameter("area_tematica_id"));
            c.setCurso(id_curso);
            c.setDescripcion(descripcion);
            c.setArea_tematica_id(area_tematica_id);
            try {
                cDao.create(c);
            } catch (Exception e) {
            }

            acceso = listarcursos;
        } else if (action.equalsIgnoreCase("editar")) {
            request.setAttribute("id_edit", request.getParameter("id_curso"));
            System.out.println(request.getAttribute("id_edit"));
            
            acceso = editarcursos;
        } else if (action.equalsIgnoreCase("Actualizar")) {
            int id_curso = Integer.parseInt(request.getParameter("id_curso"));
            String descripcion = request.getParameter("descripcion");
            int area_tematica_id = Integer.parseInt(request.getParameter("area_tematica_id"));
            c.setCurso(id_curso);
            c.setDescripcion(descripcion);
            c.setArea_tematica_id(area_tematica_id);
            try {
                cDao.update(c);
            } catch (Exception e) {
            }
            acceso = listarcursos;
        } else if (action.equalsIgnoreCase("eliminar")){
            int id_curso = Integer.parseInt(request.getParameter("id_curso"));
            c.setCurso(id_curso);
            try {
                cDao.delete(c);
            } catch (Exception e) {
            }
            acceso = listarcursos;
        } else if (action.equalsIgnoreCase("Buscar")){
            String filtro = request.getParameter("buscar");
            curso c= new curso();
            c.setDescripcion(filtro);
            List<curso>lista=cDao.findByDescripcion(c);
            
            acceso = listarcursos;
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
