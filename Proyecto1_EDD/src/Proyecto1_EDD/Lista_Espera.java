/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto1_EDD;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.NoSuchElementException;

public class Lista_Espera {
    
    Nodo_Espera cabeza;
    Nodo_Espera cola;
    Nodo_Imagenes n_imagenes;
    int tamaño_doble;
    
     public int Tamaño_Doble(){
     return tamaño_doble;
     }
     public boolean EstaVacio(){
     return tamaño_doble == 0;
     }
     
     public void AgreagarCircularInicio(Object algo){
     Nodo_Espera nuevo = new Nodo_Espera(algo,cabeza,cola);
    
     if(cola == null && cabeza == null){
     cola=nuevo;
     
     nuevo.linkAnterior(nuevo);
     nuevo.linkSiguiente(nuevo);
     
     System.out.println("Agregando:"+algo);
     }else {
     Nodo_Espera temp = cola;
     while(temp.getSiguiente()!= cola){
      temp = temp.getSiguiente();
     }
      nuevo.linkSiguiente(cola);
      nuevo.linkAnterior(temp);
      cabeza = nuevo;
      temp.linkSiguiente(nuevo);
      cola.linkAnterior(nuevo);
     
     System.out.println("Agregando:"+algo);
     }
     
     
     tamaño_doble++;
     
     }
     public void BuscarAdelante(Object Buscar){
     Nodo_Espera temp = cola;
     int contador = 0;
     boolean redflag = false;
  
     while(temp.getElement() != Buscar || redflag == true){
     temp = temp.getSiguiente();
     if(temp.getSiguiente()==cola){
     contador++;
     }
     if(contador > 3){
     redflag = true;
     
     break;
     }
     }
     if (redflag != true){
     System.out.println("Encontrado: "+temp.getElement());
     
     }else{
     System.out.println("No encontrado :( ");
     }
     
     
     }
     
    public void imprimir() {
        Nodo_Espera temp = cola;
        String Data = "";

        if (temp == null) {
            System.out.println("La lista espera esta vacia");
        } else {
            temp = temp.getSiguiente();
            Data = temp.getElement() + "-->" + Data;
            while (temp.getSiguiente() != cola) {
                Data = temp.getElement() + "-->" + Data;
                temp = temp.getSiguiente();
            }
        }
    }
    
