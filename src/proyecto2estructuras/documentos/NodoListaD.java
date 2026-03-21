/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2estructuras.documentos;

/**
 *
 * @author PC
 */
public class NodoListaD {
    NodoListaD sig;
    NodoListaD ant;
    Documento docu;

    /**
     * contructor de la lista de documentos
     * @param docu 
     */
    public NodoListaD(Documento docu) {
        this.sig = null;
        this.ant = null;
        this.docu = docu;
    }
    
    
    
}
