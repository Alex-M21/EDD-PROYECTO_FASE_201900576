/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
        this.dataBlock = new Object[100];
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
    
    public String getSHA(String input)
    {
        try {

            // Static getInstance method is called with hashing SHA
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // digest() method called
            // to calculate message digest of an input
            // and return array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            System.out.println("Exception thrown"
                    + " for incorrect algorithm: " + e);

            return null;
        }
    }

    public void add(int value){
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
        int[] ArrayArboles = {2,4,8,16,32,64,128};
        // mapeamos para ver que caso es
        int explorador = 0;
        while(ArrayArboles[explorador]<tamaño_datos){
            explorador++;
        }
        //System.out.println("Este es el tamaño de datos: "+tamaño_datos+", Este es el tamñano del arbol: "+ArrayArboles[explorador]);
        //Creamos lista definitiva 
        
        Object[] ListaDefinitiva = new Object[ArrayArboles[explorador]];
        for(int def = 0;def<ListaDefinitiva.length;def++){
            if(dataBlock[def] != null){
            ListaDefinitiva[def] = getSHA(dataBlock[def]+"");
            }else{
            ListaDefinitiva[def] = getSHA(def+"VACIO");
            }
        }
        
        tophash = CrearRama(ListaDefinitiva);
        
        //tophash = CrearArbol(ramas);
        //PreOrder(tophash);
           
        
    }
    
    public HashNode CrearRama(Object[] transaction){
        HashNode[] Almacen = new HashNode[(transaction.length/2)];
        index = 0;
    for(int recorrido = 0;recorrido<transaction.length;recorrido+=2){
        // creamos los dos nodos hoja
        HashNode izquierda = new HashNode(transaction[recorrido]);
        HashNode derecha = new HashNode(transaction[recorrido+1]);
        
        // creamos el padret
        String encriptado = getSHA(transaction[recorrido]+""+transaction[recorrido+1]);
        
        HashNode Padre = new HashNode(encriptado);
        
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
        String encriptado = getSHA(((HashNode)Almacen[ver]).hash+""+((HashNode)Almacen[ver+1]).hash);
        root = new HashNode(encriptado);
        root.left =  medioiz;
        root.right = medioder;
    }
    }
    else if(Almacen.length > 2){
        
            while (Almacen.length != 1) {
                HashNode[] AlmacenSecundario = new HashNode[(Almacen.length / 2)];
                int control = 0;
                for (int ver = 0; ver < Almacen.length; ver += 2) {
                    HashNode Hijo1izq = (HashNode) Almacen[ver];
                    HashNode Hijo1Der = (HashNode) Almacen[ver + 1];
                    String encriptado = getSHA(((HashNode) Almacen[ver]).hash +""+ ((HashNode) Almacen[ver + 1]).hash);
                    HashNode Padre2 = new HashNode(encriptado);
                    Padre2.left = Hijo1izq;
                    Padre2.right = Hijo1Der;
                    AlmacenSecundario[control] = Padre2;
                    control++;
                }
                Almacen = new HashNode[control];
                Almacen = AlmacenSecundario;
            }
            if(Almacen.length == 1){
            root =(HashNode)Almacen[0];
            
            }
            
            

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
    
    public String InOrderGraph(HashNode r){
    String text="";
    if(r != null){
   
     text += InOrderGraph(r.left)+"Nodo_"+r.hash+"[label=\"Hash: "+r.hash+"\"];\n"+InOrderGraph(r.right);
    }
    return text;
    }
    
   
     
    public String textoGraph(HashNode r){
    if(r.left  == null && r.right == null){
        String devuelve = "\n";
    return devuelve;
    
    }else{
          String text = "";
          if(r.left != null){
          text += "Nodo_"+r.hash+"->"+"Nodo_"+r.left.hash+";\n"+textoGraph(r.left);
          
          
          }
          if(r.right != null){
          text += "Nodo_"+r.hash+"->"+"Nodo_"+r.right.hash+";\n"+textoGraph(r.right);
          }
          return text;
    }
    }
    
     public String ArmarEstructura(String combo1,String combo2){
    String data = "";
    data += "digraph G { \n";

    data += combo1;
    data += combo2;
    data += "}";
    return data;
    }
    
    
    
    
    
    public void ConvertimosGraphviz(String entrada,String nombre){
    try {
      
      String GraficarRuta = "C:\\Program Files\\Graphviz\\bin\\dot.exe";
      
      String RutaEntrada = "C:\\Users\\braya\\OneDrive\\Escritorio\\Salidas\\Principal\\"+entrada+".txt";
      
      String RutaSalida = "C:\\Users\\braya\\OneDrive\\Escritorio\\Salidas\\Principal\\"+nombre+".jpg";
      
      String tParametro = "-Tjpg";
      String tOParam = "-o";
        
      String[] composicion = new String[5];
      composicion[0] = GraficarRuta;
      composicion[1] = tParametro;
      composicion[2] = RutaEntrada;
      composicion[3] = tOParam;
      composicion[4] = RutaSalida;
                  
      Runtime rt = Runtime.getRuntime();
      
      rt.exec( composicion );
      
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
    }
    
    }
    public void CrearEstructura(String Data,String fNombre){
    try {   
            String ruta = "C:\\Users\\braya\\OneDrive\\Escritorio\\Salidas\\Principal\\"+fNombre+".txt";
            String contenido = Data;
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
   
    

    
    
    
    
}
    

