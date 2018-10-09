package modelo;

public class Cliente {
    
    private String nombre,email,telefono,cuit,razonsocial,grupo;

    public String getNombre() {
        return nombre;
    }

    public Cliente() {
        super();
    }

    public Cliente(String nombre, String email, String telefono, String cuit, String razonsocial, String grupo) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.cuit = cuit;
        this.razonsocial = razonsocial;
        this.grupo = grupo;
    }
}
