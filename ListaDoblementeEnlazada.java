/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListasDoblesEnlazadas;

import java.util.Random;
import jdk.nashorn.internal.ir.BreakNode;

/**
 *
 * @author USER
 */
public class ListaDoblementeEnlazada {

    private Nodo cabeza;
    private Nodo cola;
    private int tamaño;
    final Random r = new Random();

    public ListaDoblementeEnlazada() {
        cabeza = null;
        cola = null;
        tamaño = 0;
    }

    public int getTamaño() {
        return this.tamaño;
    }

    public int crearAleatorios() {
        int valor = (int) r.nextInt(91) + 10;
        return valor;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    //ingresar al inicio
    public void ingresarInicio() {
        Nodo nuevo = new Nodo(crearAleatorios());

        if (estaVacia()) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            nuevo.enlaceSiguiente(cabeza);
            cabeza.enlaceAnterior(nuevo);
            cabeza = nuevo;
        }
        tamaño++;
    }

    public void ingresarFinal() {
        Nodo nuevo = new Nodo(crearAleatorios());

        if (estaVacia()) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.enlaceSiguiente(nuevo);
            nuevo.enlaceAnterior(cola);
            cola = nuevo;
        }
        tamaño++;
    }
    
    public void ingresarXIndice(int pos){
        int contador = 0;
        Nodo nuevo = new Nodo(crearAleatorios());
        Nodo temp = cabeza;
        if (estaVacia()){
            System.out.println("La lista esta vacia se ingresara ala pasicion [0]");
            ingresarInicio();
        }
        else if(pos == 0) ingresarInicio();
        else if(pos == tamaño-1) ingresarFinal();
        else {
            while(contador < tamaño){
                if (contador == pos-1){
                    //enlazamos con la siguiente posicion
                     nuevo.enlaceSiguiente(temp.obtenerSiguiente());
                     temp.obtenerSiguiente().enlaceAnterior(nuevo);
                     
                    //Enlazamos con la anterior posicion
                     temp.enlaceSiguiente(nuevo);
                     nuevo.enlaceAnterior(temp);
                     break;
                }
                temp = temp.obtenerSiguiente();
                contador++;
                
            }
        }
        tamaño++;
    }
    
    public void ingresarXElemento(int num){
        int contador = 0;
        Nodo temp = cabeza;
        while(contador < tamaño){
            if(cabeza.getValor() == num){
                ingresarInicio();
                break;
            }else if (temp.getValor() == num){
                ingresarXIndice(contador);
                break;
            }
            temp = temp.obtenerSiguiente();
            contador++;
        }
    }
    //**************************************************************************
    
    //Metodo pora mostrar la lista**********************************************
    //Metodo para imprimier de izquierda a derecha
    public void recorridoIaD() {
        int contador = 0;
        if (estaVacia()) {
            System.out.println("La lista esta vacia");
        } else {
            Nodo temp = cabeza;
            while (contador < tamaño) {
                System.out.print("[" + temp.getValor() + "] <-> ");
                temp = temp.obtenerSiguiente();
                contador++;
            }
        }
    }
    
    //Metodo para imprimier de derecha a izquierda
    public void recorridoDaI() {
        Nodo temp = cola;
        int contador = 0;
        if (estaVacia()) {
            System.out.println("La lista esta vacia");
        } else {
            
            while (contador < tamaño) {
                System.out.print(" <-> [" + temp.getValor() + "]");
                temp = temp.getAnterior();
                contador++;
            }
        }
    }
    //**************************************************************************

    //Metodo para obtener el tamaño de la lista*********************************
    public void tamañoLista(){
        System.out.println("El tamaño de la lista es : "+getTamaño()+" elementos");
    }
    //**************************************************************************

    //Metodo para eliminar******************************************************
    public void eliminarInicio() {
        if (estaVacia()) {
            System.out.println("**Lista vacia**");
        } else {
            System.out.println("Se elimino el numero : " + cabeza.getValor());
            cabeza = cabeza.obtenerSiguiente();
            tamaño--;
        }

    }
    
    public void eliminarUltimo() {
        int contador = 0;
        Nodo temp = cabeza;
        if(estaVacia()) System.out.println("**Lista vacia **");
        else {
          while (contador < tamaño-1){
            temp = temp.obtenerSiguiente();
            contador++;
        }
        temp.enlaceSiguiente(null);
        tamaño--;
        System.out.println("Se elimino el ultimo elemento..");  
        }
        
    }
    
    public void eliminarPos(int pos) {
        int contador = 0;
        Nodo temp = cabeza;
        if (estaVacia()) {
            System.out.println("**Lista vacia**");
        }else if (pos == 0) eliminarInicio();
        
        else if (pos == tamaño-1) eliminarUltimo();
        
        else {
            while (contador < pos - 1) {
                temp = temp.obtenerSiguiente();
                contador++;
            }
            System.out.println("Se elimon el numero : " + temp.obtenerSiguiente().getValor());
            temp.enlaceSiguiente(temp.obtenerSiguiente().obtenerSiguiente());
            tamaño--;
        }
    }
    //se estan eliminando dos numeros
    public void eliminarXElemento(int numero){
        int contador = 0;
        Nodo temp = cabeza;
        if (estaVacia()) System.out.println("**Lisra vacia**");
        else {
            while(contador < tamaño){
            if(cabeza.getValor() == numero){
                eliminarInicio();
                break;
            }else if(cola.getValor() == numero) {
                eliminarUltimo();
                break;
            }else if(temp.getValor() == numero){
                System.out.println("Se elimino el numero : "+temp.getValor()+" exitosamente");
                temp.getAnterior().enlaceSiguiente(temp.obtenerSiguiente());
                temp.obtenerSiguiente().enlaceAnterior(temp.getAnterior());
                tamaño--;
                break;
            }
            temp = temp.obtenerSiguiente();
            contador++;
        }
        }
        
        
    }
    //**************************************************************************
    
    //Metodos de busqueda******************************************************* 
    //Buscar por indice
    public boolean buscarElementoXPos(int pos) {
        int contador = 0;
        Nodo temp = cabeza;
        if (estaVacia()) {
            System.out.println("**Lista vacia**");
        } else {
            while (contador < tamaño) {
                if (contador == pos) {
                    System.out.println("Buscando ....");
                    System.out.println("Resultados");
                    System.out.println("[" + temp.getValor() + "] Se encuntra en la posicion (" + contador + ")");
                    return true;
                }
                temp = temp.obtenerSiguiente();
                contador++;
            }
        }
        return false;
    }
    
    //Buscar por elemento
    public boolean buscarElementoXValor(int numero) {
        int contador = 0;
        Nodo temp = cabeza;
        if (estaVacia()) {
            System.out.println("**Lista vacia**");
        } else {
            while (contador < tamaño) {
                if (numero == temp.getValor()) {
                    System.out.println("Buscando ....");
                    System.out.println("Resultados");
                    System.out.println("[" + temp.getValor()+ "] Se encuntra en la posicion (" + contador + ")");
                    return true;
                }
                temp = temp.obtenerSiguiente();
                contador++;
            }
        }
        return false;
    }
    //**************************************************************************

    //Metodos de ordecacion*****************************************************
    //Metodo de ordenamiento burbuja - creciente
     public void ondenarBurbujaCreciente() {
        Nodo temp = cabeza;
        Nodo aux = new Nodo();
        if (estaVacia()) System.out.println("**Lista vacia**");
        else {
          for (int i = 0; i < (tamaño-1); i++) {
            for (int j = 0; j < (tamaño-1); j++) {
                if (temp.getValor()> temp.obtenerSiguiente().getValor()) {//si numeroActual es mayor al numeroSiguiente
                    //cambio
                    //guardamos en aux el dato del snumeroSigueine
                    aux.setValor(temp.obtenerSiguiente().getValor());

                    //a numeroSiguiente asignamos el valor del numeroActual
                    temp.obtenerSiguiente().setValor(temp.getValor());

                    //a numeroActual asignamos el valor del numeroSiguiente
                    temp.setValor(aux.getValor());
                }
                temp = temp.obtenerSiguiente();
            }
            temp = cabeza;
        }
        System.out.println("Se logro el ordenamiento...");  
        }
        
    }
     
     //Metodo de ordenamiento burbuja - decreciente
     public void ondenarBurbujaDecreciente() {
        Nodo temp = cabeza;
        Nodo aux = new Nodo();
        if (estaVacia()) System.out.println("**Lista vacia**");
        else {
          for (int i = 0; i < (tamaño-1); i++) {
            for (int j = 0; j < (tamaño-1); j++) {
                if (temp.getValor()< temp.obtenerSiguiente().getValor()) {//si numeroActual es mayor al numeroSiguiente
                    //cambio
                    //guardamos en aux el dato del snumeroSigueine
                    aux.setValor(temp.obtenerSiguiente().getValor());

                    //a numeroSiguiente asignamos el valor del numeroActual
                    temp.obtenerSiguiente().setValor(temp.getValor());

                    //a numeroActual asignamos el valor del numeroSiguiente
                    temp.setValor(aux.getValor());
                }
                temp = temp.obtenerSiguiente();
            }
            temp = cabeza;
        }
        System.out.println("Se logro el ordenamiento...");  
        }
    }
    //**************************************************************************
    
    //Metodos de intercambio****************************************************
    //Metodo de intercambiar dos elementos
    public void intercambioElementos(int num1 , int num2){
        int contador = 0;
        Nodo temp = cabeza;
        Nodo aux = new Nodo();
        int valor1 = 0 , valor2 = 0;
        if (estaVacia()) System.out.println("**Lista Vacia**");
        else {
          while(contador < tamaño){
            if (temp.getValor() == num1){ //capturamos el primer numero
                valor1 = temp.getValor(); //guardamos el valor del primer numero
                aux = temp; //guardamos en aux el Nodo del primer numero
                break;
            }
            temp = temp.obtenerSiguiente();
            contador++;
        }
        temp = cabeza;
        contador = 0; 
        
        while(contador < tamaño){
            if (temp.getValor() == num2){//capturamos el segundo numero
                valor2 = temp.getValor();//guardamos el valor del segundo numero
                break;
            }
            temp = temp.obtenerSiguiente();
            contador++;
        }
        
        temp.setValor(valor1);//al nodo del primer segudo numero le damos el valor del primer numero
        aux.setValor(valor2); //Al nodo del primer numero le damos el valor del segundo numero  
        }
        
        
    }
    //**************************************************************************
    
    //Metodo de modificacion de un elemento*************************************
    public void modificarElemento(int buscarNum , int nuevoNum){
        int contador = 0;
        Nodo temp = cabeza;
        if (estaVacia()) System.out.println("**Lista vacia**");
        else{
           while(contador < tamaño){
            if (temp.getValor() == buscarNum){
            temp.setValor(nuevoNum);
            System.out.println("Se cambio el numero "+ buscarNum +" por el numero "+ nuevoNum);
            break;
            }   
            temp = temp.obtenerSiguiente();
            contador++;
            } 
        }
    }
    //************************************************************************** 
    

}
