/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_3;

/**
 *
 * @author braya
 */
public class TablaHash {
    private final Integer size;
    private Object arrayHash[]; 
    // numero primo no necesariamente cercano a 2
    public TablaHash(int tamaño){
    this.size = tamaño;
    this.arrayHash = new Object[size];
    
    }
    //120, 0-12
    public long hash(long k){
    long key = 0;
    key =k%size;
    return key;
    }
    
    public Integer rehash(int k, int i){
    int key = 0;
    key = ((k%7)+1)*i;
    return key;
    }
    
    public Object rehashing(){
    Object aux [] = arrayHash;
    Object nueva [] = new Object[1];
    return nueva;
    }
    
    public boolean valLLenado(){
    int lleno = 0;
    boolean valido = false;
    for(int i=0;i<arrayHash.length;i++){
    if(arrayHash[i]!=null){
    lleno++;
    }
    }
    int porcentaje =((int)(lleno*100)/size);
    if(porcentaje > 75){
    valido = true;
    }else{
    valido = false;
    }
    return valido;
    }
    
   
    
    public void buscar(long k){
    for(int j = 0;j<arrayHash.length;j++){
    System.out.println("Este es un nodo hash: "+arrayHash[j]);
    }
    }
    
    public void insertar(long k) {
        if (valLLenado() == false) {
            long getHash = hash(k);
            System.out.println("este es el key long: "+ getHash);
            int contador = 0;
            while (contador != getHash) {
                contador++;
            }
            if(arrayHash[contador] == null){
            arrayHash[contador] = k;
            System.out.println("se agrego correctamente");
            }else{
            System.out.println("se necesita rehash");
            }
            

        } else {
            // hacer rehashing agregar el siguiente primo
            System.out.println("realizar un rehashin de la tabla");

        }
       
        
 
    }
    
}
