/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logic.Estudiante;
import Logic.usuario;
import Services.Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ksand
 */
@WebServlet(name="ServicioFormulario", urlPatterns = {"/ServicioFormulario"})
public class ServicioFormulario extends javax.servlet.http.HttpServlet {
        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
            String respuesta = "";
            String error_msg = "";
            
            response.setContentType("text/html;charset=UTF-8");
        
        try {
            Estudiante e = new Estudiante (
               Integer.parseInt(request.getParameter("cedula")),
                request.getParameter("cedula"),
                request.getParameter("nombre"),
                request.getParameter("apellido1"),
                request.getParameter("apellido2"),
                request.getParameter("telefono"),
                request.getParameter("correo")); 
            
            Service s = Service.instance();
            DateFormat simpleFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
            Date now = new Date();
            String password = generateRandomPassword(4);
            usuario u = new usuario(request.getParameter("cedula"), "qaz", now, 1, 3);
            s.crearUsuario(u);            
            s.crearEstudiante(e);          
            respuesta = "estudiante.jsp";
            request.removeAttribute("Error");
            HttpSession session = request.getSession(true);  
            session.setAttribute("Usuario", u);
            session.setAttribute("Estudiante", e);
            request.getRequestDispatcher(respuesta).forward(request, response);
            
            
        } catch (Exception ex){
            error_msg = "Hubo un error al registrarse";
            respuesta = "register.jsp";
            System.err.printf("Expection: '%s'%n", ex.getMessage());
            request.setAttribute("Error", error_msg);
            request.getRequestDispatcher(respuesta).forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ServicioFormulario.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ServicioFormulario.class.getName()).log(Level.SEVERE, null, ex);
        }
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

public static String generateRandomPassword(int len)
    {
        // ASCII range – alphanumeric (0-9, a-z, A-Z)
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
 
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
 
        // each iteration of the loop randomly chooses a character from the given
        // ASCII range and appends it to the `StringBuilder` instance
 
        for (int i = 0; i < len; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
 
        return sb.toString();
    }
}


