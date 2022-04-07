    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg2;

public class Nodo_M {
  // Pinters
  Nodo_M siguiente;
  Nodo_M anterior; 
  Nodo_M abajo;
  Nodo_M arriba;
  //Data
  Object Dato;
  int posX;
  int posY;

    public Nodo_M(int posX, int posY,Object Dato) {
        this.Dato = Dato;
        this.posX = posX;
        this.posY = posY;
        this.siguiente = null;
        this.anterior = null;
        this.abajo = null;
        this.arriba = null;
       

    }
  
  

  
    
}
