
package ListasDoblesEnlazadas;

import java.util.Scanner;


public class AplicaListaDoblementeEnlazada {
    
     static Scanner entrada = new Scanner(System.in);
    static ListaDoblementeEnlazada listaDoble  = new ListaDoblementeEnlazada();
    
    public static void main(String[] args) {
        menu();
    }
    
    
    static void menu(){
        byte opcion;
        do{
            System.out.println("\nOperaciones de la lista");
            subrayado();
            System.out.println("[1] Insertar Inicio");
            System.out.println("[2] Insertar Final");
            System.out.println("[3] Insertar Por Posición");
            System.out.println("[4] Insertar Por Elemento");
            subrayado();
            System.out.println("[5] Mostrar Lista");
            subrayado();
            System.out.println("[6] Eliminar primero");
            System.out.println("[7] Eliminar ultimo");
            System.out.println("[8] Elimnar por posición");
//            System.out.println("[6] Modificar primer elemento par");
//            System.out.println("[7] Modificar Elemento");
//            subrayado();
//            System.out.println("[8] Eliminar primero");
//            System.out.println("[9] Eliminar ultimo");
//           
//            subrayado();
//            System.out.println("[11] Buscar Elemento");
//            System.out.println("[12] Intercambio del elemento mayor con el último elemento");
//            System.out.println("[13] Intercambio del elemento menor con el primer elemento");
//            System.out.println("[14] Intercambio del primer elemento par con el primer elemento impar");
//            System.out.println("[15] Ordenar Lsita");
            subrayado();
            System.out.println("[0] Salir");
            
            System.out.print("Elige una opcion : ");
            opcion = entrada.nextByte();
            switch(opcion){
                case 1:
                    listaDoble.ingresarInicio();
                    System.out.println("\nSe inserto Elemento...");
                    break;
                
                case 2:
                    listaDoble.ingresarFinal();
                    System.out.println("\nSe inserto Elemento...");
                    break;
                    
                case 3:
                    listaDoble.ingresarXIndice(pedirPos());
                    System.out.println("\nSe inserto Elemento...");
                    break;    
                  
                case 4:
                    listaDoble.ingresarXElemento(pedirNum());
                    System.out.println("\nSe inserto Elemento...");
                    break; 
                    
                case 5:
                    System.out.println("");
                    System.out.println("Los Elementos son ...");
                    subrayado();
                    listaDoble.recorrido();
                    System.out.println("");
                    break;
                    
                case 6:
                    subrayado();
                    listaDoble.eliminarInicio();
                    subrayado();
                    break;
                    
                case 7:
                    subrayado();
                    listaDoble.eliminarUltimo();
                    subrayado();
                    break;
                  
                case 8:
                    subrayado();
                    listaDoble.eliminarPos(pedirPos());
                    subrayado();
                    break;    
//                case 5:
//                    System.out.println("Los Primos Son ");
//                    subrayado();
//                    listaCircular.contarPrimos();
//                    System.out.println("");
//                    subrayado();
//                    break;
//                   
//                case 6:
//                    subrayado();
//                    listaCircular.modificarPar(pedirNum());
//                    subrayado();
//                    break;
//                    
//                case 7:
//                    subrayado();
//                    System.out.println("Ingrees numero que quiere modificar");
//                    int num = entrada.nextInt();
//                    listaCircular.modificarElemento(num, pedirNum());
//                    subrayado();
//                    break;
//                
//                
//                    
//                
//                case 11:
//                    subrayado();
//                    if(listaCircular.buscarElemento(pedirNum()));
//                    else System.out.println("Elemento no encontrado");
//                    subrayado();
//                    break;
//                
//                case 12:
//                    subrayado();
//                    listaCircular.intercambioMayorConUltimo();
//                    subrayado();
//                    break;
//                    
//                case 13:
//                    subrayado();
//                    listaCircular.intercambioMenorConPrimer();
//                    subrayado();
//                    break;
//                    
//                case 14:
//                    subrayado();
//                    listaCircular.intercambioParConImpar();
//                    subrayado();
//                    break;    
//                    
//                case 15:
//                    subrayado();
//                    listaCircular.ondenarBurbuja();
//                    subrayado();
//                    break;
                    
                    
                case 0:
                    System.exit(0);
                    break;
                
                default:System.out.println("**Ingrese opcion valida**");
            }
        }while(opcion != 0);
    }
    
    static void subrayado(){
        System.out.println("------------------------------------");
    }
    
    static int pedirPos(){
        int pos;
        do{
        System.out.print("Ingrese la posicion : ");
        pos = entrada.nextInt();
        if (pos < 0 || pos>listaDoble.getTamaño()){
            System.out.println("**No existe elemento en esa posicion**");
        }
        }while(pos < 0 || pos>listaDoble.getTamaño());
        return pos;
    }
    
    static int pedirNum(){
        int num;
        System.out.print("Ingrese la numero : ");
        num = entrada.nextInt();
        
        return num;
    }
}
