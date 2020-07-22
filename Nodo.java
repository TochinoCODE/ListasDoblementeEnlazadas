/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListasDoblesEnlazadas;
/**
 *
 * @author USER
 */
public class Nodo {
    
    //Atributos de un nodo
    private int valor;
    private Nodo siguiente;
    private Nodo anterior;
    
    //constructor por defecto 
    public Nodo() {
        valor = 0;
        siguiente = null;
    }

    public Nodo(int valor) {
        this.valor = valor;
    }
    
    //GETER y SETER

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Nodo obtenerSiguiente() {
        return siguiente;
    }

    public void enlaceSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void enlaceAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
    
    
    
    
    
    
}
