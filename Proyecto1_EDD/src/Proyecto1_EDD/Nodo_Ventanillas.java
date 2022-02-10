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
       Nodo_Ventanillas siguiente;
       Nodo_Ventanillas abajo;
       Nodo_Ventanillas anterior;

    public Nodo_Ventanillas(Object elemento) {
        this.elemento = elemento;
        this.siguiente = null;
        this.abajo = null;
    }

    public Object getElemento() {
        return elemento;
    }

    public Nodo_Ventanillas getSiguiente() {
        return siguiente;
    }
    public Nodo_Ventanillas getAbajo(){
    return abajo;
    }
    public Nodo_Ventanillas getAnterior(){
    return anterior;
    }
 
    public void LinkSiguiente(Nodo_Ventanillas siguiente) {
        this.siguiente = siguiente;
    }
    public void LinkAbajo(Nodo_Ventanillas abajo){
    this.abajo = abajo;
    }
    public void LinkAnterior(Nodo_Ventanillas anterior){
    this.anterior = anterior;
    }
    
}
