/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Logic.curso;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ksand
 */
public class cursoDao {

    public void create(curso o) throws Exception {
        String sql = "insert into curso (id_curso, descripcion, area_tematica_id) "
                + "values(?,?,?)";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, Integer.toString(o.getCurso()));
        stm.setString(2, o.getDescripcion());
        stm.setString(3, Integer.toString(o.getArea_tematica_id()));
        int count = Database.instance().executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Curso ya existe");
        }
    }

    public curso read(int id_curso) throws Exception {
        curso r;
        String sql = "select * from curso where id_curso=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, Integer.toString(id_curso));
        ResultSet rs = Database.instance().executeQuery(stm);
        if (rs.next()) {
            r = from(rs);
        } else {
            throw new Exception("Curso no Existe");
        }
        return r;
    }

    public void update(curso o) throws Exception {
        String sql = "update curso set descripcion=?, area_tematica_id=? "
                + "where id_curso=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, o.getDescripcion());
        stm.setString(2, Integer.toString(o.getArea_tematica_id()));
        stm.setString(3, Integer.toString(o.getCurso()));
        
        int count = Database.instance().executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Curso no existe");
        }
    }

    public void delete(curso o) throws Exception {
        String sql = "delete from curso where id_curso=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, Integer.toString(o.getCurso()));
        int count = Database.instance().executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Curso no existe");
        }
    }

    public List<curso> findAll() {
        List<curso> r = new ArrayList<>();
        String sql = "select * from curso c inner join area_tematica at on c.area_tematica_id=at.id_area";
       
        try {         
            PreparedStatement stm = Database.instance().prepareStatement(sql);
            ResultSet rs =  Database.instance().executeQuery(stm); 
             while (rs.next()) {
                r.add(from(rs));
            }
        } catch (SQLException ex) { }
        return r;
    }

    public List<curso> findByDescripcion(curso o) {
        List<curso> r = new ArrayList<>();
        String sql = "select * from curso where descripcion like ?";
        try {
            PreparedStatement stm = Database.instance().prepareStatement(sql);
            stm.setString(1, "%" + o.getDescripcion() + "%");
            ResultSet rs = Database.instance().executeQuery(stm);
            while (rs.next()) {
                r.add(from(rs));
            }
        } catch (SQLException ex) {
        }
        return r;
    }

    public curso from(ResultSet rs) {
        try {
            area_tematicaDao at = new area_tematicaDao();
            curso r = new curso();
            r.setCurso(Integer.valueOf(rs.getString("id_curso")));
            r.setDescripcion(rs.getString("descripcion"));
            r.setArea_tematica_id(Integer.valueOf(rs.getString("area_tematica_id")));
            return r;
        } catch (SQLException ex) {
            return null;
        }
    }

    public void close() {
    }
}
