
package Dao;

import Red.CreateConnection; 
import java.sql.PreparedStatement;
import java.sql.Connection; 
import Models.UsuarioModel;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;

public class UsuarioDao {
 
private final CreateConnection connFactory = new CreateConnection();
    
public boolean agregar(UsuarioModel U){
String query = "INSERT INTO usuario (nombre, usuario, password, email, rol, departamento, estado, fecha_creacion)"
        + "VALUES (?,?,?,?,?,?,?,?)";
try(Connection conn = connFactory.getConnection(); 
    PreparedStatement ps = conn.prepareStatement(query)){
    ps.setString(1, U.getNombre());
    ps.setString(2, U.getUsuario());
    ps.setString(3, U.getPassword());
    ps.setString(4, U.getEmail());
    ps.setString(5, U.getRol()); 
    ps.setString(6, U.getDepartamento()); 
    ps.setInt(7, U.getEstado());
    ps.setDate(8, new java.sql.Date(U.getFecha_creacion().getTime()));
    ps.executeUpdate();
    return true;
}catch(Exception e){
e.printStackTrace();
}
return false;
}
  

public boolean actualizar(UsuarioModel U){
String query = "UPDATE usuario SET nombre=?, usuario=?, password=?, email=?, rol=?, departamento=?, estado=?, fecha_creacion=?"
        + "  WHERE id_usuario=?";
try(Connection conn = connFactory.getConnection(); 
    PreparedStatement ps = conn.prepareStatement(query)){
    ps.setString(1, U.getNombre());
    ps.setString(2, U.getUsuario());
    ps.setString(3, U.getPassword());
    ps.setString(4, U.getEmail());
    ps.setString(5, U.getRol()); 
    ps.setString(6, U.getDepartamento()); 
    ps.setInt(7, U.getEstado());
    ps.setDate(8, new java.sql.Date(U.getFecha_creacion().getTime()));
    ps.setInt(9, U.getId_usuario());
    ps.executeUpdate();
    return true;
}catch(Exception e){
e.printStackTrace();
}
return false;
} 


public boolean eliminar(int id_usuario){
String query = "DELETE FROM usuario WHERE id_usuario=?";
try(Connection conn = connFactory.getConnection(); 
    PreparedStatement ps = conn.prepareStatement(query)){
    ps.setInt(1, id_usuario);
    ps.executeUpdate();
    return true;
}catch(Exception e){
e.printStackTrace();
}
return false;
}


public UsuarioModel buscar(int id_usuario){
String query = "SELECT * FROM usuario WHERE id_usuario=?";
try(Connection conn = connFactory.getConnection(); 
    PreparedStatement ps = conn.prepareStatement(query)){
    ps.setInt(1,id_usuario);
    ResultSet rs = ps.executeQuery();
    while(rs.next()){
    UsuarioModel U = new UsuarioModel(
     rs.getString("nombre"),
     rs.getString("usuario"),
     rs.getString("password"), 
     rs.getString("email"), 
     rs.getString("rol"), 
     rs.getString("departamento"),
     rs.getInt("estado"), 
     rs.getDate("fecha_creacion")
    );
    return U;
    }
}catch(Exception e){
e.printStackTrace();
}
return null;
}


public UsuarioModel accesologion(String usuario, String password){
String query = "SELECT * FROM usuario WHERE usuario=? AND password=?";
try(Connection conn = connFactory.getConnection(); 
    PreparedStatement ps = conn.prepareStatement(query)){
    ps.setString(1, usuario);
    ps.setString(2, password);
    ResultSet rs = ps.executeQuery();
    if(rs.next()){
    return new UsuarioModel(
      rs.getString("nombre"),
     rs.getString("usuario"),
     rs.getString("password"), 
     rs.getString("email"), 
     rs.getString("rol"), 
     rs.getString("departamento"),
     rs.getInt("estado"), 
     rs.getDate("fecha_creacion")
    );
    }
}catch(Exception e){
e.printStackTrace();
}

return null;
}


public List<UsuarioModel>ObtenerTodos(){
List<UsuarioModel>lista = new ArrayList<>();
String query = "SELECT * FROM usuario";
try(Connection conn = connFactory.getConnection(); 
    PreparedStatement ps = conn.prepareStatement(query); 
    ResultSet rs = ps.executeQuery()){
    while(rs.next()){
    UsuarioModel U = new UsuarioModel(
     rs.getInt("Id_usuario"),
     rs.getString("nombre"),
     rs.getString("usuario"),
     rs.getString("password"), 
     rs.getString("email"), 
     rs.getString("rol"), 
     rs.getString("departamento"),
     rs.getInt("estado"), 
     rs.getDate("fecha_creacion")
    ); 
     lista.add(U);
    } 
}catch(Exception e){
e.printStackTrace();
}
return lista;
}




}
