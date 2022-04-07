/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto1_EDD;

/**
 *
 * @author braya
 */
public class Nodo_Recepcion {
   Object elemento;
   Nodo_Recepcion siguiente;

    public Nodo_Recepcion(Object elemento) {
        this.elemento = elemento;
        this.siguiente = null;
    }
    public Object getElemento() {
        return elemento;
    }
    public Nodo_Recepcion getSiguiente() {
        return siguiente;
    }
    public void LinkSiguiente(Nodo_Recepcion siguiente) {
        this.siguiente = siguiente;
    }
   
   
}

