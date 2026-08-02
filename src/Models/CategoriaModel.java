
package Models;


public class CategoriaModel { 
    
    private int id_categoria; 
    private String descripcion; 
    private boolean activo;
    
    public CategoriaModel(){}
    
    public CategoriaModel(int id_categoria, String descripcion, boolean activo){
    this.id_categoria = id_categoria; 
    this.descripcion = descripcion; 
    this.activo = activo;
    }
    
    public CategoriaModel(String descripcion, boolean activo){
    this.descripcion = descripcion; 
    this.activo = activo;
    } 

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
    
}
