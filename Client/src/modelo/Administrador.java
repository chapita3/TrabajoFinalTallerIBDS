package modelo;

import java.util.ArrayList;
import java.util.Iterator;

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

    public void solicitarInformeCliente(){     
    }
    
    public void solicitarInformeColaborador(){
        
    }
    
    public void solicitarTareasEnCursoColaboradores(){
        Iterator it = this.bdd.getColaboradores().iterator();
        while(it.hasNext()){
            Colaborador c = (Colaborador) it.next();
            c.solicitarITareasEnCurso();
        }
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
