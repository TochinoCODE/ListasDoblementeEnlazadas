
package ListasDoblesEnlazadas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class AplicaListaDoblementeEnlazada {
    
     static Scanner entrada = new Scanner(System.in);
    static ListaDoblementeEnlazada listaDoble  = new ListaDoblementeEnlazada();
    
    public static void main(String[] args) throws FileNotFoundException , IOException, InputMismatchException{
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
            System.out.println("[5] Mostrar Lista de Izquierda a Derecha");
            System.out.println("[6] Mostrar Lista de Deracha a Izquierda");
            System.out.println("[7] Tamaño de la lista");
            subrayado();
            System.out.println("[8] Eliminar Primero");
            System.out.println("[9] Eliminar Ultimo");
            System.out.println("[10] Elimnar por Posición");
            System.out.println("[11] Elimnar por Elemento");
            subrayado();
            System.out.println("[12] Buscar por Elemento");
            System.out.println("[13] Buscar por Posición");
            subrayado();
            System.out.println("[14] Ordenar crecientemente");
            System.out.println("[15] Ordenar decrecientemente");
            subrayado();
            System.out.println("[16] Intercambiar dos elementos");
            subrayado();
            System.out.println("[17] Modificar elemento");
            subrayado();
            System.out.println("[0] Salir");
            subrayado();
            System.out.print("\nElige una opcion : ");
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
                    listaDoble.recorridoIaD();
                    System.out.println("");
                    break;
                    
                case 6:
                    System.out.println("");
                    System.out.println("Los Elementos son ...");
                    subrayado();
                    listaDoble.recorridoDaI();
                    System.out.println("");
                    break;
                    
                case 7:
                    subrayado();
                    listaDoble.tamañoLista();
                    subrayado();
                    break;
                    
                case 8:
                    subrayado();
                    listaDoble.eliminarInicio();
                    subrayado();
                    break;
                    
                case 9:
                    subrayado();
                    listaDoble.eliminarUltimo();
                    subrayado();
                    break;
                  
                case 10:
                    subrayado();
                    listaDoble.eliminarPos(pedirPos());
                    subrayado();
                    break;
                    
                case 11:
                    subrayado();
                    listaDoble.eliminarXElemento(pedirNum());
                    subrayado();
                    break;
                    
                case 12:
                    subrayado();
                    if(listaDoble.buscarElementoXValor(pedirNum()));
                    else System.out.println("Elemento no existente");
                    subrayado();
                    break;
                    
                case 13:
                    subrayado();
                    if(listaDoble.buscarElementoXPos(pedirPos()));
                    subrayado();
                    break;
                    
                case 14:
                    subrayado();
                    listaDoble.ondenarBurbujaCreciente();
                    subrayado();
                    break;
                    
                case 15:
                    subrayado();
                    listaDoble.ondenarBurbujaDecreciente();
                    subrayado();
                    break;
                    
                case 16:
                    subrayado();
                    listaDoble.intercambioElementos(pedirNum(),pedirNum());
                    subrayado();
                    break;
                    
                case 17:
                    subrayado();
                    listaDoble.modificarElemento(pedirNum(), pedirNum());
                    subrayado();
                    break;
                
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
        int pos = 0;
           do{
        System.out.print("Ingrese la posicion : ");
        pos = entrada.nextInt();
        if (pos < 0 || pos>listaDoble.getTamaño()-1){
            System.out.println("**No existe esa posicion**");
        }
        }while(pos < 0 || pos>listaDoble.getTamaño()-1); 
        return pos;
        
    }
    
    static int pedirNum(){
        int num;
        System.out.print("Ingrese la numero : ");
        num = entrada.nextInt();
        
        return num;
    }
}
