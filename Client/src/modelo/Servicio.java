package modelo;

public class Servicio {
    
    //Tipo puede ser Fijo/por hora
    
    private String descripcion,tipo;
    private int costo;


    public Servicio(String descripcion, String tipo, int costo) {
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.costo = costo;
    }

    public Servicio() {
        super();
    }
}
