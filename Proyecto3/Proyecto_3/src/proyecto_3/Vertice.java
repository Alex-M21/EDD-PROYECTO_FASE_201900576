/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_3;

/**
 *
 * @author braya
 */
public class Vertice {
    Object nombre;
    int numeroVertice;
    Lista_Simple lista;

    public Vertice(Object nombre) {
        this.nombre = nombre;
        this.numeroVertice = -1;
        this.lista = new Lista_Simple();
    }
    // Nos devuelve verdadero si dos vertices se llaman igual 
    public boolean equals(Object d){
    Vertice dos = (Vertice)d;
    return nombre.equals(dos.nombre);
    }
    // Indica el numero que identifica el vertice
    public void asigVert(int n){
    numeroVertice = n;
    }
    // devuelve el nombre del vertice
    public String nomVertice(){
    return nombre.toString();
    }
    public String Tostring(){
    return nombre + "("+numeroVertice+")";
    }
    
}
