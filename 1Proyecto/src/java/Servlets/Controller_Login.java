/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logic.usuario;
import Services.Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Joaquin
 */
@WebServlet(name="Ingresar", urlPatterns = {"/Ingresar"})
public class Controller_Login extends javax.servlet.http.HttpServlet {
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String respuesta = "index.jsp";
        String cedula_request = request.getParameter("cedula");
        String contrasena_request = request.getParameter("contrasena");
        Date date = new Date();        
        try {
            usuario u = Service.instance().login(new usuario(cedula_request,contrasena_request, date, 1, 1));
        } catch (Exception ex) {
            
        }
        
        
        request.getRequestDispatcher(respuesta).forward(request, response);
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
