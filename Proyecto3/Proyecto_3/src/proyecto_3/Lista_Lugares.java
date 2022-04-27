/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_3;

public class Lista_Lugares {
    Nodo_Lista_Simple cabeza;
    int size;

    public Lista_Lugares() {
        cabeza = null;
        size = 0;
    }

    public boolean ValVacio() {
        return (cabeza == null) ? true : false;
    }

    public void AgregarNodoInicio(Object algo) {
        // Cuando la lista esta vacia
        if (cabeza == null) {
            cabeza = new Nodo_Lista_Simple(algo);
            // cuando la lista esta llena
        } else {
            Nodo_Lista_Simple temp = cabeza;
            Nodo_Lista_Simple nuevo = new Nodo_Lista_Simple(algo);
            nuevo.linkSiguiente(temp);
            cabeza = nuevo;
        }
        size++;
    }
    public String imprimir(){
    Nodo_Lista_Simple temp = cabeza;
    String data = "";
    if(cabeza != null){
    
    while (temp.getSiguiente() != null){
    data =data+"-->"+temp.getDato(); 
    temp = temp.getSiguiente();
    }
    data =data+"-->"+temp.getDato();
    System.out.println(data);
    }else{
    data += "La lista Simple esta vacia";
    
    }
    return data;
    
    }
    
}
