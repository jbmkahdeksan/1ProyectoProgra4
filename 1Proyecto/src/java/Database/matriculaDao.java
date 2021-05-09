/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Logic.matricula;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ksand
 */
public class matriculaDao {

    public void create(matricula o) throws Exception {
        String sql = "insert into matricula (estudiante_id, grupo_num, curso_id, estado_id, nota) "
                + "values(?,?,?,?,?)";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, Integer.toString(o.getEstudiante_id()));
        stm.setString(2, Integer.toString(o.getGrupo_num()));
        stm.setString(3, Integer.toString(o.getCurso_id()));
        stm.setString(4, Integer.toString(o.getEstado_id()));
        stm.setString(5, Integer.toString(o.getNota()));
        System.out.println(stm);
        int count = Database.instance().executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Matricula ya existe");
        }
    }

    public matricula read(int estudiante_id) throws Exception{
       matricula r;
        String sql="select * from matricula where estudiante_id=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, Integer.toString(estudiante_id));
        ResultSet rs =  Database.instance().executeQuery(stm); 
        if (rs.next()) {
            r = from(rs);
        }
        else{
            throw new Exception ("Horario no Existe");
        }
        return r;
    }
    
    public matricula readall(int estudiante_id, int num_grupo, int curso_id) throws Exception{
       matricula r;
        String sql="select * from matricula where estudiante_id=? and grupo_num=? and curso_id=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, Integer.toString(estudiante_id));
        stm.setString(2, Integer.toString(num_grupo));
        stm.setString(3, Integer.toString(curso_id));
        ResultSet rs =  Database.instance().executeQuery(stm); 
        if (rs.next()) {
            r = from(rs);
        }
        else{
            throw new Exception ("Horario no Existe");
        }
        return r;
    }
    public void update(matricula o) throws Exception{
        String sql="update matricula set grupo_num=?,curso_id=?,estado_id=?,nota=? "+
                "where estudiante_id=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, Integer.toString(o.getGrupo_num())); 
        stm.setString(2, Integer.toString(o.getCurso_id())); 
        stm.setString(3, Integer.toString(o.getEstado_id()));
        stm.setString(4, Integer.toString(o.getNota())); 
        stm.setString(5, Integer.toString(o.getEstudiante_id())); 
        
        int count=Database.instance().executeUpdate(stm);
        if (count==0){
            throw new Exception("Matricula no existe");
        }
    }    
    public void delete(matricula o) throws Exception {
        String sql = "delete from matricula where estudiante_id=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, Integer.toString(o.getEstudiante_id()));
        int count = Database.instance().executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Horario no existe");
        }
    }

    public List<matricula> findAll(int e) {
        List<matricula> r = new ArrayList<>();
        String sql = "select * from matricula where estudiante_id = ?";
        try {
            PreparedStatement stm = Database.instance().prepareStatement(sql);
            stm.setString(1, Integer.toString(e));
            ResultSet rs = Database.instance().executeQuery(stm);
            while (rs.next()) {
                r.add(from(rs));
            }
        } catch (SQLException ex) {
        }
        return r;
    }
    public List<matricula> findByMatricula(matricula o) {
        List<matricula> r = new ArrayList<>();
        String sql = "select * from matricula where grupo_num=? AND curso_id=?";
        try {         
            PreparedStatement stm = Database.instance().prepareStatement(sql);
             stm.setString(1, Integer.toString(o.getGrupo_num())); 
             stm.setString(2, Integer.toString(o.getCurso_id()));
            ResultSet rs =  Database.instance().executeQuery(stm);         
            while (rs.next()) { r.add(from(rs)); } 
        } catch (SQLException ex) { }
            return r;
    }

    public List<matricula> findByCurso(matricula o) {
        List<matricula> r = new ArrayList<>();
        String sql = "select * from matricula where grupo_num like ?";
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

    public matricula from(ResultSet rs) {
        try {
            matricula r = new matricula();
            r.setEstudiante_id(Integer.valueOf(rs.getString("estudiante_id")));
            r.setGrupo_num(Integer.valueOf(rs.getString("grupo_num")));
            r.setCurso_id(Integer.valueOf(rs.getString("curso_id")));
            r.setEstado_id(Integer.valueOf(rs.getString("estado_id")));
            r.setNota(Integer.valueOf(rs.getString("nota")));
            return r;
        } catch (SQLException ex) {
            return null;
        }
    }

    public void close() {
    }
}
