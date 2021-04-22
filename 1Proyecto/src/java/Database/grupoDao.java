/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Logic.especialidad;
import Logic.grupo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ksand
 */
public class grupoDao {

    public void create(grupo o) throws Exception {
        String sql = "insert into grupo (num_grupo, curso_id, profesor_id) "
                + "values(?,?,?)";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, Integer.toString(o.getNum_grupo()));
        stm.setString(2, Integer.toString(o.getCurso_id()));
        stm.setString(3, Integer.toString(o.getProfesor_id()));
        int count = Database.instance().executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Grupo ya existe");
        }
    }

    public grupo read(int num_grupo) throws Exception{
       grupo r;
        String sql="select * from grupo where num_grupo=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, Integer.toString(num_grupo));
        ResultSet rs =  Database.instance().executeQuery(stm); 
        if (rs.next()) {
            r = from(rs);
        }
        else{
            throw new Exception ("Grupo no Existe");
        }
        return r;
    }
    public void update(grupo o) throws Exception{
        String sql="update grupo set curso_id=?,profesor_id=? "+
                "where num_grupo=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, Integer.toString(o.getCurso_id())); 
        stm.setString(2, Integer.toString(o.getProfesor_id())); 
        stm.setString(3, Integer.toString(o.getNum_grupo())); 
        
        int count=Database.instance().executeUpdate(stm);
        if (count==0){
            throw new Exception("Grupo no existe");
        }
    }    
    public void delete(grupo o) throws Exception {
        String sql = "delete from grupo where num_grupo=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, Integer.toString(o.getNum_grupo()));
        int count = Database.instance().executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Grupo no existe");
        }
    }

    public List<grupo> findAll() {
        List<grupo> r = new ArrayList<>();
        String sql = "select * from grupo";
        try {
            PreparedStatement stm = Database.instance().prepareStatement(sql);
            ResultSet rs = Database.instance().executeQuery(stm);
            while (rs.next()) {
                r.add(from(rs));
            }
        } catch (SQLException ex) {
        }
        return r;
    }

    public List<grupo> findByCurso(grupo o) {
        List<grupo> r = new ArrayList<>();
        String sql = "select * from grupo where curso_id like ?";
        try {
            PreparedStatement stm = Database.instance().prepareStatement(sql);
            stm.setString(1, "%" + Integer.toString(o.getCurso_id()) + "%");
            ResultSet rs = Database.instance().executeQuery(stm);
            while (rs.next()) {
                r.add(from(rs));
            }
        } catch (SQLException ex) {
        }
        return r;
    }

    public grupo from(ResultSet rs) {
        try {
            grupo r = new grupo();
            r.setNum_grupo(Integer.valueOf(rs.getString("num_grupo")));
            r.setCurso_id(Integer.valueOf(rs.getString("curso_id")));
            r.setProfesor_id(Integer.valueOf(rs.getString("profesor_id")));
            return r;
        } catch (SQLException ex) {
            return null;
        }
    }

    public void close() {
    }
}
