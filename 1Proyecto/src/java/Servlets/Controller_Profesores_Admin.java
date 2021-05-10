/*
    Programación 4
    I Ciclo - 2021
    Proyecto 1 - Cursos Libres.com
    117440348 - Joaquin Barrientos Monge
    A00144883 - Kathy Sandoval Blandon
 */
package Servlets;

import Database.ProfesorDAO;
import Logic.profesor;
import Logic.usuario;
import Services.Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        String origen = request.getServletPath();
        String action = request.getParameter("accion");
        Service s = Service.instance();
        
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");
        System.out.println(action);

        if (action.equalsIgnoreCase("ver")) {
            List<profesor> profesores = Service.instance().getProfesores();
            request.setAttribute("ListaProfesores", profesores);
            request.getRequestDispatcher(listarprofesores).forward(request, response);

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
                Service s = Service.instance();
                DateFormat simpleFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
                Date now = new Date();
                s.crearUsuario(new usuario(request.getParameter("usuario_id"), "qwerty", now, 1, 2));            
                s.crearProfesor(p);  
               
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
            List<profesor> lista = Service.instance().searchProfesor(filtro);
           request.setAttribute("ListaProfesores", lista);
            request.getRequestDispatcher(listarprofesores).forward(request, response);

        }
        List<profesor> profesores = Service.instance().getProfesores();
        request.setAttribute("ListaProfesores", profesores);
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
