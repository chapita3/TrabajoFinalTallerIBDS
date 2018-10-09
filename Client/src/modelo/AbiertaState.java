package modelo;

import java.util.Date;

public class AbiertaState implements State {
    
    private Tarea tarea;
    
    public AbiertaState(Tarea tarea) {
        this.tarea = tarea;
    }


    @Override
    public void abrir() {
        // ERROR, YA ESTA ABIERTA.
    }

    @Override
    public void pausado() {
        this.tarea.setEstado(new PausadaState(this.tarea));
    }

    @Override
    public void cerrar() {
        this.tarea.setFechacierre(new Date());
        this.tarea.setEstado(new CerradaState(this.tarea));
    }
}
