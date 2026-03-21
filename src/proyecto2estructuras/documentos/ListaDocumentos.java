/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2estructuras.documentos;

/**
 *
 * @author PC
 */
public class ListaDocumentos {
    NodoListaD primero = null;

    public ListaDocumentos() {
    }
    
  
    public void agregar(Documento d) {
        NodoListaD nuevo = new NodoListaD(d);
        if (primero == null) {
            primero = nuevo;
        } else {
            NodoListaD aux = primero;
            while (aux.sig != null) {
                aux = aux.sig;
            }
            aux.sig = nuevo;
        }
    }

    
    public void eliminar(String nombre) {
        if (primero == null) return;

        if (primero.docu.nombre.equals(nombre)) {
            primero = primero.sig;
            return;
        }

        NodoListaD anterior = primero;
        NodoListaD aux = primero;
        while (aux != null) {
            if (aux.docu.nombre.equals(nombre)) {
                anterior.sig = aux.sig;
                return;
            }
            anterior = aux;
            aux = aux.sig;
        }
    }

    public NodoListaD buscar(String nombre) {
        NodoListaD aux = primero;
        while (aux != null) {
            if (aux.docu.nombre.equals(nombre)) return aux;
            aux = aux.sig;
        }
        return null;
    }

    public String imprimir() {
        String otaku = " ";
        NodoListaD aux = primero;
        while (aux != null) {
            otaku += aux.docu.nombre + " -> " + aux.docu.prioridad + "->" + aux.docu.tipo;
            aux = aux.sig;
        }
        return otaku;
    }
    
}
