
package Models;


public class ClienteModel { 
    
    private int id_cliente;
    private String nombre;
    private String dpi;
    private String email;
    private String telefono;
    private String direccion;
    private boolean estado;

    public ClienteModel(){}
    
    public ClienteModel(int id_cliente, String nombre,  String email, String dpi, String telefono, String direccion, boolean estado) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.email = email;
        this.dpi = dpi;
        this.telefono = telefono;
        this.direccion = direccion;
        this.estado = estado;
    } 
    
      public ClienteModel(String nombre,  String email, String dpi, String telefono, String direccion, boolean estado) {
        this.nombre = nombre;
        this.email = email;
        this.dpi = dpi;
        this.telefono = telefono;
        this.direccion = direccion;
        this.estado = estado;
    } 
      

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
      
    
    
    
}
