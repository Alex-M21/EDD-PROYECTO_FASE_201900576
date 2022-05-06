/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_3;

import java.io.IOException;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONObject;
import static proyecto_3.frmLogin.lstVert;
import static proyecto_3.frmLogin.tabla;

/**
 *
 * @author braya
 */
public class Carga_Masiva {
    public int convertidor(String entrada) {
        int salida = Integer.parseInt(entrada);
        return salida;
    }
    
    
    public void Cargar_Mensajeros(String data) {
        String regreso = "";
            JSONArray mensajero = new JSONArray(data);
            for (int i = 0; i < mensajero.length(); i++) {
            String post_id = mensajero.getJSONObject(i).getString("dpi");
            
            
            System.out.println(post_id);
            String post_nombre = mensajero.getJSONObject(i).getString("nombres");
            System.out.println(post_nombre);
            String post_apellido = mensajero.getJSONObject(i).getString("apellidos");
            System.out.println(post_apellido);
            String post_tipo = mensajero.getJSONObject(i).getString("tipo_licencia");
            System.out.println(post_tipo);
            String post_genero = mensajero.getJSONObject(i).getString("genero");
            System.out.println(post_genero);
            String post_direccion = mensajero.getJSONObject(i).getString("direccion");
            System.out.println(post_direccion);
            String post_telefono = mensajero.getJSONObject(i).getString("telefono");
            System.out.println(post_telefono);
       
           
            
            Mensajero msj = new Mensajero(post_id, post_nombre, post_apellido, post_tipo, post_genero,post_telefono,post_direccion);
            tabla.insertar(msj);
            
            
            }
        
        
        
       String d = tabla.GenerarGrafo();
       tabla.CrearTxt(d,"tabla_hash");
       tabla.LLamarGraphviz("tabla_hash","tabla_hash");
    }

    public void Carga_Lugares(String data,Lista_Lugares almacen) {
        JSONObject carga = new JSONObject(data);
  
         JSONArray arr = carga.getJSONArray("Lugares");
        for (int i = 0; i < arr.length(); i++) {
            int post_id = arr.getJSONObject(i).getInt("id");
            System.out.println(post_id);
            String post_departamento = arr.getJSONObject(i).getString("departamento");
            System.out.println(post_departamento);
            String post_nombre = arr.getJSONObject(i).getString("nombre");
            System.out.println(post_nombre);
            String post_sn = arr.getJSONObject(i).getString("sn_sucursal");
            System.out.println(post_sn);
            almacen.AgregarNodoInicio(new Lugares(post_id,post_departamento,post_nombre,post_sn));
            
        }
        
    }

    public void Carga_Rutas(String data,Lista_Rutas rutas) {
        JSONObject carga = new JSONObject(data);

        JSONArray arr = carga.getJSONArray("Grafo");
        for (int i = 0; i < arr.length(); i++) {
            int post_inicio = arr.getJSONObject(i).getInt("inicio");
            System.out.println(post_inicio);
            int post_final = arr.getJSONObject(i).getInt("final");
            System.out.println(post_final);
            int post_peso = arr.getJSONObject(i).getInt("peso");
            System.out.println(post_peso);
            
            Rutas ruta = new Rutas(post_inicio,post_final,post_peso);
            
            
            rutas.AgregarNodoInicio(ruta);
            rutas.imprimir();
            
            lstVert.Insertar_Vert_Arista(post_inicio,post_final);
            
            
        
            

        }
        String resultado = lstVert.GraficarNodos();
        
            lstVert.CrearTxt(resultado,"Adyacencia");
            lstVert.LLamarGraphviz("Adyacencia","Adyacencia");
        
        
    }
}
