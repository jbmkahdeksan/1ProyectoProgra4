/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Logic.area_tematica;
import Logic.estado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ksand
 */
public class estadoDao {
    
    public void create(estado o) throws Exception{
        String sql="insert into estado (id_estado, descripcion) "+
                "values(?,?)";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, Integer.toString(o.getId_estado()));
        stm.setString(2, o.getDescripcion());        
        int count=Database.instance().executeUpdate(stm);
        if (count==0){
            throw new Exception("Estado ya existe");
        }
    }
    
    public estado read(int id_estado) throws Exception{
       estado r;
        String sql="select * from estado where id_estado=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, Integer.toString(id_estado));
        ResultSet rs =  Database.instance().executeQuery(stm); 
        if (rs.next()) {
            r = from(rs);
        }
        else{
            throw new Exception ("Estado no Existe");
        }
        return r;
    }
    
    public void update(estado o) throws Exception{
        String sql="update estado set descripcion=? "+
                "where id_estado=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, o.getDescripcion());
        stm.setString(2, Integer.toString(o.getId_estado()));        
        int count=Database.instance().executeUpdate(stm);
        if (count==0){
            throw new Exception("Estado no existe");
        }
    }    

    public void delete(estado o) throws Exception{
        String sql="delete from estado where id_estado=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, Integer.toString(o.getId_estado()));        
        int count=Database.instance().executeUpdate(stm);        
        if (count==0){
            throw new Exception("Estado no existe");
        }
    }
    
    public List<estado> findAll(){
        List<estado> r= new ArrayList<>();
        String sql="select * from estado";
        try {        
            PreparedStatement stm = Database.instance().prepareStatement(sql);
            ResultSet rs =  Database.instance().executeQuery(stm);     
            while (rs.next()) {
                r.add(from(rs));
            }
        } catch (SQLException ex) { }
        return r;
    }

    public List<estado> findByDescripcion(estado o){
        List<estado> r= new ArrayList<>();
        String sql="select * from estado where descripcion like ?";
        try {        
            PreparedStatement stm = Database.instance().prepareStatement(sql);
            stm.setString(1, "%"+o.getDescripcion()+"%");   
            ResultSet rs =  Database.instance().executeQuery(stm); 
            while (rs.next()) {
                r.add(from(rs));
            }
        } catch (SQLException ex) { }
        return r;
    }
    
    public estado from (ResultSet rs){
        try {
            estado r= new estado();
            r.setId_estado(Integer.valueOf(rs.getString("id_estado")));
            r.setDescripcion(rs.getString("descripcion"));
            return r;
        } catch (SQLException ex) {
            return null;
        }
    }

    public  void close(){
    }
}
