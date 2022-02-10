/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto1_EDD;

/**
 *
 * @author braya
 */
public class Cliente {
    String id ;
    String Nombre;
    String Img_C;
    String Img_BW;

    public Cliente(String id, String Nombre, String Img_C, String Img_BW) {
        this.id = id;
        this.Nombre = Nombre;
        this.Img_C = Img_C;
        this.Img_BW = Img_BW;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getImg_C() {
        return Img_C;
    }

    public String getImg_BW() {
        return Img_BW;
    }
    
}
