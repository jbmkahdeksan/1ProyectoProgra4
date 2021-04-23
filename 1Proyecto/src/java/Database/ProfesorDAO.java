/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Logic.profesor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashSet;


/**
 *
 * @author Joaquin
 */
public class ProfesorDAO {
    public profesor create(profesor cl) throws SQLException, Exception{
        String sqlcommand =  "insert into profesor(id_profesor, usuario_id, apellido1, apellido2, nombre, telefono, email)"
                + "values(?,?,?,?,?,?,?)";
        PreparedStatement stm = Database.instance().prepareStatement(sqlcommand);       
        stm.setString(1,Integer.toString(cl.getId_profesor()));
        stm.setString(2,cl.getUsuario_id());
        stm.setString(3,cl.getApellido1());
        stm.setString(4,cl.getApellido2());
        stm.setString(5,cl.getNombre());
        stm.setString(6,cl.getTelefono());
        stm.setString(7,cl.getE_mail());
     
        System.out.println(stm);
        int count = Database.instance().executeUpdate(stm);
        if (count == 0) {
            
            throw new Exception("Ya existe un profesor con esa información");
            
        }
        return cl;
        
    }
    
    public profesor read(String id) throws Exception{        
        String sqlcommand = "select * from profesor where id = ?";
        PreparedStatement stm = Database.instance().prepareStatement(sqlcommand);
        stm.setString(1, id);
        ResultSet rs =  Database.instance().executeQuery(stm);           
        if (rs.next()) {          
            return from(rs);
        }
        else{
            throw new Exception ("No se encontró el profesor");
        }
    }
    
    
    public profesor from (ResultSet rs){
        try {
            profesor p = new profesor();
            p.setId_profesor(rs.getInt("id_profesor"));            
            p.setUsuario_id(rs.getString("id_usuario"));            
            p.setApellido1(rs.getString("apellido1"));
            p.setApellido2(rs.getString("apellido2"));
            p.setNombre(rs.getString("nombre"));
            p.setTelefono(rs.getString("telefono"));
            p.setE_mail(rs.getString("e_mail"));               
            System.out.println("Profesor registrado");
            return p;
        } catch (SQLException ex) {
            return null;
        }
    }
}
