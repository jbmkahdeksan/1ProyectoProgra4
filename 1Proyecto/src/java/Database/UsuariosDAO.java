/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;
import Logic.usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Joaquin
 */
public class UsuariosDAO {
    public usuario create(usuario cl) throws SQLException, Exception{
        String sqlcommand =  "insert into usuario(id_usuario, rol_id, clave, ulitmo_acceso, activo)"
                + "values(?,?,?,?,?)";
        PreparedStatement stm = Database.instance().prepareStatement(sqlcommand);       
        stm.setString(1,cl.getId());
        stm.setString(2,Integer.toString(cl.getRol_id()));
        stm.setString(3,cl.getClave());
        DateFormat simpleFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        stm.setString(4,simpleFormat.format(cl.getUltimo_acceso()));
        stm.setString(5,Integer.toString(cl.getActivo()));
     
        System.out.println(stm);
        int count = Database.instance().executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Ya existe un usuario con esa información");
        }
        return cl;
        
    }
    
    public usuario read(String id) throws Exception{        
        String sqlcommand = "select * from usuario where id_usuario = ?";
        PreparedStatement stm = Database.instance().prepareStatement(sqlcommand);
        stm.setString(1, id);
        ResultSet rs =  Database.instance().executeQuery(stm);   
        System.out.println(stm);
        System.out.println(rs);
        if (rs.next()) {
            System.out.println("Hace read del usuario");
            return from(rs);
        }
        else{
            throw new Exception ("No se encontró el usuario");
        }
    }
    
    
    public usuario from (ResultSet rs){
        try {
            usuario u = new usuario();
            u.setId(rs.getString("id_usuario"));
            u.setClave(rs.getString("clave"));            
            u.setUltimo_acceso(rs.getDate("ultimo_aceso"));
            u.setActivo(rs.getInt("activo"));
            u.setRol_id(rs.getInt("rol_id"));
            System.out.println("Usuario registrado");
            return u;
        } catch (SQLException ex) {
            return null;
        }
    }
}
