package Dao;

import Models.Detalle_VentaModelo;
import Red.CreateConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Detalle_VentaDao{

    private final CreateConnection connFactory = new CreateConnection();

    public boolean agregar(Detalle_VentaModelo detalle){
        String query = "INSERT INTO detalle_venta"
                + "(id_venta, producto, cantidad, precio_unitario, subtotal, iva, total) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = connFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)){
             ps.setInt(1, detalle.getId_venta());
             ps.setString(2, detalle.getProducto());
             ps.setInt(3, detalle.getCantidad());
             ps.setDouble(4, detalle.getPrecio_unitario());
             ps.setDouble(5, detalle.getSubtotal());
             ps.setDouble(6, detalle.getIva());
             ps.setDouble(7, detalle.getTotal());
             ps.executeUpdate();
             return true;
        } catch (Exception e){
            e.printStackTrace();
        } 
        return false;
    }

    public boolean actualizar(Detalle_VentaModelo detalle){
        String query = "UPDATE detalle_venta SET "
                + "id_venta=?, producto=?, cantidad=?, "
                + "precio_unitario=?, subtotal=?, iva=?, total=? "
                + "WHERE id_detalle=?";
        try (Connection cn = connFactory.getConnection();
            PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setInt(1, detalle.getId_venta());
            ps.setString(2, detalle.getProducto());
            ps.setInt(3, detalle.getCantidad());
            ps.setDouble(4, detalle.getPrecio_unitario());
            ps.setDouble(5, detalle.getSubtotal());
            ps.setDouble(6, detalle.getIva());
            ps.setDouble(7, detalle.getTotal());
            ps.setInt(8, detalle.getId_detalle());
            ps.executeUpdate();
            return true;
        }catch(Exception e){
           e.printStackTrace();
        } 
        return false;
    }

    public boolean eliminar(int id_detalle){
        String query = "DELETE FROM detalle_venta WHERE id_detalle=?";
        try (Connection cn = connFactory.getConnection();
             PreparedStatement ps = cn.prepareStatement(query)) {
             ps.setInt(1, id_detalle);
             ps.executeUpdate();
             return true; 
        }catch (Exception e){
            e.printStackTrace();
        } 
        return false;
    }

    public List<Detalle_VentaModelo>ObtenerTodos(){
        List<Detalle_VentaModelo>lista = new ArrayList<>();
        String query = "SELECT * FROM detalle_venta";
        try (Connection cn = connFactory.getConnection();
             PreparedStatement ps = cn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()){
             while (rs.next()) {
             Detalle_VentaModelo D = new Detalle_VentaModelo(
             rs.getInt("id_detalle"),
             rs.getInt("id_venta"),
             rs.getString("producto"),
             rs.getInt("cantidad"),
             rs.getDouble("precio_unitario"),
             rs.getDouble("subtotal"),
             rs.getDouble("iva"),
             rs.getDouble("total")
             ); 
             lista.add(D);
            }
        }catch(Exception e){
           e.printStackTrace();
        }
        return lista;
    }

    public Detalle_VentaModelo buscar(int id_detalle){
        String query = "SELECT * FROM detalle_venta WHERE id_detalle=?";
        try (Connection cn = connFactory.getConnection();
             PreparedStatement ps = cn.prepareStatement(query)){
             ps.setInt(1, id_detalle);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
             Detalle_VentaModelo D = new Detalle_VentaModelo(
             rs.getInt("id_detalle"),
             rs.getInt("id_venta"),
             rs.getString("producto"),
             rs.getInt("cantidad"),
             rs.getDouble("precio_unitario"),
             rs.getDouble("subtotal"),
             rs.getDouble("iva"),
             rs.getDouble("total")
             );
             return D;
             }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

}