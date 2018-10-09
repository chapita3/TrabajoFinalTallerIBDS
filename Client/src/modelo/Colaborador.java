package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Colaborador extends Usuario {
    
    //private ArrayList<Tarea> tareas;
    private HashMap<Cliente,Tarea> tareas;
    
    public Colaborador() {
        super();
    }

    public Colaborador(String nombre, String email, String telefono, String id, String contrasena) {
        super(nombre, email, telefono, id, contrasena);
    }

    public void crearTarea(Servicio servicio, Cliente cliente){
        Tarea tarea = new Tarea(servicio,cliente,this);
        this.tareas.put(cliente, tarea);
        
    }
    
    public void eliminarTarea(Tarea tarea){
        if(this.tareas.containsKey(tarea))
            this.tareas.remove(tarea);
    }
    
    public void cerrarTarea(Tarea tarea){
        if(this.tareas.containsKey(tarea))
            this.tareas.get(tarea).getEstado().cerrar();
    }
    
    public void pausarTarea(Tarea tarea){
        if(this.tareas.containsKey(tarea))
            this.tareas.get(tarea).getEstado().pausado();
    }
    
    public void reanudarTarea(Tarea tarea){
        if(this.tareas.containsKey(tarea))
            this.tareas.get(tarea).getEstado().abrir();                                  
    }
    
    public String solicitarITareasEnCurso(){
         String resp = null;
        if(!this.tareas.isEmpty()){
           
            Iterator it = this.tareas.entrySet().iterator();
            while(it.hasNext()) {
                Map.Entry map = (Map.Entry) it.next();
                Tarea aux = (Tarea) map.getValue();
                if(aux.getEstado().devolverestado().equalsIgnoreCase("abierta") || aux.getEstado().devolverestado().equalsIgnoreCase("pausada")){
                    Date fecha_actual = new Date();
                    resp = "Colaborador: " + this.getNombre()+" Cliente: "+ aux.getCliente().getNombre() +" Servicio: "+ aux.getServicio().getDescripcion() +
                           " Inicio: " + aux.getFechainicio() + " Estado : tarea " + aux.getEstado().devolverestado() + " Horas accumuladas : "+
                           (fecha_actual.getMinutes() - aux.getFechainicio().getMinutes());                                           
                }
            }  
        }
        else resp = "no hay tareas activas";
        return resp;
    }
    

}
