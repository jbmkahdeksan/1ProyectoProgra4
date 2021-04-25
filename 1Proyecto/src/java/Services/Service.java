package Services;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Database.AdministradorDAO;
import Database.EstudiantesDAO;
import Database.ProfesorDAO;
import Database.RolDAO;
import Database.UsuariosDAO;
import Database.area_tematicaDao;
import Database.cursoDao;
import Database.especialidadDao;
import Database.estadoDao;
import Database.grupoDao;
import Database.horarioDao;
import Database.matriculaDao;
import Logic.curso;
import Logic.usuario;
import java.util.List;

/**
 *
 * @author Joaquin
 */
public class Service {
    private AdministradorDAO administrador_dao;
    private EstudiantesDAO estudiantes_dao;
    private ProfesorDAO profesor_dao;
    private RolDAO rol_dao;
    private UsuariosDAO usuarios_dao;
    private area_tematicaDao area_dao;
    private cursoDao curso_dao;
    private especialidadDao especialidad_dao;
    private estadoDao estado_dao;
    private grupoDao grupo_dao;
    private horarioDao horario_dao;
    private matriculaDao matricula_dao;
    
    private static Service theInstance;
    
    public static Service instance(){
        if(theInstance==null){
            theInstance = new Service();
        }
        return theInstance;
    }
    
    public Service(){
        administrador_dao = new AdministradorDAO();
        estudiantes_dao = new EstudiantesDAO();
        profesor_dao = new ProfesorDAO();
        rol_dao = new RolDAO();
        usuarios_dao = new UsuariosDAO();
        area_dao = new area_tematicaDao();
        curso_dao = new cursoDao();
        especialidad_dao = new especialidadDao();
        estado_dao = new estadoDao();
        grupo_dao = new grupoDao();
        horario_dao = new horarioDao();
        matricula_dao = new matriculaDao();
        
    }

//    
////crear nuevo matricula
//   public Matricula  crear_matricula(Matricula u){
//         Matricula result = null;
//         try{
//            result=matriculasdao.create(u);
//        //    System.out.println(u.getId());
//              return result;
//         }
//         catch(Exception e){
//           return null ;//usuario ya existe 
//         }
//   
//    }    
////crear nuevp grupo
//    public Grupo crear_grupo(Grupo u){
//         Grupo result = null;
//         try{
//            result=gruposdao.create(u);
//            //System.out.println(u.getId());
//              return result;
//         }
//         catch(Exception e){
//           return null ;//Grupo ya existe 
//         }
//   
//    }   
   
//    }
//    //crear usario nuevo en la base de datos
//    public Usuarios crear_usario(Usuarios u){
//         Usuarios result = null;
//         try{
//            result=usuarioDao.create(u);
//            System.out.println(u.getId());
//              return result;
//         }
//         catch(Exception e){
//           return null ;//usuario ya existe 
//         }
//   
//    }
    public usuario login(usuario u) throws Exception{
        usuario result = null;
        
        result = usuarios_dao.read(u.getId());
        if(result == null)
            throw new Exception("Usuario no encontrado");
//               System.out.println("Contrassena de base de datos: "+result.getContrasenna());
//        System.out.println("Contrassena de usuario: "+u.getContrasenna());
//            if((result.getContrasenna()).equals(u.getContrasenna())){
//               System.out.println("Correcto");  
//            }
        if(!(result.getClave()).equals(u.getClave())){
            throw new Exception("Usuario con mala contrasenna");
        }
        
        return result;
    }
    
    
    // ------------ Cursos -------------    

    public List<curso> getCursos() {
        return curso_dao.findAll();
    }
    
    public void addCurso(curso o)throws Exception{
        curso_dao.create(o);
    }

    public curso getCurso(curso o) throws Exception{
        return curso_dao.read(o.getCurso());
    }  

    public void updateCurso(curso o)throws Exception{
        curso_dao.update(o);
        curso stored=this.getCurso(o);
    }
    
    public List<curso> searchCurso(curso o){
        return curso_dao.findByDescripcion(o); 
    }
    
    //falta solo de implementar en service, ya exise el metodo en dao respectivo
    //FALTA leer grupos por curso
    //FALTA LEER profesor por grupo
    //FALTAleer grupos por profe
    //FALTAgrupos por estudiante(historial)
    //FALTAEstudiantes por grupo
}
