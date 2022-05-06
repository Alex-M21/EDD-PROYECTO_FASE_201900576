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
public class ListaClientes {
    
    
    Nodo_Cliente cabeza;

    int size;

    public ListaClientes() {
        cabeza = null;
        
        size = 0;
    }

    public boolean ValVacio() {
        return (cabeza == null) ? true : false;
    }

    public void AgregarNodoInicio(Object algo) {
        // Cuando la lista esta vacia
        if (cabeza == null) {
            cabeza = new Nodo_Cliente(algo);
            // cuando la lista esta llena
        } else {
            Nodo_Cliente temp = cabeza;
            Nodo_Cliente nuevo = new Nodo_Cliente(algo);
            nuevo.linkSiguiente(temp);
            cabeza = nuevo;
        }
        size++;

    }
    public void AgregarNodoFinal(Object algo){
        if (cabeza == null) {
            cabeza = new Nodo_Cliente(algo);
        }else{
            Nodo_Cliente temp = cabeza;
            Nodo_Cliente nuevo = new Nodo_Cliente(algo);
            
            while(temp.getSiguiente() != null){
                temp = temp.getSiguiente();
            }
            nuevo.linkSiguiente(null);
            temp.linkSiguiente(nuevo);
        }
        size++;
        
    }
    
    
    
    public String imprimir(){
    Nodo_Cliente temp = cabeza;
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

    public Nodo_Cliente ObtenerNodo(int index) {
        int contador = 0;
        Nodo_Cliente temporal = cabeza;
        while (contador != index) {
            temporal = temporal.getSiguiente();
            contador++;
        }
        return temporal;
    }
    public boolean ValidarEntrada(String user,String contra){
         Nodo_Cliente temporal = cabeza;
        boolean User = false;
        boolean Clave = false;
        boolean Entrada = false;
        if (temporal != null) {
            while (temporal.getSiguiente() != null) {
                System.out.println("User: "+user+", Cli; "+((Cliente) temporal.dato).Nombre_usuario.toString());
                if (user.equals(((Cliente) temporal.dato).Nombre_usuario.toString())) {
                    User = true;
                } else {
                    User = false;
                }
               System.out.println("key: "+contra+", Cli; "+((Cliente) temporal.dato).Nombre_usuario.toString());
                if (contra.equals(((Cliente) temporal.dato).Contraseña.toString())) {
                    Clave = true;
                } else {
                    Clave = false;
                }
                temporal = temporal.getSiguiente();
            }
            System.out.println("User: "+user+", Cli; "+((Cliente) temporal.dato).Nombre_usuario.toString());
                if (user.equals(((Cliente) temporal.dato).Nombre_usuario.toString())) {
                    User = true;
                } else {
                    User = false;
                }
               System.out.println("key: "+contra+", Cli; "+((Cliente) temporal.dato).Nombre_usuario.toString());
                if (contra.equals(((Cliente) temporal.dato).Contraseña.toString())) {
                    Clave = true;
                } else {
                    Clave = false;
                }
            if (User == true && Clave == true) {
                Entrada = true;
            }

        } else {
            Entrada = false;
        }
        return Entrada;
    
    }
    
    public void Modificar(int index,Cliente remplazo){
    int contador = 0;
        Nodo_Cliente temporal = cabeza;
        while (contador != index) {
            temporal = temporal.getSiguiente();
            contador++;
        }
        temporal.setDato(remplazo);
    }
    public Object ObtenerPrimero(){
    Nodo_Cliente temporal = cabeza;
    Nodo_Cliente temporal2 = cabeza;
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
            Nodo_Cliente actual = cabeza;
            while (cont != index - 2) {
                actual = actual.getSiguiente();
                cont++;
            }
            actual.linkSiguiente(null);
        } else {
            int cont = 0;
            Nodo_Cliente temporal = cabeza;
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
        Nodo_Cliente temp = cabeza;
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
    Nodo_Cliente actual = cabeza;
    Nodo_Cliente actual2 = cabeza;
    Nodo_Cliente head = cabeza;
    String Data = " digraph G { \n";
    int contador = 1;
    if (actual == null){
    
    
    }else{
        while (actual.getSiguiente() != null){
        
        Data = Data + "Cliente"+contador+"[label=\""+"Cliente"+((Cliente)actual.getDato()).Nombre_completo+"\"];\n";
        actual = actual.getSiguiente();
        contador++;
    }
    Data = Data + "Cliente"+contador+"[label=\""+"Cliente"+((Cliente)actual.getDato()).Nombre_completo+"\"];\n";
    Data = Data + "\n";
    
    cabeza = head;
    contador = 1;
    
       
    while (actual2.getSiguiente() != null){
        
        Data = Data + "Cliente"+contador+"->Cliente"+(contador+1)+"\n";
        actual2 = actual2.getSiguiente();
        contador++;
    }
    
    }
    Data+="\n }";
    return Data; 
    }
    
    public void CrearTxt(String Data,String fNombre){
    try {   //C:\Users\braya\OneDrive\Escritorio\Salidas\Principal
            String ruta = "C:\\Users\\braya\\OneDrive\\Escritorio\\Salidas\\Admin\\"+fNombre+".txt";
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
      
      String RutaEntrada = "C:\\Users\\braya\\OneDrive\\Escritorio\\Salidas\\Admin\\"+nombreE+".txt";
      String RutaSalida = "C:\\Users\\braya\\OneDrive\\Escritorio\\Salidas\\Admin\\"+nombreS+".jpg";
      
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
