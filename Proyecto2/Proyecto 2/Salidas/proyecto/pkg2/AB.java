
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
                break;
                }
            }
        }
    }
    
    
  
    
    
    public boolean estaVacio(){
    return raiz == null;
    }
    public String InOrder(Nodo__AB r){
        String text = "";
    if(r != null){
     text += InOrder(r.Izquierda)+ r.dato +"," + InOrder(r.Derecha);
    }
    return text;
    }
    
    public void InOrderMat(Nodo__AB r){
    if(r != null){
     InOrderMat(r.Izquierda);
     System.out.println(r.MatrizCapa.toString());
     InOrderMat(r.Derecha);
    }
    }
    public String PreOrder(Nodo__AB r){
        String text = "";
    if (r != null){
        text += r.dato+","+PreOrder(r.Izquierda)+PreOrder(r.Derecha);
    }
    return text;
    }
    public String PostOrder(Nodo__AB r){
        String text = "";
    if(r != null){
        text += PostOrder(r.Izquierda)+PostOrder(r.Derecha)+r.dato+",";
    }
    return text;
   
    }
    
    public String InOrderGraph(Nodo__AB r){
    String text="";
    if(r != null){
   
     text += InOrderGraph(r.Izquierda)+"Nodo_"+r.id+"[label=\"Capa "+r.dato+"\"];\n"+InOrderGraph(r.Derecha);
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
      
      String RutaEntrada = "..\\Proyecto 2\\src\\GraphABB\\"+entrada+".txt";
      
      String RutaSalida = "..\\Proyecto 2\\src\\GraphABB\\"+nombre+".jpg";
      
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
            String ruta = "..\\Proyecto 2\\src\\GraphABB\\"+fNombre+".txt";
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
    public Object BuscarNodo(int capa, Nodo__AB r) {
   
        if (r != null) {
            if (capa == r.dato) {
                Nodo__AB encontrado = r;
                return encontrado;
            } else {
                if (capa < r.dato) {

                    BuscarNodo(capa, r.Izquierda);

                } else {
                    BuscarNodo(capa, r.Derecha);

                }
            }
        }
        return null;
    }
    public Nodo__AB BuscarNodoW(int capa,Nodo__AB r){
   
    while(r!=null){
    if(capa < r.dato){
    r = r.Izquierda;
    }else if(capa > r.dato){
    r = r.Derecha;
    }else if(capa == r.dato){
    return r;
    
    }
    }
    return null;
    }
    
    public void UnirCapas(Nodo__AB r){
       
    if(r!= null){
        
    MD matrix = r.MatrizCapa;
    
    UnirCapas(r.Izquierda); 
    UnirCapas(r.Derecha);
    }
     
    }
    public int BuscarMayor(Nodo__AB r){
    int retorno = 0;
    while(r.Derecha.Derecha != null){ 
      r = r.Derecha;
    }
    if(r.Derecha != null && r.Izquierda != null){
    
    retorno = r.Derecha.dato;
    }else if ( r.Derecha != null && r.Izquierda == null){
    retorno = r.Derecha.dato;
    
    }else if(r.Derecha == null && r.Izquierda != null){
    retorno = r.Izquierda.dato;
    }
    return retorno;
    }
    
  
   
}    

