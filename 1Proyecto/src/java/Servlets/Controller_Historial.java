/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logic.Estudiante;
import Logic.curso;
import Logic.estado;
import Logic.grupo;
import Logic.grupo_aux;
import Logic.horario;
import Logic.matricula;
import Logic.profesor;
import Services.Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
@WebServlet(name="Controller_Historial", urlPatterns = {"/Controller_Historial"})
public class Controller_Historial extends javax.servlet.http.HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            System.out.println("Entra a controller_historial ");
            HttpSession session = request.getSession(true);  
            String respuesta = "mis_cursos.jsp";
                       
            Service s = Service.instance();
            Estudiante e = (Estudiante) session.getAttribute("Estudiante");
            
            System.out.println("Estudiante haciendo request " + e);
            
            List<matricula> en_historial = s.getHistorial(e.getId_estudiante());
            
            
            String lista = construyeHistorial(en_historial);
            
            session.setAttribute("historico", lista);
            
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
            Logger.getLogger(Controller_Historial.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Controller_Historial.class.getName()).log(Level.SEVERE, null, ex);
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

    public String construyeHistorial(List<matricula> h) throws Exception{
        Service s = Service.instance();
        StringBuilder r = new StringBuilder();
        for (matricula m: h){
           grupo g = s.getGrupo_INTS(m.getGrupo_num(), m.getCurso_id());
           curso c = s.buscar_curso(g.getCurso_id());
           estado e = s.getEstado(m.getEstado_id());
           horario ho = s.gethorario(m.getGrupo_num(), m.getCurso_id());
           profesor pr = s.buscar_profesor(g.getProfesor_id());
           String dia = "";
           switch(ho.getDia()){
               case 1:{dia = "Lunes"; break;}
               case 2:{dia = "Martes"; break;}
               case 3:{dia = "Miercoles"; break;}
               case 4:{dia = "Jueves"; break;}
               case 5:{dia = "Viernes"; break;}
               case 6:{dia = "Sabado"; break;}
               case 7:{dia = "Domingo"; break;}              
               
           }
           
           r.append("<tr>");
           r.append("<td>"+c.getDescripcion()+"</td>");
           r.append("<td><strong>Dia: </strong>"+dia+ " <strong> Hora </strong>"+ho.getHora()+":00 </td>");
           r.append("<td>"+pr.getNombre()+" "+pr.getApellido1()+"</td>");
           r.append("<td>"+e.getDescripcion()+"</td>");
           if (m.getNota() >= 0){
               r.append("<td>"+m.getNota()+"</td>");
           }else{
               r.append("<td>N/A</td>");
           }
           r.append("</tr>");
        }      
        return r.toString();
    }
    
    
}
