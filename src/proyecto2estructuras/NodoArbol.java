/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2estructuras;

import documentos.Documento;

/**
 * Nodo que se guarda en el montículo
 * @author PC
 */
public class NodoArbol {
    public Documento documento;
    public int etiquetaTiempo;  // Valor que determina la prioridad (menor = más prioridad)


    public NodoArbol(Documento documento, int etiquetaTiempo) {
        this.documento = documento;
        this.etiquetaTiempo = etiquetaTiempo;
    }
}

    

