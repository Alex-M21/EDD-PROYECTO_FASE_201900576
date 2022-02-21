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
public class Lista_Circular {
    Nodo_2 primero;
    Nodo_2 ultimo;
    String dato;

    public Lista_Circular() {
        primero = null;
        ultimo = null;
    }

    public void ingresar(Object x) {
        Nodo_2 nuevo = new Nodo_2();
        nuevo.datos = x;
        if (primero == null) {
            primero = nuevo;
            primero.siguiente = primero;
            primero.anterior = ultimo;
            ultimo = nuevo;
        } else {
            ultimo.siguiente = nuevo;
            nuevo.siguiente = primero;
            ultimo = nuevo;
            primero.anterior = ultimo;

        }

    }

    public void mostrar() {
        
        Nodo_2 actual = new Nodo_2();
        actual = primero;
        if(actual != null){
        do {
            System.out.println(((Cliente) actual.datos).Nombre);
            actual = actual.siguiente;
        } while (actual != primero);
        
        }
        
    }

    public void Buscar(String x) {

        Nodo_2 actual = new Nodo_2();
        actual = primero;
        boolean encontrado = false;
        do {
            //System.out.println(((Cliente)actual.datos).Nombre);
            if (((Cliente) actual.datos).id == x) {
                encontrado = true;
                dato = ((Cliente) actual.datos).Nombre;
            }
            actual = actual.siguiente;
        } while (actual != primero);
        if (encontrado == true) {
            System.out.println(dato);
        }

    }
    
    public void BuscarCliente(String client){
    Nodo_2 actual = new Nodo_2();
        actual = primero;
        boolean encontrado = false;
        do {
            //System.out.println(((Cliente)actual.datos).Nombre);
            
            int h = Integer.parseInt(((Cliente)actual.datos).getId());
            int b = Integer.parseInt(client);
            if (h == b) {
                encontrado = true;
                dato = "  El cliente es  "+((Cliente) actual.datos).Nombre+",  Su Id es:  "+((Cliente) actual.datos).id;
                dato = dato +",  Sus datos imagenes son:"+ (actual.lstImg.retornarImagenesEspera());
            }
            actual = actual.siguiente;
        } while (actual != primero);
        if (encontrado == true) {
            System.out.println("Se enconntro el cliente:"+dato);
            
        }else{
        System.out.println("No se encontro el cliente");
        }
    
    }

    public void BuscarAgregar(String buscar, Object agregar) {
        Nodo_2 actual = new Nodo_2();
        actual = primero;
        dato = "";
        boolean encontrado = false;
        do {
            //System.out.println(((Cliente)actual.datos).Nombre);
            if (((Cliente) actual.datos).id == buscar) {
                encontrado = true;
                dato = ((Cliente) actual.datos).Nombre;
                actual.lstImg.AgregarNodoInicio(agregar);
            }
            actual = actual.siguiente;
        } while (actual != primero);
        if (encontrado == true) {
            System.out.println("se encontro: " + dato);

        } else {
            System.out.println(" No se encontro el id :( ");
        }
    }

    public void ImprimirListadeListas() {
        Nodo_2 actual = new Nodo_2();
        actual = primero;
        do {

            actual = actual.siguiente;
            actual.lstImg.imprimirImagenesEspera();
        } while (actual != primero);

    }

    public String  Graficar() {
        Nodo_2 actual = new Nodo_2();
        String data = "digraph G {\n   rankdir=LR; \n";
        actual = primero;
        if (actual == null){
         data=data+"NULL \n }";
        }else{
        
        int contador = 1;
        int contador2 = 2;
        data = data + "Cliente"+contador+"->"+"Cliente"+contador2+"\n";
        data = data + "Cliente"+contador2+"->"+"Cliente"+contador+"\n";
        if(actual.lstImg.size >= 0){
            String ref = "Client"+contador;
        data = data + actual.lstImg.GraficarNodos(ref,contador);
        
        }else{
         data = data+"Cliente"+contador+"->"+"Null"+contador+"\n";
        
        }
        actual = actual.siguiente;
        contador++;
        contador2 ++;
        while (actual.siguiente != primero){
            System.out.println(((Cliente) actual.datos).Nombre);
            data = data + "Cliente"+contador+"->"+"Cliente"+contador2+"\n";
            data = data + "Cliente"+contador2+"->"+"Cliente"+contador+"\n";
            if(actual.lstImg.size >= 0){
            String ref = "Client"+contador;
            data = data + actual.lstImg.GraficarNodos(ref,contador);
        
        }else{
         data = data+"Cliente"+contador+"->"+"Null \n";
        
        }
            contador++;
           contador2 ++;
        
            actual = actual.siguiente;
            
        }
        if(actual.lstImg.size >= 0){
            String ref = "Client"+contador;
            data = data + actual.lstImg.GraficarNodos(ref,contador);
        
        }else{
         data = data+"Cliente"+contador+"->"+"Null \n";
        
        }
        
        
        data = data + "Cliente1 ->"+"Cliente"+(contador)+"\n";
        data = data + "Cliente"+(contador)+"->"+"Cliente1 \n";
        
        
        
        data = data + "}";
        }
        
    return data;
    }
    public void CrearTxt(String Data) {
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

    public void LLamarGraphviz() {
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

            rt.exec(composicion);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }

    }
}
