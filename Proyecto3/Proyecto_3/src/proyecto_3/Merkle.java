/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author braya
 */
public class Merkle {

    HashNode tophash;
    String dot;
    Object dataBlock[];
    int index = 0;

    public Merkle() {
        this.tophash = null;
        this.dataBlock = new Object[16];
        this.dot = "";
    }

    public void push(Object value) {
        int indice = 0;
        boolean insertado = false;
        while (insertado != true) {
            if (dataBlock[indice] == null) {
                dataBlock[indice] = value;
                insertado = true;
            } else {
                indice++;
            }

        }

    }

    public void add(int value) {
        push(new DataNode(value));
    }

    public void createTree(int exp) {
        tophash = new HashNode(0);
        _createTree(this.tophash, exp);
    }

    public void _createTree(HashNode tmp, int exp) {
        if (exp > 0) {
            tmp.left = new HashNode(0);
            tmp.right = new HashNode(0);
            _createTree(tmp.left, exp - 1);
            _createTree(tmp.right, exp - 1);
        }
    }
    public void crearHojasArbol(){
        //Crear Hijos
        int index;
        //Obtener datos
        int tamaño_datos = 0;
        // validamos el numero de datos ingresados
        for(int tam = 0; tam<dataBlock.length;tam++){
            if(dataBlock[tam] != null){
            tamaño_datos++;
            }
        
        }
        // este array almacena los tipos de arboles cuadrados que se pueden formar
        int[] ArrayArboles = {2,4,8,16,32,64};
        // mapeamos para ver que caso es
        int explorador = 0;
        while(ArrayArboles[explorador]<tamaño_datos){
            explorador++;
        }
        System.out.println("Este es el tamaño de datos: "+tamaño_datos+", Este es el tamñano del arbol: "+ArrayArboles[explorador]);
        //Creamos lista definitiva 
        
        Object[] ListaDefinitiva = new Object[ArrayArboles[explorador]];
        for(int def = 0;def<ListaDefinitiva.length;def++){
            if(dataBlock[def] != null){
            ListaDefinitiva[def] = dataBlock[def];
            }else{
            ListaDefinitiva[def] = def*-1;
            }
        }
        
        tophash = CrearRama(ListaDefinitiva);
        
        //tophash = CrearArbol(ramas);
        PreOrder(tophash);
           
        
    }
    
    public HashNode CrearRama(Object[] transaction){
        Object[] Almacen = new Object[(transaction.length/2)];
        index = 0;
    for(int recorrido = 0;recorrido<transaction.length;recorrido+=2){
        // creamos los dos nodos hoja
        HashNode izquierda = new HashNode(transaction[recorrido]);
        HashNode derecha = new HashNode(transaction[recorrido+1]);
        
        // creamos el padre
        HashNode Padre = new HashNode("|"+transaction[recorrido]+"-"+transaction[recorrido+1]+"|");
        
        // le indicamos sus hijos
        Padre.left = izquierda;
        Padre.right = derecha;
        
        // los almacenamos para no perderlos
        Almacen[index] = (HashNode)Padre;
        index++;
    } 
    HashNode root = new HashNode(0);
    if(Almacen.length == 1){
        root = (((HashNode)Almacen[0]));
    }
    else if(Almacen.length == 2){
    for(int ver = 0;ver<Almacen.length;ver+=2){
        HashNode medioiz = (HashNode)Almacen[ver];
        HashNode medioder = (HashNode)Almacen[ver+1];
        root = new HashNode(((HashNode)Almacen[ver]).hash+"$"+((HashNode)Almacen[ver+1]).hash);
        root.left =  medioiz;
        root.right = medioder;
    }
    }
    else if(Almacen.length == 4){
        Object[] AlmacenSecundario = new Object[(Almacen.length/2)];
        int control = 0;
        for(int ver = 0;ver<Almacen.length;ver+=2){
        HashNode Hijoizq = (HashNode)Almacen[ver];
        HashNode HijoDer = (HashNode)Almacen[ver+1];
        //HashNode Padre2 = 
        //AlmacenSecundario[control]=
        control++;
    }
    
    
    }else if(Almacen.length == 8){
    
    
    }
    
    
    return root;
    }
    
    public HashNode CrearArbol(Object[] ramas){
        HashNode raiz = new HashNode("raiz");
        int elementos = ramas.length;
        System.out.println("Este es el tamaño de ramas: " + elementos);
        for(int ver=0;ver<elementos;ver++){
            System.out.println(((HashNode)ramas[ver]).hash);
        }
        if (elementos == 2) {
            
            for(int ver=0;ver<elementos;ver+=2){
                HashNode izq = new HashNode((HashNode)ramas[ver]);
                HashNode der = new HashNode((HashNode)ramas[ver+1]);
                 
                 raiz = new HashNode("/"+((HashNode)ramas[ver]).hash+"-"+((HashNode)ramas[ver+1]).hash+"/");
                 
                 raiz.left = izq;
                 raiz.right = der;
                 
            
        }
            System.out.println("Se creo correctamente el arbol");
        }
        return raiz;
    }
    public void PreOrder(HashNode r){
        if (r != null) {
            System.out.println("recorrido: "+r.hash);
            PreOrder(r.left);
            PreOrder(r.right);
          
        }
    }

    
    
    
    
}
    

