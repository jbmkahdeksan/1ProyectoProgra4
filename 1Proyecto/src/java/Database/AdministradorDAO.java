/*
    Programación 4
    I Ciclo - 2021
    Proyecto 1 - Cursos Libres.com
    117440348 - Joaquin Barrientos Monge
    A00144883 - Kathy Sandoval Blandon
 */
package Database;

import Logic.administrador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Joaquin
 */
public class AdministradorDAO {
    public administrador create(administrador cl) throws SQLException, Exception{
        String sqlcommand =  "insert into administrador(id_profesor, usuario_id, apellido1, apellido2, nombre, telefono, email)"
                + "values(?,?,?,?,?,?,?)";
        PreparedStatement stm = Database.instance().prepareStatement(sqlcommand);       
        stm.setString(1,Integer.toString(cl.getId_administrador()));
        stm.setString(2,cl.getUsuario_id());
        stm.setString(3,cl.getApellido1());
        stm.setString(4,cl.getApellido2());
        stm.setString(5,cl.getNombre());
        stm.setString(6,cl.getTelefono());
        stm.setString(7,cl.getE_mail());     
        System.out.println(stm);
        int count = Database.instance().executeUpdate(stm);
        if (count == 0) {            
            throw new Exception("Ya existe un administrador con esa información");            
        }
        return cl;
        
    }
    
    public administrador read(String id) throws Exception{        
        String sqlcommand = "select * from administrador where usuario_id = ?";
        PreparedStatement stm = Database.instance().prepareStatement(sqlcommand);
        stm.setString(1, id);        
        System.out.println(stm);
        ResultSet rs =  Database.instance().executeQuery(stm);           
        if (rs.next()) {            
            return from(rs);
        }
        else{
            throw new Exception ("No se encontró el administrador");
        }
    }
    
    
    public administrador from (ResultSet rs){
        try {
            administrador a = new administrador();
            a.setId_administrador(rs.getInt("id_administrador"));            
            a.setUsuario_id(rs.getString("usuario_id"));            
            a.setApellido1(rs.getString("apellido1"));
            a.setApellido2(rs.getString("apellido2"));
            a.setNombre(rs.getString("nombre"));
            a.setTelefono(rs.getString("telefono"));
            a.setE_mail(rs.getString("e_mail"));  
            return a;
        } catch (SQLException ex) {
            System.out.println("Error al crear administrador");
            return null;
        }
    }
}
