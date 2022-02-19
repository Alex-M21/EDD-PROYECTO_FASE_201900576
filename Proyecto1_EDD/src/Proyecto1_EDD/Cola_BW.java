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
public class Cola_BW {
    Nodo_impresion cabeza;
    int size;
     public Cola_BW() {
        cabeza = null;
        size = 0;
    }

    public boolean ValVacio() {
        return (cabeza == null) ? true : false;
    }

    public void AgregarNodoInicio(Object algo) {
        // Cuando la lista esta vacia
        if (cabeza == null) {
            cabeza = new Nodo_impresion(algo);
            // cuando la lista esta llena
        } else {
            Nodo_impresion temp = cabeza;
            Nodo_impresion nuevo = new Nodo_impresion(algo);
            nuevo.linkSiguiente(temp);
            cabeza = nuevo;
        }
        size++;

    }
    
    public void imprimir(){
    Nodo_impresion temp = cabeza;
    
    if(cabeza != null){
    String data = "";
    while (temp.getSiguiente() != null){
    data =data+"-->"+((Imagen)temp.getImagen()).getTipo(); 
    temp = temp.getSiguiente();
    }
    data =data+"-->"+((Cliente)temp.getImagen()).getNombre();
    System.out.println(data);
    }else{
    System.out.println("La Cola_BW esta vacia");
    
    }
    
    }
    

    public int tamaño() {
        return size;
    }

    public Object ObtenerNodo(int index) {
        int contador = 0;
        Nodo_impresion temporal = cabeza;
        while (contador != index) {
            temporal = temporal.getSiguiente();
            contador++;
        }
        return temporal.getImagen();
    }
    public Object ObtenerPrimero(){
    Nodo_impresion temporal = cabeza;
    Nodo_impresion temporal2 = cabeza;
    Object retorno;
    if(temporal.getSiguiente() != null){
    int contador = 0;
    int contador2 = 0; 
    while(temporal.getSiguiente() != null){
    temporal = temporal.getSiguiente();
    contador++;
    }
    retorno = temporal.getImagen();
    while(contador2 != contador-1){
    temporal2 = temporal2.getSiguiente();
    contador2++;
    }
    temporal2.linkSiguiente(null);
    
    
    
    }else{
    retorno = cabeza.getImagen();
    cabeza = null;
    
    
    }
   return retorno;
    }

    
    public void EliminarNodo(int index) {
        if (index == 0) {
            cabeza = cabeza.getSiguiente();
        } else if (index == size - 1) {
            int cont = 0;
            Nodo_impresion actual = cabeza;
            while (cont != index - 2) {
                actual = actual.getSiguiente();
                cont++;
            }
            actual.linkSiguiente(null);
        } else {
            int cont = 0;
            Nodo_impresion temporal = cabeza;
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
        Nodo_impresion temp = cabeza;
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
    
    public String GraficarNodosImg(){
    Nodo_impresion actual = cabeza;
    Nodo_impresion actual2 = cabeza;
    Nodo_impresion head = cabeza;
    String Data = "digraph G {\n";
    int contador = 1;
    if(actual == null){
    
    Data = Data + "NULL }";
    
    }else{
     while (actual.getSiguiente() != null){
        
        Data = Data + "Imagen"+contador+"[label=\""+"Imagen"+((Imagen)actual.getImagen()).id+"  "+((Imagen)actual.getImagen()).getTipo()+"\"];\n";
        actual = actual.getSiguiente();
        contador++;
    }
    Data = Data + "Imagen"+contador+"[label=\""+"Imagen"+((Imagen)actual.getImagen()).id+"  "+((Imagen)actual.getImagen()).getTipo()+"\"];\n";
    Data = Data + "rankdir=LR;\n";
    
    cabeza = head;
    contador = 1;
    while (actual2.getSiguiente() != null){
        
        Data = Data + "Imagen"+contador+"->Imagen"+(contador+1)+"\n";
        actual2 = actual2.getSiguiente();
        contador++;
    }
    Data = Data + "Imegen"+contador+"->NULL \n }";
    
    }
    return Data;
    }
    
    public void CrearTxt(String Data){
    try {   //C:\Users\braya\OneDrive\Documentos\NetBeansProjects\Proyecto1_EDD\src\Code\\+fNombre+".txt";
            String ruta = "C:\\Users\\braya\\OneDrive\\Documentos\\NetBeansProjects\\Proyecto1_EDD\\src\\Code\\Cola_BW.txt";
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
    public void LLamarGraphviz(){
    try {
      
      String GraficarRuta = "C:\\Program Files\\Graphviz\\bin\\dot.exe";
      
      String RutaEntrada = "C:\\Users\\braya\\OneDrive\\Documentos\\NetBeansProjects\\Proyecto1_EDD\\src\\Code\\Cola_WB.txt";
      String RutaSalida = "C:\\Users\\braya\\OneDrive\\Documentos\\NetBeansProjects\\Proyecto1_EDD\\src\\Graficas\\Cola_WB.jpg";
      
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

