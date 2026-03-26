/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package documentos;

import usuarios.Usuario;

/**
 *
 * @author PC
 */
public class Documento {
    public String nombre;  //nombre del documento
    public int tamaño;     //tamaño del documento
    public String tipo;    //tipo de docunto
    public String prioridad;  //prioridad del documento0
    public Usuario creador;      //usuario que creo el documento;
    public int indiceEnMonticulo; // Guardará en qué posición del arreglo está actualmente
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
        this.indiceEnMonticulo = -1;
    }
    
    
   
}
