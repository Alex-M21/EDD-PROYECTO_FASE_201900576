/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto1_EDD;

/**
 *
 * @author braya
 */
public class Nodo_Espera {
    Object element;
    
    Nodo_Espera siguiente;
    Nodo_Espera anterior;
    Nodo_Imagenes abajo;
    

   

    public Nodo_Espera(Object element, Nodo_Espera siguiente,Nodo_Espera anterior) {
        this.element = element;
        this.anterior = null;
        this.siguiente = null;
        this.abajo = null;
    }

    public Object getElement() {
        return element;
    }

    public Nodo_Espera getSiguiente() {
        return siguiente;
    }

    public Nodo_Espera getAnterior() {
        return anterior;
    }
    public Nodo_Imagenes getAbajo(){
    return abajo;
    
    }

    public void linkSiguiente(Nodo_Espera siguiente) {
        this.siguiente = siguiente;
    }

    public void linkAnterior(Nodo_Espera anterior) {
        this.anterior = anterior;
    }
     public void linkAbajo(Nodo_Imagenes abajo) {
        this.abajo = abajo;
    }
    
    
}
