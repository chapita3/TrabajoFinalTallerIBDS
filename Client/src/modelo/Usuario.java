package modelo;

import java.util.ArrayList;

public class Usuario{

    //Perfil puede ser Administrador/Colaborador

    protected String nombre,email,telefono;
    private final String id,contrasena;


    public Usuario() {
        super();
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getId() {
        return id;
    }

    public String getContrasena() {
        return contrasena;
    }

    public ArrayList<Tarea> getTareas() {
        return tareas;
    }
    private ArrayList<Tarea> tareas;

    public void crearTarea(){
        
    }
    public void eliminarTarea(){
        
    }
    public void cerrarTarea(){
        
    }
    public void modificarTarea(){
        
    }
}
