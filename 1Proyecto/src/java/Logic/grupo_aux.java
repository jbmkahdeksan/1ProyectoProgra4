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
 * @author Joaquin
 */
public class grupo_aux {
    private String num;
    private String desc;
    private String dia;
    private String hora;
    private String profe_nombre;
    private String profe_apellido;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getProfe_nombre() {
        return profe_nombre;
    }

    public void setProfe_nombre(String profe_nombre) {
        this.profe_nombre = profe_nombre;
    }

    public String getProfe_apellido() {
        return profe_apellido;
    }

    public void setProfe_apellido(String profe_apellido) {
        this.profe_apellido = profe_apellido;
    }

    public grupo_aux() {
    }
    
    

    public grupo_aux(String num, String desc, String dia, String hora, String profe_nombre, String profe_apellido) {
        this.num = num;
        this.desc = desc;
        this.dia = dia;
        this.hora = hora;
        this.profe_nombre = profe_nombre;
        this.profe_apellido = profe_apellido;
    } 
    
}
