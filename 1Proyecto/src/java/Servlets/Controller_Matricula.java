/*
    Programación 4
    I Ciclo - 2021
    Proyecto 1 - Cursos Libres.com
    117440348 - Joaquin Barrientos Monge
    A00144883 - Kathy Sandoval Blandon
 */
package Servlets;

import Logic.Estudiante;
import Logic.grupo;
import Logic.matricula;
import Services.Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Joaquin
 */
@WebServlet(name="Controller_Matricula", urlPatterns = {"/Controller_Matricula"})
public class Controller_Matricula extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            System.out.println("Paso 1");
            String respuesta = "";
            Estudiante e = null;
            
            HttpSession session = request.getSession(true); 
            System.out.println("Paso 2");
            e = (Estudiante) session.getAttribute("Estudiante");
            String mensaje = "";
            String color = "";
            if (e == null){
                System.out.println("Paso 3");
                respuesta = "login.jsp";
                request.getRequestDispatcher(respuesta).forward(request, response);
            }else{
                try{
                    Service s = Service.instance();
                    System.out.println("Paso 4");
                    System.out.println("Paso 5");
                    String codigo_grupo = request.getParameter("codgrupo");
                    String codigo_curso = request.getParameter("codcurso");
                    System.out.println("Paso 6");
                    System.out.println(codigo_curso);
                    System.out.println(codigo_grupo);
                    matricula m;
                    m = new matricula(e.getId_estudiante(), Integer.parseInt(codigo_grupo), Integer.parseInt(codigo_curso), 102, -1);
                    System.out.println(m);
                    System.out.println( "Este es el estudiante que se matriculara: " + e.getNombre());
                    s.Matricular(m);
                    respuesta = "pivot_matricula.jsp"; 
                    mensaje = "¡La matricula se ha hecho de manera exitosa!";
                    color = "green";
                    request.setAttribute("mensaje", mensaje);
                    request.setAttribute("color", color);
                    request.getRequestDispatcher(respuesta).forward(request, response);
                }catch(Exception ex){
                    System.out.println(ex);
                    color = "red";
                    mensaje = e.getNombre() + " "+ e.getApellido1() + " ya se encuentra matriculad@ en este grupo.";
                    request.setAttribute("mensaje", mensaje);
                    request.setAttribute("color", color);
                    request.getRequestDispatcher("pivot_matricula.jsp").forward(request, response);            
                }                            
            }
           
            
            
            
        }
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
