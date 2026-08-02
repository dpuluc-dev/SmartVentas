package Dao;

import Models.VentaDetalleModel;
import Models.VentaModel;
import Red.CreateConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VentaDao {

    private final CreateConnection connFactory = new CreateConnection();

   
    public int agregar(VentaModel V){
        String query = "INSERT INTO venta(subtotal, total_iva, total_final, estado, cliente) "
                + "VALUES (?, ?, ?, ?, ?) RETURNING id_venta";
        try (Connection conn = connFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)){
             ps.setDouble(1, V.getSubtotal());
             ps.setDouble(2, V.getTotal_iva());
             ps.setDouble(3, V.getTotal_final());
             ps.setString(4, V.getEstado());
             ps.setString(5, V.getCliente());

             ResultSet rs = ps.executeQuery();
             if (rs.next()) {
                 return rs.getInt("id_venta");
             }
        } catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    } 
    
 public List<VentaDetalleModel> obtenerVentasConDetalle(){
    List<VentaDetalleModel> lista = new ArrayList<>();
    String query = "SELECT v.id_venta, v.fecha_venta, v.cliente, "
                 + "d.producto, d.cantidad, d.precio_unitario, d.subtotal, d.total "
                 + "FROM venta v "
                 + "INNER JOIN detalle_venta d ON v.id_venta = d.id_venta "
                 + "ORDER BY v.id_venta";
    try(Connection conn = connFactory.getConnection();
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery()){
        while(rs.next()){
        VentaDetalleModel V = new VentaDetalleModel(
         rs.getInt("id_venta"),
         rs.getDate("fecha_venta"),
         rs.getString("cliente"),
         rs.getString("producto"),
         rs.getInt("cantidad"),
         rs.getDouble("precio_unitario"),
         rs.getDouble("subtotal"),
         rs.getDouble("total")
        );
        lista.add(V);
        }
    }catch(Exception e){
    e.printStackTrace();
    }
    return lista;
}
    
    
    
    
}