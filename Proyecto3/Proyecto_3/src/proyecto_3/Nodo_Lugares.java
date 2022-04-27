/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_3;

public class Nodo_Lugares {
    Object Dato;
    Nodo_Lugares siguiente;

    public Nodo_Lugares(Object Dato) {
        this.Dato = Dato;
        this.siguiente = null;
    }

    public Object getDato() {
        return Dato;
    }

 
    public Nodo_Lugares getSiguiente() {
        return siguiente;
    }

    public void linkSiguiente(Nodo_Lugares siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
    
}
