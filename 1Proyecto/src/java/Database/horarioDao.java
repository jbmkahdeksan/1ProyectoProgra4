/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Logic.grupo;
import Logic.horario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ksand
 */
public class horarioDao {

    public void create(horario o) throws Exception {
        String sql = "insert into horario (seq, grupo_num, grupo_curso_id, dia, hora) "
                + "values(?,?,?,?,?)";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, Integer.toString(o.getSeq()));
        stm.setString(2, Integer.toString(o.getGrupo_num()));
        stm.setString(3, Integer.toString(o.getGrupo_curso_id()));
        stm.setString(4, Integer.toString(o.getDia()));
        stm.setString(5, Integer.toString(o.getHora()));
        int count = Database.instance().executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Hprario ya existe");
        }
    }

    public horario read(int seq) throws Exception{
       horario r;
        String sql="select * from horario where seq=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, Integer.toString(seq));
        ResultSet rs =  Database.instance().executeQuery(stm); 
        if (rs.next()) {
            r = from(rs);
        }
        else{
            throw new Exception ("Horario no Existe");
        }
        return r;
    }
    public void update(horario o) throws Exception{
        String sql="update horario set grupo_num=?,grupo_curso_id=?,dia=?,hora=? "+
                "where seq=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, Integer.toString(o.getGrupo_num())); 
        stm.setString(2, Integer.toString(o.getGrupo_curso_id())); 
        stm.setString(3, Integer.toString(o.getDia()));
        stm.setString(4, Integer.toString(o.getHora())); 
        stm.setString(5, Integer.toString(o.getSeq())); 
        
        int count=Database.instance().executeUpdate(stm);
        if (count==0){
            throw new Exception("Horario no existe");
        }
    }    
    public void delete(horario o) throws Exception {
        String sql = "delete from horario where seq=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, Integer.toString(o.getSeq()));
        int count = Database.instance().executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Horario no existe");
        }
    }

    public List<horario> findAll() {
        List<horario> r = new ArrayList<>();
        String sql = "select * from horario";
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

    public List<horario> findByCurso(horario o) {
        List<horario> r = new ArrayList<>();
        String sql = "select * from horario where grupo_num like ?";
        try {
            PreparedStatement stm = Database.instance().prepareStatement(sql);
            stm.setString(1, "%" + Integer.toString(o.getGrupo_num()) + "%");
            ResultSet rs = Database.instance().executeQuery(stm);
            while (rs.next()) {
                r.add(from(rs));
            }
        } catch (SQLException ex) {
        }
        return r;
    }

    public horario from(ResultSet rs) {
        try {
            horario r = new horario();
            r.setSeq(Integer.valueOf(rs.getString("seq")));
            r.setGrupo_num(Integer.valueOf(rs.getString("grupo_num")));
            r.setGrupo_curso_id(Integer.valueOf(rs.getString("grupo_curso_id")));
            r.setDia(Integer.valueOf(rs.getString("dia")));
            r.setHora(Integer.valueOf(rs.getString("hora")));
            return r;
        } catch (SQLException ex) {
            return null;
        }
    }

    public void close() {
    }
}
