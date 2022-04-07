
package proyecto.pkg2;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.json.JSONArray;






public class Lectura_Json {
    
  
    
    
     public  void LeerClientes(String ruta){
         JSONArray user = new JSONArray(ruta);
            for (int i = 0; i < user.length(); i++) {
            String post_id = user.getJSONObject(i).getString("dpi");
            System.out.println(post_id);
            String post_nombre = user.getJSONObject(i).getString("nombre_cliente");
            System.out.println(post_nombre);
            String post_pass = user.getJSONObject(i).getString("password");
            System.out.println(post_pass);
   }
   
   }
   public  void LeerImagenesUser(String ruta){
            JSONArray imagenes = new JSONArray(ruta);
            for (int i = 0; i < imagenes.length(); i++) {
        
            int id = imagenes.getJSONObject(i).getInt("id");
            System.out.println("Este es un ID"+id);
            
            JSONArray capas = imagenes.getJSONObject(i).getJSONArray("capas");
            System.out.println(capas);
            for(int j = 0;j<capas.length();j++){
            int capa = capas.getInt(j);
            System.out.println("esta es una capa:"+capa);
            }
            
   }
   
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
            //System.out.println(pixeles);
           
            for (int j = 0; j < pixeles.length(); j++) {
              
                
                int fila = pixeles.getJSONObject(j).getInt("fila");
                //System.out.println("Este es la fila pixel: " + fila);

                int columna = pixeles.getJSONObject(j).getInt("columna");
                //System.out.println("Este es la columna pixel: " + columna);

                String color = pixeles.getJSONObject(j).getString("color");
                //System.out.println("Este es el color pixel " + color);
                System.out.println("["+fila+","+columna+","+color+"]");
                matriz.insertarNodo(fila,columna,color);

            }
         String Part1 = matriz.GraphInit();
         String Part2 = matriz.GraphFilas();
         String Part3 = matriz.GraphColumna();
         String todo = matriz.CreateDot(Part1, Part2, Part3);
         matriz.CrearEstructura(todo,"Capa"+capa);
         matriz.ConvertimosGraphviz("Capa"+capa,"Capa"+capa);    
        
        SBtree.agregarNodo(capa,"Capa"+capa, matriz);
        }
        SBtree.InOrder(SBtree.raiz);
    return SBtree;    
   }
}
