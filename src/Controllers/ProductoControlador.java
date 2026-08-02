
package Controllers;

import Models.ProductoModel; 
import Dao.ProductoDao; 
import java.util.Date;
import java.util.List;

public class ProductoControlador { 
    
    ProductoDao dao = new ProductoDao(); 
    
    public boolean agregarProducto(String nombre, String descripcion, double precio, int stock,
    double iva,String categoria,String marca, Date fecha_creacion, boolean activo, int id_proveedor){
    ProductoModel P = new ProductoModel(nombre, descripcion, precio, stock, iva, categoria, marca, fecha_creacion, activo, id_proveedor);
    boolean res = dao.agregar(P); 
    return res;
    } 
    
    public boolean actualizarProducto(int id_producto, String nombre, String descripcion, double precio, int stock,
    double iva,String categoria,String marca, Date fecha_creacion, boolean activo, int id_proveedor){
    ProductoModel P = new ProductoModel(id_producto,nombre, descripcion, precio, stock, iva, categoria, marca, fecha_creacion, activo, id_proveedor);
    boolean res = dao.actualizar(P);
    return res;
    }  
    
    public boolean eliminarProducto(int id_producto){
    ProductoModel P = new ProductoModel();
    P.setId_producto(id_producto);
    boolean res = dao.eliminar(id_producto); 
    return res;
    } 
     
    public boolean actualizar(ProductoModel P){
    return dao.actualizar(P);
    }
    
    public ProductoModel buscarPorNombre(String nombre) {
    return dao.buscarPorNombre(nombre);
}
    
    public List<ProductoModel>ObtenerTodos(){
    return dao.ObtenerTodos();
    }
    
}
