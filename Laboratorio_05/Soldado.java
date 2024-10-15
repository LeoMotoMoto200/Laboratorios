public class Soldado {

    private String Nombre;
    private int nivelVida;
    private int Fila;
    private char Columna;

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
    public char getColumna(){
        return Columna;
    }

}