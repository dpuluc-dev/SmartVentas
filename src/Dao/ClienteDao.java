
package Dao;

import Red.CreateConnection; 
import java.sql.Connection; 
import Models.ClienteModel;
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.util.ArrayList; 
import java.util.List;

public class ClienteDao { 
    
    private final CreateConnection connFactory = new CreateConnection();
    
    public boolean agregar(ClienteModel c) {
        String query = "INSERT INTO cliente (nombre, email, dpi, telefono, direccion, estado) "
                + "VALUES (?,?,?,?,?,?)";
        try (Connection conn = connFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)){
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getEmail());
            ps.setString(3, c.getDpi());
            ps.setString(4, c.getTelefono());
            ps.setString(5, c.getDireccion());
            ps.setBoolean(6, c.isEstado());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean actualizar(ClienteModel c) {
        String query = "UPDATE cliente SET nombre=?, email=?, dpi=?, telefono=?, direccion=?, "
                + "estado=? WHERE id_cliente=?";
        try (Connection conn = connFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getEmail());
            ps.setString(3, c.getDpi());
            ps.setString(4, c.getTelefono());
            ps.setString(5, c.getDireccion());
            ps.setBoolean(6, c.isEstado());
            ps.setInt(7, c.getId_cliente());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean eliminar(int id_cliente) {
        String query = "DELETE FROM cliente WHERE id_cliente=?";
        try (Connection conn = connFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id_cliente);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
     public ClienteModel buscar(int id_cliente) {
        String query = "SELECT * FROM cliente WHERE id_cliente=?";
        try (Connection conn = connFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id_cliente);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new ClienteModel(
                    rs.getString("nombre"),
                    rs.getString("email"),
                    rs.getString("dpi"),
                    rs.getString("telefono"),
                    rs.getString("direccion"),
                    rs.getBoolean("estado")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; 
    }
     
    public List<ClienteModel>ObtenerTodos() {
        List<ClienteModel> lista = new ArrayList<>();
        String query = "SELECT * FROM cliente";
        try (Connection conn = connFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()){
            while (rs.next()) {
                ClienteModel c = new ClienteModel(
                    rs.getInt("id_cliente"),
                    rs.getString("nombre"),
                    rs.getString("email"),
                    rs.getString("dpi"),
                    rs.getString("telefono"),
                    rs.getString("direccion"),
                    rs.getBoolean("estado")
                );
                lista.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
     
    
    
}
