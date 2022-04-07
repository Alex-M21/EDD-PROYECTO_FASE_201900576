
package proyecto.pkg2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class AB {
    Nodo__AB raiz;
    public AB(){
    raiz = null;
    }
    // insertar un nodo en el arbol 
    public void agregarNodo(int d, String nom,MD capa) {
        String id = nom + d;
        Nodo__AB nuevo = new Nodo__AB(d,nom,id,capa);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            Nodo__AB auxiliar = raiz;
            Nodo__AB padre;
            while (true) {
                padre = auxiliar;
                
                //añadir izquierda
                if (d < auxiliar.dato) {
                    auxiliar = auxiliar.Izquierda;
                    if (auxiliar == null) {
                        padre.Izquierda = nuevo;
                        return;
                    }
                //añadir mayores o iguales a la derecha
                } else if (d > auxiliar.dato){
                    auxiliar = auxiliar.Derecha;
                    if (auxiliar == null) {
                        padre.Derecha = nuevo;
                        return;
                    }
                }else{
                System.out.println("dato repetido");
                }
            }
        }
    }
    
    
  
    
    
    public boolean estaVacio(){
    return raiz == null;
    }
    public void InOrder(Nodo__AB r){
    if(r != null){
     InOrder(r.Izquierda);
     System.out.println(r.dato);
     InOrder(r.Derecha);
    }
    }
    public void PreOrder(Nodo__AB r){
    if (r != null){
    System.out.println(r.dato);
    PreOrder(r.Izquierda);
    PreOrder(r.Derecha);
    }
    }
    public void PostOrder(Nodo__AB r){
    if(r != null){
    PostOrder(r.Izquierda);
    PostOrder(r.Derecha);
    System.out.println(r.dato);
    }
    }
    
    public String InOrderGraph(Nodo__AB r){
    String text="";
    if(r != null){
   
     text += InOrderGraph(r.Izquierda)+"Nodo_"+r.id+"[label=\""+r.dato+"\"];\n"+InOrderGraph(r.Derecha);
    }
    return text;
    }
    
   
     
    public String textoGraph(Nodo__AB r){
    if(r.Izquierda  == null && r.Derecha == null){
        String devuelve = "\n";
    return devuelve;
    
    }else{
          String text = "";
          if(r.Izquierda != null){
          text += "Nodo_"+r.id+"->"+"Nodo_"+r.Izquierda.id+";\n"+textoGraph(r.Izquierda);
          
          
          }
          if(r.Derecha != null){
          text += "Nodo_"+r.id+"->"+"Nodo_"+r.Derecha.id+";\n"+textoGraph(r.Derecha);
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
      
      String RutaEntrada = "..\\Proyecto 2\\src\\Graph\\"+entrada+".txt";
      
      String RutaSalida = "..\\Proyecto 2\\src\\Graph\\"+nombre+".jpg";
      
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
            String ruta = "..\\Proyecto 2\\src\\Graph\\"+fNombre+".txt";
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
