/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author esp15
 */
public class Arbol {
    private int mCoeficiente[][] = new int[24][24];
    private int mAdyacencia[][] = new int [24][24];
    private int cordX[] = new int [24];
    private int cordY[] = new int [24];
    private int nombre[] = new int [24];
    private int enArbol[];
    
    public Arbol () {
        
    }

    public int getmCoeficiente(int i, int j) {
        return mCoeficiente[i][j];
    }

    public void setmCoeficiente(int i, int j, int mCoeficiente) {
        this.mCoeficiente[i][j] = mCoeficiente;
    }

    public int getmAdyacencia(int i, int j) {
        return mAdyacencia[i][j];
    }

    public void setmAdyacencia(int i, int j, int mAdyacencia) {
        this.mAdyacencia[i][j] = mAdyacencia;
    }

    public int getCordX(int i) {
        return cordX[i];
    }

    public void setCordX(int i, int cordX) {
        this.cordX[i] = cordX;
    }

    public int getCordY(int i) {
        return cordY[i];
    }

    public void setCordY(int i, int cordY) {
        this.cordY[i] = cordY;
    }

    public int getNombre(int i) {
        return nombre[i];
    }

    public void setNombre(int i, int nombre) {
        this.nombre[i] = nombre;
    }
    
    public int getEnArbol (int i) {
        return enArbol[i];
    }
    
    public void setEnArbol (int i, int enArbol) {
        this.enArbol[i] = enArbol;
    }
    
    public void crearEnArbol (int i) {
        enArbol = new int[i];
    }
    
}
