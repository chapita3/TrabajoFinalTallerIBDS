package modelo;

public class Prueba {
    public Prueba() {
        super();
    }

    public static void main(String[] args) {
        
        BaseDeDatos bdd = new BaseDeDatos();
        
        Administrador admin = new Administrador("nombre", "email", "telefono", "id", "contrasena");
        admin.setBdd(bdd);
        
        //TAREAS ADMIN
        
        admin.crearColaborador("c1", "email", "telefono", "id", "contrasena");
        admin.crearColaborador("c2", "email", "telefono", "id", "contrasena");
        admin.crearColaborador("c3", "email", "telefono", "id", "contrasena");
        admin.crearColaborador("c4", "email", "telefono", "id", "contrasena");
        admin.crearColaborador("c5", "email", "telefono", "id", "contrasena");
        
        admin.crearCliente("cl1","email","telefono","cuit","razonsocial","grupo");
        admin.crearCliente("cl2","email","telefono","cuit","razonsocial","grupo");
        admin.crearCliente("cl3","email","telefono","cuit","razonsocial","grupo");
        
        admin.crearServicio("Barrer","Por hora",200);
        admin.crearServicio("Lavar","Por hora",500);
        admin.crearServicio("Cambiar piso","Fijo",1200);
        admin.crearServicio("Mudanza","Fijo",2000);
        
        
        //EL ADMINISTRADOR CREA SUS TAREAS CON DISITINTOS TIEMPOS EN EL MEDIO
        double i=0;
        
        admin.getBdd().getColaboradores().get(0).crearTarea(admin.getBdd().getServicios().get(0), admin.getBdd().getClientes().get(0));
        admin.getBdd().getColaboradores().get(1).crearTarea(admin.getBdd().getServicios().get(1), admin.getBdd().getClientes().get(1));
       
        admin.getBdd().getColaboradores().get(2).crearTarea(admin.getBdd().getServicios().get(2), admin.getBdd().getClientes().get(2));
 
        admin.getBdd().getColaboradores().get(3).crearTarea(admin.getBdd().getServicios().get(3), admin.getBdd().getClientes().get(0));
        admin.getBdd().getColaboradores().get(4).crearTarea(admin.getBdd().getServicios().get(1), admin.getBdd().getClientes().get(2));
        
       
        
        //EL ADMIN SOLICITA LAS TAREAS DE TODOS LOS COLABORADORES
        System.out.println("EL ADMIN SOLICITA LAS TAREAS DE TODOS LOS COLABORADORES \n" + admin.solicitarTareasEnCursoColaboradores());
        
        //CREO UNA SEGUNDA TAREA
        admin.getBdd().getColaboradores().get(1).crearTarea(admin.getBdd().getServicios().get(0), admin.getBdd().getClientes().get(2));
        
        //EL COLABORADOR SOLICITA SUS TAREAS EN CURSO
        System.out.println("" + admin.getBdd().getColaboradores().get(0).solicitarITareasEstadoIntervalo("abierta", 18, 21));
        
        //EL ADMIN SOLICITA EL INFORME DE UN CLIENTE EN UN DETERMINADO INTERVALO
        System.out.println("" + admin.solicitarInformeCliente(admin.getBdd().getClientes().get(0), 18, 21));

        //EL ADMIN SOLICITA EL INFORME DE UN COLABORADOR EN UN DETERMINADO INTERVALO
        System.out.println(" " + admin.solicitarInformeColaboradorIntervalo(admin.getBdd().getColaboradores().get(0),18, 21));
    
    }
}
