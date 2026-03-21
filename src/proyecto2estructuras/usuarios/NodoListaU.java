/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2estructuras.usuarios;

/**
 *
 * @author PC
 */
public class NodoListaU {
    NodoListaU sig; //sig de la lista
    NodoListaU ant; //ant de la lista
    Usuario dato;  // el dato del usuario

    /**
     * contructor de la lista de usuarios.
     * @param dato dato que viene de la clase usuario.
     */
    public NodoListaU(Usuario dato) {
        this.sig = null;
        this.ant = null;
        this.dato = dato;
    }
 
}
