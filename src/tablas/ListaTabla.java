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
public class ListaTabla {
    NodoTabla primero;
    int t;

    public ListaTabla() {
        this.primero = null;
        this.t = 0;
    }
    

    public void insertar(Documento docu, Usuario id) {  //inserta a base del nombre de usuario y nombre de documento
        NodoTabla nuevo = new NodoTabla(docu, id);
        if (primero == null) {          //por si la lsita esta vacia
            primero = nuevo;
            t++;
        } else {
            NodoTabla aux = primero;
            while (aux.sig != null) {
                aux = aux.sig;        //recorre hasta el final de la lista 
            }
            aux.sig = nuevo;          // conecta el nuevo nodo
            t++;
        }

    }

    public void eliminar(Documento docu, Usuario id) {          //elimina a base del nombre de usuario y nombre de documento
        if (primero != null) {
            NodoTabla aux = primero;
            if (aux.usuario.equals(id) && aux.documento.equals(docu)) {        // Si es el primero
                primero = primero.sig;
                t--;
                
                return;
            }
            while (aux.sig != null && !aux.sig.usuario.equals(id) && !aux.sig.documento.equals(docu) ) {
                aux = aux.sig;                  //busca el nodo a eliminar
            }
            if (aux.sig != null) {
                aux.sig = aux.sig.sig;          //reasigna los punteros
                t--;
            }

        }
    }

    public NodoTabla buscar(Documento docu, Usuario id) {       // busco con nombre de usuario y nombre de documento
        if (primero != null) {
            NodoTabla aux = primero;
            while (aux != null && !aux.documento.equals(docu) && !aux.usuario.equals(id) ) {
                aux = aux.sig;  

            }
            return aux;
        }
        return null;
    }

    
}
