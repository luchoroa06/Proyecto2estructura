/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios;

/**
 *
 * @author PC
 */
public class ListaUsuario {
    NodoListaU primero = null;

    public ListaUsuario() {
    }
    
      // Agrega un usuario al final de la lista
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

    // Elimina un usuario por su nombre
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
    // Busca un usuario por su nombre
    public NodoListaU buscar(String nombre) {
        NodoListaU aux = primero;
        while (aux != null) {
            if (aux.dato.nombre.equals(nombre)) return aux;
            aux = aux.sig;
        }
        return null;
    }
     // Devuelve un string con todos los usuarios y sus documentos
    public String imprimir() {
        String otaku = " ";
        NodoListaU aux = primero;
        while (aux != null) {
            otaku += aux.dato.nombre + " -> " + aux.dato.tipo + "->" + aux.dato.lDoc.imprimir() + "\n" ;
            aux = aux.sig;
        }
        return otaku;
    }
    
}
