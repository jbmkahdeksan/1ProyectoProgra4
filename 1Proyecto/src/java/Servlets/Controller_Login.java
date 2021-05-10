/*
    Programación 4
    I Ciclo - 2021
    Proyecto 1 - Cursos Libres.com
    117440348 - Joaquin Barrientos Monge
    A00144883 - Kathy Sandoval Blandon
 */
package Servlets;

import Logic.Estudiante;
import Logic.administrador;
import Logic.profesor;
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
public class Controller_Login extends HttpServlet {
    
    private Service service;
    private Model_Login model;

    public Controller_Login() {
        this.service = new Service();
        this.model = new Model_Login();
    } 
    
    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Model_Login getModel() {
        return model;
    }

    public void setModel(Model_Login model) {
        this.model = model;
    }  
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String respuesta = "index.jsp";
        String cedula_request = request.getParameter("cedula");
        String contrasena_request = request.getParameter("contrasena");
        Date date = new Date(System.currentTimeMillis());        
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
        
        System.out.println("Entrando al servlet de ingresar");
        response.setContentType("text/html;charset=UTF-8");
        String respuesta = "home";
        String cedula_request = request.getParameter("cedula");
        String contrasena_request = request.getParameter("contrasena");        
        Date date = new Date(System.currentTimeMillis());          
        usuario u = null;
        try {
            u = Service.instance().login(new usuario(cedula_request, contrasena_request));
        } catch (Exception ex) {
            Logger.getLogger(Controller_Login.class.getName()).log(Level.SEVERE, null, ex);
            if (u == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
            }        
        } 
        HttpSession session = request.getSession(true);  
        session.setAttribute("Usuario", u);
        if(u.getRol_id()==1){            
            try {
                administrador admin = Service.instance().buscar_administrador(u.getId());
                System.out.println(admin.getNombre());
                session.setAttribute("administrador", admin);
                respuesta = "admin.jsp";
            } catch (Exception ex) {
                Logger.getLogger(Controller_Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(u.getRol_id()==2){
            try {
                profesor p = Service.instance().buscar_profesor(u.getId());
                System.out.println(p.getNombre());
                session.setAttribute("profesor", p);
                respuesta = "perfil_profe.jsp";
            } catch (Exception ex) {
                Logger.getLogger(Controller_Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(u.getRol_id()==3){
            try {
                Estudiante e = Service.instance().buscar_estudiante(u.getId());
                session.setAttribute("Estudiante", e);
                respuesta = "estudiante.jsp";
            } catch (Exception ex) {
                Logger.getLogger(Controller_Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        request.getRequestDispatcher(respuesta).forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
