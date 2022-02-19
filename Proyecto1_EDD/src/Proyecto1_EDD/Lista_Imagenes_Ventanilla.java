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
    public void AgragarNodoFinal(Object algo){
    if (cabeza == null){
    cabeza = new Nodo_Imagenes(algo);
    }else{
        Nodo_Imagenes actual = cabeza;
        Nodo_Imagenes nuevo = new Nodo_Imagenes(algo);
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
    if (temp == null){
    System.out.println("La lista imagenes esta vacia");
    }else{
        while (temp.getSiguiente() != null){
    data =data+"-->"+ temp.getElemento().toString(); 
    temp = temp.getSiguiente();
    }
    data =data+"-->"+temp.getElemento().toString();
    System.out.println(data);
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
    public void ExportarImpresoras(Cola_BW colaBW, Cola_Color colaC){
    Nodo_Imagenes actual =cabeza;
    while(actual.getSiguiente() != null){
        
        Object imagen = ((Imagen)actual.getElemento()).tipo;
        int numimpresora = ((Imagen)actual.getElemento()).impresora;
        if(numimpresora == 1){
        // Impresora Blaco y negro
        colaBW.AgregarNodoInicio(imagen);
        }else if(numimpresora == 0){
        // Impresora Color
        colaC.AgregarNodoInicio(imagen);
        }  
        actual = actual.getSiguiente();
        System.out.println("Esta cola color");
        //colaC.imprimir();
        
        System.out.println("Esta cola BW");
        colaBW.imprimir();
        
    }
    
    
    }
    public void eliminarTodo(){
    cabeza = null;
    }
    
    
    public String GraficarNodos(String vent,int cont){
    Nodo_Imagenes actual = cabeza;
    Nodo_Imagenes actual2 = cabeza;
    Nodo_Imagenes head = cabeza;
    String Data = "\n";
    int contador = 1;
    if(actual == null){
     Data = Data+"Ventanilla"+cont+"->"+"NuLL \n";
      
    
    
    }else{
    
    Data = Data+"Ventanilla"+cont+"->"+"Imagen"+vent+contador+"\n";
        while (actual.getSiguiente() != null){
        
        Data = Data + "Imagen"+vent+contador+"[label=\""+((Imagen)(actual.getElemento())).getTipo()+((Imagen)(actual.getElemento())).getId()+contador+"\"];\n";
        actual = actual.getSiguiente();
        contador++;
    }
    Data = Data + "Imagen"+vent+contador+"[label=\""+((Imagen)(actual.getElemento())).getTipo()+((Imagen)(actual.getElemento())).getId()+contador+"\"];\n";
    Data = Data + "";
    
    cabeza = head;
    contador = 1;
    while (actual2.getSiguiente() != null){
        
        Data = Data + "Imagen"+vent+contador+"->Imagen"+vent+(contador+1)+"\n";
        actual2 = actual2.getSiguiente();
        contador++;
    }
    Data = Data + "Imagen"+vent+contador+"->NuLL"+contador+" \n ";
    
    
    
    }
    
    
    return Data;
    }
    
    
    
    
    }
