/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablas;

import documentos.Documento;
import usuarios.Usuario;

/**
 * Nodo de la lista enlazada para la tabla hash
 * @author sebas
 */
public class NodoTabla {
    Documento documento;
    Usuario usuario;
    NodoTabla sig;

    public NodoTabla(Documento documento, Usuario usuario) {
        this.documento = documento;
        this.usuario = usuario;
        this.sig = null;
    }
    
    
}
