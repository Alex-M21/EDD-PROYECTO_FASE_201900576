/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto1_EDD;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author braya
 */
public class Lista_Recepcion {
    Nodo_Recepcion cabeza;

    int size;

    public Lista_Recepcion() {
        cabeza = null;
        
        size = 0;
    }

    public boolean ValVacio() {
        return (cabeza == null) ? true : false;
    }

    public void AgregarNodoInicio(Object algo) {
        // Cuando la lista esta vacia
        if (cabeza == null) {
            cabeza = new Nodo_Recepcion(algo);
            // cuando la lista esta llena
        } else {
            Nodo_Recepcion temp = cabeza;
            Nodo_Recepcion nuevo = new Nodo_Recepcion(algo);
            nuevo.LinkSiguiente(temp);
            cabeza = nuevo;
        }
        size++;

    }
    
    
    
    public void imprimir(){
    Nodo_Recepcion temp = cabeza;
    
    if(cabeza != null){
    String data = "";
    while (temp.getSiguiente() != null){
    data =data+"-->"+((Cliente)temp.getElemento()).getNombre(); 
    temp = temp.getSiguiente();
    }
    data =data+"-->"+((Cliente)temp.getElemento()).getNombre();
    System.out.println(data);
    }else{
    System.out.println("La lista Recepcion esta vacia");
    
    }
    
    }
    

    public int tamaño() {
        return size;
    }

    public Object ObtenerNodo(int index) {
        int contador = 0;
        Nodo_Recepcion temporal = cabeza;
        while (contador != index) {
            temporal = temporal.getSiguiente();
            contador++;
        }
        return temporal.getElemento();
    }
    public Object ObtenerPrimero(){
    Nodo_Recepcion temporal = cabeza;
    Nodo_Recepcion temporal2 = cabeza;
    Object retorno = null;
    if (temporal != null){
     if(temporal.getSiguiente() != null){
    int contador = 0;
    int contador2 = 0; 
    while(temporal.getSiguiente() != null){
    temporal = temporal.getSiguiente();
    contador++;
    }
    retorno = temporal.getElemento();
    while(contador2 != contador-1){
    temporal2 = temporal2.getSiguiente();
    contador2++;
    }
    temporal2.LinkSiguiente(null);
    
    
    
    }else if(temporal.getSiguiente()==null ){
    retorno = temporal.getElemento();
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
            Nodo_Recepcion actual = cabeza;
            while (cont != index - 2) {
                actual = actual.getSiguiente();
                cont++;
            }
            actual.LinkSiguiente(null);
        } else {
            int cont = 0;
            Nodo_Recepcion temporal = cabeza;
            while (cont != index) {
                temporal = temporal.getSiguiente();
                cont++;
            }
            temporal.LinkSiguiente(temporal.getSiguiente().getSiguiente());
        }

        size--;
    }

    public void Cortar(int index) {
        int contador = 0;
        Nodo_Recepcion temp = cabeza;
        while (contador != index) {
            temp = temp.getSiguiente();
            contador++;
        }
        temp.LinkSiguiente(null);

    }

    public void EliminarInicio() {
        cabeza = cabeza.getSiguiente().getSiguiente();
        size--;
    }
    
    public String GraficarNodos(){
    Nodo_Recepcion actual = cabeza;
    Nodo_Recepcion actual2 = cabeza;
    Nodo_Recepcion head = cabeza;
    String Data = "digraph G {\n";
    int contador = 1;
    if (actual == null){
    
    Data =Data+"NULL \n }";
    }else{
        while (actual.getSiguiente() != null){
        
        Data = Data + "Cliente"+contador+"[label=\""+"Cliente"+((Cliente)actual.getElemento()).id+"  "+((Cliente)actual.getElemento()).getNombre()+"\"];\n";
        actual = actual.getSiguiente();
        contador++;
    }
    Data = Data + "Cliente"+contador+"[label=\""+"Cliente"+((Cliente)actual.getElemento()).id+"  "+((Cliente)actual.getElemento()).getNombre()+"\"];\n";
    Data = Data + "rankdir=LR;\n";
    
    cabeza = head;
    contador = 1;
    while (actual2.getSiguiente() != null){
        
        Data = Data + "Cliente"+contador+"->Cliente"+(contador+1)+"\n";
        actual2 = actual2.getSiguiente();
        contador++;
    }
    Data = Data + "Cliente"+contador+"->NULL \n }";
    
    
    
    }
    
    
    
    return Data;
    
    
    }
    
    public void CrearTxt(String Data,String fNombre){
    try {   //C:\Users\braya\OneDrive\Documentos\NetBeansProjects\Proyecto1_EDD\src\Code\\+fNombre+".txt";
            String ruta = "C:\\Users\\braya\\OneDrive\\Documentos\\NetBeansProjects\\Proyecto1_EDD\\src\\Code\\"+fNombre+".txt";
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
    public void LLamarGraphviz(String nombre){
    try {
      
      String GraficarRuta = "C:\\Program Files\\Graphviz\\bin\\dot.exe";
      
      String RutaEntrada = "C:\\Users\\braya\\OneDrive\\Documentos\\NetBeansProjects\\Proyecto1_EDD\\src\\Code\\Lista Recepcion.txt";
      String RutaSalida = "C:\\Users\\braya\\OneDrive\\Documentos\\NetBeansProjects\\Proyecto1_EDD\\src\\Graficas\\"+nombre+".jpg";
      
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
