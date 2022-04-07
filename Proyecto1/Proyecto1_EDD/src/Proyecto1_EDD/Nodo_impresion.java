/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto1_EDD;

/**
 *
 * @author braya
 */
public class Nodo_impresion {
    Object imagen;
    Nodo_impresion siguiente;

    public Nodo_impresion(Object imagen) {
        this.imagen = imagen;
        this.siguiente = siguiente;
    }

    public Object getImagen() {
        return imagen;
    }
    
    public Nodo_impresion getSiguiente() {
        return siguiente;
    }

    public void linkSiguiente(Nodo_impresion siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
    
}
