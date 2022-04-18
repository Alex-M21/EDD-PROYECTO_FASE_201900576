/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_3;

public class ArbolB {

    int orden_arbol = 5;
    RamaB raiz;

    public ArbolB() {
        this.raiz = null;
    }

    public void insertar(int id) {
        NodoB nodo = new NodoB(id);
        if (raiz == null) {
            raiz = new RamaB();
            raiz.insertar(nodo);
        } else {
            NodoB obj = insertar_en_rama(nodo, raiz);
            if (obj != null) {
                //si devuelve algo el metodo de insertar en rama quiere decir que creo una nueva rama, y se debe insertar en el arbol
                raiz = new RamaB();
                raiz.insertar(obj);
                raiz.hoja = false;
            }
        }
    }

    private NodoB insertar_en_rama(NodoB nodo, RamaB rama) {
        if (rama.hoja) {
            rama.insertar(nodo);
            if (rama.contador == orden_arbol) {
                //si ya se insertaron todos los elementos posibles se debe dividir la rama
                return dividir(rama);
            } else {
                return null;
            }
        } else {
            NodoB temp = rama.primero;
            do {
                if (nodo.id == temp.id) {
                    return null;
                } else if (nodo.id < temp.id) {
                    NodoB obj = insertar_en_rama(nodo, temp.izquierda);
                    if (obj instanceof NodoB) {
                        rama.insertar((NodoB) obj);
                        if (rama.contador == orden_arbol) {
                            return dividir(rama);
                        }
                    }
                    return null;
                } else if (temp.siguiente == null) {
                    NodoB obj = insertar_en_rama(nodo, temp.derecha);
                    if (obj instanceof NodoB) {
                        rama.insertar((NodoB) obj);
                        if (rama.contador == orden_arbol) {
                            return dividir(rama);
                        }
                    }
                    return null;
                }
                temp = (NodoB) temp.siguiente;
            } while (temp != null);
        }
        return null;
    }

    private NodoB dividir(RamaB rama) {
        int val = -999;
        NodoB temp, Nuevito;
        NodoB aux = rama.primero;
        RamaB rderecha = new RamaB();
        RamaB rizquierda = new RamaB();

        int cont = 0;
        while (aux != null) {
            cont++;
            //implementacion para dividir unicamente ramas de 4 nodos
            if (cont < 3) {
                temp = new NodoB(aux.id);
                temp.izquierda = aux.izquierda;
                if (cont == 2) {
                    temp.derecha = aux.siguiente.izquierda;
                } else {
                    temp.derecha = aux.derecha;
                }
                //si la rama posee ramas deja de ser hoja
                if (temp.derecha != null && temp.izquierda != null) {
                    rizquierda.hoja = false;
                }

                rizquierda.insertar(temp);

            } else if (cont == 3) {
                val = aux.id;
                
            } else {
                temp = new NodoB(aux.id);
                temp.izquierda = aux.izquierda;
                temp.derecha = aux.derecha;
                
                //si la rama posee ramas deja de ser hoja
                if (temp.derecha != null && temp.izquierda != null) {
                    rderecha.hoja = false;
                }
                rderecha.insertar(temp);
            }
            aux = aux.siguiente;
        }
        Nuevito = new NodoB(val);
        Nuevito.derecha = rderecha;
        Nuevito.izquierda = rizquierda;
        
     
        return Nuevito;
    }
    
     public NodoB dividirRama(RamaB rama) {
        RamaB derecha = new RamaB();
        RamaB izquierda = new RamaB();
        NodoB medio = null;
        NodoB temp = rama.primero;

        int inicio = 1;
        
        int valorMedio = ((int)(orden_arbol / 2)) + 1;
        int fin = orden_arbol;
        for (int i = 1; i < orden_arbol + 1; i++, temp = temp.siguiente) {
            NodoB nodo = new NodoB(temp.id);
            nodo.izquierda = temp.izquierda;
            nodo.derecha = temp.derecha;

            if (nodo.derecha != null && nodo.izquierda != null) {
                izquierda.hoja = false;
                derecha.hoja = false;
            }

            if (i >= inicio && i < valorMedio) {
                izquierda.insertar(nodo);
            } else if (i == valorMedio) {
                medio = nodo;
            } else if (i <= fin && i > valorMedio) {
                derecha.insertar(nodo);
            }
        }
        
        medio.izquierda = izquierda;
        medio.derecha = derecha;
        return medio;
    }
    
    public void InOrder(RamaB raiz){
     if(raiz != null){
     InOrder(raiz.primero.izquierda);
     System.out.println(raiz.print());   
     InOrder(raiz.primero.derecha);
     }
    
    }
    

}