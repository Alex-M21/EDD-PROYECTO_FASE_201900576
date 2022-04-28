/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Lista_Lugares {
    Nodo_Lugares cabeza;
    int size;

    public Lista_Lugares() {
        cabeza = null;
        size = 0;
    }

    public boolean ValVacio() {
        return (cabeza == null) ? true : false;
    }

    public void AgregarNodoInicio(Object algo) {
        // Cuando la lista esta vacia
        if (cabeza == null) {
            cabeza = new Nodo_Lugares(algo);
            // cuando la lista esta llena
        } else {
            Nodo_Lugares temp = cabeza;
            Nodo_Lugares nuevo = new Nodo_Lugares(algo);
            nuevo.linkSiguiente(temp);
            cabeza = nuevo;
        }
        size++;
    }
    public String imprimir(){
    Nodo_Lugares temp = cabeza;
    String data = "";
    if(cabeza != null){
    
    while (temp.getSiguiente() != null){
    data =data+"-->"+temp.getDato(); 
    temp = temp.getSiguiente();
    }
    data =data+"-->"+temp.getDato();
    System.out.println(data);
    }else{
    data += "La lista Simple esta vacia";
    
    }
    return data;
    }
    
     public String GraficarNodos(){
    Nodo_Lugares actual = cabeza;
    Nodo_Lugares actual2 = cabeza;
    Nodo_Lugares head = cabeza;
    String Data = "digraph G {\n";
    int contador = 1;
    if (actual == null){
    Data =Data+" Lista_Vacia }";
    }else{
        Data = Data + " rankdir=LR;\n";
        while (actual.getSiguiente() != null){
        Data = Data + "Lugar"+contador+"[label=\""+"L"+((Lugares)actual.getDato()).Nombre+"\"];\n";
        actual = actual.getSiguiente();
        contador++;
    }
    Data = Data + "Lugar"+contador+"[label=\""+"L"+((Lugares)actual.getDato()).Nombre+"\"];\n";
    cabeza = head;
    contador = 1;
    while (actual2.getSiguiente() != null){
        
        Data = Data + "Lugar"+contador+"->Lugar"+(contador+1)+"\n";
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
