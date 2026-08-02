
package Dao;

import Red.CreateConnection; 
import java.sql.Connection; 
import Models.ProductoModel;
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.util.ArrayList; 
import java.util.List; 



public class ProductoDao { 
    
    private final CreateConnection connFactory = new CreateConnection();
    
    public boolean agregar (ProductoModel P){
    String query = "INSERT INTO producto(nombre, descripcion, precio, stock, iva, categoria, marca, fecha_creacion,"
            + "activo, id_proveedor) VALUES (?,?,?,?,?,?,?,?,?,?)";
    try(Connection conn = connFactory.getConnection(); 
        PreparedStatement ps = conn.prepareStatement(query)){
        ps.setString(1, P.getNombre()); 
        ps.setString(2, P.getDescripcion()); 
        ps.setDouble(3, P.getPrecio()); 
        ps.setInt(4, P.getStock()); 
        ps.setDouble(5, P.getIva());
        ps.setString(6, P.getCategoria()); 
        ps.setString(7, P.getMarca()); 
        ps.setDate(8, new java.sql.Date(P.getFecha_creacion().getTime()));
        ps.setBoolean(9, P.isActivo());
        ps.setInt(10, P.getId_proveedor());
        ps.executeUpdate();
        return true;
    }catch(Exception e){
    e.printStackTrace();
    }
    return false; 
    }
    
    public List<ProductoModel>ObtenerTodos(){
List<ProductoModel>lista = new ArrayList<>();
String query = "SELECT * FROM producto";
try(Connection conn = connFactory.getConnection(); 
    PreparedStatement ps = conn.prepareStatement(query); 
    ResultSet rs = ps.executeQuery()){
    while(rs.next()){
    ProductoModel P = new ProductoModel(
     rs.getInt("id_producto"),
     rs.getString("nombre"),
     rs.getString("descripcion"),
     rs.getDouble("precio"), 
     rs.getInt("stock"), 
     rs.getDouble("iva"), 
     rs.getString("Categoria"),
     rs.getString("Marca"), 
     rs.getDate("fecha_creacion"),
     rs.getBoolean("activo"),
     rs.getInt("id_proveedor")
    ); 
     lista.add(P);
    } 
}catch(Exception e){
e.printStackTrace();
}
return lista;
}
    
    
    public boolean actualizar (ProductoModel P){
    String query = "UPDATE producto SET nombre=?, descripcion=?, precio=?, stock=?, iva=?, categoria=?, marca=?, fecha_creacion=?,"
            + "activo=?, id_proveedor=? WHERE id_producto=?";
    try(Connection conn = connFactory.getConnection(); 
        PreparedStatement ps = conn.prepareStatement(query)){
        ps.setString(1, P.getNombre()); 
        ps.setString(2, P.getDescripcion()); 
        ps.setDouble(3, P.getPrecio()); 
        ps.setInt(4, P.getStock()); 
        ps.setDouble(5, P.getIva());
        ps.setString(6, P.getCategoria()); 
        ps.setString(7, P.getMarca()); 
        ps.setDate(8, new java.sql.Date(P.getFecha_creacion().getTime()));
        ps.setBoolean(9, P.isActivo());
        ps.setInt(10, P.getId_proveedor());
        ps.setInt(11, P.getId_producto());
        ps.executeUpdate();
        return true;
    }catch(Exception e){
    e.printStackTrace();
    }
    return false; 
    }
    
public boolean eliminar(int id_producto){
String query = "DELETE FROM producto WHERE id_producto=?";
try(Connection conn = connFactory.getConnection(); 
    PreparedStatement ps = conn.prepareStatement(query)){
    ps.setInt(1, id_producto);
    ps.executeUpdate();
    return true;
}catch(Exception e){
e.printStackTrace();
}
return false;
}

    public ProductoModel buscarPorNombre(String nombre) {
    String query = "SELECT * FROM producto WHERE nombre = ?";
    try (Connection cn = connFactory.getConnection();
         PreparedStatement ps = cn.prepareStatement(query)) {
        ps.setString(1, nombre);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return new ProductoModel(
                    rs.getInt("id_producto"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getDouble("precio"),
                    rs.getInt("stock"),
                    rs.getDouble("iva"),
                    rs.getString("categoria"),
                    rs.getString("marca"),
                    rs.getDate("fecha_creacion"),
                    rs.getBoolean("activo"),
                    rs.getInt("id_proveedor")
                );
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}
    
}
