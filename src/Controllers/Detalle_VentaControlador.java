
package Controllers;


import Dao.Detalle_VentaDao;
import Models.Detalle_VentaModelo; 
import java.util.List;

public class Detalle_VentaControlador { 
    
    Detalle_VentaDao dao = new Detalle_VentaDao(); 
    
    // Registra
    public boolean agregarDetalle(int id_venta, String producto, int cantidad,
    double precio_unitario, double subtotal,double iva, double total){
    Detalle_VentaModelo D = new Detalle_VentaModelo(id_venta, producto, cantidad, precio_unitario,
    subtotal, iva, total);
    boolean res = dao.agregar(D);
    return res;
    }  
    
    // Actualiza
    public boolean actualizarDetalle(int id_detalle, int id_venta, String producto, int cantidad,
    double precio_unitario, double subtotal,double iva, double total){
    Detalle_VentaModelo D = new Detalle_VentaModelo(id_detalle, id_venta, producto, cantidad, precio_unitario,
    subtotal, iva, total);
    boolean res = dao.actualizar(D);
    return res;
    } 
    
    // Eliminar
    public boolean eliminarDetalle(int id_detalle){
    Detalle_VentaModelo D = new Detalle_VentaModelo();
    D.setId_detalle(id_detalle);
    boolean res = dao.eliminar(id_detalle); 
    return res;
    } 
    
    // Lista
    public List<Detalle_VentaModelo>ObtenerTodos(){
    return dao.ObtenerTodos();
    } 
    
    
    
}
