
package proyecto.pkg2;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.json.JSONArray;






public class Lectura_Json {
    
  
    
    
     public  String LeerClientesPantalla(String ruta){
         String regreso = "";
         JSONArray user = new JSONArray(ruta);
            for (int i = 0; i < user.length(); i++) {
            String post_id = user.getJSONObject(i).getString("dpi");
            System.out.println(post_id);
            String post_nombre = user.getJSONObject(i).getString("nombre_cliente");
            System.out.println(post_nombre);
            String post_pass = user.getJSONObject(i).getString("password");
            System.out.println(post_pass);
            regreso += "dpi: "+post_id+"nombre_cliente: "+post_nombre+"password: "+post_pass+"\n";
            }
         return regreso;
        }
     
     public ArbolB LeerClientesArbol(String ruta){
         
         ArbolB hola = new ArbolB();
         JSONArray user = new JSONArray(ruta);
            for (int i = 0; i < user.length(); i++) {
            String post_id = user.getJSONObject(i).getString("dpi");
            System.out.println(post_id);
            
            int cast = Integer.parseInt(post_id);
            
            String post_nombre = user.getJSONObject(i).getString("nombre_cliente");
            System.out.println(post_nombre);
            String post_pass = user.getJSONObject(i).getString("password");
            System.out.println(post_pass);
            Users u = new Users(post_nombre,post_id,post_pass);
            
            hola.insertar(cast, u);
            }
         return hola;
        }
   
    
    public Arbol_AVL LeerImagenesUser(String ruta, AB entrada) {
        Arbol_AVL AVLtree = new Arbol_AVL();
        JSONArray imagenes = new JSONArray(ruta);
        for (int i = 0; i < imagenes.length(); i++) {
            AB abbaux = new AB();
            int id = imagenes.getJSONObject(i).getInt("id");
            System.out.println("Este es un ID" + id);

            JSONArray capas = imagenes.getJSONObject(i).getJSONArray("capas");
            System.out.println(capas);
            for (int j = 0; j < capas.length(); j++) {
                int capa = capas.getInt(j);
                System.out.println("esta es una capa:" + capa);
                System.out.println("esta es la matriz de abbglobal"+entrada.raiz.MatrizCapa.toString());

                Nodo__AB recuperada = entrada.BuscarNodoW(capa, entrada.raiz);
              
                
                System.out.println("esto es lo que se recupero del nodo: "+recuperada.dato + recuperada.nombre + recuperada.MatrizCapa.toString());
                int dato = recuperada.dato;
                String nombre = recuperada.nombre;
                MD matrix = recuperada.MatrizCapa;
                System.out.println("agregando a arbol aux");
                
                abbaux.agregarNodo(j,nombre,matrix);
                
                
              
                
                
                
                
                
               
            }
        AVLtree.add(id,abbaux);
        }
        return AVLtree;
    }
   
   public  void LeerAlbum(String ruta){
            JSONArray albunes = new JSONArray(ruta);
            for (int i = 0; i < albunes.length(); i++) {
        
            String nombre = albunes.getJSONObject(i).getString("nombre_album");
            System.out.println("Este es un nombre: "+nombre);
            
            JSONArray imagenes = albunes.getJSONObject(i).getJSONArray("imgs");
            System.out.println(imagenes);
            for(int j = 0;j<imagenes.length();j++){
            int capa = imagenes.getInt(j);
            System.out.println("esta es una capa:"+capa);
            }
    
    }
   
   }
   
    public AB LeerCapas(String ruta) {
        AB SBtree = new AB();
        JSONArray capas = new JSONArray(ruta);
         
        for (int i = 0; i < capas.length(); i++) {
            MD matriz = new MD();
            int capa = capas.getJSONObject(i).getInt("id_capa");
            System.out.println("Este es la capa: " + capa);

            JSONArray pixeles = capas.getJSONObject(i).getJSONArray("pixeles");
      
           
            for (int j = 0; j < pixeles.length(); j++) {
              
                
                int fila = pixeles.getJSONObject(j).getInt("fila");
              

                int columna = pixeles.getJSONObject(j).getInt("columna");
           

                String color = pixeles.getJSONObject(j).getString("color");
               
                System.out.println("["+fila+","+columna+","+color+"]");
                matriz.insertarNodo(fila,columna,color);

            }
         String Part1 = matriz.GraphInit();
         String Part2 = matriz.GraphFilas();
         String Part3 = matriz.GraphColumna();
         String todo = matriz.CreateDot(Part1, Part2, Part3);
         matriz.CrearEstructura(todo,"Capa"+capa);
         matriz.ConvertimosGraphviz("Capa"+capa,"Capa"+capa);    
        System.out.println("agregamos la matriz al nodo ABB"+ matriz.toString());
        SBtree.agregarNodo(capa,"Capa"+capa,matriz);
        }
        SBtree.InOrder(SBtree.raiz);
    return SBtree;    
   }
}
