/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_3;

/**
 *
 * @author braya
 */
public class Proyecto_3 {

    
    public static void main(String[] args) {
        //frmLogin login  = new frmLogin();
        //login.setTitle("Login");
        
        //login.show();
        
        //frmAdmin admin = new frmAdmin();
        // admin.show();
        
     
        // lista de adyacencia
        
        Lista_Vertices lstVert = new Lista_Vertices();
        
   
   
        lstVert.Insertar_Vert_Arista(20,2);
        lstVert.Insertar_Vert_Arista(23,1);
        lstVert.Insertar_Vert_Arista(27,3);
       
        lstVert.Insertar_Vert_Arista(34,3);
        lstVert.Insertar_Vert_Arista(34,3);
        lstVert.Insertar_Vert_Arista(34,5);
        lstVert.Insertar_Vert_Arista(52,3);
        lstVert.Insertar_Vert_Arista(59,2);
       
        
        
        
        
        lstVert.imprimir();
        
        String resultado = lstVert.GraficarNodos();
        
        lstVert.CrearTxt(resultado,"hola");
        lstVert.LLamarGraphviz("hola","hola");
        //System.out.println("Este es el nodo"+lstVert.ObtenerNodo(2));
        
        
        
      frmPrincipal principal = new frmPrincipal();
      principal.show();
        
    }
    
}
