/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_3;

/**
 *
 * @author braya
 */
public class Nodo_Vertice {
    int posicion;
    Nodo_Vertice vertice;
    Lista_Simple lstSimple;

    public Nodo_Vertice(int posicion) {
        this.posicion = posicion;
        this.vertice = null;
        this.lstSimple = new Lista_Simple();
    }

    public int getDato() {
        return posicion;
    }
    public Nodo_Vertice getSiguiente() {
        return vertice;
    }

    public void linkSiguiente(Nodo_Vertice vertice) {
        this.vertice = vertice;
    }
    
}
