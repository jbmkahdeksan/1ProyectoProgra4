/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logic.usuario;
import Models.Model_Login;
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
import javax.servlet.http.HttpSession;
/**
 *
 * @author Joaquin
 */
@WebServlet(name="Ingresar", urlPatterns = {"/Ingresar"})
public class Controller_Login extends javax.servlet.http.HttpServlet {
    
    private Service service;
    private Model_Login model;

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String respuesta = "index.jsp";
        String cedula_request = request.getParameter("cedula");
        String contrasena_request = request.getParameter("contrasena");
        Date date = new Date();        
        try {
            usuario u = Service.instance().login(new usuario(cedula_request,contrasena_request, date, 1, 1));
            System.out.println("Se ingreso el usuario");
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
                System.out.println("Entrando al servlet de ingresar");
        response.setContentType("text/html;charset=UTF-8");
        String respuesta = "index.jsp";
        String cedula_request = request.getParameter("cedula");
        String contrasena_request = request.getParameter("contrasena");
        Date date = new Date();   
        usuario u = null;
        System.out.println("Antes de verificar session");
        try {
           u = Service.instance().login(new usuario(cedula_request,contrasena_request, date, 1, 1));    
        } catch (Exception ex) {
            if (u == null){
                 request.getRequestDispatcher("login.jsp").forward(request, response);
            }            
        }         
        System.out.println("Antes de crear session");
        HttpSession session = request.getSession(true);
        session.setAttribute("Usuario", u);        
        request.setAttribute("Model_Login", model);
        request.getRequestDispatcher(respuesta).forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
