package modelo;

public class Tarea {
    
    //Estado puede ser Abierta/Pausa/Cerrada
    //Fecha inicio y fecha cierre automaticos al abrir/cerrar la tarea
    
    private String colaborador,cliente,servicio,fechainicio,fechacierre,estado;
    private int costototal;
    
    public Tarea() {
        super();
    }
}
