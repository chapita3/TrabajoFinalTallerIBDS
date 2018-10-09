package modelo;

public class CerradaState implements State {
    
    private Tarea tarea;

    public CerradaState(Tarea tarea) {
        this.tarea = tarea;
        if(!this.tarea.getServicio().getTipo().equals("Fijo"))
            this.tarea.setCostototal(this.tarea.getServicio().getCosto()*(this.tarea.getFechacierre().getMinutes() - this.tarea.getFechainicio().getMinutes()));
        else
            this.tarea.setCostototal(this.tarea.getServicio().getCosto());
    }

    @Override
    public void abrir() {
        //ERROR, YA ESTA CERRADA.
    }

    @Override
    public void pausado() {
        //ERROR, YA ESTA CERRADA.
    }

    @Override
    public void cerrar() {
        //ERROR, YA ESTA CERRADA.    
    }
}
