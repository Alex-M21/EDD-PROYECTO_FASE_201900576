/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.math.BigInteger;

/**
 *
 * @author braya
 */
public class TablaHash {
    public int size;
    public int tarray;
    public Object arrayHash[]; 
    // numero primo no necesariamente cercano a 2
    public TablaHash(int tamaño){
    this.size = tamaño;
    this.tarray = tamaño;
    this.arrayHash = new Object[tarray];
    
    }
    //120, 0-12
    public int hash(String k){
       int key = 0;
       BigInteger a = new BigInteger(k);
       String tamaño = size+"";
       BigInteger b = new BigInteger(tamaño);
       String g = a.remainder(b)+"";
       key = Integer.parseInt(g);
       
    return key;
    }
    
    public Integer rehash(String k, int i){
    int key = 0;
    BigInteger a = new BigInteger(k);
    BigInteger b = new BigInteger("7");
   
    String g = a.remainder(b)+"";
    int prekey = Integer.parseInt(g);
    key = (prekey+1)*i;
    return key;
    }
    
    public void rehashing() {
        // Obtenemos numero primo 
        int tam = size + 1;
        System.out.println("este es el tam siguiente: " + tam);
        while (ValPrimo(tam) != true) {
            tam++;
        }
        System.out.println("El siguiente primo es: " + (tam));
        Object aux[] = new Object[size];
        for (int j = 0; j < aux.length; j++) {
            aux[j] = arrayHash[j];
        }
        System.out.println("Copiando lista");
        size = tam;
        System.out.println("Redimensionando Array");
        arrayHash = new Object[size];
        System.out.println("Ingresamos copia a nuevo array");
        for (int l = 0; l < aux.length; l++) {
            arrayHash[l] = aux[l];
        }

    }
    
    public boolean valLLenado(){
    int lleno = 0;
    boolean valido = false;
    for(int i=0;i<arrayHash.length;i++){
    if(arrayHash[i]!=null){
    lleno++;
    }
    }
    double porcentaje =((double)(lleno*100)/size);
    System.out.println("porcetaje de llenado"+porcentaje+"El valor tamaño es: "+arrayHash.length+"El valor de lleno"+lleno);
    if(porcentaje >= 75){
    valido = true;
    }else{
    valido = false;
    }
    return valido;
    }
    
    public boolean ValPrimo(int numero){
        int contador = 2;
        boolean primo = true;
        while ((primo) && (contador != numero)) {
            if (numero % contador == 0) {
                primo = false;
            }
            contador++;
        }
        return primo;
    }
    
   
    
    public void buscar(long k){
    for(int j = 0;j<arrayHash.length;j++){
    System.out.println("Este es un nodo hash: "+arrayHash[j]);
    }
    }
    
    public void insertar(Object k) {
        if (valLLenado() == false) {
            String dpi = ((Mensajero)k).DPI;
            int getHash = hash(dpi);
            System.out.println("este es el key BI: "+ getHash);
            int contador = 0;
            while (contador != getHash) {
                contador++;
            }
            if(arrayHash[contador] == null){
            arrayHash[contador] = k;
            System.out.println("se agrego correctamente");
            }else{
            System.out.println("se necesita rehash");
            contador = 1;
            boolean validado = false;
                    
                    while(validado != true){
                        
                        int getrehash = rehash(dpi,contador);
                        
                        if (arrayHash[getrehash] == null) {
                            arrayHash[getrehash] = k;
                            validado = true;
                            System.out.println("Se acepto el rehash");
                        } else {
                            System.out.println("No se acepto el rehash,numero iterador : " + contador);
                            validado = false;
                        }
                        contador++;
                    }
            }
        } else {
            // hacer rehashing agregar el siguiente primo
            System.out.println("realizar un rehashin de la tabla");
            rehashing();
               
        }
    }
    
    public void Imprimir(){
        String data = "";
        //System.out.println("Este es el tamaño del arreglo: "+ (size));
    for(int z = 0;z<arrayHash.length;z++){
        if(arrayHash[z] == null){
        System.out.println("|  "+"Index"+(z+1)+"  |");     
       
        }else{
        System.out.println("|  "+arrayHash[z]+"  |");
        }
    
    }
    
    }
    
    public String GenerarGrafo(){
        String data = "digraph D {\n" +
"\n" +
"  node [shape=plaintext] \n";
        data += "same_node [ \n";
        data += "label=<\n" +
"     <table border=\"0\" cellborder=\"1\" cellspacing=\"0\"> \n";
        for (int z = 0; z < arrayHash.length; z++) {
            if (arrayHash[z] == null) {
                data += "<tr><td bgcolor=\"yellow\">Index "+(z+1)+"</td><td bgcolor=\"yellow\">Vacio</td></tr>\n";
            } else {
                data += "<tr><td bgcolor=\"lightblue\"><font color=\"#0000ff\">Index "+(z+1)+"</font></td><td bgcolor=\"lightblue\"> DPI: "+((Mensajero)arrayHash[z]).DPI+", Nombre: "+((Mensajero)arrayHash[z]).Nombres+"</td> </tr>\n";
            }
    }
        data+=" </table>>\n" +
"  ];\n";
                
        
        data+="}";
        return data;
    
}
    public void CrearTxt(String Data,String fNombre){
    try {   //C:\Users\braya\OneDrive\Escritorio\Salidas\Principal
            String ruta = "C:\\Users\\braya\\OneDrive\\Escritorio\\Salidas\\Principal\\"+fNombre+".txt";
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
      
      String RutaEntrada = "C:\\Users\\braya\\OneDrive\\Escritorio\\Salidas\\Principal\\"+nombreE+".txt";
      String RutaSalida = "C:\\Users\\braya\\OneDrive\\Escritorio\\Salidas\\Principal\\"+nombreS+".jpg";
      
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
