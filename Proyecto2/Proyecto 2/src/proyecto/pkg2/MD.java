
package proyecto.pkg2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class MD {
    Nodo_M root=new Nodo_M(-1,-1,"Root"); 

  
    
    //Buscamos columna
    public Nodo_M buscar_Col(int x) {
        Nodo_M aux = root;
        while (aux != null) {
            if (aux.posX == x) {
                return aux;
                
            }
            aux = aux.siguiente;

        }
        return null;
    }
    
    // Buscamos por Filas 
    public Nodo_M buscar_Fil(int y){
        Nodo_M aux = root;
        while (aux != null) {
            if (aux.posY == y) {
                return aux;
            }
            aux = aux.abajo;
        }
        return null;
    }
    
    public Nodo_M crear_Col(int x) {
        Nodo_M nodo_col = root;
        Nodo_M nuevo = new Nodo_M(x, -1, "COLUM");
        Nodo_M columna = insertar_orden_col(nuevo, nodo_col);
        return columna;
    }

    public Nodo_M insertar_orden_col(Nodo_M nuevo, Nodo_M nodo_col) {
        Nodo_M aux = nodo_col;
        boolean insertado = false;
        while (true) {
            if (nuevo.posX == aux.posX) {
                aux.posY = nuevo.posY;
                aux.Dato = nuevo.Dato;
                return aux;

            } else if (aux.posX > nuevo.posX) {
                insertado = true;
                break;
            }
            if (aux.siguiente != null) {

                aux = aux.siguiente;
            } else {

                insertado = false;
                break;
            }

        }if (insertado){
        nuevo.siguiente = aux;
        aux.anterior.siguiente = nuevo;
        nuevo.anterior = aux.anterior;
        aux.anterior=nuevo;
        
        }
        else{
        aux.siguiente = nuevo;
        nuevo.anterior = aux;
        }
        return nuevo;
    }
    
    //Insertar Cabecera Fila
    public Nodo_M crear_fila(int y){
        Nodo_M nodo_fila=root;
        Nodo_M nuevo= new Nodo_M(-1,y,"Fila");
        Nodo_M columna = insertar_orden_fil(nuevo,nodo_fila);
        return columna;
                }
//Insertar en orden Filas

    public Nodo_M insertar_orden_fil(Nodo_M nuevo, Nodo_M cabeza_fila) {
        Nodo_M aux = cabeza_fila;
        boolean insertado = false;
        while (true) {
            if (nuevo.posY == aux.posY) {
                aux.posX = nuevo.posX;
                aux.Dato = nuevo.Dato;
                return aux;
            } else if (aux.posY > nuevo.posY) {
                //insertar en medio, antes del aux
                insertado = true;
                break;
            }
            if (aux.abajo != null) {
                aux = aux.abajo;
            } else {
                //insertar despues del auxiliar
                insertado = false;
                break;
            }
        }
        if (insertado) {
            nuevo.abajo = aux;
            aux.arriba.abajo = nuevo;
            nuevo.arriba = aux.arriba;
            aux.arriba = nuevo;
        } else {
            aux.abajo = nuevo;
            nuevo.arriba = aux;

        }
        return nuevo;
    }
       //Metodo para insertar   
    public void insertarNodo(int x, int y, Object dato){
        Nodo_M nuevo = new Nodo_M(x, y, dato);
        Nodo_M NodoColumna = buscar_Col(x);
        Nodo_M NodoFila = buscar_Fil(y);
        //Caso 1---No existe fila ni columna
        if (NodoFila == null && NodoColumna == null) {
            System.out.println("Caso1, ---No existe fila ni columna");
            //crear las cabeceras
            NodoColumna = crear_Col(x);
            NodoFila = crear_fila(y);
            //insertamos contenido
            nuevo = insertar_orden_col(nuevo,NodoFila);
            nuevo = insertar_orden_fil(nuevo,NodoColumna);
            
        } //Caso 2---No existe Fila, pero si columna
        else if (NodoFila == null && NodoColumna != null) {
            System.out.println("Caso2");
            //crear las cabeceras
            //NodoColumna=self.crear_columna(x)
            NodoFila = crear_fila(y);
            //insertamos contenido
            nuevo = insertar_orden_col(nuevo, NodoFila);
            nuevo = insertar_orden_fil(nuevo, NodoColumna);
           
        } //Caso 3---No existe columna, pero si fila
        else if (NodoFila != null && NodoColumna == null) {
            System.out.println("Caso3");
            //crear las cabeceras
            NodoColumna = crear_Col(x);
            //##NodoFila=self.crear_fila(y)
            //#insertamos contenido
            nuevo = insertar_orden_col(nuevo, NodoFila);
            nuevo = insertar_orden_fil(nuevo, NodoColumna);
          
        } //caso en el que si existe fila y columna
        else if (NodoFila != null && NodoColumna != null) {
            System.out.println("Caso4");
            //crear las cabeceras
            //NodoColumna=self.crear_columna(x);
            //NodoFila=self.crear_fila(y);
            //insertamos contenido
            nuevo = insertar_orden_col(nuevo, NodoFila);
            nuevo = insertar_orden_fil(nuevo, NodoColumna);
            
        }else{
        System.out.println("no entra en ningun caso");
        }
    }
    
    //Imprimir
    public String imprimir(){
        Nodo_M aux=root;
       
        while (aux != null) {
            String tex = "";
            Nodo_M aux2 = aux;
            while (aux2 != null) {
                tex += "[" + aux2.posX + aux2.posY + "]";
                aux2 = aux2.siguiente;
            
            }
            System.out.println(tex);
            aux = aux.abajo;
        }
        return null;
        }
    
    //Imprimir
    public MD ObtenerData(MD entrada){
        Nodo_M aux=root;
        MD Salida = new MD();
        while (aux != null) {
            String tex = "";
            Nodo_M aux2 = aux;
            while (aux2 != null) {
                Salida.insertarNodo(aux2.posX, aux2.posY, aux2.Dato);
                aux2 = aux2.siguiente;
            }
            System.out.println(tex);
            aux = aux.abajo;
        }
        return Salida;
        }
    
    public String GraphFilas(){
       Nodo_M aux=root;
        String vuelta = "";
        while (aux != null){
            String tex = "";
            String rank = "{rank=same;";
            Nodo_M aux2 = aux;
            Nodo_M next = aux.abajo;
            while (next != null){
                if(aux2.posX== -1 && aux2.posY == -1){
                     tex += "Nodo_fila"+"columna"+ "->"+"Nodo_fila"+"c"+next.posY+";\n";
                    
                      rank += "Nodo_fila" + "columna,";
                      rank += "Nodo_fila" +"c"+next.posY+"," ;
                next = next.abajo;
                aux2 = aux2.abajo;
                }else if(aux2.posX == -1 && next.posX == -1){
                    tex += "Nodo_fila"+"c"+aux2.posY+ "->"+"Nodo_fila"+"c"+next.posY+";\n";
                    //tex += "Nodo_fila"+"c"+next.posY+" -> Nodo_fila"+"c"+aux2.posY+ ";\n";
                    rank += "Nodo_fila"+"c"+aux2.posY+",";
                    rank += "Nodo_fila"  + "c"+next.posY+",";
                     
                next = next.abajo;
                aux2 = aux2.abajo;
                }else if (aux2.posY == -1){
                tex += "Nodo_f"+aux2.posX+"columna" +"->"+"Nodo_f" +next.posX+"c"+next.posY+";\n";
                tex += "Nodo_f" +next.posX+"c"+next.posY+" -> Nodo_f"+aux2.posX+"columna"+";\n";
                rank += "Nodo_f"+aux2.posX+"columna,"; 
                rank += "Nodo_f" + next.posX + "c" + next.posY+",";
                
                next = next.abajo;
                aux2 = aux2.abajo;
                }else{
                tex += "Nodo_f"+aux2.posX+"c"+aux2.posY+ "->"+"Nodo_f" +next.posX+"c"+next.posY+";\n";
                tex += "Nodo_f" +next.posX+"c"+next.posY+" -> Nodo_f"+aux2.posX+"c"+aux2.posY+";\n";
                
                rank +="Nodo_f" + next.posX + "c" + next.posY+",";
                next = next.abajo;
                aux2 = aux2.abajo;
                }
            }
            rank = rank.substring(0, rank.length()-1);
            rank += "}\n";
            //System.out.println(rank);
            //System.out.println(tex);
            vuelta += rank;
            vuelta += tex;
            aux = aux.siguiente;
          
        }
        
        return vuelta;
        }
    public String GraphColumna(){
        Nodo_M aux=root;
        String vuelta = "";
        while (aux != null) {
            String tex = "";
            //String rank ="{rank=same;";
            Nodo_M aux2 = aux;
            Nodo_M next = aux.siguiente;
            while (next != null) {
              if (aux2.posX == -1 && aux2.posY == -1) {
                    tex += "Nodo_fila" + "columna" + "->" + "Nodo_f" + next.posX + "columna" + ";\n";
                    //tex += "Nodo_f" + next.posX + "columna"+" -> Nodo_fila" + "columna"+ ";\n";
              //      rank += "Nodo_fila" + "columna,";
              //      rank += "Nodo_f" + next.posX + "columna,";

                    next = next.siguiente;
                    aux2 = aux2.siguiente;
                } else if (aux2.posY == -1 && next.posY == -1) {
                    tex += "Nodo_f" + aux2.posX + "columna" + "->" + "Nodo_f" + next.posX + "columna" + ";\n";
                    //tex += "Nodo_f" + next.posX + "columna" + "->" + "Nodo_f" + aux2.posX + "columna" + ";\n";
                //    rank += "Nodo_f" + next.posX + "columna,";
                    next = next.siguiente;
                    aux2 = aux2.siguiente;
                } else if (aux2.posX == -1) {
                    tex += "Nodo_fila" + "c" + aux2.posY + "->" + "Nodo_f" + next.posX + "c" + next.posY + ";\n";
                    tex += "Nodo_f" + next.posX + "c" + next.posY + "->" + "Nodo_fila" + "c" + aux2.posY + ";\n";
                  //  rank += "Nodo_f" + next.posX + "c" + next.posY+",";
                  //  rank += "Nodo_fila" + "c" + aux2.posY+","; 
                    next = next.siguiente;
                    aux2 = aux2.siguiente;
                }else if(next.posY == -1){
                
                 //rank += "Nodo_f" + next.posX + "columna,";
                } else {
                    tex += "Nodo_f" + aux2.posX + "c" + aux2.posY + "->" + "Nodo_f" + next.posX + "c" + next.posY + ";\n";
                   // rank +="Nodo_f" + next.posX + "c" + next.posY+",";
                    next = next.siguiente;
                    aux2 = aux2.siguiente;
}
            
            }
            //rank = rank.substring(0, rank.length()-1);
            //rank += "}";
            //System.out.println(tex);
            vuelta += tex;
            //System.out.println(rank);
            aux = aux.abajo;
        }
        return vuelta;
        }
    public String GraphInit(){
       Nodo_M aux=root;
       String vuelta = "";
        while (aux != null) {
            String tex = "";
            Nodo_M aux2 = aux;
            while (aux2 != null) {
                if (aux2.posX == -1 && aux2.posY == -1){
                    tex += "Nodo_fila" + "columna[label = \"\",style = filled, fillcolor =white, group ="+(aux2.posY+1)+"];\n" ;
                    aux2 = aux2.siguiente;
                } else if (aux2.posY == -1) {
                    tex += "Nodo_f" + aux2.posX + "columna[label = \"\",style=filled, fillcolor =white, group ="+(aux2.posY+1)+"];\n"  ;
                    aux2 = aux2.siguiente;
                } else if (aux2.posX == -1) {
                    tex += "Nodo_fila" + "c" + aux2.posY+"[label = \"\",style=filled, fillcolor =white, group ="+(aux2.posY+1)+"];\n" ;
                    aux2 = aux2.siguiente;
                } else {
                    tex += "Nodo_f" + aux2.posX + "c" + aux2.posY+"[label=\"\",style=filled, fillcolor = \""+aux2.Dato+"\", group ="+(aux2.posY+1)+"];\n" ;
                    aux2 = aux2.siguiente;
                }
            }
            //System.out.println(tex);
            vuelta += tex;
            
            aux = aux.abajo;
        }
        
       
        return vuelta;
    }
    
    public String CreateDot(String part1,String part2,String part3){
    String data ="digraph G {\n";
    data += "node[shape=box];\n" +
"splines=false;\n";
    data+=part1;
    data+=part2;
    data+=part3;
    
    data += "}";
    return data;
    }
    public void ConvertimosGraphviz(String entrada,String nombre){
    try {
      
      String GraficarRuta = "C:\\Program Files\\Graphviz\\bin\\dot.exe";
      
      String RutaEntrada = "C:\\Users\\braya\\OneDrive\\Escritorio\\Salidas\\Matrix\\"+entrada+".txt";
      
      String RutaSalida = "C:\\Users\\braya\\OneDrive\\Escritorio\\Salidas\\Matrix\\"+nombre+".jpg";
      
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
    public void ConvertimosGraphvizImg(String entrada,String nombre){
    try {

      String GraficarRuta = "C:\\Program Files\\Graphviz\\bin\\dot.exe";
      String RutaEntrada = "C:\\Users\\braya\\OneDrive\\Escritorio\\Salidas\\Imagenes\\"+entrada+".txt";
      String RutaSalida = "C:\\Users\\braya\\OneDrive\\Escritorio\\Salidas\\Imagenes\\"+nombre+".jpg";
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
    
    
    
    public void CrearEstructura(String Data,String fNombre){
    try {   
            String ruta = "C:\\Users\\braya\\OneDrive\\Escritorio\\Salidas\\Matrix\\"+fNombre+".txt";
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
    
    public void CrearEstructuraImg(String Data,String fNombre){
    try {   
            String ruta = "C:\\Users\\braya\\OneDrive\\Escritorio\\Salidas\\Imagenes\\"+fNombre+".txt";
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
  public MD CreateSuperM (MD matriz_entrada){
  MD Salida = matriz_entrada;
  Nodo_M aux=root;
        while (aux != null) {
            String tex = "";
            Nodo_M aux2 = aux;
            while (aux2 != null) {
                Salida.insertarNodo(aux2.posX,aux2.posY, aux2.Dato);
                aux2 = aux2.siguiente;
            
            }
            
            aux = aux.abajo;
        }
      ;
  
  return Salida;
  }
            

}
