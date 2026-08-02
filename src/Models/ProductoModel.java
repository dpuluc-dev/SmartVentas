
package Models;

import java.util.Date; 

public class ProductoModel { 
    
    private int id_producto; 
    private String nombre; 
    private String descripcion; 
    private double precio; 
    private int stock; 
    private double iva;
    private String categoria; 
    private String marca; 
    private Date fecha_creacion; 
    private boolean activo; 
    private int id_proveedor;
    
    public ProductoModel(){}
    
    public ProductoModel(int id_producto, String nombre, String descripcion, double precio, int stock,
            double iva, String categoria, String marca, Date fecha_creacion, boolean activo, int id_proveedor){
    this.id_producto = id_producto; 
    this.nombre = nombre; 
    this.descripcion = descripcion; 
    this.precio = precio; 
    this.stock = stock; 
    this.iva = iva;
    this.categoria = categoria; 
    this.marca = marca; 
    this.fecha_creacion = fecha_creacion; 
    this.activo = activo; 
    this.id_proveedor = id_proveedor;
    }
     
    public ProductoModel(String nombre, String descripcion, double precio, int stock,
            double iva, String categoria,String marca, Date fecha_creacion, boolean activo, int id_proveedor){
    this.nombre = nombre; 
    this.descripcion = descripcion; 
    this.precio = precio; 
    this.stock = stock; 
    this.iva = iva;
    this.categoria = categoria; 
    this.marca = marca; 
    this.fecha_creacion = fecha_creacion; 
    this.activo = activo;
    this.id_proveedor = id_proveedor;
    } 
     
    public ProductoModel(int id_producto,String nombre, double precio, double iva){
    this.id_producto = id_producto; 
    this.nombre = nombre; 
    this.precio = precio; 
    this.iva = iva;
    }
    
    
    
    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }
    
    
    
    
    
    
    
    // Metodos de la clase
    public double calcularSubtotal(int cantidad) {
    return precio * cantidad;
    }

    public double calcularIva(int cantidad) {
    double subtotal = calcularSubtotal(cantidad);
    return subtotal * iva;
    }

    public double calcularTotal(int cantidad) {
    double subtotal = calcularSubtotal(cantidad);
    double iva = calcularIva(cantidad);
    return subtotal + iva;
    }  
    
    public void descontarStock(int cantidad){
    if (cantidad <= stock) {
        stock = stock - cantidad;
    } 
}

    
    

}
