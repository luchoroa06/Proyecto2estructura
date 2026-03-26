/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios;

import documentos.ListaDocumentos;

/**
 *
 * @author PC
 */
public class Usuario {
    public String nombre;   //nombre del usuario del documento
    public String tipo;     //tipo de usuario "prioridad"
    public ListaDocumentos lDoc;   //documento a imprimir

    /**
     * contructor de usuarios y tus componentes
     * @param nombre
     * @param tipo
     * @param lDoc 
     */
    public Usuario(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.lDoc = new ListaDocumentos();
    }
    
    
    
    
}
