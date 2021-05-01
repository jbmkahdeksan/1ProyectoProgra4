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
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Joaquin
 */
public class ProfesorDAO {
    public void create(profesor cl)  throws Exception{
        String sqlcommand =  "insert into profesor(id_profesor, usuario_id, apellido1, apellido2, nombre, telefono, e_mail)"
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
            
            throw new Exception("Profesor ya existe");
            
        }
        
    }
    
    public profesor read(int id_profesor) throws Exception{        
        String sqlcommand = "select * from profesor where id_profesor=?";
        PreparedStatement stm = Database.instance().prepareStatement(sqlcommand);
        stm.setString(1, Integer.toString(id_profesor));
        ResultSet rs =  Database.instance().executeQuery(stm);           
        if (rs.next()) {          
            return from(rs);
        }
        else{
            throw new Exception ("No se encontró el profesor");
        }
    }
    
    public profesor readbyuser(String usuario_id) throws Exception{        
        String sqlcommand = "select * from profesor where usuario_id=?";
        PreparedStatement stm = Database.instance().prepareStatement(sqlcommand);
        stm.setString(1, usuario_id);
        ResultSet rs =  Database.instance().executeQuery(stm);      
        System.out.println(stm);
        System.out.println(rs);
        if (rs.next()) {          
            return from(rs);
        }
        else{
            throw new Exception ("No se encontró el profesor");
        }
    }
    public void update(profesor o) throws Exception{
        String sql="update profesor set usuario_id=?,apellido1=?,apellido2=?,nombre=?,telefono=?,e_mail=?  "+
                "where id_profesor=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, o.getUsuario_id());
        stm.setString(2, o.getApellido1());
        stm.setString(3, o.getApellido2());
        stm.setString(4, o.getNombre());
        stm.setString(5, o.getTelefono());
        stm.setString(6, o.getE_mail());
        stm.setString(7, Integer.toString(o.getId_profesor()));        
        int count=Database.instance().executeUpdate(stm);
        if (count==0){
            throw new Exception("Profesor no existe");
        }
    }    

    public void delete(profesor o) throws Exception{
        String sql="delete from profesor where id_profesor=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, Integer.toString(o.getId_profesor()));        
        int count=Database.instance().executeUpdate(stm);        
        if (count==0){
            throw new Exception("Profesor no existe");
        }
    }
    
    public List<profesor> findAll(){
        List<profesor> r= new ArrayList<>();
        String sql="select * from profesor";
        try {        
            PreparedStatement stm = Database.instance().prepareStatement(sql);
            ResultSet rs =  Database.instance().executeQuery(stm);     
            while (rs.next()) {
                r.add(from(rs));
            }
        } catch (SQLException ex) { }
        return r;
    }

    public List<profesor> findByNombre(profesor o){
        List<profesor> r= new ArrayList<>();
        String sql="select * from profesor where nombre like ?";
        try {        
            PreparedStatement stm = Database.instance().prepareStatement(sql);
            stm.setString(1, "%"+o.getNombre()+"%");   
            ResultSet rs =  Database.instance().executeQuery(stm); 
            while (rs.next()) {
                r.add(from(rs));
            }
        } catch (SQLException ex) { }
        return r;
    }
    
    
    public profesor from (ResultSet rs){
        try {
            profesor p = new profesor();
            p.setId_profesor(rs.getInt("id_profesor"));               
            p.setUsuario_id(rs.getString("usuario_id"));            
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
    public  void close(){
    }
}
