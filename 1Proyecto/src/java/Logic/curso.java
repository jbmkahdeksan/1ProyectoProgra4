    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author ksand
 */
public class curso {
    private int curso;
    private String descripcion;
    private int area_tematica_id;
    private List<grupo> grupos; 

    public curso(int curso, String descripcion, int area_tematica_id, List<grupo> grupos) {
        this.curso = curso;
        this.descripcion = descripcion;
        this.area_tematica_id = area_tematica_id;
        this.grupos = grupos;
    }

    public curso() {
        curso=0;
        grupos = new ArrayList<>();
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getArea_tematica_id() {
        return area_tematica_id;
    }

    public void setArea_tematica_id(int area_tematica_id) {
        this.area_tematica_id = area_tematica_id;
    }

    

    public List<grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<grupo> grupos) {
        this.grupos = grupos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.curso;
        hash = 97 * hash + Objects.hashCode(this.descripcion);
        hash = 97 * hash + Objects.hashCode(this.area_tematica_id);
        hash = 97 * hash + Objects.hashCode(this.grupos);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final curso other = (curso) obj;
        if (this.curso != other.curso) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.area_tematica_id, other.area_tematica_id)) {
            return false;
        }
        if (!Objects.equals(this.grupos, other.grupos)) {
            return false;
        }
        return true;
    }

   

    @Override
    public String toString() {
        return "curso{" + "curso=" + curso + ", descripcion=" + descripcion + ", area_tematica_id=" + area_tematica_id + '}';
    }
    
    
}
