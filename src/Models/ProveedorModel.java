
package Models;


public class ProveedorModel { 
    
    private int id_proveedor; 
    private String nombre; 
    private String email; 
    private String telefono; 
    private String direccion; 
    private int estado;
    
    public ProveedorModel(){}; 
    
    public ProveedorModel(int id_proveedor, String nombre, String email, String telefono, String direccion, int estado) {
        this.id_proveedor = id_proveedor;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.estado = estado;
    } 
    
     public ProveedorModel(String nombre, String email, String telefono, String direccion, int estado) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.estado = estado;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
     
     
}
