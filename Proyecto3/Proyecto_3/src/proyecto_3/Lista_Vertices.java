/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author braya
 */
public class Lista_Vertices {
    Nodo_Vertice cabeza;
    
    int size;

    public Lista_Vertices() {
        cabeza = null;
        
        size = 0;
    }

    public boolean ValVacio() {
        return (cabeza == null) ? true : false;
    }

    public void AgregarNodoInicio(int algo) {
        // Cuando la lista esta vacia
        if (cabeza == null) {
            cabeza = new Nodo_Vertice(algo);
            // cuando la lista esta llena
        } else {
            Nodo_Vertice temp = cabeza;
            Nodo_Vertice nuevo = new Nodo_Vertice(algo);
            nuevo.linkSiguiente(temp);
            cabeza = nuevo;
        }
        size++;

    }
    
    
    
    public void imprimir(){
    Nodo_Vertice temp = cabeza;
    
    if(cabeza != null){
    String data = "";
    while (temp.getSiguiente() != null){
    data =data+"->"+temp.getDato(); 
    data += "|"+temp.lstSimple.imprimir()+"|";
    temp = temp.getSiguiente();
    }
    data =data+"->"+temp.getDato();
    data += "|"+temp.lstSimple.imprimir()+"|";
    System.out.println(data);
    
    }else{
    System.out.println("La lista vertices esta vacia");
    
    }
    
    }
    

    public int tamaño() {
        return size;
    }

    public Object ObtenerNodo(int index) {
        int contador = 0;
        Nodo_Vertice temporal = cabeza;
        while (contador != index) {
            temporal = temporal.getSiguiente();
            contador++;
        }
        return temporal.getDato();
    }
    
    public void Insertar_Vert_Arista(int inicio, int fin){
  
      // Cuando la lista esta vacia
        if (cabeza == null) {
            cabeza = new Nodo_Vertice(inicio);
            cabeza.lstSimple.AgregarNodoInicio(fin);
            
            // cuando la lista esta llena
        } else if (cabeza != null) {
            Nodo_Vertice temp = cabeza;
            Nodo_Vertice aux = cabeza;
            int encontrado = -1;
            int contador_aux = 0;
            int contador_oficial = 0;
            // este while mapea
            while (aux.getSiguiente() != null) {
              if (aux.getDato() == inicio){
              encontrado = inicio;
              }
              contador_aux++;
              aux = aux.getSiguiente();
            }
            if (aux.getDato() == inicio){
              encontrado = inicio;
              }
            
            System.out.println("El valor encontrado es de: "+encontrado);
            
            if (encontrado == -1){
                Nodo_Vertice nuevo = new Nodo_Vertice(inicio);
                
                while(temp.getSiguiente() != null){
                temp = temp.getSiguiente();
                }
                nuevo.lstSimple.AgregarNodoInicio(fin);
                temp.linkSiguiente(nuevo);
                nuevo.linkSiguiente(null);
                
            
            }else{
            while(contador_oficial != contador_aux){
            contador_oficial++;
            temp = temp.getSiguiente();
            }
            temp.lstSimple.AgregarNodoInicio(fin);
            
            }
           
            
        }
    }
  
    
    public Object ObtenerPrimero(){
    Nodo_Vertice temporal = cabeza;
    Nodo_Vertice temporal2 = cabeza;
    Object retorno = null;
    if (temporal != null){
     if(temporal.getSiguiente() != null){
    int contador = 0;
    int contador2 = 0; 
    while(temporal.getSiguiente() != null){
    temporal = temporal.getSiguiente();
    contador++;
    }
    retorno = temporal.getDato();
    while(contador2 != contador-1){
    temporal2 = temporal2.getSiguiente();
    contador2++;
    }
    temporal2.linkSiguiente(null);
    
    
    
    }else if(temporal.getSiguiente()==null ){
    retorno = temporal.getDato();
    cabeza = null;
    
    
    }else{
    retorno = null;
    }
    
    }  
   size--;
   return retorno;
   }

    
    public void EliminarNodo(int index) {
        if (index == 0) {
            cabeza = cabeza.getSiguiente();
        } else if (index == size - 1) {
            int cont = 0;
            Nodo_Vertice actual = cabeza;
            while (cont != index - 2) {
                actual = actual.getSiguiente();
                cont++;
            }
            actual.linkSiguiente(null);
        } else {
            int cont = 0;
            Nodo_Vertice temporal = cabeza;
            while (cont != index) {
                temporal = temporal.getSiguiente();
                cont++;
            }
            temporal.linkSiguiente(temporal.getSiguiente().getSiguiente());
        }

        size--;
    }

    public void Cortar(int index) {
        int contador = 0;
        Nodo_Vertice temp = cabeza;
        while (contador != index) {
            temp = temp.getSiguiente();
            contador++;
        }
        temp.linkSiguiente(null);

    }

    public void EliminarInicio() {
        cabeza = cabeza.getSiguiente().getSiguiente();
        size--;
    }
    
    public String GraficarNodos(){
    Nodo_Vertice actual = cabeza;
    Nodo_Vertice actual2 = cabeza;
    Nodo_Vertice head = cabeza;
    String Data = "digraph G {\n";
    int contador = 1;
    if (actual == null){
    
    Data =Data+" Lista_Vacia }";
    }else{
        Data = Data + " rankdir=LR;\n";
        while (actual.getSiguiente() != null){
        
        Data = Data + "Vertice"+contador+"[label=\""+"V"+actual.getDato()+"\"];\n";
        Data = Data + actual.lstSimple.GraficarNodos("Vertice"+contador,actual.getDato());
        actual = actual.getSiguiente();
        contador++;
    }
    Data = Data + "Vertice"+contador+"[label=\""+"V"+actual.getDato()+"\"];\n";
    Data = Data + actual.lstSimple.GraficarNodos("Vertice"+contador,actual.getDato());
    
    
    cabeza = head;
    contador = 1;
    while (actual2.getSiguiente() != null){
        
        Data = Data + "Vertice"+contador+"->Vertice"+(contador+1)+"\n";
        actual2 = actual2.getSiguiente();
        contador++;
    }
    
    Data = Data + "\n }";
    
    
    
    }
    
    
    
    return Data;
    
    
    }
    
    public void CrearTxt(String Data,String fNombre){
    try {   //C:\Users\braya\OneDrive\Documentos\NetBeansProjects\Proyecto1_EDD\src\Code\\+fNombre+".txt";
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
    public void LLamarGraphviz(String nombreE,String nombreS){
    try {
      
      String GraficarRuta = "C:\\Program Files\\Graphviz\\bin\\dot.exe";
      
      String RutaEntrada = "C:\\Users\\braya\\OneDrive\\Escritorio\\Salidas\\Principal\\"+nombreE+".txt";
      String RutaSalida = "C:\\Users\\braya\\OneDrive\\Escritorio\\Salidas\\Principal\\"+nombreS+".jpg";
      
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
    
}
