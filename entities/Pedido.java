package tpintegrador_programacion2.entities;

//Añadir contador de id estatico para los obj detallepedido

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import tpintegrador_programacion2.enums.Estado;
import tpintegrador_programacion2.enums.FormaPago;

public class Pedido extends Base implements Calculable{
    private LocalDate fecha;
    private Estado estado;
    private double total;
    private FormaPago formaPago;
    private List<DetallePedido> detalles;
    private Usuario usuario;

    public Pedido(Estado estado, FormaPago formaPago) {
        super();
        this.estado = estado;
        this.formaPago = formaPago;
        this.detalles = new ArrayList<>();
        this.fecha = LocalDate.now();
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public List<DetallePedido> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallePedido> detalles) {
        this.detalles = detalles;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    @Override
    public void calcularTotal(){
        total = 0;
        for (DetallePedido d : detalles) {
            total += d.getSubtotal();
        }
    }
    
    public void addDetallePedido(int cantidad, Producto p){
        DetallePedido detalle = new DetallePedido(cantidad, cantidad * p.getPrecio());
        
        detalle.setProducto(p);
        detalles.add(detalle);
        
        calcularTotal();
    }
    
    public DetallePedido findDetallePedidobyProducto(Producto p){
        DetallePedido detalleEncontrado = null;
        for (DetallePedido d : detalles) {
            if (d.getProducto().getId().equals(p.getId())) {
                detalleEncontrado = d;
            }
        }
        return detalleEncontrado;
    }
    
    public void deleteDetallePedidoByProducto(Producto p){
        DetallePedido detalle = findDetallePedidobyProducto(p);
        if (detalle != null) {
            detalles.remove(detalle);
            calcularTotal();
        }else
            System.out.println("El id del producto del que intenta eliminar el detalle no existe.");
        }

@Override
public String toString() {

    return String.format(
        "Pedido[id=%d, fecha=%s, estado=%s, formaPago=%s, total=%.2f]",
        getId(),
        fecha,
        estado,
        formaPago,
        total
    );
}
}
