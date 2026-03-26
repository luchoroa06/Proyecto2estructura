/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2estructuras;

import documentos.Documento;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.swing_viewer.SwingViewer;
import org.graphstream.ui.swing_viewer.ViewPanel;
import org.graphstream.ui.view.Viewer;

/**
 *
 * @author PC
 */
public class Arbol {
    public NodoArbol[] monticulo;        // Array que almacena los nodos del montículo   
    public int tamanoActual;            // Cuántos elementos hay actualmente
    public int capacidad;               // Capacidad máxima del array

    public Arbol(int capacidad) {
        this.capacidad = capacidad;
        this.tamanoActual = 0;
        this.monticulo = new NodoArbol[capacidad];
    }
    private int padre(int i) { return (i - 1) / 2; }
    private int hijoIzquierdo(int i) { return 2 * i + 1; }
    private int hijoDerecho(int i) { return 2 * i + 2; }

    private void intercambiar(int i, int j) {       // Intercambia dos nodos y actualiza sus índices para que la hashtable no pierda la referencia
        NodoArbol temp = monticulo[i];
        monticulo[i] = monticulo[j];
        monticulo[j] = temp;
        monticulo[i].documento.indiceEnMonticulo = i;
        monticulo[j].documento.indiceEnMonticulo = j;
    }
     // Inserta un documento con su prioridad calculada según tipo de usuario
    public void insertar(Documento doc, int tiempoReloj, String tipoUsuario) {
        if (tamanoActual == capacidad) {
            redimensionar();
        }

        int etiquetaFinal = calcularEtiquetaPrioridad(tiempoReloj, tipoUsuario);
        
        NodoArbol nuevoNodo = new NodoArbol(doc, etiquetaFinal);
        monticulo[tamanoActual] = nuevoNodo;
        nuevoNodo.documento.indiceEnMonticulo = tamanoActual;
        flotar(tamanoActual);
        tamanoActual++;
    }
    // Elimina el elemento con mayor prioridad (menor etiqueta)
    public NodoArbol eliminar_min() {
        if (tamanoActual <= 0) return null;
        if (tamanoActual == 1) {
            tamanoActual--;
            return monticulo[0];
        }

        NodoArbol raiz = monticulo[0];
        monticulo[0] = monticulo[tamanoActual - 1];
        
        if (monticulo[0] != null) {
            monticulo[0].documento.indiceEnMonticulo = 0;
        }

        monticulo[tamanoActual - 1] = null;
        tamanoActual--;
        hundir(0);
        
        return raiz;
    }
     // Elimina un documento específico dándole prioridad mínima y luego sacándolo
    public void eliminarDocumentoEspecifico(int indice) {
        if (indice < 0 || indice >= tamanoActual) return;
        
        monticulo[indice].etiquetaTiempo = Integer.MIN_VALUE;
        flotar(indice);
        eliminar_min();
    }
    // Sube un nodo si su prioridad es menor que la de su padre
    private void flotar(int i) {
        while (i != 0 && monticulo[padre(i)].etiquetaTiempo > monticulo[i].etiquetaTiempo) {
            intercambiar(i, padre(i));
            i = padre(i);
        }
    }
     // Hunde un nodo si tiene hijos con mayor prioridad
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
    // Calcula la etiqueta de prioridad según el tipo de usuario
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
    public String mostrarColaOrdenada() {
        if (tamanoActual == 0) {            // Si no hay documentos, cortamos por lo sano de una vez
            return "La cola de impresión está vacía en este momento.";
        }
        Arbol arbolClon = new Arbol(this.capacidad);        //se crea un nuevo arbol par ano perder el original
         for (int i = 0; i < this.tamanoActual; i++) {       // Copiamos los nodos uno por uno al clon para mantener el estado actual
            arbolClon.monticulo[i] = this.monticulo[i];
        }
        arbolClon.tamanoActual = this.tamanoActual;         // seactualizar el tamaño del clon para que sepa cuántos elementos tiene

        StringBuilder salida = new StringBuilder();         // Uso StringBuilder porque es mucho más eficiente que sumar Strings con "+" dentro de un ciclo
        salida.append("=== Lista de Documentos en Cola (Ordenados por Prioridad) ===\n");
        int turno = 1;
        while (arbolClon.tamanoActual > 0) {            // Vamos vaciando el árbol clon sacando siempre el de mayor prioridad (menor etiqueta)
            NodoArbol nodoActual = arbolClon.eliminar_min();
            salida.append("Turno ").append(turno).append(": ")      // Armamos el texto que se va a mostrar por cada documento
                  .append(nodoActual.documento.nombre)
                  .append(" (Tipo: ").append(nodoActual.documento.tipo)
                  .append(") - Etiqueta/Prioridad: ").append(nodoActual.etiquetaTiempo)
                  .append("\n");
                  
            turno++; // Pasamos al siguiente
        }
        return salida.toString();            // Devolvemos el texto armado para que la interfaz o el main lo impriman
    }
    
   
    public void graficarArbol() {
        // Si no hay documentos en la cola, cortamos por lo sano. Ni nos molestamos en abrir la ventana xd
        if (tamanoActual == 0) {
            System.out.println("Bro, la cola está vacía, no hay nada que graficar.");
            return;
        }

        /* *
         */
        System.setProperty("org.graphstream.ui", "swing");

        Graph grafo = new SingleGraph("Cola de Impresion");

        grafo.setAttribute("ui.stylesheet", 
            "node {" +
            "   fill-color: #3498db;" + 
            "   text-color: black;" +
            "   text-size: 14px;" +
            "   text-alignment: under;" +  
            "   text-background-mode: rounded-box;" +
            "   text-background-color: white;" +
            "   size: 20px;" +
            "}" +
            "edge { fill-color: #2c3e50; }");

        for (int i = 0; i < tamanoActual; i++) {

            Node nodo = grafo.addNode(String.valueOf(i));

            String texto = monticulo[i].documento.nombre + " (" + monticulo[i].etiquetaTiempo + ")";
            nodo.setAttribute("ui.label", texto);
        }


        for (int i = 0; i < tamanoActual; i++) {

            int hijoIzq = hijoIzquierdo(i); 
            int hijoDer = hijoDerecho(i);   

            if (hijoIzq < tamanoActual) {

                grafo.addEdge(i + "-" + hijoIzq, String.valueOf(i), String.valueOf(hijoIzq));
            }
            
            if (hijoDer < tamanoActual) {
                grafo.addEdge(i + "-" + hijoDer, String.valueOf(i), String.valueOf(hijoDer));
            }
        }

        Viewer viewer = new SwingViewer(grafo, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
        viewer.enableAutoLayout(); 
        ViewPanel panelGrafo = (ViewPanel) viewer.addDefaultView(false);
        JFrame ventana = new JFrame("Arbolito de Impresión");
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        ventana.setLayout(new BorderLayout());
        ventana.add(panelGrafo, BorderLayout.CENTER);
        ventana.setSize(800, 600); 
        ventana.setLocationRelativeTo(null); 
        ventana.setVisible(true); 
    }
}
