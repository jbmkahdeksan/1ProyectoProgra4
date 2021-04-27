/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Database.ProfesorDAO;
import Logic.profesor;
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
@WebServlet(name = "AdminProfes", urlPatterns = {"/AdminProfes"})
public class Controller_Profesores_Admin extends HttpServlet {
    String listarprofesores = "profesores.jsp";
    String agregarprofesores = "addprofesor.jsp";
    String editarprofesores = "editprofesor.jsp";
    profesor p = new profesor();
    ProfesorDAO pDao = new ProfesorDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controller_Profesores_Admin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controller_Profesores_Admin at " + request.getContextPath() + "</h1>");
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
            acceso = listarprofesores;
        } else if (action.equalsIgnoreCase("Agregar")) {
            int id_profesor = Integer.parseInt(request.getParameter("id_profesor"));
            String usuario_id = request.getParameter("usuario_id");
            String apellido1 = request.getParameter("apellido1");
            String apellido2 = request.getParameter("apellido2");
            String nombre = request.getParameter("nombre");
            String telefono = request.getParameter("telefono");
            String e_mail = request.getParameter("e_mail");
            p.setId_profesor(id_profesor);
            p.setUsuario_id(usuario_id);
            p.setApellido1(apellido1);
            p.setApellido2(apellido2);
            p.setNombre(nombre);
            p.setTelefono(telefono);
            p.setE_mail(e_mail);
            try {
                pDao.create(p);
            } catch (Exception e) {
            }
            acceso = listarprofesores;
        } else if (action.equalsIgnoreCase("editar")) {
            request.setAttribute("id_edit", request.getParameter("id_profesor"));
            System.out.println(request.getAttribute("id_edit"));
            
            acceso = editarprofesores;
        } else if (action.equalsIgnoreCase("Actualizar")) {
            int id_profesor = Integer.parseInt(request.getParameter("id_profesor"));
            String usuario_id = request.getParameter("usuario_id");
            String apellido1 = request.getParameter("apellido1");
            String apellido2 = request.getParameter("apellido2");
            String nombre = request.getParameter("nombre");
            String telefono = request.getParameter("telefono");
            String e_mail = request.getParameter("e_mail");
            p.setId_profesor(id_profesor);
            p.setUsuario_id(usuario_id);
            p.setApellido1(apellido1);
            p.setApellido2(apellido2);
            p.setNombre(nombre);
            p.setTelefono(telefono);
            p.setE_mail(e_mail);
            try {
                pDao.update(p);
            } catch (Exception e) {
            }
            acceso = listarprofesores;
        } else if (action.equalsIgnoreCase("eliminar")){
            int id_profesor = Integer.parseInt(request.getParameter("id_profesor"));
            p.setId_profesor(id_profesor);
            try {
                pDao.delete(p);
            } catch (Exception e) {
            }
            acceso = listarprofesores;
        } else if (action.equalsIgnoreCase("Buscar")){
            String filtro = request.getParameter("buscar");
            p.setNombre(filtro);
            List<profesor>lista=pDao.findByNombre(p);
            
            acceso = listarprofesores;
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
