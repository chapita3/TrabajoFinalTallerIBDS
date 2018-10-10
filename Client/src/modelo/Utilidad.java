package modelo;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

public class Utilidad extends Observable{
    
    private BaseDeDatos bdd;
    private Colaborador colaboradorActual;
    private Administrador administradorActual;
    public final static String esAdministrador = "ADMIN";
    public final static String esColaborador = "COLABORADOR";
    private static Utilidad instance=null;
    
    private Utilidad(){
        BaseDeDatos auxBDD= new BaseDeDatos();
        auxBDD=auxBDD.deserializarBDD();
        if(auxBDD!=null)
            this.bdd=auxBDD;
        else
            this.bdd=new BaseDeDatos(new Administrador("Admin","admin@gmail.com","111","admin","123"));
    }
    
    
    public static Utilidad getUtilidad()
    {
        Utilidad res=null;
        if(Utilidad.instance==null)
        {
            Utilidad.instance=new Utilidad();
            res=Utilidad.instance;
        }
        else 
        {
            res=Utilidad.instance;
        }
        return res;
    }
    
    public String verificarUsuario(String id,String contrasena) throws UsuarioNoEncontradoException {
        boolean encontrado = false;
        String resp=null;
        if(!id.equals("")&& !contrasena.equals("")){
        if(this.bdd.getAdmin().getId().equalsIgnoreCase(id) && this.bdd.getAdmin().getContrasena().equals(contrasena)){
            this.administradorActual=(Administrador)this.bdd.getAdmin();
            encontrado=true;
            resp = Utilidad.esAdministrador;
        }
        else{
            Iterator it = this.bdd.getColaboradores().iterator();
            while(it.hasNext() && !encontrado){
                Colaborador u=(Colaborador) it.next();
                if(u.getId().equalsIgnoreCase(id) && u.getContrasena().equals(contrasena)){
                    encontrado=true;
                    this.colaboradorActual=(Colaborador) u;
                    resp = Utilidad.esColaborador;
                }
            }
            }
        }
        if(!encontrado){
            throw new UsuarioNoEncontradoException();
            }//Excepcion, no encontro el usuario.
        return resp;
    }

    public BaseDeDatos getBdd() {
        return bdd;
    }

    public Colaborador getColaboradorActual() {
        return colaboradorActual;
    }

    public Administrador getAdministradorActual() {
        return administradorActual;
    }

    public static Utilidad getInstance() {
        return instance;
    }


}
