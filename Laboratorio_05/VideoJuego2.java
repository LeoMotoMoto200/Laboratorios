import java.util.Scanner;

public class VideoJuego2{
    public static void main(String[] args) {
        Soldado Tablero [][] = new Soldado[10][10];
        llenarTablero(Tablero);

    }
    public static int Aleatorio(){
        int aleatorio = (int) ((Math.random()*10) + 1);
        return aleatorio;
    }
    public static void llenarTablero(Soldado Tablero [][]){
        Scanner nay = new Scanner(System.in);
        for(int i = 0; i < Aleatorio(); i++){
            System.out.print("\nIngrese el nombre del soldado"+(i + 1)+" : ");
            String nombre = nay.next();
            Tablero[i][0] = new Soldado();
            Tablero[i][0].setNombre(nombre);
            Tablero[i][0].setNivelVida(generadorVida());
            Tablero[i][0].setFila(Aleatorio());
            Tablero[i][0].setColumna(generadorColumna());

        }

    }
    public static int generadorVida(){
        int vidaRandom = (int)((Math.random()* 5) + 1);
        return vidaRandom;
    }
    public static char generadorColumna(){
        int random = (int)(Math.random() * 11);
        char letraRandom;
        char letras [] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        letraRandom = letras[random];
        return letraRandom;

    }
    public static void UbicarSoldados(Soldado Tablero [][]){
        char columna;
        int fila;
        char a = 'A';
        int numA = a;

        for(int i = 0; i < Aleatorio(); i++){
            columna = Tablero[i][0].getColumna();
            fila = Tablero[i][0].getFila();
            
        }



    }
    public static int ConvertirEntero( char Letra){
        char Letra;
        switch(Letra){
            case 'A':
            return 1;
            case 'B':
            return 2;
            case 'C':
            return 3;

        }

    }

}