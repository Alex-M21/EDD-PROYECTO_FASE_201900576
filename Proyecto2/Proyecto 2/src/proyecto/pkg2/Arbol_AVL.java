/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Arbol_AVL {
    Nodo_AVL raiz;

    public Arbol_AVL() {
        this.raiz = null;
    }
    //Busqueda 
    
    public Nodo_AVL buscar(int digito, Nodo_AVL r){
    if (raiz == null){
    return null;
    
    }else if (r.dato == digito){
        return r;
    
    }else if(r.dato < digito){
    return buscar(digito,r.derecho);
    }else{
    return buscar(digito,r.izquierdo);
    }
    
    }
    
    // obtener factor de equilibrio 
    public int ObtenerFactor (Nodo_AVL cualquiera){
    if(cualquiera == null){
    
    return -1;
    }else{
    return cualquiera.factor;
    }
    
    }
    
    public Nodo_AVL rotacionIzquierda(Nodo_AVL a){
    Nodo_AVL aux = a.izquierdo;
    a.izquierdo = aux.derecho;
    aux.derecho = a;
    a.factor = Math.max(ObtenerFactor(a.izquierdo),ObtenerFactor(a.derecho))+1;
    aux.factor = Math.max(ObtenerFactor(aux.izquierdo),ObtenerFactor(aux.derecho))+1;
    return aux;
    }
    
    public Nodo_AVL rotacionDerecha(Nodo_AVL b){
    Nodo_AVL aux = b.derecho; 
    b.derecho = aux.izquierdo;
    aux.izquierdo  = b;
    b.factor = Math.max(ObtenerFactor(b.izquierdo),ObtenerFactor(b.derecho))+1;
    aux.factor = Math.max(ObtenerFactor(aux.izquierdo),ObtenerFactor(aux.derecho))+1;
    return aux;
    }
    
    // Rotacion Doble 
    
    public Nodo_AVL rotacionDobleIzquierda(Nodo_AVL doblea){
    Nodo_AVL temp ;
    doblea.izquierdo = rotacionDerecha(doblea.izquierdo);
    temp = rotacionIzquierda(doblea);
    return temp;
    }
    
    // Rotacion Doble Izquierda
    
    public Nodo_AVL rotacionDobleDerecha(Nodo_AVL dobleb){
    Nodo_AVL temp;
    dobleb.derecho = rotacionIzquierda(dobleb.derecho);
    temp = rotacionDerecha(dobleb);
    return temp;
    }
    
    // Incercion AVL
    
    public Nodo_AVL insertAVL(Nodo_AVL nuevo, Nodo_AVL subAr) {
        Nodo_AVL nuevoPadre = subAr;

        if (nuevo.dato < subAr.dato) {
            if (subAr.izquierdo == null) {
                subAr.izquierdo = nuevo;    
            } else {
                subAr.izquierdo = insertAVL(nuevo,subAr.izquierdo);
                if ((ObtenerFactor(subAr.izquierdo) - ObtenerFactor(subAr.derecho)) == 2) {
                    if (nuevo.dato < subAr.izquierdo.dato) {
                        nuevoPadre = rotacionIzquierda(subAr);
                    } else {
                        nuevoPadre = rotacionDobleIzquierda(subAr);
                    }
                }

            }
        } else if (nuevo.dato > subAr.dato) {
            if (subAr.derecho == null) {
                subAr.derecho = nuevo;
            } else {
                subAr.derecho = insertAVL(nuevo, subAr.derecho);
                if ((ObtenerFactor(subAr.derecho) - ObtenerFactor(subAr.izquierdo)) == 2) {
                    if (nuevo.dato > subAr.derecho.dato) {  
                        nuevoPadre = rotacionDerecha(subAr);
                    } else {
                        nuevoPadre = rotacionDobleDerecha(subAr);
                    }
                }

            }
         } else {
            System.out.println("Nodo Duplicado");
        }
        //Actualizar la altura
        if ((subAr.izquierdo == null) && (subAr.derecho != null)) {
            subAr.factor = subAr.derecho.factor + 1;
        } else if ((subAr.derecho == null) && (subAr.izquierdo != null)) {
            subAr.factor = subAr.izquierdo.factor + 1;
        } else {
            subAr.factor = Math.max(ObtenerFactor(subAr.izquierdo), ObtenerFactor(subAr.derecho)) + 1;
        }
        return nuevoPadre;
    }
    
    public void add(int digito,AB Stree){
    Nodo_AVL nuevo  = new Nodo_AVL(digito,Stree);
    if(raiz == null){
    raiz = nuevo;
    }else{
        raiz = insertAVL(nuevo,raiz);
    }
    // Recorridos 
    
    }
    public void InOrder(Nodo_AVL r) {
        if (r != null) {
            InOrder(r.izquierdo);
            System.out.println(r.dato);
            InOrder(r.derecho);
        }
    }

    public void PreOrder(Nodo_AVL r) {
        if (r != null) {
            System.out.println(r.dato);
            PreOrder(r.izquierdo);
            PreOrder(r.derecho);
        }
    }

    public void PostOrder(Nodo_AVL r) {
        if (r != null) {
            PostOrder(r.izquierdo);
            PostOrder(r.derecho);
            System.out.println(r.dato);
        }
    }
     public String InOrderGraph(Nodo_AVL r){
    String text="";
    if(r != null){
   
     text += InOrderGraph(r.izquierdo)+"Nodo_"+r.dato+"[label=\""+r.dato+"\"];\n"+InOrderGraph(r.derecho);
    }
    return text;
    }
    public String textoGraph(Nodo_AVL r){
    if(r.izquierdo  == null && r.derecho == null){
        String devuelve = "\n";
    return devuelve;
    
    }else{
          String text = "";
          if(r.izquierdo != null){
          text += "Nodo_"+r.dato+"->"+"Nodo_"+r.izquierdo.dato+";\n"+textoGraph(r.izquierdo);
          
          
          }
          if(r.derecho != null){
          text += "Nodo_"+r.dato+"->"+"Nodo_"+r.derecho.dato+";\n"+textoGraph(r.derecho);
          }
          return text;
    }
    }
    
     public String ArmarEstructura(String combo1,String combo2){
    String data = "";
    data += "digraph G { \n";
    data += "by [label=\"201900576\" color=red];\n";
    data += combo1;
    data += combo2;
    data += "}";
    return data;
    }
     
     public void ConvertimosGraphviz(String entrada,String nombre){
    try {
      
      String GraficarRuta = "C:\\Program Files\\Graphviz\\bin\\dot.exe";
      
      String RutaEntrada = "C:\\Users\\braya\\OneDrive\\Escritorio\\Salidas\\GraphAVL\\"+entrada+".txt";
      
      String RutaSalida = "C:\\Users\\braya\\OneDrive\\Escritorio\\Salidas\\GraphAVL\\"+nombre+".jpg";
      
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
            String ruta = "C:\\Users\\braya\\OneDrive\\Escritorio\\Salidas\\GraphAVL\\"+fNombre+".txt";
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
    public void GenerarImagenes(Nodo_AVL r){
    if (r != null) {
            System.out.println(r.dato);
            AB Arbolbb = r.SBtree;
            System.out.println("Recorrido de un nodo  AVL Nodo:"+r.dato);
           
            System.out.println("//////////////////////////////////////");
            String data = Arbolbb.InOrder(Arbolbb.raiz);
            data = data.substring(0, data.length()-1);
            String[] code = data.split(",");      
            System.out.println("este es el order"+data);
      
            MD recuperado = new MD();
            for (int z  = 0; z<code.length;z++){
            int index = Integer.parseInt(code[z].toString());
            System.out.println("este es el index"+index);
            Nodo__AB combinado = Arbolbb.BuscarNodoW(index,Arbolbb.raiz);
            MD salida = combinado.MatrizCapa.CreateSuperM(recuperado);
            salida.imprimir();
            recuperado = salida;
            System.out.println("este es id de la matriz"+combinado.dato+"este es la matriz"+combinado.MatrizCapa);
            }
            String part1 = recuperado.GraphInit();
            String part2 = recuperado.GraphColumna();
            String part3 = recuperado.GraphFilas();
            System.out.println("//////////////////////////////////////");
            
            
            
            String todo = recuperado.CreateDot(part1,part2 ,part3);
            //System.out.println(todo);
            recuperado.CrearEstructuraImg(todo,"Imagenes"+r.dato);
            recuperado.ConvertimosGraphvizImg("Imagenes"+r.dato,"Imagenes"+r.dato);
            
            
            GenerarImagenes(r.izquierdo);
            GenerarImagenes(r.derecho);
            }
            
        }
    
}

