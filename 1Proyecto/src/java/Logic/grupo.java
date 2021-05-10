/*
    Programación 4
    I Ciclo - 2021
    Proyecto 1 - Cursos Libres.com
    117440348 - Joaquin Barrientos Monge
    A00144883 - Kathy Sandoval Blandon
 */
package Logic;

/**
 *
 * @author ksand
 */
public class grupo {
    private int num_grupo;
    private int curso_id;
    private int profesor_id;

    public grupo(int num_grupo, int curso_id, int profesor_id) {
        this.num_grupo = num_grupo;
        this.curso_id = curso_id;
        this.profesor_id = profesor_id;
    }
    
    public grupo() {
        this(0,0,0); 
    }

    public int getNum_grupo() {
        return num_grupo;
    }

    public void setNum_grupo(int num_grupo) {
        this.num_grupo = num_grupo;
    }

    public int getCurso_id() {
        return curso_id;
    }

    public void setCurso_id(int curso_id) {
        this.curso_id = curso_id;
    }

    public int getProfesor_id() {
        return profesor_id;
    }

    public void setProfesor_id(int profesor_id) {
        this.profesor_id = profesor_id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.num_grupo;
        hash = 97 * hash + this.curso_id;
        hash = 97 * hash + this.profesor_id;
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
        final grupo other = (grupo) obj;
        if (this.num_grupo != other.num_grupo) {
            return false;
        }
        if (this.curso_id != other.curso_id) {
            return false;
        }
        if (this.profesor_id != other.profesor_id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo{" + "num_grupo=" + num_grupo + ", curso_id=" + curso_id + ", profesor_id=" + profesor_id + '}';
    }
    
    
}
