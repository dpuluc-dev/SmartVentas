
package Controllers;

import Dao.UsuarioDao; 
import Models.UsuarioModel; 
import java.util.Date;
import java.util.List;


public class UsuarioControlador {

UsuarioDao dao = new UsuarioDao(); 

public boolean agregarUsuario(String nombre, String usuario, String password, String email, String rol, String departamento,
int estado, Date fecha_creacion){
UsuarioModel U = new UsuarioModel(nombre, usuario, password, email, rol, departamento, estado, fecha_creacion); 
boolean res = dao.agregar(U); 
return res;
}  

public boolean actualizarUsuario(int id_usuario,String nombre, String usuario, String password, String email, String rol, String departamento,
int estado, Date fecha_creacion){
UsuarioModel U = new UsuarioModel(id_usuario, nombre, usuario, password, email, rol, departamento, estado, fecha_creacion); 
boolean res = dao.actualizar(U);
return res;
} 

public boolean elimarUsuario(int id_usuario){
UsuarioModel U = new UsuarioModel();
U.setId_usuario(id_usuario);
boolean res = dao.eliminar(id_usuario); 
return res;
} 

public UsuarioModel bucarUsuario(int id_usuario){
UsuarioModel U = dao.buscar(id_usuario);
return U;
} 

public UsuarioModel LoginAcceso(String usuario, String password){
return dao.accesologion(usuario, password);
}


public List<UsuarioModel>ObtenerTodos(){
return dao.ObtenerTodos();
}


    
}
