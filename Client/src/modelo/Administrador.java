package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;


/**
 * Esta clase es el administrador de la aplicacion. Se encarga de crear Servicios, Colaboradores, Clientes.<br>
 * */

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

    /**
     * Metodo por el cual el administrador solicita todas los servicios asignados a un cliente en particular.<br>
     * Requeriemiento 3.2.1 SRS. <br>
     * @param cliente Cliente del cual se pide los servicios asignados.<br>
     * @param x Inicio del intervalo temporal solicitado.<br>
     * @param y Fin del intervalo temporal solicitado.<br>
     * @return Retorna el informe general con todos los servicios relacionados con el cliente.<br>
     */
    public String solicitarInformeCliente(Cliente cliente, int x, int y){
            Iterator it = this.bdd.getColaboradores().iterator();
            String resp = "Tarea de Servicio | Total horas  | Importe \n";
            while(it.hasNext()){
                Colaborador c = (Colaborador) it.next();
                resp += c.solicitarITareasIntervaloCliente(cliente, x, y);
            }
            return resp;
    }   
   
/**
     *  Informe que se solicita a un colaborador para informar los servicios brindados en un periodo de tiempo.<br>
     * Requeriemiento 3.2.2 SRS.<br>
     * @param colaborador Colaborador al que se le pide el informe.<br>
     * @param x Inicio del intervalo temporal.<br>
     * @param y Fin del intervalo temporal solicitado.<br>
     * @return Devuelve el informe general solicitado al colaborador.<br>
     */

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
    /**
     * El administrador solicita un informe de las tareas del colaborador (o todos) que esten en estado: abierta o pausado.<br>
     *Requeriemiento 3.2.3 SRS.<br>
     * @return Retorna un string con el informe solicitado.<br>
     */
    public String solicitarTareasEnCursoColaboradores(){
        Iterator it = this.bdd.getColaboradores().iterator();
        String resp =" Colaborador   |   Cliente  | Servicio  | Inicio    | Estado    | Horas accumuladas | \n";
        while(it.hasNext()){
            Colaborador c = (Colaborador) it.next();
            resp += c.solicitarITareasEnCurso();
        }
        return resp;
    }

    /**
     * Metodo por el cual se crea un cliente y se lo agrega a la Base de Datos.<br>
     * <b>pre:</b> La base de datos se encuentra creada.<br>
     * <b>post:</b> Se agrega el Cliente a la BDD.<br>
     * @param nombre: nombre que se le asigna al cliente nuevo. <br>
     * @param email: email que se le asigna al cliente nuevo.<br>
     * @param telefono: telefono que se le asigna al cliente nuevo.<br>
     * @param cuit: cuit que se le asigna al cliente nuevo.<br>
     * @param razonsocial: razonsocial que se le asigna al cliente nuevo.<br>
     * @param grupo: grupo que se le asigna al cliente nuevo.<br>
     * 
     * */

    public void crearCliente(String nombre,String email,String telefono,String cuit,String razonsocial,String grupo)
    {
        this.bdd.getClientes().add(new Cliente(nombre,email,telefono,cuit,razonsocial,grupo));
    }
    
    /**
     * Metodo por el cual se crea un Servicio y se lo agrega a la Base de Datos.<br>
     * <b>pre:</b> La base de datos se encuentra creada.<br>
     * <b>post:</b> Se agrega el Servicio a la BDD.<br>
     * @param descripcion: descripcion que se le agrega al servicio. <br>
     * @param tipo: Tipo de servicio a realizar.<br>
     * @param costo: Costo de realizar el servicio.<br>
     * 
     * */
    
    public void crearServicio(String descripcion, String tipo,int costo) 
    {
        this.bdd.getServicios().add(new Servicio(descripcion,tipo,costo));
    }  
    
    /**
     * Metodo por el cual se crea un Colaborador y se lo agrega a la Base de Datos.<br>
     * <b>pre:</b> La base de datos se encuentra creada.<br>
     * <b>post:</b> Se agrega el Colaborador a la BDD.<br>
     * @param nombre: nombre que se le asigna al colaborador nuevo. <br>
     * @param email: email que se le asigna al colaborador nuevo.<br>
     * @param telefono: telefono que se le asigna al colaborador nuevo.<br>
     * @param id: id que se le asigna a la cuenta del colaborador nuevo.<br>
     * @param contrasena: contrasena que se le asigna a la cuenta del colaborador nuevo.<br>
     * 
     * */
    
    public void crearColaborador(String nombre,String email,String telefono,String id,String contrasena)
    {
        this.bdd.getColaboradores().add(new Colaborador(nombre,email,telefono,id,contrasena));
    }
    
    /**
     * Metodo por el cual se elimina un Cliente y se lo elimina de la Base de Datos.<br>
     * <b>pre:</b> La base de datos se encuentra creada.<br>
     * <b>post:</b> Se elimina el Cliente de la BDD.<br>
     * @param cliente: cliente que se remueve de la base de datos. <br>
     * 
     * */
    public void eliminarCliente(Cliente cliente)
    {
        if(cliente!=null)
        this.bdd.getClientes().remove(cliente);
    }
    /**
     * Metodo por el cual se elimina un Servicio y se lo elimina de la Base de Datos.<br>
     * <b>pre:</b> La base de datos se encuentra creada.<br>
     * <b>post:</b> Se elimina el Servicio de la BDD.<br>
     * @param Servicio: Servicio que se remueve de la base de datos. <br>
     * 
     * */
    public void eliminarServicio(Servicio servicio)
    {
        if(servicio!=null)
        this.bdd.getServicios().add(servicio);
    }
    
    /**
     * Metodo por el cual se elimina un Colaborador y se lo elimina de la Base de Datos.<br>
     * <b>pre:</b> La base de datos se encuentra creada.<br>
     * <b>post:</b> Se elimina el Colaborador de la BDD.<br>
     * @param Colaborador: Colaborador que se remueve de la base de datos. <br>
     * 
     * */
    
    public void eliminarColaborador(Colaborador colaborador)
    {
        if(colaborador!=null)
        this.bdd.getColaboradores().add(colaborador);
    }
}
