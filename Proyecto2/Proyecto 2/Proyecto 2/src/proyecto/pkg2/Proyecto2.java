/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto.pkg2;

import java.io.IOException;

/**
 *
 * @author braya
 */
public class Proyecto2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       frmUsuario vent2 = new frmUsuario();
       vent2.show();
         

        
        
        /*int opcion = 0;
        int elemeto;
        String nombre;
        AB arbol = new AB();
        
        
        arbol.agregarNodo(20,"a1");
        arbol.agregarNodo(10,"b2");
        arbol.agregarNodo(52,"c3");
        arbol.agregarNodo(30,"d4");
        arbol.agregarNodo(20,"d5");
        arbol.agregarNodo(50,"e6");
        arbol.agregarNodo(60,"f7");
        arbol.agregarNodo(5,"g8");
        arbol.agregarNodo(15,"h8");
        arbol.agregarNodo(25,"i8");
        
        
     
        
        System.out.println("In-Order");
        arbol.InOrder(arbol.raiz);
        
        System.out.println("Pre-Order");
        arbol.PreOrder(arbol.raiz);
        
        System.out.println("Post-Order");
        arbol.PostOrder(arbol.raiz);
        
        String combo2 = arbol.textoGraph(arbol.raiz);
        String combo1 = arbol.InOrderGraph(arbol.raiz);
        System.out.print(combo1);
        String estruct = arbol.ArmarEstructura(combo1,combo2);
        arbol.CrearEstructura(estruct,"Grafo1");
        arbol.ConvertimosGraphviz("Grafo1","Grafo1");
        
        System.out.println("Aqui ingresamos el avl");
        //75,40,23,8,6,37,32,45,25,1,88,29,4,11,39,14,66,24,12,7
        Arbol_AVL arbol_avl = new Arbol_AVL();
        
        arbol_avl.add(75);
        arbol_avl.add(40);
        arbol_avl.add(23);
        arbol_avl.add(8);
        arbol_avl.add(6);
        arbol_avl.add(37);
        arbol_avl.add(32);
        arbol_avl.add(45);
        arbol_avl.add(25);
        arbol_avl.add(1);
        arbol_avl.add(88);
        arbol_avl.add(29);
        arbol_avl.add(4);
        arbol_avl.add(11);
        arbol_avl.add(39);
        arbol_avl.add(14);
        arbol_avl.add(66);
        arbol_avl.add(24);
        arbol_avl.add(12);
        arbol_avl.add(7);
     
        arbol_avl.InOrder(arbol_avl.raiz);
 
        String combo4 = arbol_avl.textoGraph(arbol_avl.raiz);
        String combo3 = arbol_avl.InOrderGraph(arbol_avl.raiz);
        System.out.print(combo3);
        String estruct2 = arbol_avl.ArmarEstructura(combo3,combo4);
        arbol_avl.CrearEstructura(estruct2,"Grafo2");
        arbol_avl.ConvertimosGraphviz("Grafo2","Grafo2");
        
        //arbol_avl.InOrder(arbol_avl.raiz);
        */
        ArbolB ab = new ArbolB();
        ab.insertar(75);
        ab.insertar(40);
        ab.insertar(23);
        ab.insertar(8);
        ab.insertar(6);
        ab.insertar(37);
        ab.insertar(32);
        ab.insertar(45);
        ab.insertar(25); 
        
        //ab.print();
        
        

  
    }
    
}
