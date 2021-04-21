/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.Objects;

/**
 *
 * @author ksand
 */
public class administrador {
  private int id_administrador;
  private String usuario_id;
  private String nombre;
  private String apellido1;
  private String apellido2;
  private String telefono;
  private String e_mail;

    public administrador(int id_administrador, String usuario_id, String nombre, String apellido1, String apellido2, String telefono, String e_mail) {
        this.id_administrador = id_administrador;
        this.usuario_id = usuario_id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.telefono = telefono;
        this.e_mail = e_mail;
    }

    public administrador() {
       
    }

    public int getId_administrador() {
        return id_administrador;
    }

    public void setId_administrador(int id_administrador) {
        this.id_administrador = id_administrador;
    }

    public String getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(String usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        int hash = 5;
        hash = 37 * hash + this.id_administrador;
        hash = 37 * hash + Objects.hashCode(this.usuario_id);
        hash = 37 * hash + Objects.hashCode(this.nombre);
        hash = 37 * hash + Objects.hashCode(this.apellido1);
        hash = 37 * hash + Objects.hashCode(this.apellido2);
        hash = 37 * hash + Objects.hashCode(this.telefono);
        hash = 37 * hash + Objects.hashCode(this.e_mail);
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
        final administrador other = (administrador) obj;
        if (this.id_administrador != other.id_administrador) {
            return false;
        }
        if (!Objects.equals(this.usuario_id, other.usuario_id)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido1, other.apellido1)) {
            return false;
        }
        if (!Objects.equals(this.apellido2, other.apellido2)) {
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
        return "Administrador{" + "id_administrador=" + getId_administrador() + 
                ", usuario_id=" + getUsuario_id() + 
                ", nombre=" + getNombre() + 
                ", apellido1=" + getApellido1() + 
                ", apellido2=" + getApellido2() + 
                ", telefono=" + getTelefono() + 
                ", e_mail=" + getE_mail() + '}';
    }

   
  
}
