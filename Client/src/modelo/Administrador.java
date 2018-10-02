package modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Administrador extends Usuario {
    
    private ArrayList<GrupoClientes> grupos;
    private ArrayList<Servicio> servicios;
    private ArrayList<Colaborador> colaboradores;
    
    public Administrador() {
        super();
    }
    
    public void solicitarInformeCliente(){
        
    }
    
    public void solicitarInformeColaborador(){
        
    }
    
    public void solicitarTareasEnCursoColaboradores(){
        Iterator it = this.colaboradores.iterator();
        while(it.hasNext()){
            Colaborador c = (Colaborador) it.next();
            c.solicitarITareasEnCurso();
        }
    }
    
    
    
}
