/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Logic.Estudiante;
import Logic.curso;
import Logic.grupo_aux;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Joaquin
 */
public class GruposAuxDAO {
    
    
    public List<grupo_aux> read(String id) throws Exception{  
        System.out.println("Entra al dao");
        List<grupo_aux> r = new ArrayList<>();
        String sqlcommand = "select grupo.num_grupo, curso.descripcion, horario.dia, horario.hora, profesor.nombre, profesor.apellido1 from grupo inner join curso on grupo.curso_id = curso.id_curso inner join horario on horario.grupo_curso_id = curso.id_curso inner join profesor on grupo.profesor_id = profesor.id_profesor where curso.id_curso=?";
        System.out.println("Estes es el coomadno " + sqlcommand);
        try {
            PreparedStatement stm = Database.instance().prepareStatement(sqlcommand);
            stm.setString(1, id);
            System.out.println("antes del result set");
            ResultSet rs = Database.instance().executeQuery(stm);
            while (rs.next()) {
                r.add(from(rs));
            }
        } catch (SQLException ex) {
            System.out.println("No se ha podido recuperar");
        }
        System.out.println(r);
        return r;
    }
    
    
    public grupo_aux from (ResultSet rs){
        try {
            grupo_aux e = new grupo_aux();     
            e.setNum(rs.getString("grupo.num_grupo"));
            e.setDesc(rs.getString("curso.descripcion"));
            e.setDia(rs.getString("horario.dia"));
            e.setHora(rs.getString("horario.hora"));
            e.setProfe_nombre(rs.getString("profesor.nombre"));
            e.setProfe_apellido(rs.getString("profesor.apellido1"));
            return e;
        } catch(SQLException ex){
            return null;
        }
    }
}