package tpintegrador_programacion2.entities;

//Mover logica de generar reporte al main con un bucle anidado

import java.util.ArrayList;
import java.util.List;
import tpintegrador_programacion2.enums.Rol;

public class Usuario extends Base{
    private String nombre;
    private String apellido;
    private String mail;
    private String celular;
    private String contraseña;
    private Rol rol;
    private List<Pedido> pedidos;

    public Usuario(String nombre,String apellido,String mail,Rol rol) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.rol = rol;
        this.pedidos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    
    public void agregarPedido(Pedido p){
        pedidos.add(p);
        
        p.setUsuario(this);
    }
    
    public String generarReporte() {
    StringBuilder sb = new StringBuilder();

    sb.append("====================================================\n");
    sb.append(String.format(
            "USUARIO: %s %s | Mail: %s | Rol: %s\n",
            nombre,
            apellido,
            mail,
            rol
    ));
    sb.append("====================================================\n");
    double acumulado = 0;

    for (Pedido p : pedidos) {
        sb.append(String.format("> Pedido #%d | Fecha: %s | Estado: %s | FormaPago: %s\n",p.getId(),p.getFecha(),p.getEstado(),p.getFormaPago()));

        for (DetallePedido d : p.getDetalles()) {
            sb.append(String.format("   - DetallePedido #%d: %s x %d => Subtotal: $%.2f\n",d.getId(),d.getProducto().getNombre(),d.getCantidad(),d.getSubtotal()));
        }
        sb.append(String.format("TOTAL DEL PEDIDO: $%.2f\n\n",p.getTotal()));
        acumulado += p.getTotal();
    }

    sb.append(String.format(
            "TOTAL ACUMULADO del usuario: $%.2f\n",
            acumulado
    ));

    sb.append("====================================================\n");

    return sb.toString();
}

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", apellido=" + apellido + ", mail=" + mail + ", celular=" + celular + ", contrase\u00f1a=" + contraseña + ", rol=" + rol + ", pedidos=" + pedidos + '}';
    }
    
    
}
