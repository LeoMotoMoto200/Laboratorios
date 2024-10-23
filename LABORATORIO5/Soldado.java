package Laboratorio5;
public class Soldado {

    private String Nombre;
    private int nivelVida;
    private int Fila;
    private int Columna; //Usaremos la Columna como un entero, para facilitar el trabajo

    public Soldado(String s, int vida, int fil, int col){
        this.Nombre = s;
        this.nivelVida = vida;
        this.Fila = fil;
        this.Columna = col;
    }
    public void setNombre(String n){
        Nombre = n;
    }
    public String getNombre(){
        return Nombre;
    }
    public void setNivelVida(int v){
        nivelVida = v;
    }
    public int getNivelVida(){
        return nivelVida;
    }
    public void setFila(int f){
        Fila = f;
    }
    public int getFila(){
        return Fila;
    }
    public void setColumna(char c){
        Columna = c;
    }
    public int getColumna(){
        return Columna;
    }

}