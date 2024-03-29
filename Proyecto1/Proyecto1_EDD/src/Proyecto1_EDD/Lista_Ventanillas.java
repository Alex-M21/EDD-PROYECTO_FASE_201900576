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
    
    public boolean IterarTodo() {
        Nodo_Ventanillas temp = cabeza;
        int contador = 0;
        int tamaño = size;
        boolean terminado = false;

        
        while (temp.getSiguiente() != null) {
            if (temp.getArriba() == null) {
                contador++;
            }
            temp = temp.getSiguiente();
        }
       
        if (temp.getSiguiente() == null) {
            if (temp.getArriba() == null) {
                contador++;
            }
        }
        System.out.println("El contador llego a:" + contador + "/" + tamaño);
        
        if (contador == tamaño) {
            terminado = true;
        } else {
            terminado = false;
            //    }
        }
        return terminado;
    }

    public void AgregarNodoInicio(Object algo,int id) {
        // Cuando la lista esta vacia
        if (cabeza == null) {
            cabeza = new Nodo_Ventanillas(algo,id);
            // cuando la lista esta llena
        } else {
            Nodo_Ventanillas temp = cabeza;
            Nodo_Ventanillas nuevo = new Nodo_Ventanillas(algo,id);
            nuevo.linkSiguiente(temp);
            cabeza = nuevo;
        }
        size++;

    }
    public void AgragarNodoFinal(Object algo,int id){
    if (cabeza == null){
    cabeza = new Nodo_Ventanillas(algo,id);
    }else{
        Nodo_Ventanillas actual = cabeza;
        Nodo_Ventanillas nuevo = new Nodo_Ventanillas(algo,id);
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
    if(cliente != null){
    while(temp.getArriba()!= null){
        temp = temp.getSiguiente();
    }
    System.out.println("La"+temp.getElemento());
    Nodo_Recepcion cli = new Nodo_Recepcion(cliente);
    temp.linkArriba(cli);
    System.out.println("ingreso un cliente:"+((Cliente)cli.getElemento()).getNombre());
    
    }
    
    
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
        
        String imgBWconv = ((Cliente)obtener).getImg_BW();
        String imgCconv = ((Cliente)obtener).getImg_C();
        String Id = ((Cliente)obtener).getId();
        int n_imgBWconv = Integer.parseInt(imgBWconv);
        int n_imgCconv = Integer.parseInt(imgCconv);
        
        for(int b=0;b<n_imgBWconv;b++){
        System.out.println("Imagen Blanco y negro ");
        nv.lstImgVent.AgragarNodoFinal(new Imagen("Imagen Blanco y Negro",Id,1));
        
        }
        for(int c=0;c<n_imgCconv;c++){
        System.out.println("Imagen Color");
        nv.lstImgVent.AgragarNodoFinal(new Imagen("Imagen Color",Id,0));
        
        }
        
        
    
    }
    
    public void VerImagenes(Object ventanilla){
         Nodo_Ventanillas nv = cabeza;
      
        
        while(nv.getElemento() != ventanilla && nv.getSiguiente() != null){
            
        nv = nv.getSiguiente();
        }
        nv.lstImgVent.imprimir();
    
    
    
    
    }
    
    public void tomarImagenClienteBW(int id){
    
     Nodo_Ventanillas nv = cabeza;
      
        
        while(nv.id != id && nv.getSiguiente() != null){
            
        nv = nv.getSiguiente();
        }
        String c21 = ((Cliente)nv.arriba.getElemento()).getImg_BW();
        String Id = ((Cliente)nv.arriba.getElemento()).getId();
        int c04 = Integer.parseInt(c21);
        c04 =  c04-1;
        String c101 = c04+"";
        ((Cliente)nv.arriba.getElemento()).setImg_BW(c101);
        nv.lstImgVent.AgragarNodoFinal(new Imagen("Imagen BW",Id,1));
        System.out.println(((Cliente)nv.arriba.getElemento()).getImg_BW());
       
    }
    public int RevisarCliente(){
        int ventanillaVacia = 0;
        Nodo_Ventanillas nv = cabeza;
        int contador = 1;
        
        do{
            if(nv.getArriba() == null){
            ventanillaVacia = contador;
            }
            nv = nv.getSiguiente();
        contador++;
        
        }while(nv.getSiguiente() != null);
        
    return ventanillaVacia;
    }
    
    public boolean tomarImagenCliente(int id){
    boolean vacio = false;
     Nodo_Ventanillas nv = cabeza;
      
        
        while(nv.id != id && nv.getSiguiente() != null){
            
        nv = nv.getSiguiente();
        }
        if(nv.getArriba() != null){
            System.out.println("Buscamos ventanilla "+ id);
        System.out.println("Este es el elemento "+nv.getElemento());
        String c99 = ((Cliente)nv.arriba.getElemento()).getImg_C();
        String Id = ((Cliente)nv.arriba.getElemento()).getId();
        int c100 = Integer.parseInt(c99);
        String c21 = ((Cliente)nv.arriba.getElemento()).getImg_BW();
       
        int c04 = Integer.parseInt(c21);
        
        if (c100 > 0){
        c100 =  c100-1;
        String c101 = c100+"";
        ((Cliente)nv.arriba.getElemento()).setImg_C(c101);
        nv.lstImgVent.AgragarNodoFinal(new Imagen("Imagen Color",Id,0));
        System.out.println("Imgenes color restantes:"+((Cliente)nv.arriba.getElemento()).getImg_C());
        vacio = false;
        }else if(c100 == 0 && c04 > 0 ){
        
        c04 =  c04-1;
        String c101 = c04+"";
        ((Cliente)nv.arriba.getElemento()).setImg_BW(c101);
        nv.lstImgVent.AgragarNodoFinal(new Imagen("Imagen BW",Id,1));
        System.out.println("Imagenes BW restantes: "+((Cliente)nv.arriba.getElemento()).getImg_BW());
        vacio = false;
        
        }else {
        
        System.out.println("el cliente ya no tiene imagenes");
        vacio = true;
        }
        
        }else{
        System.out.println("No existe el cliente");
        }
        
         
        
       return vacio;
    }
    
    
    
    public void SalidaCliente(int ventanilla,Lista_Circular lstEspera ,Cola_BW bw,Cola_Color color){
    Nodo_Ventanillas temp = cabeza;
    boolean redflag = false;
    System.out.println("Ventanilla buscada = "+ventanilla);
    if(temp.id == ventanilla){
     System.out.println("este es temp: "+ temp.getElemento());
     System.out.println("Se eliminara el cliente"+temp.getElemento());
     Object clienteSale = temp.arriba.getElemento();
     
     lstEspera.ingresar(clienteSale);
     temp.lstImgVent.ExportarImpresoras(bw,color);
     System.out.println("Esta parte se cortara:");
     temp.lstImgVent.imprimir();
     System.out.println("cortada:");
     temp.lstImgVent.eliminarTodo();
     //temp.lstImgVent.imprimir();
     
     temp.linkArriba(null);
     
    }else{
         while(temp.id != ventanilla || redflag == true ){
       
    temp = temp.getSiguiente();
    if(temp.getSiguiente()== null){
    redflag = true;
    break;
    }
    }
     System.out.println("Se encontro la: "+ temp.getElemento()  );
     System.out.println("Se eliminara el cliente"+temp.getElemento());
     Object clienteSale = temp.arriba.getElemento();
     
     lstEspera.ingresar(clienteSale);
     lstEspera.ingresar(clienteSale);
     temp.lstImgVent.ExportarImpresoras(bw,color);
     System.out.println("Esta parte se cortara:");
     temp.lstImgVent.imprimir();
     System.out.println("cortada:");
     temp.lstImgVent.eliminarTodo();
     temp.lstImgVent.imprimir();
     
     temp.linkArriba(null);
    
    }
   
    }
    
    public void EnviarImgCola(Cola_BW bw,Cola_Color color){
    Nodo_Ventanillas actual = cabeza;
    if (actual == null){
    System.out.println("Esta es la lista vacia");
    
    }else{
    actual.lstImgVent.ExportarImpresoras(bw,color);
        
    
    }
    }
    
    public void imprimirArriba(){
    Nodo_Ventanillas temp = cabeza;
    while(temp.getSiguiente()!=null){
        
        temp = temp.getSiguiente();
    }
    
    }
    
    
    public void imprimir(){
    Nodo_Ventanillas temp = cabeza;
    String data = "";
    if(cabeza != null){
    while (temp.getSiguiente() != null){
    data ="--->"+temp.getElemento().toString()+data; 
    temp = temp.getSiguiente();
    }
    data =data+"-->"+temp.getElemento().toString();
    System.out.println(data);
    }else{
    System.out.println("La lista Ventanillas esta vacia :( ");
    
    }
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
    
     public String GraficarNodos(){
    Nodo_Ventanillas actual = cabeza;
    Nodo_Ventanillas actual2 = cabeza;
    Nodo_Ventanillas head = cabeza;
    String Data = "digraph G {\n";
    int contador = 1;
         while (actual.getSiguiente() != null) {
             //Extraemos el nodo prinicipa 
             Data = Data + "Ventanilla" + contador + "[label=\"" + (actual.getElemento()) + "\"];\n";
             // Extraemos el nodo Cliente
             if (actual.getArriba() != null) {
                 Data = Data + "Ventanilla" + contador + "->" + "Cliente" + ((Cliente) ((Nodo_Recepcion) actual.getArriba()).getElemento()).getId() + "\n";
             // si esta vacio imprime null 
             } else {
                 Data = Data + "Ventanilla" + contador + "->" + "NuLl"+contador+"\n";
             }
             //Extraemos la lista de imagenes
               if(actual.lstImgVent.size > 0){
                   
                   String ref = "vent"+contador;
         Data = Data + actual.lstImgVent.GraficarNodos(ref,contador);
         
         
         }else if(actual.lstImgVent.size == 0){
         Data = Data + "Ventanilla"+contador+"->"+"Null"+contador+"\n";
         }
             
             
             actual = actual.getSiguiente();
             contador++;
         }
         // Estraemos nodo principal
         Data = Data + "Ventanilla" + contador + "[label=\"" + (actual.getElemento()) + "\"];\n";
         // Extraemos el nodo cliente
         if (actual.getArriba() != null) {
             Data = Data + "Ventanilla" + contador + "->" + "Cliente" + ((Cliente) ((Nodo_Recepcion) actual.getArriba()).getElemento()).getId() + "\n";
         //si esta vacio lo dirijimos a nulo
         } else {
             Data = Data + "Ventanilla" + contador + "->" + "NulL"+contador+"\n";
         }
         //Extraemos lista imagnes imagenes
         if(actual.lstImgVent.size > 0){
             String ref = "vent"+contador;
         Data = Data + actual.lstImgVent.GraficarNodos(ref,contador);

         
         
         }else if(actual.lstImgVent.size == 0){
         Data = Data + "Ventanilla"+contador+"->"+"NUll"+contador+"\n";
         }
         
         
         
         
         Data = Data + "";
         cabeza = head;
         contador = 1;
         while (actual2.getSiguiente() != null) {

             Data = Data + "Ventanilla" + contador + "->Ventanilla" + (contador + 1) + ";\n";
             actual2 = actual2.getSiguiente();
             contador++;
         }
    Data = Data + "Ventanilla"+contador+"->NULL"+contador+"}\n";
    
    return Data;
    
    
    }
    
    public void CrearTxt(String Data){
    try {   //C:\Users\braya\OneDrive\Documentos\NetBeansProjects\Proyecto1_EDD\src\Code\\+fNombre+".txt";
            String ruta = "C:\\Users\\braya\\OneDrive\\Documentos\\NetBeansProjects\\Proyecto1_EDD\\src\\Code\\Lista Ventanillas.txt";
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
      
      String RutaEntrada = "C:\\Users\\braya\\OneDrive\\Documentos\\NetBeansProjects\\Proyecto1_EDD\\src\\Code\\Lista Ventanillas.txt";
      String RutaSalida = "C:\\Users\\braya\\OneDrive\\Documentos\\NetBeansProjects\\Proyecto1_EDD\\src\\Graficas\\Lista Ventanillas.jpg";
      
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
