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
public class profesor {
  private int id_profesor;
  private String usuario_id;
  private String apellido1;
  private String apellido2;
  private String nombre;
  private String telefono;
  private String e_mail;

    public profesor(int id_profesor, String usuario_id, String apellido1, String apellido2, String nombre, String telefono, String e_mail) {
        this.id_profesor = id_profesor;
        this.usuario_id = usuario_id;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nombre = nombre;
        this.telefono = telefono;
        this.e_mail = e_mail;
    }

    public profesor() {
       this(0,"","","","","",""); 
    }

    public int getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }

    public String getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(String usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.id_profesor;
        hash = 53 * hash + Objects.hashCode(this.usuario_id);
        hash = 53 * hash + Objects.hashCode(this.apellido1);
        hash = 53 * hash + Objects.hashCode(this.apellido2);
        hash = 53 * hash + Objects.hashCode(this.nombre);
        hash = 53 * hash + Objects.hashCode(this.telefono);
        hash = 53 * hash + Objects.hashCode(this.e_mail);
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
        final profesor other = (profesor) obj;
        if (this.id_profesor != other.id_profesor) {
            return false;
        }
        if (!Objects.equals(this.usuario_id, other.usuario_id)) {
            return false;
        }
        if (!Objects.equals(this.apellido1, other.apellido1)) {
            return false;
        }
        if (!Objects.equals(this.apellido2, other.apellido2)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        if (!Objects.equals(this.e_mail, other.e_mail)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "profesor{" + "id_profesor=" + id_profesor + ", usuario_id=" + usuario_id + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", nombre=" + nombre + ", telefono=" + telefono + ", e_mail=" + e_mail + '}';
    }

    
  
}
