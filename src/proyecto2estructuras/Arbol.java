/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2estructuras;

import proyecto2estructuras.documentos.Documento;

/**
 *
 * @author PC
 */
public class Arbol {
    public NodoArbol[] monticulo;
    public int tamanoActual;
    public int capacidad;

    public Arbol(int capacidad) {
        this.capacidad = capacidad;
        this.tamanoActual = 0;
        this.monticulo = new NodoArbol[capacidad];
    }
    private int padre(int i) { return (i - 1) / 2; }
    private int hijoIzquierdo(int i) { return 2 * i + 1; }
    private int hijoDerecho(int i) { return 2 * i + 2; }

    private void intercambiar(int i, int j) {
        NodoArbol temp = monticulo[i];
        monticulo[i] = monticulo[j];
        monticulo[j] = temp;
    }

    public void insertar(Documento doc, int tiempoReloj, String tipoUsuario) {
        if (tamanoActual == capacidad) {
            redimensionar();
        }

        int etiquetaFinal = calcularEtiquetaPrioridad(tiempoReloj, tipoUsuario);
        
        NodoArbol nuevoNodo = new NodoArbol(doc, etiquetaFinal);
        monticulo[tamanoActual] = nuevoNodo;
        
        flotar(tamanoActual);
        tamanoActual++;
    }

    public NodoArbol eliminar_min() {
        if (tamanoActual <= 0) return null;
        if (tamanoActual == 1) {
            tamanoActual--;
            return monticulo[0];
        }

        NodoArbol raiz = monticulo[0];
        monticulo[0] = monticulo[tamanoActual - 1];
        monticulo[tamanoActual - 1] = null;
        tamanoActual--;
        hundir(0);
        
        return raiz;
    }

    public void eliminarDocumentoEspecifico(int indice) {
        if (indice < 0 || indice >= tamanoActual) return;
        
        monticulo[indice].etiquetaTiempo = Integer.MIN_VALUE;
        flotar(indice);
        eliminar_min();
    }

    private void flotar(int i) {
        while (i != 0 && monticulo[padre(i)].etiquetaTiempo > monticulo[i].etiquetaTiempo) {
            intercambiar(i, padre(i));
            i = padre(i);
        }
    }

    private void hundir(int i) {
        int menor = i;
        int izq = hijoIzquierdo(i);
        int der = hijoDerecho(i);

        if (izq < tamanoActual && monticulo[izq].etiquetaTiempo < monticulo[menor].etiquetaTiempo) {
            menor = izq;
        }
        if (der < tamanoActual && monticulo[der].etiquetaTiempo < monticulo[menor].etiquetaTiempo) {
            menor = der;
        }

        if (menor != i) {
            intercambiar(i, menor);
            hundir(menor);
        }
    }

    private int calcularEtiquetaPrioridad(int tiempoReloj, String tipoUsuario) {
        if (tipoUsuario.equals("prioridad_alta")) return tiempoReloj - 1000;
        if (tipoUsuario.equals("prioridad_media")) return tiempoReloj - 500;
        if (tipoUsuario.equals("prioridad_baja")) return tiempoReloj - 100;
        
        return tiempoReloj;
    }

    private void redimensionar() {
        NodoArbol[] nuevoArr = new NodoArbol[capacidad * 2];
        for (int i = 0; i < capacidad; i++) {
            nuevoArr[i] = monticulo[i];
        }
        monticulo = nuevoArr;
        capacidad *= 2;
    }
    
}
