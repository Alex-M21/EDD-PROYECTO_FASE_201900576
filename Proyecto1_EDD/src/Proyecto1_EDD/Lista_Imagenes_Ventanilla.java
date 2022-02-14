/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto1_EDD;

/**
 *
 * @author braya
 */
public class Lista_Imagenes_Ventanilla {
    Nodo_Imagenes cabeza;

    int size;

    public Lista_Imagenes_Ventanilla() {
        cabeza = null;
        
        size = 0;
    }

    public boolean ValVacio() {
        return (cabeza == null) ? true : false;
    }

    public void AgregarNodoInicio(Object algo,Object id) {
        // Cuando la lista esta vacia
        if (cabeza == null) {
            cabeza = new Nodo_Imagenes(algo,id);
            // cuando la lista esta llena
        } else {
            Nodo_Imagenes temp = cabeza;
            Nodo_Imagenes nuevo = new Nodo_Imagenes(algo,id);
            nuevo.linkSiguiente(temp);
            cabeza = nuevo;
        }
        size++;

    }
    public void AgragarNodoFinal(Object algo,Object id){
    if (cabeza == null){
    cabeza = new Nodo_Imagenes(algo,id);
    }else{
        Nodo_Imagenes actual = cabeza;
        Nodo_Imagenes nuevo = new Nodo_Imagenes(algo,id);
        while (actual.getSiguiente() != null){
            actual = actual.getSiguiente();
        }
        actual.linkSiguiente(nuevo);
        nuevo.linkSiguiente(null);
    }
    size++;
    }
    
    public void imprimir(){
    Nodo_Imagenes temp = cabeza;
    String data = "";
    while (temp.getSiguiente() != null){
    data =data+"-->"+ temp.getElemento().toString(); 
    temp = temp.getSiguiente();
    }
    data =data+"-->"+temp.getElemento().toString();
    System.out.println(data);
    }

    public int tamaño() {
        return size;
    }

    public Object ObtenerNodo(int index) {
        int contador = 0;
        Nodo_Imagenes temporal = cabeza;
        while (contador != index) {
            temporal = temporal.getSiguiente();
            contador++;
        }
        return temporal.getElemento();
    }
    public Object ObtenerPrimero(){
    Nodo_Imagenes temporal = cabeza;
    Nodo_Imagenes temporal2 = cabeza;
    int contador = 0;
    int contador2 = 0; 
    while(temporal.getSiguiente() != null){
    temporal = temporal.getSiguiente();
    contador++;
    }
    temporal.getElemento();
    while(contador2 != contador-1){
    temporal2 = temporal2.getSiguiente();
    }
    temporal2.linkSiguiente(null);
    return temporal.getElemento();
    }

    public void EliminarNodo(int index) {
        if (index == 0) {
            cabeza = cabeza.getSiguiente();
        } else if (index == size - 1) {
            int cont = 0;
            Nodo_Imagenes actual = cabeza;
            while (cont != index - 2) {
                actual = actual.getSiguiente();
                cont++;
            }
            actual.linkSiguiente(null);
        } else {
            int cont = 0;
            Nodo_Imagenes temporal = cabeza;
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
        Nodo_Imagenes temp = cabeza;
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
}
