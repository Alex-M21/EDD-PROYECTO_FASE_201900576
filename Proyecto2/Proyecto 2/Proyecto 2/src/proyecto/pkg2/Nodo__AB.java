
package proyecto.pkg2;

public class Nodo__AB {
    int dato;
    String nombre;
    String id;
    Nodo__AB Izquierda,Derecha;
    MD MatrizCapa;
    
    public Nodo__AB (int d,String nom,String id,MD capa){
    this.dato = d;
    this.nombre = nom;
    this.Derecha = null;
    this.Izquierda = null;
    this.id = id;
    this.MatrizCapa = new MD();
    }
    public String toString(){
    return nombre +" Su dato es "+dato;
    }
}
