package modelo;

import java.util.ArrayList;

public class Usuario{

    //Perfil puede ser Administrador/Colaborador

    protected String nombre,email,telefono,id,contrasena;


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


}
