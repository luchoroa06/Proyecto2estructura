/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto2estructuras;

import documentos.Documento;
import interfaces.Menuprincipal;
import tablas.Tabla;
import usuarios.ListaUsuario;
import usuarios.Usuario;

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
        Menuprincipal A = new Menuprincipal(new Arbol(1000), new Tabla(1000), new ListaUsuario());
        A.setVisible(true);
    }
    
}
