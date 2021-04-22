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
public class horario {

    private int seq;
    private int grupo_num;
    private int grupo_curso_id;
    private int dia;
    private int hora;

    public horario() {
        this(0,0,0,0,0); 
    }

    public horario(int seq, int grupo_num, int grupo_curso_id, int dia, int hora) {
        this.seq = seq;
        this.grupo_num = grupo_num;
        this.grupo_curso_id = grupo_curso_id;
        this.dia = dia;
        this.hora = hora;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public int getGrupo_num() {
        return grupo_num;
    }

    public void setGrupo_num(int grupo_num) {
        this.grupo_num = grupo_num;
    }

    public int getGrupo_curso_id() {
        return grupo_curso_id;
    }

    public void setGrupo_curso_id(int grupo_curso_id) {
        this.grupo_curso_id = grupo_curso_id;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.seq;
        hash = 83 * hash + this.grupo_num;
        hash = 83 * hash + this.grupo_curso_id;
        hash = 83 * hash + this.dia;
        hash = 83 * hash + this.hora;
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
        final horario other = (horario) obj;
        if (this.seq != other.seq) {
            return false;
        }
        if (this.grupo_num != other.grupo_num) {
            return false;
        }
        if (this.grupo_curso_id != other.grupo_curso_id) {
            return false;
        }
        if (this.dia != other.dia) {
            return false;
        }
        if (this.hora != other.hora) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "horario{" + "seq=" + seq + ", grupo_num=" + grupo_num + ", grupo_curso_id=" + grupo_curso_id + ", dia=" + dia + ", hora=" + hora + '}';
    }
    
    
}
