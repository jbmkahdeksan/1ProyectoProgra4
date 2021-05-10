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
public class especialidad {
    private int profesor_id_profesor;
    private int area_tematica_id;

    public especialidad(int profesor_id_profesor, int area_tematica_id) {
        this.profesor_id_profesor = profesor_id_profesor;
        this.area_tematica_id = area_tematica_id;
    }
    public especialidad() {
        this(0,0); 
    }

    public int getProfesor_id_profesor() {
        return profesor_id_profesor;
    }

    public void setProfesor_id_profesor(int profesor_id_profesor) {
        this.profesor_id_profesor = profesor_id_profesor;
    }

    public int getArea_tematica_id() {
        return area_tematica_id;
    }

    public void setArea_tematica_id(int area_tematica_id) {
        this.area_tematica_id = area_tematica_id;
    }
    
    
}
