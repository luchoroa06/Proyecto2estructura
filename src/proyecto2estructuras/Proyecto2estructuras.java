/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto2estructuras;

import proyecto2estructuras.documentos.Documento;
import proyecto2estructuras.usuarios.ListaUsuario;
import proyecto2estructuras.usuarios.Usuario;

/**
 *
 * @author PC
 */
public class Proyecto2estructuras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ListaUsuario l = new ListaUsuario();
        l.agregar(new Usuario("Luciano", "alta"));
        l.agregar(new Usuario("andres", "media"));
        l.agregar(new Usuario("sebastian", "baja"));
        
        l.buscar("Luciano").dato.lDoc.agregar(new Documento("abc", 2 ,"me quiero salir de la carrera xd", l.buscar("Luciano").dato));
        l.buscar("andres").dato.lDoc.agregar(new Documento("edc", 2 ,"estoy obstinaod de dar clases no xd", l.buscar("andres").dato));
        l.buscar("sebastian").dato.lDoc.agregar(new Documento("wxy", 2 ,"me quiero matar xd", l.buscar("sebastian").dato));
        
        System.out.println(l.imprimir());
    }
    
}
