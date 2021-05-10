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
public class estado {
    private int id_estado;
    private String descripcion;

    public estado(int id_estado, String descripcion) {
        this.id_estado = id_estado;
        this.descripcion = descripcion;
    }
    public estado() {
        this(0,""); 
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
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
        hash = 73 * hash + this.id_estado;
        hash = 73 * hash + Objects.hashCode(this.descripcion);
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
        final estado other = (estado) obj;
        if (this.id_estado != other.id_estado) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "estado{" + "id_estado=" + id_estado + ", descripcion=" + descripcion + '}';
    }
    
    
}
