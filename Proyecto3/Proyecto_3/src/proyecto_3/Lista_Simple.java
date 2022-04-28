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
public class Lista_Simple {
    Nodo_Lista_Simple cabeza;

    int size;

    public Lista_Simple() {
        cabeza = null;
        
        size = 0;
    }

    public boolean ValVacio() {
        return (cabeza == null) ? true : false;
    }

    public void AgregarNodoInicio(Object algo) {
        // Cuando la lista esta vacia
        if (cabeza == null) {
            cabeza = new Nodo_Lista_Simple(algo);
            // cuando la lista esta llena
        } else {
            Nodo_Lista_Simple temp = cabeza;
            Nodo_Lista_Simple nuevo = new Nodo_Lista_Simple(algo);
            nuevo.linkSiguiente(temp);
            cabeza = nuevo;
        }
        size++;

    }
    
    
    
    public String imprimir(){
    Nodo_Lista_Simple temp = cabeza;
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
    

    public int tamaño() {
        return size;
    }

    public Object ObtenerNodo(int index) {
        int contador = 0;
        Nodo_Lista_Simple temporal = cabeza;
        while (contador != index) {
            temporal = temporal.getSiguiente();
            contador++;
        }
        return temporal.getDato();
    }
    public Object ObtenerPrimero(){
    Nodo_Lista_Simple temporal = cabeza;
    Nodo_Lista_Simple temporal2 = cabeza;
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
            Nodo_Lista_Simple actual = cabeza;
            while (cont != index - 2) {
                actual = actual.getSiguiente();
                cont++;
            }
            actual.linkSiguiente(null);
        } else {
            int cont = 0;
            Nodo_Lista_Simple temporal = cabeza;
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
        Nodo_Lista_Simple temp = cabeza;
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
    
    public String GraficarNodos(String conexion,int vertice){
    Nodo_Lista_Simple actual = cabeza;
    Nodo_Lista_Simple actual2 = cabeza;
    Nodo_Lista_Simple head = cabeza;
    String Data = "";
    int contador = 1;
    if (actual == null){
    
    Data =Data+"\n";
    }else{
        while (actual.getSiguiente() != null){
        
        Data = Data + "Arista"+contador+"_"+vertice+"[label=\""+"A"+actual.getDato()+"\"];\n";
        actual = actual.getSiguiente();
        contador++;
    }
    Data = Data + "Arista"+contador+"_"+vertice+"[label=\""+"A"+actual.getDato()+"\"];\n";
    Data = Data + "\n";
    
    cabeza = head;
    contador = 1;
    
       Data = Data + conexion + "->"+"Arista"+contador+"_"+vertice+"\n";
    while (actual2.getSiguiente() != null){
        
        Data = Data + "Arista"+contador+"_"+vertice+"->Arista"+(contador+1)+"_"+vertice+"\n";
        actual2 = actual2.getSiguiente();
        contador++;
    }
    
    }
    return Data; 
    }
    
    public void CrearTxt(String Data,String fNombre){
    try {   //C:\Users\braya\OneDrive\Escritorio\Salidas\Principal
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
      
      String RutaEntrada = "C:\\Users\\braya\\OneDrive\\Escritorio\\Salidas\\Principal\\"+nombreE+".tx";
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
