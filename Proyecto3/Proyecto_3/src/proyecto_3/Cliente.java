/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_3;

/**
 *
 * @author braya
 */
public class Cliente {
    int DPI;
    String Nombre_completo;
    String Nombre_usuario;
    String Correo;
    String Contraseña;
    int Telefono;
    String Direccion;
    int Id_Municipio;

    public Cliente(int DPI, String Nombre_completo, String Nombre_usuario, String Correo, String Contraseña, int Telefono, String Direccion, int Id_Municipio) {
        this.DPI = DPI;
        this.Nombre_completo = Nombre_completo;
        this.Nombre_usuario = Nombre_usuario;
        this.Correo = Correo;
        this.Contraseña = Contraseña;
        this.Telefono = Telefono;
        this.Direccion = Direccion;
        this.Id_Municipio = Id_Municipio;
    }
    
    
}
