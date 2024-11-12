import java.util.*;

class Soldado {
    private String nombre;
    private int nivelVida;
    private int fila;
    private int columna; //Para poder ubicar los objetos en la tabla más rápido

    public Soldado(String nombre, int nivelVida, int fila, int columna) {
        this.nombre = nombre;
        this.nivelVida = nivelVida;
        this.fila = fila;
        this.columna = columna;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivelVida() {
        return nivelVida;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
}