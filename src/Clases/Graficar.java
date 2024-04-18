/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author esp15
 */
public class Graficar {
    Color color;
    
    public static void trazarCirculo (Graphics point, int x, int y, String n) {
        ((Graphics2D) point).setColor(Color.blue);
        ((Graphics2D) point).setStroke(new BasicStroke(1));
        ((Graphics2D) point).fillOval(x, y, 6, 6);
        ((Graphics2D) point).setColor(Color.BLACK);
        ((Graphics2D) point).drawOval(x, y, 6, 6);
        ((Graphics2D) point).setColor(Color.CYAN);
        Font fuente = new Font("Monospaced", Font.BOLD, 0);
        point.setFont(fuente);
        ((Graphics2D) point).drawString(n, x, y);
    }
    
    public static void trazarLinea (Graphics line, int x1, int y1, int x2, int y2, int tam) {
        int xAux = 0; int yAux = 0;
        ((Graphics2D) line).setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON);
        BasicStroke stroke = new BasicStroke(2);
        ((Graphics2D) line).setStroke(stroke);
        ((Graphics2D) line).drawLine(x1+5, y1+5, x2+5, y2+5);
        if (x1 <= x2) {
            xAux = ((x2 - x1)/2) + x1;
        }else if (x1>x2) {
            xAux = ((x1 - x2)/2) + x2;
        }
        if (y1 < y2) {
            yAux = ((y2 - y1)/2) + y1;
        }else if (y1 >= y2) {
            yAux = ((y1 - y2)/2) + y2;
        }
        ((Graphics2D) line).setColor(Color.blue);
        Font fuente = new Font("Monospaced", Font.PLAIN, 12);
        line.setFont(fuente);
        ((Graphics2D) line).drawString(String.valueOf(tam), xAux, yAux);            
    }
    
    public static void trazarRecorrido (Graphics recorrido, int x1, int y1, int x2, int y2, Color color) {
        ((Graphics2D) recorrido).setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON);
        BasicStroke stroke = new BasicStroke(2);
        ((Graphics2D) recorrido).setStroke(stroke);
        recorrido.setColor(color);
        recorrido.drawLine(x1+5, y1+5, x2+5, y2+5);
    }
    
    public static void seleccionarNodo (Graphics apuntado, int x, int y, String n, Color color) {
        ((Graphics2D) apuntado).setColor(color);
        ((Graphics2D) apuntado).setStroke(new BasicStroke(1));
        ((Graphics2D) apuntado).fillOval(x, y, 6, 6);
        ((Graphics2D) apuntado).setColor(Color.BLACK);
        ((Graphics2D) apuntado).drawOval(x, y, 6, 6);
    }
}
