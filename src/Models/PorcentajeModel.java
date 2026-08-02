
package Models;


public class PorcentajeModel {

private int id_iva; 
private double iva; 
private boolean activo; 

public PorcentajeModel(){}

public PorcentajeModel(int id_iva, double iva, boolean activo){
this.id_iva = id_iva; 
this.iva = iva; 
this.activo = activo;
}
    
public PorcentajeModel(double iva, boolean activo){
this.iva = iva; 
this.activo = activo;
} 

    public int getId_iva() {
        return id_iva;
    }

    public void setId_iva(int id_iva) {
        this.id_iva = id_iva;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }


}
