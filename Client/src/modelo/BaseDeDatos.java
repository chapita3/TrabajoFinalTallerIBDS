package modelo;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.util.ArrayList;

public class BaseDeDatos {
    private ArrayList<GrupoClientes> grupos;
    private ArrayList<Servicio> servicios;
    private ArrayList<Cliente>clientes;
    private ArrayList<Colaborador> colaboradores;
    private Administrador admin;
    
    public final static String nombreArchivo = "BaseDeDatos.xml";
    public BaseDeDatos() {
        super();
    }

    public void setGrupos(ArrayList<GrupoClientes> grupos) {
        this.grupos = grupos;
    }

    public void setServicios(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void setColaboradores(ArrayList<Colaborador> colaboradores) {
        this.colaboradores = colaboradores;
    }

    public void setAdmin(Administrador admin) {
        this.admin = admin;
    }

    public BaseDeDatos(Administrador admin) {
        this.admin = admin;
        this.admin.setBdd(this);
    }


    public ArrayList<GrupoClientes> getGrupos() {
        return grupos;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Colaborador> getColaboradores() {
        return colaboradores;
    }

    public Administrador getAdmin() {
        return admin;
    }
    
    public void serializarBDD(){
        XMLEncoder encoder=null;
        try
        {
            encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(BaseDeDatos.nombreArchivo)));
           
            encoder.writeObject(this);
            encoder.close();
            System.out.print("se guardo la bdd\n");
            
        } catch (FileNotFoundException e)
        {
            System.out.print("no se guardo la bdd \n");
        }
    }
    public BaseDeDatos deserializarBDD(){
          BaseDeDatos resp=null;
           XMLDecoder decoder=null;
           try
           {
               decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(BaseDeDatos.nombreArchivo)));
               resp=(BaseDeDatos)decoder.readObject();
               decoder.close();
               System.out.println("Se deserializo");
           } catch (FileNotFoundException e)
               {
                   System.out.println("No se cargo");
             
               }
           return resp;
           }
}
