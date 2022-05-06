/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_3;

/**
 *
 * @author braya
 */
public class Nodo_Cliente {
 Object dato;
 Nodo_Cliente siguiente;

    public Nodo_Cliente(Object dato) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public Nodo_Cliente getSiguiente() {
        return siguiente;
    }

    public void linkSiguiente(Nodo_Cliente siguiente) {
        this.siguiente = siguiente;
    }
    
 
 
}
