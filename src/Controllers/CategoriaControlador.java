
package Controllers;

import Models.CategoriaModel; 
import Dao.CategoriaDao; 
import java.util.List;

public class CategoriaControlador {
     
    CategoriaDao dao = new CategoriaDao(); 
    
    public boolean agregarCategoria(String descripcion, boolean activo){
    CategoriaModel C = new CategoriaModel(descripcion, activo);
    boolean res = dao.agregar(C); 
    return res; 
    } 
    
    public boolean actualizarCategoria(int id_categoria, String descripcion, boolean activo){
    CategoriaModel C = new CategoriaModel(id_categoria, descripcion, activo);
    boolean res = dao.actualizar(C);
    return res; 
    } 
    
    public boolean eliminarCategoria(int id_categoria){
    CategoriaModel C = new CategoriaModel(); 
    C.setId_categoria(id_categoria);
    boolean res = dao.eliminar(id_categoria); 
    return res; 
    }
    
    public List<CategoriaModel>ObtenerTodos(){
    return dao.ObtenerTodos();
    }
    
    
}
