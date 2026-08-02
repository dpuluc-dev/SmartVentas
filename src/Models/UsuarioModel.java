
package Models;

import java.util.Date;

public class UsuarioModel { 
    
    private int id_usuario;
    private String nombre; 
    private String usuario; 
    private String password;
    private String email;
    private String rol;
    private String departamento;
    private int estado;
    private Date fecha_creacion;
            
    public UsuarioModel(){}
    
    public UsuarioModel(int id_usuario, String nombre, String usuario, String password, String email, String rol, String departamento,
            int estado, Date fecha_creacion){
    this.id_usuario = id_usuario; 
    this.nombre = nombre;
    this.usuario = usuario; 
    this.password = password;
    this.email = email;
    this.rol = rol;
    this.departamento = departamento;
    this.estado = estado; 
    this.fecha_creacion = fecha_creacion;
    } 
    
    public UsuarioModel(String nombre, String usuario, String password, String email, String rol, String departamento,
            int estado, Date fecha_creacion){
    this.nombre = nombre;
    this.usuario = usuario;  
    this.password = password;
    this.email = email;
    this.rol = rol;
    this.departamento = departamento;
    this.estado = estado; 
    this.fecha_creacion = fecha_creacion;
    } 

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
    
}
