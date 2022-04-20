/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_3;

/**
 *
 * @author braya
 */
public class Nodo_Lista_Simple {
    Object dato;
    Nodo_Lista_Simple siguiente;

    public Nodo_Lista_Simple(Object dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public Nodo_Lista_Simple getSiguiente() {
        return siguiente;
    }

    public void linkSiguiente(Nodo_Lista_Simple siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