     public String GraficarNodos(){
    Nodo_Espera actual = cola;
    Nodo_Espera actual2 = cola;
    Nodo_Espera head = cola;
    String Data = "digraph G {\n";
    int contador = 1;
    if (actual == null){
    
    
    Data = Data + "NULL \n }";
    
    
    }else{
     actual = actual.getSiguiente();
    while (actual.getSiguiente() != cola){
        
        Data = Data + "Cliente"+contador+"[label=\""+"Cliente"+((Cliente)actual.getElement()).id+"  "+((Cliente)actual.getElement()).getNombre()+"\"];\n";
        actual = actual.getSiguiente();
        contador++;
    }
    Data = Data + "Cliente"+contador+"[label=\""+"Cliente"+((Cliente)actual.getElement()).id+"  "+((Cliente)actual.getElement()).getNombre()+"\"];\n";
    Data = Data + "rankdir=LR;\n";
    
    cabeza = head;
    contador = 1;
    actual2 = actual2.getSiguiente();
    while (actual2.getSiguiente() != cola){
        
        Data = Data + "Cliente"+contador+"->Cliente"+(contador+1)+"\n";
        actual2 = actual2.getSiguiente();
        contador++;
    }
    Data = Data + "Cliente"+contador+"->Cliente1 \n Cliente1 -> Cliente"+contador+ "\n}";
    }
    return Data;
    }
     
     
     public void CrearTxt(String Data){
    try {   //C:\Users\braya\OneDrive\Documentos\NetBeansProjects\Proyecto1_EDD\src\Code\\+fNombre+".txt";
            String ruta = "C:\\Users\\braya\\OneDrive\\Documentos\\NetBeansProjects\\Proyecto1_EDD\\src\\Code\\Lista Espera.txt";
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
      
      String RutaEntrada = "C:\\Users\\braya\\OneDrive\\Documentos\\NetBeansProjects\\Proyecto1_EDD\\src\\Code\\Lista Espera.txt";
      String RutaSalida = "C:\\Users\\braya\\OneDrive\\Documentos\\NetBeansProjects\\Proyecto1_EDD\\src\\Graficas\\Lista Espera.jpg";
      
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
     
     public void BuscarAgregar(Object Buscar,Object imagen){
     Nodo_Espera temp = cola;
     int contador = 0;
     boolean redflag = false;
  
     while(temp.getElement() != Buscar || redflag == true){
     temp = temp.getSiguiente();
     if(temp.getSiguiente()==cola){
     contador++;
     }
     if(contador > 3){
     redflag = true;
     
     break;
     }
     }
     if (redflag != true){
     System.out.println("Encontrado: "+temp.getElement());
     //Nodo_Imagenes img = new Nodo_Imagenes(imagen,temp.getElement());
     //if (temp.getAbajo()== null){
     //temp.linkAbajo(img);
     //System.out.println("Imagen isertada correctamente");
     
     //}else{
     //    while(temp.getAbajo()!= null){
         
      //    System.out.println("Estamos en desarrollo");
     //    }
     
     
     
     }else{
     System.out.println("No encontrado :( ");
     }
     
     
     }
     
     
    /* public void BuscarAgregar(Object Buscar,Object Agregar){
     Nodo_Espera temp = cola;
     boolean redflag=false;
     while((temp.getElement()!= Buscar) || redflag != true ){
     temp = temp.getSiguiente();
     
     
     if(temp.getSiguiente()==cola){
     System.out.println("red flag: No se econtro dato");
     redflag = true;
     break;
     }
     }
     System.out.println("Encontrado:  "+ temp.getElement());
     Nodo_Imagenes img_nueva = new Nodo_Imagenes(Agregar,"1");
     if (temp.getAbajo() == null){
     temp.linkAbajo(img_nueva);
     
     }else{
     Nodo_Imagenes img_n;
     img_n = temp.getAbajo();
     
     while(img_n.getSiguiente() != null){
     img_n = img_n.getSiguiente();
     }
     System.out.println("Se agrego imagen:  "+ temp.getElement());
     img_n.linkSiguiente(img_nueva);
     img_nueva.linkSiguiente(null);
  
     
     }
     
     
     }
     
     
     */
     
     public void Agregar_Doble_Inicio(Object algo){
     Nodo_Espera temp = new Nodo_Espera(algo,cabeza,null);
     if(cabeza != null){
     cabeza.anterior = temp;
     }
     cabeza = temp;
     if(cola == null){
     cola=temp;
     System.out.println("Agregando:"+algo);
     }
     
     tamaño_doble++;
     }
     public void Agregar_Doble_Final(Object algo){
     Nodo_Espera temp = new Nodo_Espera(algo,null,cola);
     if(cola != null){
     cola.siguiente = temp;
     }
     cola= temp;
     if(cabeza == null){
         cabeza = temp;
     }
     tamaño_doble++;
     System.out.println("Agregando:"+algo);
     }
     public void iterarAdelante(){
     System.out.println("Iterando..");
     Nodo_Espera temp = cabeza;
     while(temp != null){
     System.out.println(temp.element);
     temp = temp.siguiente;
     }
     
     }
     public void iterarDetras(){
     System.out.println("Iterando...");
     Nodo_Espera temp = cola;
     while(temp != null){
     System.out.println(temp.element);
     temp = temp.anterior;
     }
     
     }
     
     public void removerInicio(){
     if(tamaño_doble == 0) throw new NoSuchElementException();
     Nodo_Espera temp = cabeza;
     cabeza= cabeza.siguiente;
     cabeza.anterior = null;
     tamaño_doble--;
     System.out.println("Eliminado: "+temp.element);
     }
     
     public void removerFinal(){
     if (tamaño_doble==0) throw new NoSuchElementException();
     Nodo_Espera temp = cola;
     cola = cola.anterior;
     cola.siguiente=null;
     tamaño_doble--;
     System.out.println("Eliminado: "+temp.element);
    
     }
    
}
