
package Dao;

import Red.CreateConnection; 
import java.sql.Connection; 
import Models.PorcentajeModel;
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.util.ArrayList; 
import java.util.List;

public class PorcentajeDao {
    
     private final CreateConnection connFactory = new CreateConnection(); 
    
    public boolean agregar(PorcentajeModel C){
        String query = "INSERT INTO porcentaje (iva, activo) VALUES (?,?)"; 
        try(Connection conn = connFactory.getConnection(); 
            PreparedStatement ps = conn.prepareStatement(query)){
            ps.setDouble(1, C.getIva());
            ps.setBoolean(2, C.isActivo()); 
            ps.executeUpdate();
            return true;
        }catch(Exception e){
        e.printStackTrace();
        }
        return false; 
    } 
    
    
       public boolean actualizar(PorcentajeModel C){
        String query = "UPDATE porcentaje SET iva=?, activo=? WHERE id_iva=?"; 
        try(Connection conn = connFactory.getConnection(); 
            PreparedStatement ps = conn.prepareStatement(query)){
            ps.setDouble(1, C.getIva());
            ps.setBoolean(2, C.isActivo()); 
            ps.setInt(3, C.getId_iva());
            ps.executeUpdate();
            return true;
        }catch(Exception e){
        e.printStackTrace();
        }
        return false; 
    } 
    
    
       
public boolean eliminar(int id_iva){
String query = "DELETE FROM porcentaje WHERE id_iva=?";
try(Connection conn = connFactory.getConnection(); 
    PreparedStatement ps = conn.prepareStatement(query)){
    ps.setInt(1, id_iva);
    ps.executeUpdate();
    return true;
}catch(Exception e){
e.printStackTrace();
}
return false;
}
    
public List<PorcentajeModel>ObtenerTodos(){
List<PorcentajeModel>lista = new ArrayList<>();
String query = "SELECT * FROM porcentaje";
try(Connection conn = connFactory.getConnection(); 
    PreparedStatement ps = conn.prepareStatement(query); 
    ResultSet rs = ps.executeQuery()){
    while(rs.next()){
    PorcentajeModel P = new PorcentajeModel(
     rs.getInt("Id_iva"),
     rs.getDouble("iva"),
     rs.getBoolean("activo")
    ); 
     lista.add(P);
    } 
}catch(Exception e){
e.printStackTrace();
}
return lista;
}
    
}
