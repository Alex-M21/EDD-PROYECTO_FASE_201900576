/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_3;

/**
 *
 * @author braya
 */
public class Proyecto_3 {

    
    public static void main(String[] args) {
        //frmLogin login  = new frmLogin();
        //login.setTitle("Login");
        
        //login.show();
        
        ArbolB arbol = new ArbolB();
        arbol.insertar(25);
        arbol.insertar(19);
        arbol.insertar(31);
        arbol.insertar(54);
        arbol.insertar(63);
        arbol.insertar(94);
        arbol.insertar(11);
        arbol.insertar(12);
        arbol.insertar(100);
        arbol.insertar(200);
       
        
  
        
     
       
        arbol.InOrder(arbol.raiz);
       
        
        
        
        
    }
    
}
