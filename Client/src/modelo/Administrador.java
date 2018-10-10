package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

public class Administrador extends Usuario {
    

    private BaseDeDatos bdd;

    
    public Administrador() {
        super();
    }


    public Administrador(String nombre, String email, String telefono, String id, String contrasena) {
        super(nombre, email, telefono, id, contrasena);
    }

    public void setBdd(BaseDeDatos bdd) {
        this.bdd = bdd;
    }

    public BaseDeDatos getBdd() {
        return bdd;
    }

    public String solicitarInformeCliente(Cliente cliente, int x, int y){
            Iterator it = this.bdd.getColaboradores().iterator();
            String resp = "Tarea de Servicio | Total horas  | Importe \n";
            while(it.hasNext()){
                Colaborador c = (Colaborador) it.next();
                resp += c.solicitarITareasIntervaloCliente(cliente, x, y);
            }
            return resp;
    }   
   
    
    public String solicitarInformeColaboradorIntervalo(Colaborador colaborador, int x, int y){
            Iterator it = this.bdd.getColaboradores().iterator();
            String resp = "Cliente  |  Tarea de servicio  | Total horas\n";
            while(it.hasNext()){
                Colaborador c = (Colaborador) it.next();
                if(c.getNombre().equals(colaborador.getNombre()))
                    resp += c.solicitarITareasIntervalo(x, y);
            }
            return resp;
    }
    
    public String solicitarTareasEnCursoColaboradores(){
        Iterator it = this.bdd.getColaboradores().iterator();
        String resp =" Colaborador   |   Cliente  | Servicio  | Inicio    | Estado    | Horas accumuladas | \n";
        while(it.hasNext()){
            Colaborador c = (Colaborador) it.next();
            resp += c.solicitarITareasEnCurso();
        }
        return resp;
    }
                
    public void crearCliente(String nombre,String email,String telefono,String cuit,String razonsocial,String grupo)
    {
        this.bdd.getClientes().add(new Cliente(nombre,email,telefono,cuit,razonsocial,grupo));
    }
    
    public void crearServicio(String descripcion, String tipo,int costo) 
    {
        this.bdd.getServicios().add(new Servicio(descripcion,tipo,costo));
    }  
    
    public void crearColaborador(String nombre,String email,String telefono,String id,String contrasena)
    {
        this.bdd.getColaboradores().add(new Colaborador(nombre,email,telefono,id,contrasena));
    }
    
    public void eliminarCliente(Cliente cliente)
    {
        if(cliente!=null)
        this.bdd.getClientes().remove(cliente);
    }
    public void eliminarServicio(Servicio servicio)
    {
        if(servicio!=null)
        this.bdd.getServicios().add(servicio);
    }
    public void eliminarColaborador(Colaborador colaborador)
    {
        if(colaborador!=null)
        this.bdd.getColaboradores().add(colaborador);
    }
}
