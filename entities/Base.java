package tpintegrador_programacion2.entities;

import java.time.LocalDateTime;

public abstract class Base {
    private static Long generadorId = 1L;
    
    private Long id;
    private boolean eliminado;
    private LocalDateTime createdAt;

    public Base() {
        this.id = generadorId++;
        this.eliminado = false;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public abstract String toString();
    
}
