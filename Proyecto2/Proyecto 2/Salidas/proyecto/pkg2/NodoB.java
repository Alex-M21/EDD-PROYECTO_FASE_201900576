/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg2;

public class NodoB {
    //Valores
    int id;
    Object usuario;
    //Apuntadores
    NodoB siguiente;
    NodoB anterior;
    RamaB derecha;
    RamaB izquierda;
    public NodoB(int id,Object usuario) {
        this.id = id;
        this.usuario = usuario;
        this.anterior = null;
        this.siguiente = null;
        this.derecha = null;
        this.izquierda = null;
        
    }

}
