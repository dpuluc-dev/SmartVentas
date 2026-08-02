
package Controllers;

import Models.PorcentajeModel;
import Dao.PorcentajeDao;
import java.util.List;

public class PorcentajeControlador { 
    
     PorcentajeDao dao = new PorcentajeDao(); 
    
    public boolean agregarPorcentaje(double iva, boolean activo){
    PorcentajeModel C = new PorcentajeModel(iva, activo);
    boolean res = dao.agregar(C);
    return res; 
    } 
    
    public boolean actualizarPorcentaje(int id_iva, double iva, boolean activo){
    PorcentajeModel C = new PorcentajeModel(id_iva, iva, activo);
    boolean res = dao.actualizar(C);
    return res; 
    } 
    
    public boolean eliminarPorcentaje(int id_iva){
    PorcentajeModel C = new PorcentajeModel(); 
    C.setId_iva(id_iva);
    boolean res = dao.eliminar(id_iva); 
    return res; 
    }
    
    public List<PorcentajeModel>ObtenerTodos(){
    return dao.ObtenerTodos();
    }
    
    
}
