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
    public void tomarImagenCliente(int id){
    
     Nodo_Ventanillas nv = cabeza;
      
        
        while(nv.id != id && nv.getSiguiente() != null){
            
        nv = nv.getSiguiente();
        }
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
        
        }else if(c100 == 0 && c04 > 0 ){
        
        c04 =  c04-1;
        String c101 = c04+"";
        ((Cliente)nv.arriba.getElemento()).setImg_BW(c101);
        nv.lstImgVent.AgragarNodoFinal(new Imagen("Imagen BW",Id,1));
        System.out.println("Imagenes BW restantes: "+((Cliente)nv.arriba.getElemento()).getImg_BW());
        
        
        }else {
        
        System.out.println("el cliente ya no tiene imagenes");
        
        }
        
       
    }
    
    
    public void SalidaCliente(int ventanilla,Lista_Espera lstEspera){
    Nodo_Ventanillas temp = cabeza;
    boolean redflag = false;
    System.out.println("Ventanilla buscada = "+ventanilla);
    if(temp.id == ventanilla){
     System.out.println("este es temp: "+ temp.getElemento());
     System.out.println("Se eliminara el cliente"+temp.getElemento());
     Object clienteSale = temp.arriba.getElemento();
     
     lstEspera.AgreagarCircularInicio(clienteSale);
     
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
     
     lstEspera.AgreagarCircularInicio(clienteSale);
     temp.linkArriba(null);
    
    }
   
    }
    
    public void EnviarImgCola(){
    
    
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
}
