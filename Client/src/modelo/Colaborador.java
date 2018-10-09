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
        // TODO Implement this method
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
        // Sino tirar excepcion o error, no hay tareas.
        if(!this.tareas.isEmpty()){
            Iterator it = this.tareas.entrySet().iterator();
            while(it.hasNext()) {
                Map.Entry map = (Map.Entry) it.next();
            }
            //Recorrer cada elemento buscando tareas que esten en curso(Pausa o Abiertas)
            // Luego:
            // Tarea aux = this.tareas.get(tarea);
            // 
            // String resp = suma de todo lo siguiente:
            // aux.getCliente().getNombre();
            //  aux.getServicio().getDescripcion();
            //  aux.getFechainicio();
            //  Date fecha_actual = new Date();
            //  De alguna forma conseguir el estado actual;
            //  Hacer la cuenta entre fecha actual y la de inicio;
            // return resp;
        }
        return "0";
    }
    

}
