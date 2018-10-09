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

public class Utilidad {
    
    private BaseDeDatos bdd;
    private Colaborador colaboradorActual;
    private Administrador administradorActual;
    public final static String esAdministrador = "ADMIN";
    public final static String esColaborador = "COLABORADOR";
    
    
    public Utilidad() {
        super();
    }
    
    public String verificarUsuario(String id,String contrasena){
        boolean encontrado = false;
        String resp=null;
        if(this.bdd.getAdmin().getId().equalsIgnoreCase(id) && this.bdd.getAdmin().getContrasena().equals(contrasena)){
            this.administradorActual=(Administrador)this.bdd.getAdmin();
            encontrado=true;
            resp = Utilidad.esAdministrador;
        }                                           
        Iterator it = this.bdd.getColaboradores().iterator();
        while(it.hasNext() && !encontrado){
            Colaborador u=(Colaborador) it.next();
            if(u.getId().equalsIgnoreCase(id) && u.getContrasena().equals(contrasena)){
                encontrado=true;
                this.colaboradorActual=(Colaborador) u;
                resp = Utilidad.esColaborador;
            }
        }
        if(!encontrado){}//Excepcion, no encontro el usuario.
        return resp;
    }


}