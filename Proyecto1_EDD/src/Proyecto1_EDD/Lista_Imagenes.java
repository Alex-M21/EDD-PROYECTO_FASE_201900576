/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto1_EDD;

/**
 *
 * @author braya
 */
public class Lista_Imagenes {
    Nodo_Imagenes cabeza;

    int size;

    public Lista_Imagenes() {
        cabeza = null;
        
        size = 0;
    }

    public boolean ValVacio() {
        return (cabeza == null) ? true : false;
    }

    public void AgregarNodoInicio(Object algo) {
        // Cuando la lista esta vacia
        if (cabeza == null) {
            cabeza = new Nodo_Imagenes(algo);
            // cuando la lista esta llena
        } else {
            Nodo_Imagenes temp = cabeza;
            Nodo_Imagenes nuevo = new Nodo_Imagenes(algo);
            nuevo.linkSiguiente(temp);
            cabeza = nuevo;
        }
        size++;

    }
    
    public void imprimir(){
    Nodo_Imagenes temp = cabeza;
    
    if(cabeza != null){
    String data = "";
    while (temp.getSiguiente() != null){
    data =data+"-->"+((Cliente)temp.getElemento()).getNombre(); 
    temp = temp.getSiguiente();
    }
    data =data+"-->"+((Cliente)temp.getElemento()).getNombre();
    System.out.println(data);
    }else{
    System.out.println("La lista esta vacia");
    
    }
    
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
    Object retorno;
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
    temporal2.linkSiguiente(null);
    
    
    
    }else{
    retorno = cabeza.getElemento();
    cabeza = null;
    
    
    }
   return retorno;
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
