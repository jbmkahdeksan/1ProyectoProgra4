/*
    Programación 4
    I Ciclo - 2021
    Proyecto 1 - Cursos Libres.com
    117440348 - Joaquin Barrientos Monge
    A00144883 - Kathy Sandoval Blandon
 */
package Logic;

import java.util.Objects;

/**
 *
 * @author ksand
 */
public class area_tematica {
    private int id_area;
    private String descripcion;

    public area_tematica(int id_area, String descripcion) {
        this.id_area = id_area;
        this.descripcion = descripcion;
    }
    
    public area_tematica() {
        this(0,""); 
    }

    public int getId_area() {
        return id_area;
    }

    public void setId_area(int id_area) {
        this.id_area = id_area;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.id_area;
        hash = 71 * hash + Objects.hashCode(this.descripcion);
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
        final area_tematica other = (area_tematica) obj;
        if (this.id_area != other.id_area) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "area_tematica{" + "id_area=" + id_area + ", descripcion=" + descripcion + '}';
    }
    
    
}
