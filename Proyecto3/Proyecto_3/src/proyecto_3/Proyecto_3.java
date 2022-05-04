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
        
   
   
        lstVert.Insertar_Vert_Arista(1,2);
        lstVert.Insertar_Vert_Arista(1,4);
        
        lstVert.Insertar_Vert_Arista(2,1);
        lstVert.Insertar_Vert_Arista(2,3);
        lstVert.Insertar_Vert_Arista(2,5);
        
        lstVert.Insertar_Vert_Arista(3,2);
        lstVert.Insertar_Vert_Arista(3,4);
        
        lstVert.Insertar_Vert_Arista(4,1);
        lstVert.Insertar_Vert_Arista(4,3);
        lstVert.Insertar_Vert_Arista(4,5);
        
        lstVert.Insertar_Vert_Arista(5,2);
        lstVert.Insertar_Vert_Arista(5,4);
       
        
        
        
        
        lstVert.imprimir();
        
        String resultado = lstVert.GraficarNodos();
        
        lstVert.CrearTxt(resultado,"hola");
        lstVert.LLamarGraphviz("hola","hola");
        
        lstVert.Buscar(1,3);
        
        
        
        
      //frmPrincipal principal = new frmPrincipal();
      //principal.show();
        
    }
    
}
