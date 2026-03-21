/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2estructuras.usuarios;

import proyecto2estructuras.documentos.ListaDocumentos;

/**
 *
 * @author PC
 */
public class Usuario {
    String nombre;   //nombre del usuario del documento
    String tipo;     //tipo de usuario "prioridad"
    ListaDocumentos lDoc;   //documento a imprimir

    /**
     * contructor de usuarios y tus componentes
     * @param nombre
     * @param tipo
     * @param lDoc 
     */
    public Usuario(String nombre, String tipo, ListaDocumentos lDoc) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.lDoc = new ListaDocumentos();
    }
    
    
    
    
}
