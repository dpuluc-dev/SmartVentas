
package Dao;

import Red.CreateConnection; 
import java.sql.Connection; 
import Models.CategoriaModel;
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.util.ArrayList; 
import java.util.List; 


public class CategoriaDao { 
    
    private final CreateConnection connFactory = new CreateConnection(); 
    
    public boolean agregar(CategoriaModel C){
        String query = "INSERT INTO categoria (descripcion, activo) VALUES (?,?)"; 
        try(Connection conn = connFactory.getConnection(); 
            PreparedStatement ps = conn.prepareStatement(query)){
            ps.setString(1, C.getDescripcion()); 
            ps.setBoolean(2, C.isActivo()); 
            ps.executeUpdate();
            return true;
        }catch(Exception e){
        e.printStackTrace();
        }
        return false; 
    } 
    
    
       public boolean actualizar(CategoriaModel C){
        String query = "UPDATE categoria SET descripcion=?, activo=? WHERE id_categoria=?"; 
        try(Connection conn = connFactory.getConnection(); 
            PreparedStatement ps = conn.prepareStatement(query)){
            ps.setString(1, C.getDescripcion()); 
            ps.setBoolean(2, C.isActivo()); 
            ps.setInt(3, C.getId_categoria());
            ps.executeUpdate();
            return true;
        }catch(Exception e){
        e.printStackTrace();
        }
        return false; 
    } 
    
    
       
public boolean eliminar(int id_categoria){
String query = "DELETE FROM categoria WHERE id_categoria=?";
try(Connection conn = connFactory.getConnection(); 
    PreparedStatement ps = conn.prepareStatement(query)){
    ps.setInt(1, id_categoria);
    ps.executeUpdate();
    return true;
}catch(Exception e){
e.printStackTrace();
}
return false;
}
    
public List<CategoriaModel>ObtenerTodos(){
List<CategoriaModel>lista = new ArrayList<>();
String query = "SELECT * FROM categoria";
try(Connection conn = connFactory.getConnection(); 
    PreparedStatement ps = conn.prepareStatement(query); 
    ResultSet rs = ps.executeQuery()){
    while(rs.next()){
    CategoriaModel C = new CategoriaModel(
     rs.getInt("Id_categoria"),
     rs.getString("descripcion"),
     rs.getBoolean("activo")
    ); 
     lista.add(C);
    } 
}catch(Exception e){
e.printStackTrace();
}
return lista;
}
    
}
