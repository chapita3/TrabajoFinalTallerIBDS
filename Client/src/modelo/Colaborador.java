package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/**
 * Clase que representa a los Colaboradores del sistema.<br>
 */
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
    /**
     *Metodo que crea una tarea con un servicio y cliente predeterminado.<br>
     * @param servicio: servicio para la nueva tarea.<br>
     * @param cliente: cliente para la nueva tarea.<br>
     * <b>pre:</b> El servicio y cliente existian con anterioridad.<br>
     * <b>pos:</b> Se crea una nueva tarea.<br>
     */
    public void crearTarea(Servicio servicio, Cliente cliente){
        Tarea tarea = new Tarea(servicio,cliente,this);
        this.tareas.put(cliente, tarea);
        
    }
    
    /**
     *Metodo que elimina una tarea con un servicio y cliente predeterminado.<br>
     * @param tarea: tarea a ser eliminada.<br>
     * <b>pre:</b> La tarea ya existia con anterioridad.<br>
     * <b>pos:</b> Se elimina la tarea del array en el colaborador.<br>
     */
    public void eliminarTarea(Tarea tarea){
        if(this.tareas.containsKey(tarea))
            this.tareas.remove(tarea);
    }
    /**
     *Metodo que cierra la tarea enviada como parametro.<br>
     * @param tarea: tarea a cerrar.<br>
     * <b>pre:</b> La tarea ya existia con anterioridad.<br>
     * <b>pos:</b> Se cambia el estado de la tarea a cerrado.<br>
     */
    public void cerrarTarea(Tarea tarea){
        if(this.tareas.containsKey(tarea))
            this.tareas.get(tarea).getEstado().cerrar();
    }
    

    /**
     *Metodo que pausa la tarea enviada como parametro.<br>
     * @param tarea: tarea a pausar.<br>
     * <b>pre:</b> La tarea ya existia con anterioridad.<br>
     * <b>pos:</b> Se cambia el estado de la tarea a pausado.<br>
     */
    
    public void pausarTarea(Tarea tarea){
        if(this.tareas.containsKey(tarea))
            this.tareas.get(tarea).getEstado().pausado();
    }
    
    /**
     *Metodo que reanuda la tarea enviada como parametro.<br>
     * @param tarea: tarea a reanudar.<br>
     * <b>pre:</b> La tarea ya existia con anterioridad.<br>
     * <b>pos:</b> Se cambia el estado de la tarea a abierta.<br>
     */
    
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


    public HashMap<Cliente, Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(HashMap<Cliente, Tarea> tareas) {
        this.tareas = tareas;
    }
}
