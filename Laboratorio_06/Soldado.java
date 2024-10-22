public class Soldado {

    private String Nombre;
    private int nivelVida;
    private int Fila;
    private int Columna;

    public Soldado(String N, int n, int f, int c){
        this.Nombre = N;
        this.nivelVida = n;
        this.Fila = f;
        this.Columna = c;
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
    public void setColumna(int c){
        Columna = c;
    }
    public int getColumna(){
        return Columna;
    }

}