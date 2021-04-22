/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author ksand
 */
public class matricula {
    private int estudiante_id;
    private int grupo_num;
    private int curso_id;
    private int estado_id;
    private int nota;

    public matricula(int estudiante_id, int grupo_num, int curso_id, int estado_id, int nota) {
        this.estudiante_id = estudiante_id;
        this.grupo_num = grupo_num;
        this.curso_id = curso_id;
        this.estado_id = estado_id;
        this.nota = nota;
    }
    
    public matricula() {
        this(0,0,0,0,0); 
    }

    public int getEstudiante_id() {
        return estudiante_id;
    }

    public void setEstudiante_id(int estudiante_id) {
        this.estudiante_id = estudiante_id;
    }

    public int getGrupo_num() {
        return grupo_num;
    }

    public void setGrupo_num(int grupo_num) {
        this.grupo_num = grupo_num;
    }

    public int getCurso_id() {
        return curso_id;
    }

    public void setCurso_id(int curso_id) {
        this.curso_id = curso_id;
    }

    public int getEstado_id() {
        return estado_id;
    }

    public void setEstado_id(int estado_id) {
        this.estado_id = estado_id;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.estudiante_id;
        hash = 41 * hash + this.grupo_num;
        hash = 41 * hash + this.curso_id;
        hash = 41 * hash + this.estado_id;
        hash = 41 * hash + this.nota;
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
        final matricula other = (matricula) obj;
        if (this.estudiante_id != other.estudiante_id) {
            return false;
        }
        if (this.grupo_num != other.grupo_num) {
            return false;
        }
        if (this.curso_id != other.curso_id) {
            return false;
        }
        if (this.estado_id != other.estado_id) {
            return false;
        }
        if (this.nota != other.nota) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "matricula{" + "estudiante_id=" + estudiante_id + ", grupo_num=" + grupo_num + ", curso_id=" + curso_id + ", estado_id=" + estado_id + ", nota=" + nota + '}';
    }
    
    
}
