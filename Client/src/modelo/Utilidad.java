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
    
    private ArrayList<Usuario> usuarios;
    private Colaborador colaboradorActual;
    private Administrador administradorActual;
    public final static String esAdministrador = "ADMIN";
    public final static String esColaborador = "COLABORADOR";
    public final static String nombreArchivo = "Usuarios.xml";
    
    public Utilidad() {
        super();
    }
    
    public String verificarUsuario(String id,String contrasena){
        boolean encontrado = false;
        String resp=null;
        if(this.usuarios.get(0).getId().equalsIgnoreCase(id) && this.usuarios.get(0).getContrasena().equals(contrasena)){
            this.administradorActual=(Administrador)this.usuarios.get(0);
            encontrado=true;
            resp = Utilidad.esAdministrador;
        }                                           
        Iterator it = this.usuarios.iterator();
        while(it.hasNext() && !encontrado){
            Usuario u=(Usuario) it.next();
            if(u.getId().equalsIgnoreCase(id) && u.getContrasena().equals(contrasena)){
                encontrado=true;
                this.colaboradorActual=(Colaborador) u;
                resp = Utilidad.esColaborador;
            }
        }
        if(!encontrado){}//Excepcion, no encontro el usuario.
        return resp;
    }
    public void serializarUsuarios(){
        XMLEncoder encoder=null;
        try
        {
            encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(Utilidad.nombreArchivo)));
           
            encoder.writeObject(this.usuarios);
            encoder.close();
            System.out.print("se guardo la lista de usuarios\n");
            
        } catch (FileNotFoundException e)
        {
            System.out.print("no se guardo la lista de usuarios \n");
        }
    }
    public void deserializarUsuarios(){
           ArrayList<Usuario> resp=null;
           XMLDecoder decoder=null;
           try
           {
               decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(Utilidad.nombreArchivo)));
               resp=(ArrayList<Usuario>)decoder.readObject();
               decoder.close();
               System.out.println("Se deserializo");
           } catch (FileNotFoundException e)
               {
                   System.out.println("No se cargo");
             
               }
           if (resp != null)
               this.usuarios=resp;
       }

}