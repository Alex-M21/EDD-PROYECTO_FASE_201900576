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

    int tamaño_doble;

    public int Tamaño_Doble() {
        return tamaño_doble;
    }

    public boolean EstaVacio() {
        return tamaño_doble == 0;
    }

    public void AgreagarCircularInicio(Object algo) {
        Nodo_Espera nuevo = new Nodo_Espera(algo, cabeza, cola);
        //<---objeto---->
        if (cola == null && cabeza == null) {
            cola = nuevo;
            nuevo.linkAnterior(nuevo);
            nuevo.linkSiguiente(nuevo);
            System.out.println("Agregando 1:" + algo);
            
            
            
        } else  {
            Nodo_Espera temp = cola;
            
            if(temp.getSiguiente() == cola){
            nuevo.linkSiguiente(temp);
            nuevo.linkAnterior(temp);
            cabeza = nuevo;
            temp.linkSiguiente(nuevo);
            cola.linkAnterior(nuevo);
            System.out.println("Agregando 2:" + algo);
            
            }else if(temp.getSiguiente() == cabeza){
             nuevo.linkSiguiente(temp);
             nuevo.linkAnterior(cabeza);
             temp.linkAnterior(nuevo);
             cabeza.linkSiguiente(nuevo);
             cola = nuevo;
             System.out.println("Agregando 3:" + algo);
            
            }
            

            System.out.println("Agregando:" + algo);
        }

        tamaño_doble++;

    }
    public void Agregar2(Object algo){
    Nodo_Espera nuevo = new Nodo_Espera(algo,cabeza,cola);
    
    if(cola == null){
    cola = nuevo;
    cola.linkSiguiente(cola);
    nuevo.linkSiguiente(cabeza);
    cabeza=nuevo;
    }else{
    cabeza.linkSiguiente(nuevo);
    nuevo.linkSiguiente(cola);
    nuevo.linkAnterior(cabeza);
    cabeza=nuevo;
    cola.linkAnterior(cabeza);
    }
    tamaño_doble++;
    }

    public Object BuscarAdelante(Object Buscar) {
        Nodo_Espera temp = cola;
        int contador = 0;
        boolean redflag = false;

        while (((Cliente) temp.getElement()).getId() != Buscar || redflag == true) {
            temp = temp.getSiguiente();
            if (temp.getSiguiente() == cola) {
                contador++;
            }
            if (contador > 3) {
                redflag = true;

                break;
            }
        }
        if (redflag != true) {
            System.out.println("Encontrado: " + ((Cliente) temp.getElement()).getNombre());
            Object devolver = temp.getElement();
        } else {
            System.out.println("No encontrado :( ");

        }

        return temp;
    }

    public void imprimir() {
        Nodo_Espera temp = cola;
        String Data = "";

        if (temp == null) {
            System.out.println("La lista espera esta vacia");
        } else {
            Data = ((Cliente)temp.getElement()).getNombre() +"->"+Data;
         
           
            while (temp.getSiguiente() != cola) {
                Data = ((Cliente)temp.getElement()).getNombre() + "-->" + Data;
                temp = temp.getSiguiente();
            }
            temp = temp.getSiguiente();
            Data = ((Cliente)temp.getElement()).getNombre() + "-->" + Data;
            
            System.out.println(Data);
            System.out.println("Este es el tamaño doble"+tamaño_doble);
        }
    }

    public void imprimirlistas() {
       Nodo_Espera temp = cola;

        if (temp == null) {
            System.out.println("La lista espera esta vacia");
        } else {
            
            temp = temp.getSiguiente();
            temp.lstImagenes.imprimirImagenesEspera();
            while (temp.getSiguiente() != cola) {
                temp.lstImagenes.imprimirImagenesEspera();
                temp = temp.getSiguiente();
            }
            
           
        }
    }

    public String GraficarNodos() {
        Nodo_Espera actual = cola;
        Nodo_Espera actual2 = cola;
        Nodo_Espera head = cola;
        String Data = "digraph G {\n";
        int contador = 1;
        if (actual == null) {

            Data = Data + "NULL \n }";

        } else {
            actual = actual.getSiguiente();
            while (actual.getSiguiente() != cola) {

                Data = Data + "Cliente" + contador + "[label=\"" + "Cliente" + ((Cliente) actual.getElement()).id + "  " + ((Cliente) actual.getElement()).getNombre() + "\"];\n";
                actual = actual.getSiguiente();
                contador++;
            }
            Data = Data + "Cliente" + contador + "[label=\"" + "Cliente" + ((Cliente) actual.getElement()).id + "  " + ((Cliente) actual.getElement()).getNombre() + "\"];\n";
            Data = Data + "rankdir=LR;\n";

            cabeza = head;
            contador = 1;
            actual2 = actual2.getSiguiente();
            while (actual2.getSiguiente() != cola) {

                Data = Data + "Cliente" + contador + "->Cliente" + (contador + 1) + "\n";
                actual2 = actual2.getSiguiente();
                contador++;
            }
            Data = Data + "Cliente" + contador + "->Cliente1 \n Cliente1 -> Cliente" + contador + "\n}";
        }
        return Data;
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

    public void BuscarAgregar(Object Buscar, Object imagen) {
        System.out.println("Buscar Adelante");
        Nodo_Espera temp = cola;
        int contador = 0;
        boolean redflag = false;

        while (((Cliente) temp.getElement()).getId() != Buscar || redflag == true) {
            temp = temp.getSiguiente();
            if (temp.getSiguiente() == cola) {
                contador++;
            }
            if (contador > 3) {
                redflag = true;

                break;
            }
        }
        if (redflag != true) {
            System.out.println("Encontrado: " + ((Cliente) temp.getElement()).getNombre());
            System.out.println("Este es el objeto imagen: " + imagen);
            temp.lstImagenes.AgregarNodoInicio(imagen);
        } else {
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
    public void Agregar_Doble_Inicio(Object algo) {
        Nodo_Espera temp = new Nodo_Espera(algo, cabeza, null);
        if (cabeza != null) {
            cabeza.anterior = temp;
        }
        cabeza = temp;
        if (cola == null) {
            cola = temp;
            System.out.println("Agregando:" + algo);
        }

        tamaño_doble++;
    }

    public void Agregar_Doble_Final(Object algo) {
        Nodo_Espera temp = new Nodo_Espera(algo, null, cola);
        if (cola != null) {
            cola.siguiente = temp;
        }
        cola = temp;
        if (cabeza == null) {
            cabeza = temp;
        }
        tamaño_doble++;
        System.out.println("Agregando:" + algo);
    }

    public void iterarAdelante() {
        System.out.println("Iterando..");
        Nodo_Espera temp = cabeza;
        while (temp != null) {
            System.out.println(temp.element);
            temp = temp.siguiente;
        }

    }

    public void iterarDetras() {
        System.out.println("Iterando...");
        Nodo_Espera temp = cola;
        while (temp != null) {
            System.out.println(temp.element);
            temp = temp.anterior;
        }

    }

    public void removerInicio() {
        if (tamaño_doble == 0) {
            throw new NoSuchElementException();
        }
        Nodo_Espera temp = cabeza;
        cabeza = cabeza.siguiente;
        cabeza.anterior = null;
        tamaño_doble--;
        System.out.println("Eliminado: " + temp.element);
    }

    public void removerFinal() {
        if (tamaño_doble == 0) {
            throw new NoSuchElementException();
        }
        Nodo_Espera temp = cola;
        cola = cola.anterior;
        cola.siguiente = null;
        tamaño_doble--;
        System.out.println("Eliminado: " + temp.element);

    }

}
