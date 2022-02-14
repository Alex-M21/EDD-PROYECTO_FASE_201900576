/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto1_EDD;

/**
 *
 * @author braya
 */
public class Nodo_Imagenes {
     Object elemento;
     Object id;
     Nodo_Imagenes siguiente;

    public Nodo_Imagenes(Object elemento,Object id) {
        this.elemento = elemento;
        this.id = id;
        this.siguiente = null;
    }
    public Object getElemento() {
        return elemento;
    }
    public Nodo_Imagenes getSiguiente() {
        return siguiente;
    }
    public void linkSiguiente(Nodo_Imagenes siguiente) {
        this.siguiente = siguiente;
    }
}
