package Controllers;

import Dao.VentaDao;
import Models.VentaDetalleModel;
import Models.VentaModel;
import java.util.List;

public class VentaControlador {

    private final VentaDao ventaDao = new VentaDao();

    public int agregarVenta(VentaModel venta) {
        return ventaDao.agregar(venta);
    } 
    
       public List<VentaDetalleModel> obtenerVentasConDetalle(){
        return ventaDao.obtenerVentasConDetalle();
    }
    
}