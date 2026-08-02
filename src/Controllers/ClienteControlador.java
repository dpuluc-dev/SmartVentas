package Controllers;

import Models.ClienteModel; 
import Dao.ClienteDao; 
import java.util.List;

public class ClienteControlador {
    
    ClienteDao dao = new ClienteDao(); 
    
    public boolean agregarCliente(String nombre, String email, String dpi, String telefono, String direccion, boolean estado){
        ClienteModel c = new ClienteModel(nombre, email, dpi, telefono, direccion, estado);
        boolean res = dao.agregar(c); 
        return res; 
    } 
    
  
    public boolean actualizarCliente(int id_cliente, String nombre, String email, String dpi, String telefono, String direccion, boolean estado){
        ClienteModel c = new ClienteModel(id_cliente, nombre, email, dpi, telefono, direccion, estado);
        boolean res = dao.actualizar(c);
        return res; 
    } 
    
   
    public boolean eliminarCliente(int id_cliente){
        ClienteModel c = new ClienteModel(); 
        c.setId_cliente(id_cliente);
        boolean res = dao.eliminar(id_cliente); 
        return res; 
    }
    
   
    public ClienteModel buscarCliente(int id_cliente){
        return dao.buscar(id_cliente);
    }
    
 
    public List<ClienteModel> obtenerTodos(){
        return dao.ObtenerTodos();
    }
}
