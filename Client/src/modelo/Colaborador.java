package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Colaborador extends Usuario {
    
    //private ArrayList<Tarea> tareas;
    private HashMap<Cliente,Tarea> tareas = new HashMap<Cliente,Tarea>();
    
    public Colaborador() {
        super();
    }

    public Colaborador(String nombre, String email, String telefono, String id, String contrasena) {
        super(nombre, email, telefono, id, contrasena);
    }

    public void crearTarea(Servicio servicio, Cliente cliente){
        //ACA FALTA CORROBORAR QUE NO CREE TAREA SI EXISTE ALGUNA ACTIVA (EXEPCION)      
        Tarea tarea = new Tarea(servicio,cliente,this);
        this.tareas.put(cliente, tarea);
    }
    
    public void eliminarTarea(Tarea tarea){
        if(this.tareas.containsKey(tarea))
            this.tareas.remove(tarea);
    }
    
    public void cerrarTarea(Tarea tarea){
        if(this.tareas.containsKey(tarea.getCliente()))
            this.tareas.get(tarea.getCliente()).getEstado().cerrar();
    }
    
    public void pausarTarea(Tarea tarea){
        if(this.tareas.containsKey(tarea.getCliente()))
            this.tareas.get(tarea.getCliente()).getEstado().pausado();
    }
    
    public void reanudarTarea(Tarea tarea){
        if(this.tareas.containsKey(tarea.getCliente()))
            this.tareas.get(tarea.getCliente()).getEstado().abrir();                                  
    }
    
    public String solicitarITareasIntervalo(int x, int y){
         String resp = "";
         if(!this.tareas.isEmpty()){    
            Iterator it = this.tareas.entrySet().iterator();
            while(it.hasNext()) {
                Map.Entry map = (Map.Entry) it.next();
                Tarea aux = (Tarea) map.getValue();
                if((aux.getFechainicio().getHours()>= x) && (aux.getFechainicio().getHours() <= y)){
                    Date fecha_actual = new Date();
                    resp +=aux.getCliente().getNombre() +" "+ aux.getServicio().getDescripcion() + " " + (fecha_actual.getHours() - aux.getFechainicio().getHours()) + "\n";                                            
                }
            }  
        }
        return resp;
    }
    
    public String solicitarITareasIntervaloCliente(Cliente cliente, int x, int y){
         String resp = "";
         if(!this.tareas.isEmpty()){    
            Iterator it = this.tareas.entrySet().iterator();
            while(it.hasNext()) {
                Map.Entry map = (Map.Entry) it.next();
                Tarea aux = (Tarea) map.getValue();
                if(aux.getCliente().getNombre().equalsIgnoreCase(cliente.getNombre()) && (aux.getFechainicio().getHours()>= x) && (aux.getFechainicio().getHours() <= y)){
                    Date fecha_actual = new Date();
                    int costo = 0;
                    if(!aux.getServicio().getTipo().equals("Fijo"))
                        costo = (aux.getServicio().getCosto()*(fecha_actual.getHours() - aux.getFechainicio().getHours()));
                    else
                        costo = aux.getServicio().getCosto();
                    resp += aux.getServicio().getDescripcion() + " " + (fecha_actual.getHours() - aux.getFechainicio().getHours()) + " " + costo + "\n";                                            
                }
            }  
        }
        return resp;
    }
    
    public String solicitarITareasEstadoIntervalo(String estado, int x, int y){
         String resp = "Cliente  |  Tarea de Servicio  |  Inicio  |  Estado  |  Horas Acumuladas\n";
         if(!this.tareas.isEmpty()){    
            Iterator it = this.tareas.entrySet().iterator();
            while(it.hasNext()) {
                Map.Entry map = (Map.Entry) it.next();
                Tarea aux = (Tarea) map.getValue();
                if(aux.getEstado().devolverestado().equalsIgnoreCase(estado) && (aux.getFechainicio().getHours()>= x) && (aux.getFechainicio().getHours() <= y)){
                    Date fecha_actual = new Date();
                    resp += aux.getCliente().getNombre() +" "+ aux.getServicio().getDescripcion() +
                           " " + aux.getFechainicio() + " " + aux.getEstado().devolverestado() + " "+
                           (fecha_actual.getHours() - aux.getFechainicio().getHours()) + "\n";                                             
                }
                else if(estado.equalsIgnoreCase("todos")){
                    Date fecha_actual = new Date();
                    resp += aux.getCliente().getNombre() +" "+ aux.getServicio().getDescripcion() +
                           " " + aux.getFechainicio() + " " + aux.getEstado().devolverestado() + " "+
                           (fecha_actual.getHours() - aux.getFechainicio().getHours()) + "\n";
                    }
            }  
        }
        return resp;
    }
    
    public String solicitarITareasEnCurso(){
         String resp = "";
         if(!this.tareas.isEmpty()){
           
            Iterator it = this.tareas.entrySet().iterator();
            while(it.hasNext()) {
                Map.Entry map = (Map.Entry) it.next();
                Tarea aux = (Tarea) map.getValue();
                if(aux.getEstado().devolverestado().equalsIgnoreCase("abierta") || aux.getEstado().devolverestado().equalsIgnoreCase("pausada")){
                    Date fecha_actual = new Date();
                    resp += this.getNombre()+" "+ aux.getCliente().getNombre() +" "+ aux.getServicio().getDescripcion() +
                           " " + aux.getFechainicio() + " " + aux.getEstado().devolverestado() + " "+
                           (fecha_actual.getSeconds() - aux.getFechainicio().getSeconds()) + "\n";                                           
                }
            }  
        }
        return resp;
    }

    public void setTareas(HashMap<Cliente, Tarea> tareas) {
        this.tareas = tareas;
    }

    public HashMap<Cliente, Tarea> getTareas() {
        return tareas;
    }


}
