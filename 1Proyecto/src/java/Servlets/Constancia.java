/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logic.Estudiante;
import Logic.curso;
import Logic.grupo;
import Logic.horario;
import Logic.matricula;
import Logic.profesor;
import Services.Service;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import static java.lang.Math.round;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ksand
 */
@WebServlet(name = "pdf", urlPatterns = {"/pdf"})
public class Constancia extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        String path = "src/java/ConstanciasPDF";

        Service s = Service.instance();
        try {
            Estudiante e = (Estudiante) session.getAttribute("Estudiante");
            String msg = "your message";

            Document document = new Document();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PdfWriter.getInstance(document, baos);
            List<matricula> en_historial = s.getHistorial(e.getId_estudiante());
            document.open();
            //Fecha

            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.DARK_GRAY);
            PdfPTable Empresa = new PdfPTable(2);
            Empresa.setWidthPercentage(100);
            Empresa.getDefaultCell().setBorder(0);
            String logo = "CursosLibres.com" + "\nDonde encontrarás cursos irónicamente útiles.";
            float[] columnWidthsEmpresa = new float[]{50f, 50f};
            Empresa.setWidths(columnWidthsEmpresa);
            Empresa.setHorizontalAlignment(Element.ALIGN_LEFT);
            Empresa.addCell("Constancia de estudiante");
            Empresa.addCell(logo);
            document.add(Empresa);
            Paragraph pp = new Paragraph();
            pp.add(Chunk.NEWLINE);
            pp.add(Chunk.NEWLINE);
            pp.add(Chunk.NEWLINE);
            document.add(pp);
            
            PdfPTable Encabezado = new PdfPTable(2);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0);
            float[] columnWidthsEncabezado = new float[]{6f, 40f};
            Encabezado.setWidths(columnWidthsEncabezado);
            Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
            //info estudiante
            String id = e.getUsuario_id() + ", ";
            String nom = e.getNombre();
            String apell =  e.getApellido1() + " " + e.getApellido2();
            Encabezado.addCell("Estudiante: ");
            Encabezado.addCell(id + nom + " " + apell);
            document.add(Encabezado);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            //cursos
            PdfPTable tabla = new PdfPTable(5);
            tabla.setWidthPercentage(100);
            tabla.getDefaultCell().setBorder(0);
            float[] columnWidths = new float[]{13f, 18f, 20f, 10f, 5f};
            tabla.setWidths(columnWidths);
            tabla.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell c1 = new PdfPCell(new Phrase("Nombre Curso", negrita));
            PdfPCell c2 = new PdfPCell(new Phrase("Horario", negrita));
            PdfPCell c3 = new PdfPCell(new Phrase("Profesor", negrita));
            PdfPCell c4 = new PdfPCell(new Phrase("Estado", negrita));
            PdfPCell c5 = new PdfPCell(new Phrase("Nota", negrita));
            c1.setBorder(Rectangle.NO_BORDER);
            c2.setBorder(Rectangle.NO_BORDER);
            c3.setBorder(Rectangle.NO_BORDER);
            c4.setBorder(Rectangle.NO_BORDER);
            c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            c2.setBackgroundColor(BaseColor.LIGHT_GRAY);
            c3.setBackgroundColor(BaseColor.LIGHT_GRAY);
            c4.setBackgroundColor(BaseColor.LIGHT_GRAY);
            c5.setBackgroundColor(BaseColor.LIGHT_GRAY);
            tabla.addCell(c1);
            tabla.addCell(c2);
            tabla.addCell(c3);
            tabla.addCell(c4);
            tabla.addCell(c5);
            for (int i = 0; i < en_historial.size(); i++) {
            grupo g = s.getGrupo_INTS(en_historial.get(i).getGrupo_num(), en_historial.get(i).getCurso_id());
            curso c = s.getCurso_int(en_historial.get(i).getCurso_id());
            horario ho = s.gethorario(en_historial.get(i).getGrupo_num(), en_historial.get(i).getCurso_id());
            String dia = "";
           switch(ho.getDia()){
               case 1:{dia = "Lunes"; break;}
               case 2:{dia = "Martes"; break;}
               case 3:{dia = "Miercoles"; break;}
               case 4:{dia = "Jueves"; break;}
               case 5:{dia = "Viernes"; break;}
               case 6:{dia = "Sabado"; break;}
               case 7:{dia = "Domingo"; break;} 
               default: dia = "No asignado";
               
           }
            String curso = c.getDescripcion();
            profesor p = s.buscar_profesor(g.getProfesor_id());
            String horario = "Dia: " + dia + " Hora: " + ho.getHora();
            String profesor = p.getNombre() + " " + p.getApellido1() + " " + p.getApellido2();
            String estado = s.getEstado(en_historial.get(i).getEstado_id()).getDescripcion();
            String nota = Integer.toString(en_historial.get(i).getNota());
            tabla.addCell(curso);
            tabla.addCell(horario);
            tabla.addCell(profesor);
            tabla.addCell(estado);
            tabla.addCell(nota);
            }
            
            document.add(tabla);
            document.add(Chunk.NEWLINE);
            Paragraph ob = new Paragraph();
            ob.add(Chunk.NEWLINE);
            ob.add("-------------------------------------------------------------------------------------------------------------------------------\n");
            ob.add("Observaciones: ");
            ob.setAlignment(Element.ALIGN_LEFT);
            document.add(ob);
            Paragraph gr = new Paragraph();
            gr.add(Chunk.NEWLINE);
            gr.add("¡Gracias por estudiar con nosotros!");
            gr.setAlignment(Element.ALIGN_CENTER);
            document.add(gr);
            document.close();

            response.setHeader("Expires", "0");
            response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
            response.setHeader("Pragma", "public");

            response.setContentType("application/pdf");

            response.setContentLength(baos.size());

            ServletOutputStream out = response.getOutputStream();
            baos.writeTo(out);
            out.flush();

        } catch (Exception e2) {
            System.out.println("Error in " + getClass().getName() + "\n" + e2);
        }

//        
////            doc.open();
////            
////            
            
//////            
//////            doc.add(tabla);
            
//////            
//////            Paragraph firma = new Paragraph();
//////            firma.add(Chunk.NEWLINE);
//////            firma.add("Cancelado \n\n");
//////            firma.add("----------------------\n");
//////            firma.setAlignment(Element.ALIGN_CENTER);
//////            doc.add(firma);
            
//            doc.close();
//            } catch (Exception ex){
//                ex.getMessage();
//            }
//             
//        } finally {
//        
//        }
    }

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
