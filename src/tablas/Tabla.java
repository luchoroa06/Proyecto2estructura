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
public class Tabla {
    ListaTabla[] tabla;   //creacion de la array del hashtable;
    int t;
/**
 * contrustor del hastable
 * @param t 
 */
    public Tabla(int t) {
        this.t = t;
        tabla = new ListaTabla[t];
        for (int i = 0; i < t; i++) {
            tabla[t] = new ListaTabla();
        }
    }
    public int hash(String guillenteamo){                     //guillen te amo, sumebe nota porfis ☺
        int hash = 0;     
        for (int i = 0; i < guillenteamo.length(); i++) {       //recorremos el array
           hash += guillenteamo.charAt(i)+73*hash;      //lo multiplicamos por un numero primo para sea mas certero
        }
        if(hash< 0){                // por si el hash da negativo
            hash = hash*(-1);
        }
        return hash%t;      //retornamos el resto
    }
    
    public void agregar(Documento docu, Usuario id){   //agrega el documento a base del documento y usuario y llama insertar de Listatabla y la agrega
        String clave = docu.nombre + id.nombre;
        int resultado = this.hash(clave);
        tabla[resultado].insertar(docu, id);
    }
    
    public NodoTabla buscar(Documento docu, Usuario id){    //busca el documento a base del documento y usuario y llama buscar de Listatabla y retorna Nombre del documento 
        String clave = docu.nombre + id.nombre;             //y el id de usuario
        int resultado = this.hash(clave);
        NodoTabla a = tabla[resultado].buscar(docu, id);
        return a;
    }
    
    public void eliminar(Documento docu, Usuario id){   //elimina el documento a base del documento y usuario y llama eliminar de Listatabla y lo elimina.
        String clave = docu.nombre + id.nombre;
        int resultado = this.hash(clave);
        tabla[resultado].eliminar(docu, id);
    }
}
