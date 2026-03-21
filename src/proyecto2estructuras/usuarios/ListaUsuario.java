/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2estructuras.usuarios;

import proyecto2estructuras.documentos.Documento;
import proyecto2estructuras.documentos.NodoListaD;

/**
 *
 * @author PC
 */
public class ListaUsuario {
    NodoListaU primero = null;

    public ListaUsuario() {
    }
    
  
    public void agregar(Usuario u) {
        NodoListaU nuevo = new NodoListaU(u);
        if (primero == null) {
            primero = nuevo;
        } else {
            NodoListaU aux = primero;
            while (aux.sig != null) {
                aux = aux.sig;
            }
            aux.sig = nuevo;
        }
    }

    
    public void eliminar(String nombre) {
        if (primero == null) return;

        if (primero.dato.nombre.equals(nombre)) {
            primero = primero.sig;
            return;
        }

        NodoListaU anterior = primero;
        NodoListaU aux = primero;
        while (aux != null) {
            if (aux.dato.nombre.equals(nombre)) {
                anterior.sig = aux.sig;
                return;
            }
            anterior = aux;
            aux = aux.sig;
        }
    }

    public NodoListaU buscar(String nombre) {
        NodoListaU aux = primero;
        while (aux != null) {
            if (aux.dato.nombre.equals(nombre)) return aux;
            aux = aux.sig;
        }
        return null;
    }

    public String imprimir() {
        String otaku = " ";
        NodoListaU aux = primero;
        while (aux != null) {
            otaku = aux.dato.nombre + " -> " + aux.dato.tipo + "->" + aux.dato.lDoc.imprimir();
            aux = aux.sig;
        }
        return otaku;
    }
    
}
