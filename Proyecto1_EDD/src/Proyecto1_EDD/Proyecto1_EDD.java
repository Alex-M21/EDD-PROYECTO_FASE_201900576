/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Proyecto1_EDD;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.File;
import static java.lang.Math.random;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.Random;




public class Proyecto1_EDD {


    public static boolean Val_Numero(String valuar) {
        boolean validado = false;
        try {
            int prueba = Integer.parseInt(valuar);
            validado = true;
            if (prueba < 7) {
                validado = true;
            } else {
                System.out.println("El valor que ingreso esun numero pero no esta en el rango del menu");
            }
        } catch (Exception e) {
            System.out.print("Error el dato que ingreso no es un numero" + e);
            validado = false;
        }

        return validado;
    }
    public static String ObtenerRuta(){
       String ruta = "";
        JFileChooser chooser = new JFileChooser (); // Crear un objeto para seleccionar un archivo
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			 File file = chooser.getSelectedFile (); // Crea un objeto de archivo, que es el archivo seleccionado
			 ruta = file.toString();
		}
                return  ruta;
        
    }
    public static void IngresarRandoms(Lista_Recepcion lstR){
        Lista_Recepcion LR = lstR;
        Random random = new Random();
        String[] Nombres = {"Liam","Noah","Oliver","Elijah","Olivia","Emma","Ava","Charlotte","Lafter","Alice"};
        String[] Apellidos = {"Mejia","Barrientos","Garcia","Cabrera","Gramajo","Arevalo","Caballeros","Corado","Orellana","Altamirano"};
        int Cant_Imagenes = random.nextInt(4);
        int Cant_Clientes = random.nextInt(3);
        String N = "";
        String A = "";
        String NCompleto = "";
        String id = "";
        int idnumero = 1999;
        
        String ing_Imagen_Color = "";
        String ing_Imagen_BW = "";
        
        
        for(int i=0;i<=Cant_Clientes;i++){
            idnumero = idnumero + i;
            int indexN = random.nextInt(9);
            N = Nombres[indexN];
            int indexA = random.nextInt(9);
            A = Apellidos[indexA];
            int img_Color = 0;
            int img_BW = 0;
            
            NCompleto = N + " " + A;
            System.out.println(NCompleto);
            for (int j = 0; j <= Cant_Imagenes; j++) {
                int img = random.nextInt(2);
                if (img == 0) {
                    System.out.println("img_Color");
                    img_Color++;
                } else if (img == 1) {
                    System.out.println("img BW");
                    img_BW++;
                }

            }
            ing_Imagen_Color = img_Color+"";
            ing_Imagen_BW = img_BW+"";
            id = idnumero+"";
            LR.AgregarNodoInicio(new Cliente(id,NCompleto,ing_Imagen_Color,ing_Imagen_BW));
        }
        
    
    }
    
    
    public static void LeerJson(String ruta,Lista_Recepcion lstR){
    String datos = "";
    Lista_Recepcion LR = lstR;
    try{
        Object ob = new JSONParser().parse(new FileReader(ruta));

        System.out.println("Este es el JSON"+ ob);
        JSONObject cliente = (JSONObject) ob;
        //String cl1 =(String)cliente.get("Cliente1");
        //System.out.println(cl1);
        //System.out.println("Last name is: " +lastName);
        String etiquetaClientes = "Cliente";
        int contador = 1;
        String cont = etiquetaClientes+contador;
        JSONObject inClientes = (JSONObject) cliente.get(cont);
        System.out.println(inClientes.toJSONString());
        String id = (String) inClientes.get("id_cliente");
        System.out.println("Este es el id cliente: " + id);

        String nombre = (String) inClientes.get("nombre_cliente");
        System.out.println("Este es el nombre cliente: " + nombre);

        String color = (String) inClientes.get("img_color");
        System.out.println("Este es el imagenes a color cliente: " + color);

        String bw = (String) inClientes.get("img_bw");
        System.out.println("Este es el imagenes a color cliente: " + bw);
        contador++;
        
        lstR.AgregarNodoInicio(new Cliente(id,nombre,color,bw));
         
                        
     
        while(cliente.get(cont)!=null){
           cont = etiquetaClientes+contador;
           
           inClientes=(JSONObject) cliente.get(cont);
           id = (String) inClientes.get("id_cliente");
        System.out.println("Este es el id cliente: " + id);

        nombre = (String) inClientes.get("nombre_cliente");
        System.out.println("Este es el nombre cliente: " + nombre);

        color = (String) inClientes.get("img_color");
        System.out.println("Este es el imagenes a color cliente: " + color);

        bw = (String) inClientes.get("img_bw");
        System.out.println("Este es el imagenes a color cliente: " + bw);
        LR.AgregarNodoInicio(new Cliente(id,nombre,color,bw));
        contador++;
        }
        
        
                        
    }catch (Exception e){
     System.out.println("Error en la funcion LeerJson");
    }
    
    
    
   
    }
    
    public static void DesarrollarPasos(int paso,Lista_Recepcion lstR,Lista_Ventanillas lstV,Lista_Circular lstE,Cola_BW colaBW,Cola_Color colaC){
    switch(paso){
        case 1:
            System.out.println("--------------------PASO 1---------------------");
            
            // Cliente 1 ingresa a la ventanilla 1
            Object primercliente = lstR.ObtenerPrimero();
            lstV.IngresoCliente(primercliente);
            //lstV.AgragarNodoFinal();
           
            
            
            // En la cola de recpcion pueden ingresar clientes de forma aleatoria
            // mostrar vacio de las estructuras que no se usan
           
           
            break;
        case 2:
            System.out.println("--------------------PASO 2---------------------");
            // el cliente 2 ingresa a ventanilla 2
            Object segundocliente = lstR.ObtenerPrimero();
            lstV.IngresoCliente(segundocliente);
            //ventanilla 1 recibe imagen 
            lstV.tomarImagenCliente(1);
            break;
        case 3:
            System.out.println("--------------------PASO 3---------------------");
            lstV.tomarImagenCliente(1);
            lstV.tomarImagenCliente(2);
            break;
        case 4:
            System.out.println("--------------------PASO 4---------------------");
            // El cliente 1 es atendido e ingresa a la lista de espera y La ventanilla 1 envia las Imagenes a las colas
            
            //lstV.SalidaCliente(1,lstE,colaBW,colaC);
            
            
            //El cliente 3 ingresa a la ventanilla 1
            Object tercercliente = lstR.ObtenerPrimero();
            lstV.IngresoCliente(tercercliente);
            
            //Ventanilla 2 recibe una imagen 
            lstV.tomarImagenCliente(2);
            break;
        case 5:
            // la ventanilla 1 recibe una imagen del cliente 3
            lstV.tomarImagenCliente(1);
            // La ventanilla 2 recibe una imagen del cliente 2 
            lstV.tomarImagenCliente(2);
            // Se completa la impresion de una imagen blanco y negro y se entrega al cliente
            
            
            break;
        case 6:
            //El cliente 2 es atendido y regresa a la linea de espera
            //La ventailla 2 envia imagenes del cliente 2 a las colas de impresion 
            //La ventanilla 1 recie una imagen del cliente 3
            //Se completa la impreion de una a color y se entrega al cliente
          
            break;
        case 7:
            // el cliente 3 es atendido e ingreas a la lista de espera
            // La ventanilla 2 envia las iamgenes del cliente 3 a sus colas 
            // el cliente 1 ya posee todas sus imagenes
            break;
        case 8:
            String DataR = lstR.GraficarNodos();
            lstR.CrearTxt(DataR,"Lista Recepcion");
            lstR.LLamarGraphviz("Lista Recepcion");
            String DataV = lstV.GraficarNodos();
            lstV.CrearTxt(DataV);
            lstV.LLamarGraphviz();
            String DataE = lstE.Graficar();
            lstE.CrearTxt(DataE);
            lstE.LLamarGraphviz();
            String DataBW = colaBW.GraficarNodosImg();
            colaBW.CrearTxt(DataBW);
            colaBW.LLamarGraphviz();
            String DataC = colaC.GraficarNodosImg();
            colaC.CrearTxt(DataC);
            colaC.LLamarGraphviz();
            
            
            
            break;
        case 9: 
            int numeroservidores = lstV.size;
            int contadorPasos = 0;
            System.out.println("---------------------PASO " + contadorPasos + "-----------------------");

            System.out.println("Este es el numero de servidores" + numeroservidores);
             System.out.println("--------------LA LISTA RECEPCION---------------");
            lstR.imprimir();
            System.out.println("--------------LA LISTA VENTANILLA--------------");
            lstV.imprimir();
            System.out.println("--------------LA LISTA DE ESPERA-------------- ");
            lstE.mostrar();
            System.out.println("--------------LA COLA IMRESION BW--------------");
            colaBW.imprimir();
            System.out.println("------------LA COLA IMPRESION COLOR------------");
            colaC.imprimir();
            contadorPasos++;
            int i;
            boolean ImagenesCompletas = false;
            for (i = 0; i < (numeroservidores); i++) {
                System.out.println("---------------------PASO " + contadorPasos + "-----------------------");
                System.out.println("La venetanilla" + (i + 1) + "Ingreso un cliente");
                Object prim = lstR.ObtenerPrimero();
                lstV.IngresoCliente(prim);
                contadorPasos++;
                int j;
                for (j = numeroservidores; j >= i; j--) {
                    System.out.println("---------------------PASO " + contadorPasos + "-----------------------");
                    System.out.println("La venetanilla" + (i + 1) + "Ingreso un imagen");
                    ImagenesCompletas = lstV.tomarImagenCliente((i+1));
                    contadorPasos++;
                    System.out.println("El cliente "+(i+1)+"ya no tiene imagenes?  "+ImagenesCompletas);
                    
                    if (ImagenesCompletas == true) {
                        System.out.println("---------------------PASO " + contadorPasos + "-----------------------");
                        lstV.SalidaCliente((i + 1), lstE, colaBW, colaC);
                        Object prim2 = lstR.ObtenerPrimero();
                        contadorPasos++;
                        ImagenesCompletas=false;
                        System.out.println("---------------------PASO " + contadorPasos + "-----------------------");
                        lstV.IngresoCliente(prim2);
                        if(colaBW.size >0){
                        System.out.println("Imprimiendo BW:");    
                        colaBW.EntregarImagenCliente(lstE);
                        }
                        
                        contadorPasos++;
                     
                    }
                    System.out.println("---------------------PASO " + contadorPasos + "-----------------------");
                   
                     if(colaBW.size >0){
                        System.out.println("Imprimiendo BW:");    
                        colaBW.EntregarImagenCliente(lstE);
                        }
                   
                }
            }
      
            boolean ImagenesCompletas2 = false;
            System.out.println("fuera_del for");
            int salida = lstV.RevisarCliente();
            if(salida == 0){
                while(ImagenesCompletas2 != true){
                System.out.println("---------------------PASO " + contadorPasos + "-----------------------");
                for(int z = 0; z<numeroservidores;z++){
                
                ImagenesCompletas2 = lstV.tomarImagenCliente((z+1));
                System.out.println("El cliente "+(z+1)+"ya no tiene imagenes?  "+ImagenesCompletas2);
                if(colaBW.size >0){
                        System.out.println("Imprimiendo BW:");    
                        colaBW.EntregarImagenCliente(lstE);
                        }
                if (colaC.size >0){
                    System.out.println("Imprimiendo Color:");
                    colaC.EntregarImagenCliente(lstE);
                }
                
                
                
                if(ImagenesCompletas2==true){
                    System.out.println("---------------------PASO " + contadorPasos + "-----------------------");
                        lstV.SalidaCliente((z + 1), lstE, colaBW, colaC);
                        Object prim2 = lstR.ObtenerPrimero();
                        contadorPasos++;
                        ImagenesCompletas=false;
                   
                    
                     if(colaBW.size >0){
                        System.out.println("Imprimiendo BW:");    
                        colaBW.EntregarImagenCliente(lstE);
                        }
                        
                        System.out.println("---------------------PASO " + contadorPasos + "-----------------------");
                        lstV.IngresoCliente(prim2);
                        colaC.EntregarImagenCliente(lstE);
                        contadorPasos++;
                        if(colaBW.size >0){
                        System.out.println("Imprimiendo BW:");    
                        colaBW.EntregarImagenCliente(lstE);
                        }
                         if(colaC.size >0){
                        System.out.println("Imprimiendo Color:"); 
                        colaC.EntregarImagenCliente(lstE);
                    }
                        
              
                    
                    
                }
                if(colaBW.size >0){
                   System.out.println("Imprimiendo BW:");    
                   colaBW.EntregarImagenCliente(lstE);
                    }
                
            }
            salida = lstV.RevisarCliente();
            
            contadorPasos++;
            }
                
                
                
            }else{
            System.out.println("Salida es diferente de 0");
               
            
            }
                 
            
            break;
    }
    
    
    }
  

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        Lista_Ventanillas lstVent = new Lista_Ventanillas();
        Lista_Recepcion lstRecepcion = new Lista_Recepcion();
        Lista_Circular lstEspera = new Lista_Circular();
        Cola_BW colaBW = new Cola_BW();
        Cola_Color colaC = new Cola_Color();
        
        boolean salir = false;
        while (salir != true) {
            String e1 = "";
            System.out.println("-------MENU--------");
            System.out.println("1. Parametros Iniciales");
            System.out.println("2. Ejecutar Pasos");
            System.out.println("3. Estado de memoria de las estructuras");
            System.out.println("4. Reportes ");
            System.out.println("5. Acerca de");
            System.out.println("6. Salir");
            e1 = entrada.nextLine();
            boolean valido = Val_Numero(e1);
            if (valido == true) {
                int numero = Integer.parseInt(e1);
                switch (numero) {
                    case 1:
                        System.out.println("Selecciono 1 esta en la funcion Parametros Iniciales");
                        String e2 = "";
                        boolean salida2 = false;
                        boolean Vala = false;
                        boolean Valb = false;
                                
                        while (salida2 != true) {
                            System.out.println("--------Sub-Menu--------");
                            System.out.println("1. Carga Masiva de Clientes");
                            System.out.println("2. Cantidad de Ventanillas");
                            e2 = entrada.nextLine();                      
                            if (Val_Numero(e2)== true){
                                // Sub-Menu
                                int conve2 = Integer.parseInt(e2);
                                switch(conve2){
                                    case 1:
                                     //C:\Users\braya\OneDrive\Documentos\NetBeansProjects\Extraccion_Json\src\Files_Json\Extaccion.json
                                    System.out.println("Selecciono 1.1 Esta dentro de Carga Masiva de Clientes");
                                    String ruta = "";
                                    System.out.println("Ingrese la ruta");
                                    ruta = entrada.nextLine();
                                   
                                    LeerJson(ruta,lstRecepcion);
                                    
                                    IngresarRandoms(lstRecepcion);
                                    
                                    lstRecepcion.imprimir();
                                    
                                    
                                    
                                    Vala = true;
                                        break;
                                    case 2:
                                         System.out.println("Selecciono 1.2 Esta dentro de Cantidad de Ventanillas");
                                         String ndato = "";
                                         System.out.println("Ingrese el numero de Ventanillas");
                                         ndato = entrada.nextLine();
                                         if (Val_Numero(ndato)==true){
                                             int num = Integer.parseInt(ndato);
                                             for(int i = 0; i<num;i++){
                                             lstVent.AgragarNodoFinal("Ventanilla "+(i+1),(i+1));
                                             }
                                         
                                         }
                                        lstVent.imprimir();  
                                       Valb = true;    
                                        break;
                             
                                }
                                if (Vala == true && Valb == true){
                                salida2=true;}else{salida2 = false;}
                                
                            
                               
                            }
                             
                            }
                            
                            
                            
                        

                        break;
                    case 2:
                        System.out.println("Selecciono 2 esta en la funcion Ejecutar Pasos");
                        //IngresarRandoms(lstRecepcion);
                        /*System.out.println(lstRecepcion.ObtenerNodo(1));
                        Object primercliente = lstRecepcion.ObtenerPrimero();
                        Object segundocliente = lstRecepcion.ObtenerPrimero();
                        lstVent.IngresoCliente(primercliente);
                        lstVent.IngresoCliente(segundocliente);
                        lstVent.SalidaCliente();
                        lstVent.ProcesarImagenes("Ventanilla 2");
                        
                       */
                        System.out.println("Ingrese el paso que desea ejecutar: ");
                        String recibirpaso = entrada.nextLine();
                        int paso = Integer.parseInt(recibirpaso);
                        DesarrollarPasos(paso,lstRecepcion,lstVent,lstEspera,colaBW,colaC);
                        
                        
                        
                        
                        break;
                    case 3:
                        System.out.println("Selecciono 3 esta en la funcion Estado de memoria de las estructuras");
                          String Datavent = lstVent.GraficarNodos();
                          lstVent.CrearTxt(Datavent);
                          lstVent.LLamarGraphviz();
                          String DataRec = lstRecepcion.GraficarNodos();
                          lstRecepcion.CrearTxt(DataRec, "Lista Recepcion");
                          lstRecepcion.LLamarGraphviz(DataRec);
                          String DataEsp = lstEspera.Graficar();
                          lstEspera.CrearTxt(DataEsp);
                          lstEspera.LLamarGraphviz();
                          String black = colaBW.GraficarNodosImg();
                          colaBW.CrearTxt(black);
                          colaBW.LLamarGraphviz();
                          String col = colaC.GraficarNodosImg();
                          colaC.CrearTxt(col);
                          colaC.LLamarGraphviz();
                       
                        
                        
                        break;
                    case 4:
                        System.out.println("Selecciono 4 esta en la funcion Reportes");
                        Lista_Circular le1 = new Lista_Circular();
                        le1.ingresar(new Cliente("99","Brayan","4","5"));
                        le1.ingresar(new Cliente("21","Alexander","7","2"));
                        /*le1.ingresar(new Cliente("4","Pancha","8","1"));
                        le1.ingresar(new Cliente("12","Rocky","3","4"));
                        System.out.println("imprimir clientes");
                        le1.mostrar();
                        */
                        //le1.Buscar("4");
                       
                        
                                                
                        Cola_Color Co =new Cola_Color();
                        Co.AgregarNodoInicio(new Imagen("Color","99",0));
                        Co.AgregarNodoInicio(new Imagen("Color","21",0));
                        Co.AgregarNodoInicio(new Imagen("Color","21",0));
                        System.out.println("imprimir imagenes");
                        Co.imprimir();
                        
                        le1.ImprimirListadeListas();
                        Co.EntregarImagenCliente(le1);
                        
                       
                        Co.EntregarImagenCliente(le1);
                        Co.EntregarImagenCliente(le1);
                      
                        le1.ImprimirListadeListas();
                        String Data = le1.Graficar();
                        le1.CrearTxt(Data);
                        le1.LLamarGraphviz();
                                
                        /*
                        System.out.println("Lista de listas");
                        le1.imprimirlistas();
                        String a = le1.GraficarNodos();
                        le1.CrearTxt(a);
                        le1.LLamarGraphviz();
                        
                        */
                  
                        
                        
                        break;
                    case 5:
                        System.out.println("Selecciono 5 Acerca de:    ");
                        System.out.println("Universidad de San Carlos de Guatemala");
                        System.out.println("Facultad de Ingenieria");
                        System.out.println("Escuela de Ciencias y Sistemas");
                        System.out.println("Nombre: Brayan Alexnader Mejia Barrientos");
                        System.out.println("Carnet: 201900576");

                        break;
                    case 6:
                        System.out.println("Selecciono 6  Salir");
                        System.out.println("¡Adios!");
                        salir = true;
                        break;

                }

            }

        }
    }

}
