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
            s.crearUsuario(new usuario(request.getParameter("cedula"), "qwerty", now, 1, 3));            
            s.crearEstudiante(e);          
           
        } catch (NumberFormatException ex){
            System.err.printf("Expection: '%s'%n", ex.getMessage());
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

}
