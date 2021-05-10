/*
    Programación 4
    I Ciclo - 2021
    Proyecto 1 - Cursos Libres.com
    117440348 - Joaquin Barrientos Monge
    A00144883 - Kathy Sandoval Blandon
 */
package Database;

import Logic.rol;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author Joaquin
 */
public class RolDAO {
    public rol create(rol cl) throws SQLException, Exception{
        String sqlcommand =  "insert into rol(id_rol, descripcion)"
                + "values(?,?)";
        PreparedStatement stm = Database.instance().prepareStatement(sqlcommand);       
        stm.setString(1, Integer.toString(cl.getId_rol()));
        stm.setString(2, cl.getDescripcion());     
        System.out.println(stm);
        int count = Database.instance().executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Ya existe un rol con esa información");
        }
        return cl;
        
    }
    
    public rol read(String id) throws Exception{        
        String sqlcommand = "select * from rol where id = ?";
        PreparedStatement stm = Database.instance().prepareStatement(sqlcommand);
        stm.setString(1, id);
        ResultSet rs =  Database.instance().executeQuery(stm);           
        if (rs.next()) {           
            return from(rs);
        }
        else{
            throw new Exception ("No se encontró el rol");
        }
    }
    
    
    public rol from (ResultSet rs){
        try {
            rol r = new rol();
            r.setId_rol(rs.getInt("id_rol"));
            r.setDescripcion(rs.getString("descripcion"));      
            return r;
        } catch (SQLException ex) {
            return null;
        }
    }
}
