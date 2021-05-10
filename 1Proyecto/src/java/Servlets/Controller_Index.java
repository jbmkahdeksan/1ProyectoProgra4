/*
    Programación 4
    I Ciclo - 2021
    Proyecto 1 - Cursos Libres.com
    117440348 - Joaquin Barrientos Monge
    A00144883 - Kathy Sandoval Blandon
 */
package Servlets;

import Logic.curso;
import Services.Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Joaquin
 */
@WebServlet(name="home", urlPatterns = {"/home", "/buscarCurso"})
public class Controller_Index extends javax.servlet.http.HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String origen = request.getServletPath();
        String respuesta = "index.jsp";
        Service s = Service.instance();
        switch(origen){
            
            case "/home":{
                List<curso> cursos_oferta = s.getCursosOferta();
                System.out.println("Lista de cursos en oferta (service): " + cursos_oferta);
                request.setAttribute("ListaCursos", cursos_oferta);

                request.getRequestDispatcher(respuesta).forward(request, response);
                break;
            }
            case "/buscarCurso":{
                String criterio = request.getParameter("search");
                List<curso> cursos_filtro = s.getCursosFiltro(criterio);
                request.setAttribute("ListaCursos", cursos_filtro);
                request.getRequestDispatcher(respuesta).forward(request, response);
                break;
            }
            
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
        processRequest(request, response);
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
