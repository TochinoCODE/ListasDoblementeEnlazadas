/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListasDoblesEnlazadas;

import java.util.Random;

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
            if (temp.getValor() == num){
                ingresarXIndice(contador);
                break;
            }
            temp = temp.obtenerSiguiente();
            contador++;
        }
        
    }
    
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
//        int contador = 0;
//        Nodo temp = cabeza;
//        while (contador < tamaño-1){
//            temp = temp.obtenerSiguiente();
//            contador++;
//        }
//        temp.enlaceSiguiente(null);
    tamaño--;
        System.out.println("Se elimino el ultimo elemento..");
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
    //**************************************************************************
    
    //Metodo pora mostrar la lista
    public void recorrido() {
        int contador = 0;
        if (estaVacia()) {
            System.out.println("La lista esta vacia");
        } else {
            Nodo temp = cabeza;
            while (contador < tamaño) {
                System.out.print("[" + temp.getValor() + "] -> ");
                temp = temp.obtenerSiguiente();
                contador++;
            }
        }
    }
    
    

}
