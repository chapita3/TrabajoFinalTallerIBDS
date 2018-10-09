package modelo;

public interface State {

    void abrir();
    void pausado();
    void cerrar();
    String devolverestado();
}
