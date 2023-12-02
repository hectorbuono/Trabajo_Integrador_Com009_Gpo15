package org.Trabajo_Integrador;

public class App {

    public static void main(String[] args) {
        // Obtener la conexión
        conexionBD conexion_BD = new conexionBD();
       mostrarMenu();
    }
    //private void MenuPrincipal (){

//        Scanner scanner = new Scanner(System.in);
//        int opcion;
//
//        do{
//            mostrarMenu();
//            System.out.print("Seleccione una opción: ");
//            opcion = scanner.nextInt();
//
//            switch (opcion) {
//                case 1:
//                    // Opción para cargar incidentes por teclado
//                    cargarIncidentes();
//                    break;
//                case 2:
//                    // Opción para agregar clientes
//                    agregarCliente();
//                    break;
//                case 3:
//                    // Opción para agregar técnicos
//                    agregarTecnico();
//                    break;
//                case 0:
//                    System.out.println("Saliendo de la aplicación. ¡Hasta luego!");
//                    break;
//                default:
//                    System.out.println("Opción no válida. Intente de nuevo.");
//            }
//        } while(opcion !=0);

        private static void mostrarMenu(){
            System.out.println("----- Menú Principal -----");
            System.out.println("1. Cargar Incidentes por Teclado");
            System.out.println("2. Agregar Cliente");
            System.out.println("3. Agregar Técnico");
            System.out.println("0. Salir");
            System.out.println("--------------------------");
        }

    }


