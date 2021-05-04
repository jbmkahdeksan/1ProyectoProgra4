/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.security.SecureRandom;
import java.util.Date;

/*
 *
 * @author Joaquin
 */
public class usuario {
    private String id;
    private String clave;
    private Date ultimo_acceso;
    private int activo;
    private int rol_id;
    
    public usuario() {
        
    }

    public usuario(String id, String clave) {
        this.id = id;
        this.clave = clave;
    }
    
    
    
    public usuario(String id, String clave, Date ultimo_acceso, int activo, int rol_id) {
        this.id = id;
        this.clave = clave;
        this.ultimo_acceso = ultimo_acceso;
        this.activo = activo;
        this.rol_id = rol_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Date getUltimo_acceso() {
        return ultimo_acceso;
    }

    public void setUltimo_acceso(Date ultimo_acceso) {
        this.ultimo_acceso = ultimo_acceso;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }   

    public int getRol_id() {
        return rol_id;
    }

    public void setRol_id(int rol_id) {
        this.rol_id = rol_id;
    }
}

