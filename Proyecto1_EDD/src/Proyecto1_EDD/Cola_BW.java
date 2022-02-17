/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto1_EDD;

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
}

