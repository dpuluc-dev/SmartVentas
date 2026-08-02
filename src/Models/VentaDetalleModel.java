package Models;

import java.util.Date;

public class VentaDetalleModel {

    private int id_venta;
    private Date fecha_venta;
    private String cliente;
    private String producto;
    private int cantidad;
    private double precio_unitario;
    private double subtotal;
    private double total;

    public VentaDetalleModel(int id_venta, Date fecha_venta, String cliente, String producto,
            int cantidad, double precio_unitario, double subtotal, double total) {
        this.id_venta = id_venta;
        this.fecha_venta = fecha_venta;
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
        this.subtotal = subtotal;
        this.total = total;
    }

    public int getId_venta() {
        return id_venta;
    }
    public Date getFecha_venta() {
        return fecha_venta;
    }
    public String getCliente() {
        return cliente;
    }
    public String getProducto() {
        return producto;
    }
    public int getCantidad() {
        return cantidad;
    }
    public double getPrecio_unitario() {
        return precio_unitario;
    }
    public double getSubtotal() {
        return subtotal;
    }
    public double getTotal() {
        return total;
    }
}