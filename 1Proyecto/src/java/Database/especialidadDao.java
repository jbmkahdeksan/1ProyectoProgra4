/*
    Programación 4
    I Ciclo - 2021
    Proyecto 1 - Cursos Libres.com
    117440348 - Joaquin Barrientos Monge
    A00144883 - Kathy Sandoval Blandon
 */
package Database;

import Logic.especialidad;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ksand
 */
public class especialidadDao {
    
    public void create(especialidad o) throws Exception{
        String sql="insert into especialidad (profesor_id_profesor, area_tematica_id) "+
                "values(?,?)";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, Integer.toString(o.getProfesor_id_profesor()));
        stm.setString(2, Integer.toString(o.getArea_tematica_id()));        
        int count=Database.instance().executeUpdate(stm);
        if (count==0){
            throw new Exception("Especialidad ya existe");
        }
    }
    
//    public especialidad read(int profesor_id_profesor) throws Exception{
//       especialidad r;
//        String sql="select * from especialidad where profesor_id_profesor=?";
//        PreparedStatement stm = Database.instance().prepareStatement(sql);
//        stm.setString(1, Integer.toString(profesor_id_profesor));
//        ResultSet rs =  Database.instance().executeQuery(stm); 
//        if (rs.next()) {
//            r = from(rs);
//        }
//        else{
//            throw new Exception ("Especialidad no Existe");
//        }
//        return r;
//    }
    
//    public void update(especialidad o) throws Exception{
//        String sql="update especialidad set descripcion=? "+
//                "where id_area=?";
//        PreparedStatement stm = Database.instance().prepareStatement(sql);
//        stm.setString(1, o.getDescripcion());
//        stm.setString(2, Integer.toString(o.getId_area()));        
//        int count=Database.instance().executeUpdate(stm);
//        if (count==0){
//            throw new Exception("Area Tematica no existe");
//        }
//    }    

    public void delete(especialidad o) throws Exception{
        String sql="delete from especialidad where profesor_id_profesor=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, Integer.toString(o.getProfesor_id_profesor()));        
        int count=Database.instance().executeUpdate(stm);        
        if (count==0){
            throw new Exception("Especialidad no existe");
        }
    }
    
    public List<especialidad> findAll(){
        List<especialidad> r= new ArrayList<>();
        String sql="select * from especialidad";
        try {        
            PreparedStatement stm = Database.instance().prepareStatement(sql);
            ResultSet rs =  Database.instance().executeQuery(stm);     
            while (rs.next()) {
                r.add(from(rs));
            }
        } catch (SQLException ex) { }
        return r;
    }

    public List<especialidad> findByProfesor(especialidad o){
        List<especialidad> r= new ArrayList<>();
        String sql="select * from especialidad where profesor_id_profesor like ?";
        try {        
            PreparedStatement stm = Database.instance().prepareStatement(sql);
            stm.setString(1, "%"+Integer.toString(o.getProfesor_id_profesor())+"%");   
            ResultSet rs =  Database.instance().executeQuery(stm); 
            while (rs.next()) {
                r.add(from(rs));
            }
        } catch (SQLException ex) { }
        return r;
    }
    
    public especialidad from (ResultSet rs){
        try {
            especialidad r= new especialidad();
            r.setProfesor_id_profesor(Integer.valueOf(rs.getString("profesor_id_profesor")));
            r.setArea_tematica_id(Integer.valueOf(rs.getString("area_tematica_id")));
            return r;
        } catch (SQLException ex) {
            return null;
        }
    }

    public  void close(){
    }
}
