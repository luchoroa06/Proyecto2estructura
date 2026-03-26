/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablas;

import documentos.Documento;
import usuarios.Usuario;

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
    
     // Inserta un documento con su usuario al final de la lista
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
     // Elimina un documento específico de un usuario
    public void eliminar(Documento docu, Usuario id) {          
        if (primero != null) {
            NodoTabla aux = primero;

            if (aux.usuario.nombre.equals(id.nombre) && aux.documento.nombre.equals(docu.nombre)) {        
                primero = primero.sig;
                t--;
                return;
            }

            while (aux.sig != null && !(aux.sig.usuario.nombre.equals(id.nombre) && aux.sig.documento.nombre.equals(docu.nombre))) {
                aux = aux.sig;                  
            }
            
            if (aux.sig != null) {
                aux.sig = aux.sig.sig;          // Lo desconecta de la lista
                t--;
            }
        }
    }
     // Busca un documento por usuario y nombre de documento
    public NodoTabla buscar(Documento docu, Usuario id) {    // busco con nombre de usuario y nombre de documento
        if (primero != null) {
            NodoTabla aux = primero;
            while (aux != null && !aux.documento.equals(docu) && !aux.usuario.equals(id) ) {
                if (aux.documento.nombre.equals(docu.nombre) && aux.usuario.nombre.equals(id.nombre)) {     //Comparamos los .nombre en vez del objeto completo
                    return aux; 
                }
                aux = aux.sig;  

            }
            return aux;
        }
        return null;
    }

    
}
