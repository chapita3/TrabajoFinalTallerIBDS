package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Observable;
import java.util.Observer;

import modelo.UsuarioNoEncontradoException;
import modelo.Utilidad;

import vista.VentanaAdministrador;
import vista.VentanaColaborador;
import vista.VentanaIniciarSesion;

public class Controlador implements ActionListener,Observer{
    private VentanaAdministrador vAdmin;
    private VentanaColaborador vCol;
    private VentanaIniciarSesion vInicio=new VentanaIniciarSesion();
    private Observable observable;
    private String usuarioActivo;
    public Controlador() {
        super();
        this.agregarObservable(Utilidad.getUtilidad());
       
        this.vInicio.addActionListener(this);
    }
    
    public void agregarObservable(Observable o)
    {
        if (this.observable==null)
        {
            this.observable=o;
            o.addObserver(this);
            System.out.println("Se agrego a utilidad como observable");
        }
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getActionCommand().equals(VentanaIniciarSesion.INICIO)){
            try {
                this.usuarioActivo =Utilidad.getUtilidad().verificarUsuario(this.vInicio.darTextoUsuario(), this.vInicio.darTextoContra());
                this.arrancar(this.usuarioActivo);
            } catch (UsuarioNoEncontradoException e) {         
                this.vInicio.mensajeDeError("Falta Completar campos de Inicio de Sesion");
            }
        }
        else
            {
            if(actionEvent.getActionCommand().equals(VentanaAdministrador.CREAR))
            {
                
            }
            }
    }

    @Override
    public void update(Observable observable, Object object) {
        // TODO Implement this method

    }
    public void arrancar(String user)
    {
        if(user.equals(Utilidad.esAdministrador)){
            this.vAdmin= new VentanaAdministrador();
            this.vAdmin.addActionListener(this);
            if(Utilidad.getInstance().getBdd().getClientes()!=null)
                this.vAdmin.actualizarListaCliente(Utilidad.getInstance().getBdd().getClientes().iterator());

            if(Utilidad.getInstance().getBdd().getServicios()!=null)
                this.vAdmin.actualizarListaServicios(Utilidad.getInstance().getBdd().getServicios().iterator());

            if(Utilidad.getInstance().getBdd().getColaboradores()!=null)
                this.vAdmin.actualizarListaColaboradores(Utilidad.getInstance().getBdd().getColaboradores().iterator());
        }
        else
            if(user.equals(Utilidad.esColaborador)){
                 this.vCol=new VentanaColaborador();
                 this.vCol.addActionListener(this);
        }
        this.vInicio.cerrar();
    }
    
    public static void terminar()
    {
        Utilidad.getInstance().getBdd().serializarBDD();
        System.exit(0);
    }
}
