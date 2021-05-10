/*
    Programación 4
    I Ciclo - 2021
    Proyecto 1 - Cursos Libres.com
    117440348 - Joaquin Barrientos Monge
    A00144883 - Kathy Sandoval Blandon
 */
package Models;

import Logic.usuario;
import java.io.Serializable;

/**
 *
 * @author Joaquin
 */
public class Model_Login {
     usuario current_user ;

    public Model_Login() {
        current_user= null;
    }

    public usuario getCurrent_user() {
        return current_user;
    }

    public void setCurrent_user(usuario current_user) {
        this.current_user = current_user;
    }
}
