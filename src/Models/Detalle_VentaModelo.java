package Models;

public class Detalle_VentaModelo {

    private int id_detalle;
    private int id_venta;
    private String producto;
    private int cantidad;
    private double precio_unitario;
    private double subtotal;
    private double iva;
    private double total;

    public Detalle_VentaModelo() {
    }


    public Detalle_VentaModelo(int id_venta, String producto, int cantidad,
    double precio_unitario, double subtotal,double iva, double total) {
        this.id_venta = id_venta;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
    }

    
    public Detalle_VentaModelo(int id_detalle, int id_venta, String producto, int cantidad,
        double precio_unitario, double subtotal,double iva, double total) {
        this.id_detalle = id_detalle;
        this.id_venta = id_venta;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
    }

    
    
    
    
    public int getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(int id_detalle) {
        this.id_detalle = id_detalle;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String Producto) {
        this.producto = Producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

 
}