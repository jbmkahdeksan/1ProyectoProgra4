/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;


import Logic.curso;
import Logic.grupo;
import Logic.profesor;
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

    public grupo read(int num_grupo, int curso_id) throws Exception{
       grupo r;
        String sql="select * from grupo g inner join curso c on g.curso_id=c.id_curso where g.num_grupo=? AND g.curso_id=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, Integer.toString(num_grupo));
        stm.setString(2, Integer.toString(curso_id));
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
        String sql = "delete from grupo where num_grupo=? AND curso_id=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, Integer.toString(o.getNum_grupo()));
        stm.setString(2, Integer.toString(o.getCurso_id()));
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

    public List<grupo> findByCurso(curso o){
        List<grupo> r= new ArrayList<>();
        String sql="select * from grupo g inner join curso c on g.curso_id=c.id_curso where g.curso_id=?";
        sql = String.format(sql,o.getCurso());
        try {         
            PreparedStatement stm = Database.instance().prepareStatement(sql);
             stm.setString(1, Integer.toString(o.getCurso()));       
            ResultSet rs =  Database.instance().executeQuery(stm);         
            while (rs.next()) { r.add(from(rs)); } 
        } catch (SQLException ex) { }
            return r;
    }
    
    public List<grupo> findByProfesor(profesor o){
        List<grupo> r= new ArrayList<>();
        String sql="select * from grupo g inner join profesor p on g.profesor_id=p.id_profesor where g.profesor_id=?";
        sql = String.format(sql,o.getId_profesor());
        try {         
            PreparedStatement stm = Database.instance().prepareStatement(sql);
             stm.setString(1, Integer.toString(o.getId_profesor()));       
            ResultSet rs =  Database.instance().executeQuery(stm);         
            while (rs.next()) { r.add(from(rs)); } 
        } catch (SQLException ex) { }
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
    
    public List<grupo> encuentraPorCurso(curso c){
        List<grupo> r= new ArrayList<>();
        String sql="select grupo.num_grupo, curso.descripcion, horario.dia, horario.hora, profesor.nombre, profesor.apellido1 from grupo inner join curso on grupo.curso_id = curso.id_curso inner join horario on horario.grupo_curso_id = curso.id_curso inner join profesor on grupo.profesor_id = profesor.id_profesor where curso.id_curso=?";
        sql = String.format(sql,c.getCurso());
        try {         
            PreparedStatement stm = Database.instance().prepareStatement(sql);
             stm.setString(1, Integer.toString(c.getCurso()));       
            ResultSet rs =  Database.instance().executeQuery(stm);         
            while (rs.next()) { r.add(from(rs)); } 
        } catch (SQLException ex) { }
            return r;
    }
    

    public void close() {
    }
}
