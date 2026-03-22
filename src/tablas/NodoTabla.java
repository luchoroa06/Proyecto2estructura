/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablas;

import proyecto2estructuras.documentos.Documento;
import proyecto2estructuras.usuarios.Usuario;

/**
 *
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
