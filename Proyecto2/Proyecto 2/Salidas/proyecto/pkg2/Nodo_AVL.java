/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg2;

/**
 *
 * @author braya
 */
public class Nodo_AVL {
    int dato;
    int factor;
    Nodo_AVL derecho;
    Nodo_AVL izquierdo;
    AB SBtree =  new AB();

    public Nodo_AVL(int dato, AB SBtree) {
        this.dato = dato;
        this.factor = 0;
        this.derecho = null;
        this.izquierdo = null;
        this.SBtree = SBtree ;
    }
    
}
