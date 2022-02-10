/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Proyecto1_EDD;

import java.util.Scanner;

/**
 *
 * @author braya
 */
public class Proyecto1_EDD {

    /**
     * @param args the command line arguments
     */
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

  

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
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
                                if(conve2 == 1){
                                    System.out.println("Selecciono 1.1 Esta dentro de Carga Masiva de Clientes");
                                Vala = true;
                                }else if(conve2 == 2){
                                    System.out.println("Selecciono 1.2 Esta dentro de Cantidad de Ventanillas");
                                Valb = true;    
                                
                                }
                                if (Vala == true && Valb == true){
                                salida2=true;}else{salida2 = false;}
                            } 
                            }
                            
                            
                            
                        

                        break;
                    case 2:
                        System.out.println("Selecciono 2 esta en la funcion Ejecutar Pasos");
                        
                        Lista_Recepcion LR = new Lista_Recepcion();
                        LR.AgregarNodoInicio(new Cliente("1","Alexander","3","1"));
                        LR.AgregarNodoInicio(new Cliente("2","Brayan","4","2"));
                        LR.AgregarNodoInicio(new Cliente("3","Mejia","1","3"));
                        System.out.println(((Cliente)LR.ObtenerPrimero()).getNombre());
                        break;
                    case 3:
                        System.out.println("Selecciono 3 esta en la funcion Estado de memoria de las estructuras");
                        break;
                    case 4:
                        System.out.println("Selecciono 4 esta en la funcion Reportes");
                        break;
                    case 5:
                        System.out.println("Selecciono 5 Acerca de");
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
