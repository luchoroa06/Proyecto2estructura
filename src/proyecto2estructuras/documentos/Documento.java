/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2estructuras.documentos;

import proyecto2estructuras.usuarios.Usuario;

/**
 *
 * @author PC
 */
public class Documento {
    String nombre;  //nombre del documento
    int tamaño;     //tamaño del documento
    String tipo;    //tipo de docunto
    String prioridad;  //prioridad del documento0
    Usuario creador;      //usuario que creo el documento;
    
    /**
     * contructor del documento y sus datos.
     * @param nombre
     * @param tamaño
     * @param tipo
     * @param creador 
     */
    public Documento(String nombre, int tamaño, String tipo, Usuario creador) {
        this.nombre = nombre;
        this.tamaño = tamaño;
        this.tipo = tipo;
        this.prioridad = " ";
        this.creador = creador;
    }
    
    
   
}
