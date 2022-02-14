/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto1_EDD;

/**
 *
 * @author braya
 */
public class Lista_Ventanillas {
    Nodo_Ventanillas cabeza;

    int size;

    public Lista_Ventanillas() {
        cabeza = null;
        
        size = 0;
    }

    public boolean ValVacio() {
        return (cabeza == null) ? true : false;
    }

    public void AgregarNodoInicio(Object algo) {
        // Cuando la lista esta vacia
        if (cabeza == null) {
            cabeza = new Nodo_Ventanillas(algo);
            // cuando la lista esta llena
        } else {
            Nodo_Ventanillas temp = cabeza;
            Nodo_Ventanillas nuevo = new Nodo_Ventanillas(algo);
            nuevo.linkSiguiente(temp);
            cabeza = nuevo;
        }
        size++;

    }
    public void AgragarNodoFinal(Object algo){
    if (cabeza == null){
    cabeza = new Nodo_Ventanillas(algo);
    }else{
        Nodo_Ventanillas actual = cabeza;
        Nodo_Ventanillas nuevo = new Nodo_Ventanillas(algo);
        while (actual.getSiguiente() != null){
            actual = actual.getSiguiente();
        }
        actual.linkSiguiente(nuevo);
        nuevo.linkSiguiente(null);
    }
    size++;
    }
    
    public void IngresoCliente(Object cliente){
    Nodo_Ventanillas temp = cabeza;
    while(temp.getArriba()!= null){
        temp = temp.getSiguiente();
    }
    System.out.println("La"+temp.getElemento());
    Nodo_Recepcion cli = new Nodo_Recepcion(cliente);
    temp.linkArriba(cli);
    System.out.println("ingreso un cliente:"+((Cliente)cli.getElemento()).getNombre());
    
    }
    
    public void ProcesarImagenes(Object ventanilla){
        Nodo_Ventanillas nv = cabeza;
      
        
        while(nv.getElemento() != ventanilla && nv.getSiguiente() != null){
            
        nv = nv.getSiguiente();
        }
        Object obtener = ((Nodo_Recepcion)nv.getArriba()).getElemento();
        System.out.println("Se encontro la ventanilla: ");
         System.out.println("El cliente solicito N : "+((Cliente)obtener).Nombre);
        System.out.println("El cliente solicito I BW: "+((Cliente)obtener).getImg_BW());
        System.out.println("El cliente solicito I C: "+((Cliente)obtener).getImg_C());
        
        
    
    
    }
    
    public void EntrgarImagenes(){
    
    
    
    
    }
    
    public void SalidaCliente(){
    Nodo_Ventanillas temp = cabeza;
    
    Nodo_Recepcion cl = temp.getArriba();
    System.out.println("Esta ventanilla aatiende al cliente:"+cl.getElemento());
 
    
    }
    
    
    
    
    public void imprimir(){
    Nodo_Ventanillas temp = cabeza;
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
        Nodo_Ventanillas temporal = cabeza;
        while (contador != index) {
            temporal = temporal.getSiguiente();
            contador++;
        }
        return temporal.getElemento();
    }
    public Object ObtenerPrimero(){
    Nodo_Ventanillas temporal = cabeza;
    Nodo_Ventanillas temporal2 = cabeza;
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
            Nodo_Ventanillas actual = cabeza;
            while (cont != index - 2) {
                actual = actual.getSiguiente();
                cont++;
            }
            actual.linkSiguiente(null);
        } else {
            int cont = 0;
            Nodo_Ventanillas temporal = cabeza;
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
        Nodo_Ventanillas temp = cabeza;
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
