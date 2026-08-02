package Models;

import java.util.Date;

public class VentaModel {

    private int id_venta;
    private Date fecha_venta;
    private double subtotal;
    private double total_iva;
    private double total_final;
    private String estado;
    private String cliente;

    public VentaModel(){}

    public VentaModel(double subtotal, double total_iva, double total_final, String estado, String cliente){
        this.subtotal = subtotal;
        this.total_iva = total_iva;
        this.total_final = total_final;
        this.estado = estado;
        this.cliente = cliente;
    }

    public int getId_venta() {
        return id_venta;
    }
    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }
    public Date getFecha_venta() {
        return fecha_venta;
    }
    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }
    public double getSubtotal() {
        return subtotal;
    }
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    public double getTotal_iva() {
        return total_iva;
    }
    public void setTotal_iva(double total_iva) {
        this.total_iva = total_iva;
    }
    public double getTotal_final() {
        return total_final;
    }
    public void setTotal_final(double total_final) {
        this.total_final = total_final;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getCliente() {
        return cliente;
    }
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
}