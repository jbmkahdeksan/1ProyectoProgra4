/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Logic.area_tematica;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ksand
 */
public class area_tematicaDao {
    
    public void create(area_tematica o) throws Exception{
        String sql="insert into area_tematica (id_area, descripcion) "+
                "values(?,?)";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, Integer.toString(o.getId_area()));
        stm.setString(2, o.getDescripcion());        
        int count=Database.instance().executeUpdate(stm);
        if (count==0){
            throw new Exception("Area Tematica ya existe");
        }
    }
    
    public area_tematica read(int id_area) throws Exception{
       area_tematica r;
        String sql="select * from area_tematica where id_area=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, Integer.toString(id_area));
        ResultSet rs =  Database.instance().executeQuery(stm); 
        if (rs.next()) {
            r = from(rs);
        }
        else{
            throw new Exception ("Area Tematica no Existe");
        }
        return r;
    }
    
    public void update(area_tematica o) throws Exception{
        String sql="update area_tematica set descripcion=?"+
                "where id_area=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, o.getDescripcion());
        stm.setString(2, Integer.toString(o.getId_area()));        
        int count=Database.instance().executeUpdate(stm);
        if (count==0){
            throw new Exception("Area Tematica no existe");
        }
    }    

    public void delete(area_tematica o) throws Exception{
        String sql="delete from area_tematica where id_area=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, Integer.toString(o.getId_area()));        
        int count=Database.instance().executeUpdate(stm);        
        if (count==0){
            throw new Exception("Area Tematica no existe");
        }
    }
    
    public List<area_tematica> findAll(){
        List<area_tematica> r= new ArrayList<>();
        String sql="select * from area_tematica";
        try {        
            PreparedStatement stm = Database.instance().prepareStatement(sql);
            ResultSet rs =  Database.instance().executeQuery(stm);     
            while (rs.next()) {
                r.add(from(rs));
            }
        } catch (SQLException ex) { }
        return r;
    }

    public List<area_tematica> findByDescripcion(area_tematica o){
        List<area_tematica> r= new ArrayList<>();
        String sql="select * from area_tematica where descripcion like ?";
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
    
    public List<area_tematica> findByID(area_tematica o){
        List<area_tematica> r= new ArrayList<>();
        String sql="select * from area_tematica where id_area like ?";
        try {        
            PreparedStatement stm = Database.instance().prepareStatement(sql);
            stm.setString(1, "%"+o.getId_area()+"%");   
            ResultSet rs =  Database.instance().executeQuery(stm); 
            while (rs.next()) {
                r.add(from(rs));
            }
        } catch (SQLException ex) { }
        return r;
    }
    
    public area_tematica from (ResultSet rs){
        try {
            area_tematica r= new area_tematica();
            r.setId_area(Integer.valueOf(rs.getString("id_area")));
            r.setDescripcion(rs.getString("descripcion"));
            return r;
        } catch (SQLException ex) {
            return null;
        }
    }

    public  void close(){
    }
}
