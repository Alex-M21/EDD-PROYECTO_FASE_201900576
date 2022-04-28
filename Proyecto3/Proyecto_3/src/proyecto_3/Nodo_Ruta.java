/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_3;

/**
 *
 * @author braya
 */
public class Nodo_Ruta {
    Object dato;
    Nodo_Ruta siguiente;

    public Nodo_Ruta(Object dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Object getDato() {
        return dato;
    }

    public Nodo_Ruta getSiguiente() {
        return siguiente;
    }

    public void linkSiguiente(Nodo_Ruta siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
    
    
}
