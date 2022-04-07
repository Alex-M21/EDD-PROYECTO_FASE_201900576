/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto1_EDD;

/**
 *
 * @author braya
 */
public class Imagen {
    String id ;
    String tipo;
    int impresora;

    public Imagen(String tipo, String id,int impresora) {
        this.id = id;
        this.tipo = tipo;
        this.impresora = impresora;
    }

    public String getId() {
        return id;
    }

  

    public String getTipo() {
        return tipo;
    }

    
}
