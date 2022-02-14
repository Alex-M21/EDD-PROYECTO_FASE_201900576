/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto1_EDD;

/**
 *
 * @author braya
 */
public class Nodo_Ventanillas{
       Object elemento;
       Nodo_Recepcion arriba;
       Nodo_Ventanillas siguiente;
       Nodo_Imagenes abajo;

    public Nodo_Ventanillas(Object elemento) {
        this.elemento = elemento;
        this.arriba = null;
        this.siguiente = null;
        this.abajo = null;
    }

    public Object getElemento() {
        return elemento;
    }

    public Nodo_Ventanillas getSiguiente() {
        return siguiente;
    }

    public void linkSiguiente(Nodo_Ventanillas siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo_Recepcion getArriba() {
        return arriba;
    }

    public void linkArriba(Nodo_Recepcion arriba) {
        this.arriba = arriba;
    }

    public Nodo_Imagenes getAbajo() {
        return abajo;
    }

    public void linkAbajo(Nodo_Imagenes abajo) {
        this.abajo = abajo;
    }

    
    
    

   
    
}
