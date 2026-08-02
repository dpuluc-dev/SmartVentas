
package Controllers;

import Models.ProveedorModel;
import Dao.ProveedorDao; 
import java.util.List; 

public class ProveedorControlador { 
    
    ProveedorDao dao = new ProveedorDao();
    
    public boolean agregarProveedor(String nombre, String email, String telefono, String direccion, int estado){
    ProveedorModel P = new ProveedorModel(nombre, email, telefono, direccion, estado); 
    boolean res = dao.agregar(P); 
    return res; 
    } 
    
    public boolean actualizarProveedor(int id_proveedor, String nombre, String email, String telefono, String direccion, int estado){
    ProveedorModel P = new ProveedorModel(id_proveedor, nombre, email, telefono, direccion, estado); 
    boolean res = dao.actualizar(P);
    return res; 
    } 
    
    public boolean eliminarProveedor(int id_proveedor){
    ProveedorModel P = new ProveedorModel(); 
    P.setId_proveedor(id_proveedor);
    boolean res = dao.eliminar(id_proveedor);
    return res;
    }
     
    public ProveedorModel buscar (int id_proveedor){
    ProveedorModel P = dao.bucar(id_proveedor);
    return P;
    } 
    
    public List<ProveedorModel>ObtenerTodos(){
    return dao.ObtenerTodos();
    } 
    
    
}
