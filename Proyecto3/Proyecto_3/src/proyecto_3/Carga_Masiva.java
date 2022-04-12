/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_3;

import java.io.IOException;
import javax.swing.JOptionPane;
import org.json.JSONArray;

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
            JSONArray user = new JSONArray(data);
            for (int i = 0; i < user.length(); i++) {
            String post_id = user.getJSONObject(i).getString("dpi");
            int convDPI = convertidor(post_id);
            
            System.out.println(post_id);
            String post_nombre = user.getJSONObject(i).getString("nombre");
            System.out.println(post_nombre);
            String post_apellido = user.getJSONObject(i).getString("apellidos");
            System.out.println(post_apellido);
            String post_tipo = user.getJSONObject(i).getString("tipo_licencia");
            System.out.println(post_tipo);
            String post_genero = user.getJSONObject(i).getString("genero");
            System.out.println(post_genero);
            String post_direccion = user.getJSONObject(i).getString("direccion");
            System.out.println(post_direccion);
            //regreso += "dpi: "+post_id+"nombre_cliente: "+post_nombre+"password: "+post_apellido+"\n";
            }
        
        System.out.println(regreso);
    }

    public void Carga_Lugares(String data) {

        System.out.println("hola hola");
    }

    public void Carga_Rutas(String data) {

        System.out.println("hola hola");
    }
}
