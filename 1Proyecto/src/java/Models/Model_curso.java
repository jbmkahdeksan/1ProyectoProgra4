/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Logic.area_tematica;
import Logic.curso;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ksand
 */
public class Model_curso {
    curso curso_actual;
    List<curso> lista_cursos;
    List<area_tematica> areas_tematicas;
    
     public Model_curso() {
        curso_actual = new curso();
        lista_cursos = new ArrayList<>();
        areas_tematicas = new ArrayList<>();       
    }

    public curso getCurso_actual() {
        return curso_actual;
    }

    public void setCurso_actual(curso curso_actual) {
        this.curso_actual = curso_actual;
    }

    public List<curso> getLista_cursos() {
        return lista_cursos;
    }

    public void setLista_cursos(List<curso> lista_cursos) {
        this.lista_cursos = lista_cursos;
    }

    

    public List<area_tematica> getAreas_tematicas() {
        return areas_tematicas;
    }

    public void setAreas_tematicas(List<area_tematica> areas_tematicas) {
        this.areas_tematicas = areas_tematicas;
    }
    
    
}
