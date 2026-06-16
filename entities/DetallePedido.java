package tpintegrador_programacion2.entities;

//CORREGIR: implementar validacion de producto != null en calcularsubtotal
//que los setter de cantidad y producto disparen calcularsubtotal

public class DetallePedido extends Base{
    private int cantidad;
    private double subtotal;
    private Producto producto;

    public DetallePedido(int cantidad, double subtotal) {
        super();
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    private double calcularSubtotal(){
        subtotal = cantidad * producto.getPrecio();
        return subtotal;
    }

    @Override
    public String toString() {
        return "DetallePedido{" + "cantidad=" + cantidad + ", subtotal=" + subtotal + ", producto=" + producto + '}';
    }
    
    
}
