package modelo;

import java.util.ArrayList;

public class Usuario{

    //Perfil puede ser Administrador/Colaborador

    private String nombre,email,telefono,id,contrasena;


    public Usuario(String nombre, String email, String telefono, String id, String contrasena) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.id = id;
        this.contrasena = contrasena;
    }

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


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
