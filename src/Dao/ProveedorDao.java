
package Dao;

import Models.ProveedorModel; 
import Red.CreateConnection; 
import java.sql.PreparedStatement;
import java.sql.Connection; 
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;

public class ProveedorDao { 
    
    private final CreateConnection connFactory = new CreateConnection(); 
    
    public boolean agregar(ProveedorModel P){
    String query = "INSERT INTO proveedor (nombre, email, telefono, direccion, estado) VALUES (?,?,?,?,?)";
    try(Connection conn = connFactory.getConnection(); 
            PreparedStatement ps = conn.prepareStatement(query)){
            ps.setString(1, P.getNombre()); 
            ps.setString(2, P.getEmail()); 
            ps.setString(3, P.getTelefono());
            ps.setString(4, P.getDireccion()); 
            ps.setInt(5, P.getEstado()); 
            ps.executeUpdate(); 
            return true; 
    }catch(Exception e){
    e.printStackTrace();
    }
    return false;
    } 
    
    public boolean actualizar(ProveedorModel P){
    String query = "UPDATE proveedor SET nombre=?, email=?, telefono=?, direccion=?, estado=? WHERE id_proveedor=?";
    try(Connection conn = connFactory.getConnection(); 
            PreparedStatement ps = conn.prepareStatement(query)){
            ps.setString(1, P.getNombre()); 
            ps.setString(2, P.getEmail()); 
            ps.setString(3, P.getTelefono());
            ps.setString(4, P.getDireccion()); 
            ps.setInt(5, P.getEstado());  
            ps.setInt(6, P.getId_proveedor());
            ps.executeUpdate(); 
            return true; 
    }catch(Exception e){
    e.printStackTrace();
    }
    return false;
    } 
    
    public boolean eliminar(int id_proveedor){
    String query = "DELETE FROM proveedor WHERE id_proveedor=?";
    try(Connection conn = connFactory.getConnection(); 
            PreparedStatement ps = conn.prepareStatement(query)){
            ps.setInt(1, id_proveedor);
            ps.executeUpdate(); 
            return true; 
    }catch(Exception e){
    e.printStackTrace();
    }
    return false;
    } 
     
    public ProveedorModel bucar(int id_proveedor){
    String query = "SELECT * FROM proveedor WHERE id_proveedor=?";
    try(Connection conn = connFactory.getConnection(); 
        PreparedStatement ps = conn.prepareStatement(query)){
        ps.setInt(1, id_proveedor); 
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
        ProveedorModel P = new ProveedorModel(
        rs.getString("nombre"),
        rs.getString("email"),
        rs.getString("telefono"),
        rs.getString("direccion"),
        rs.getInt("estado")
         ); 
        return P;
        }
    
    }catch(Exception e){
    e.printStackTrace();
    }
    return null;
    }
    
    public List<ProveedorModel>ObtenerTodos(){
    List<ProveedorModel>lista = new ArrayList<>();
    String query = "SELECT * FROM proveedor"; 
    try(Connection conn = connFactory.getConnection(); 
        PreparedStatement ps = conn.prepareStatement(query); 
        ResultSet rs = ps.executeQuery()){
       while(rs.next()){
       ProveedorModel P = new ProveedorModel(
        rs.getInt("id_proveedor"),
        rs.getString("nombre"),
        rs.getString("email"),
        rs.getString("telefono"),
        rs.getString("direccion"),
        rs.getInt("estado")
        ); 
       lista.add(P);
       } 
    }catch(Exception e){
    e.printStackTrace();
    }
    return lista;
    } 
    
    
    
}
