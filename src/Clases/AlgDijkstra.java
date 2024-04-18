/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import static Interfaz.GraphNav.jPanel1;
import java.awt.Color;
import javax.swing.JOptionPane;
import static Interfaz.GraphNav.R_repaint;  
import static Interfaz.GraphNav.Ruta;


/**
 *
 * @author esp15
 */
public class AlgDijkstra {
    private Arbol arbol;
    private int subTope;
    private Nodo auxi = null;
    private int auxAcumulado;
    private int subAcumulado;
    private Nodo nodo[];
    private int tope;
    private int permanente;
    private int nodoFin;
    
    public AlgDijkstra (Arbol arbol, int tope, int permanente, int nodoFin) {
        this.arbol = arbol;
        this.tope = tope;
        this.nodo = new Nodo[tope];
        this.permanente = permanente;
        this.nodoFin = nodoFin;
    }
    
    public int getAcumulado () {
        return nodo[nodoFin].getAcumulado();
    }
    
        String cabe;

    public void dijkstra() {
        Ruta.setText("");
        for (int i = 0; i < tope; i++) {
            nodo[i] = new Nodo();
        }
        if (permanente != nodoFin) {
            jPanel1.paint(jPanel1.getGraphics());
            R_repaint(tope, arbol);
            Graficar.seleccionarNodo(jPanel1.getGraphics(), 
                    arbol.getCordX(permanente), arbol.getCordY(permanente),
                    null, Color.yellow);
            nodo[permanente].setVisitado(true);
            nodo[permanente].setNombre(permanente);
            do {                
                subAcumulado = 0;
                auxAcumulado = 2000000000;
                nodo[permanente].setEtiqueta(true);
                for (int j = 0; j < tope; j++) {
                    if (arbol.getmAdyacencia(j, permanente) == 1) {
                        subAcumulado = nodo[permanente].getAcumulado() + arbol.getmCoeficiente(j, permanente);
                        if (subAcumulado <= nodo[j].getAcumulado() && nodo[j].isVisitado() == true && nodo[j].isEtiqueta() == false) {
                            nodo[j].setAcumulado(subAcumulado);
                            nodo[j].setVisitado(true);
                            nodo[j].setNombre(j);
                            nodo[j].setPredecesor(nodo[permanente]);
                        }else if (nodo[j].isVisitado() == false) {
                            nodo[j].setAcumulado(subAcumulado);
                            nodo[j].setVisitado(true);
                            nodo[j].setNombre(j);
                            nodo[j].setPredecesor(nodo[permanente]);
                        }
                    }
                }
                for (int i = 0; i < tope; i++) {
                    if (nodo[i].isVisitado() == true && nodo[i].isEtiqueta() == false) {
                        if (nodo[i].getAcumulado() <= auxAcumulado) {
                            permanente = nodo[i].getNombre();
                            auxAcumulado = nodo[i].getAcumulado();
                        }
                    }
                }
                subTope++;
            } while (subTope < tope+1);
            auxi = nodo[nodoFin];
            if (auxi.getPredecesor() == null) {
                JOptionPane.showMessageDialog(null, "No se pudo llamar al nodo " + nodoFin);
            }
            while (auxi.getPredecesor() != null) {                
                Graficar.trazarRecorrido(jPanel1.getGraphics(), arbol.getCordX(auxi.getNombre()), arbol.getCordY(auxi.getNombre()), arbol.getCordX(auxi.getPredecesor().getNombre()), arbol.getCordY(auxi.getPredecesor().getNombre()), Color.yellow);
                Graficar.seleccionarNodo(jPanel1.getGraphics(), arbol.getCordX(auxi.getNombre()), arbol.getCordY(auxi.getNombre()), cabe, Color.black);
                auxi = auxi.getPredecesor();
                System.out.println(auxi.getNombre());
                 var nombre = auxi.getNombre();
                 switch (nombre) {
                    case 0:
                        cabe = "Amazonas";
                        break;
                    case 1:
                        cabe = "Ancash";
                        break;
                    case 2:
                        cabe = "Apurimac";
                        break;
                    case 3:
                        cabe = "Arequipa";
                        break;
                    case 4:
                        cabe = "Ayacucho";
                        break;
                    case 5:
                        cabe = "Cajamarca";
                        break;
                    case 6:
                        cabe = "Cusco";
                        break;
                    case 7:
                        cabe = "Huancavelica";
                        break;
                    case 8:
                        cabe = "Huánuco";
                        break;
                    case 9:
                        cabe = "Ica";
                        break;
                    case 10:
                        cabe = "Junín";
                        break;
                    case 11:
                        cabe = "La Libertad";
                        break;
                    case 12:
                        cabe = "Lambayeque";
                        break;
                    case 13:
                        cabe = "Lima";
                        break;
                    case 14:
                        cabe = "Loreto";
                        break;
                    case 15:
                        cabe = "Madre de Dios";
                        break;
                    case 16:
                        cabe = "Moquegua";
                        break;
                    case 17:
                        cabe = "Pasco";
                        break;
                    case 18:
                        cabe = "Piura";
                        break;
                    case 19:
                        cabe = "Puno";//
                        break;
                    case 20:
                        cabe = "San Martín";
                        break;
                    case 21:
                        cabe = "Tacna";
                        break;
                    case 22:
                        cabe = "Tumbes";
                        break;
                    case 23:
                        cabe = "Ucayali";
                        break; 
                    default:
                        throw new AssertionError();
                }
                 Ruta.append(cabe+"\n");
            }
            Graficar.seleccionarNodo(jPanel1.getGraphics(), arbol.getCordX(nodoFin), arbol.getCordY(nodoFin), null, Color.GREEN);
        }else{
            Graficar.seleccionarNodo(jPanel1.getGraphics(), arbol.getCordX(nodoFin), arbol.getCordY(nodoFin), null, Color.GREEN);
        }
        
    }
    
}
