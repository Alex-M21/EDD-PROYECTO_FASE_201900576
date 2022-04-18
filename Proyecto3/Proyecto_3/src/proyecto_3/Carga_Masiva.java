/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_3;

import java.io.IOException;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONObject;

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
            int convDPI = convertidor(post_id);
            
            System.out.println(post_id);
            String post_nombre = mensajero.getJSONObject(i).getString("nombre");
            System.out.println(post_nombre);
            String post_apellido = mensajero.getJSONObject(i).getString("apellidos");
            System.out.println(post_apellido);
            String post_tipo = mensajero.getJSONObject(i).getString("tipo_licencia");
            System.out.println(post_tipo);
            String post_genero = mensajero.getJSONObject(i).getString("genero");
            System.out.println(post_genero);
            String post_direccion = mensajero.getJSONObject(i).getString("direccion");
            System.out.println(post_direccion);
            //regreso += "dpi: "+post_id+"nombre_cliente: "+post_nombre+"password: "+post_apellido+"\n";
            }
        
        System.out.println(regreso);
    }

    public void Carga_Lugares(String data) {
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
        }
    }

    public void Carga_Rutas(String data) {
        JSONObject carga = new JSONObject(data);

        JSONArray arr = carga.getJSONArray("Grafo");
        for (int i = 0; i < arr.length(); i++) {
            int post_inicio = arr.getJSONObject(i).getInt("inicio");
            System.out.println(post_inicio);
            int post_final = arr.getJSONObject(i).getInt("final");
            System.out.println(post_final);
            int post_peso = arr.getJSONObject(i).getInt("peso");
            System.out.println(post_peso);

        }
    }
}
