/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Logic.usuario;

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
