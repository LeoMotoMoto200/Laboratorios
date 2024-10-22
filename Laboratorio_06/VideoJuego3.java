import java.util.*;
public class VideoJuego3 {
    Scanner nay = new Scanner(System.in);
    ArrayList<ArrayList<Soldado>> Tablero = new ArrayList<>();
    int ej1 = Aleatorio(1, 5);
    int ej2 = Aleatorio(1, 5);
    ArrayList<Soldado> Ejercito1 = new ArrayList<>();
    ArrayList<Soldado> Ejercito2 = new ArrayList<>();
    
    



    public static int Aleatorio(int min, int max){
        int random = (int)(Math.random()*(min)+ (max - min));
        return random;
    }

    public static void LlenarTablero(ArrayList<ArrayList<Soldado>> Tablero, ArrayList<Soldado> Ejercito1, 
    ArrayList<Soldado> Ejercito2){
        for(int fila = 0; fila < Ejercito1.size() + Ejercito2.size(); fila++){
            int columna = 0;
            String soldadoMarca;
            while(columna< Ejercito1.size() + Ejercito2.size()){
                if(Tablero.get(fila).get(columna) == null){
                    



                }

            }

        }


    }
    public static void imprimirTablero(ArrayList<ArrayList<Soldado>> Tablero){


    }
    public static void LlenarEjercito(ArrayList<Soldado> Ejercito, int banda){
        for(int i = 0; i < Ejercito.size(); i++){
            if(banda == 1){
            Ejercito.get(i).setNombre("SoldadoX"+(i));
            Ejercito.get(i).setNivelVida(Aleatorio(1, 5));
            Ejercito.get(i).setFila(Aleatorio(1, 10));
            Ejercito.get(i).setColumna(Aleatorio(1, 10));
            }else{
            Ejercito.get(i).setNombre("SoldadoY"+(i));
            Ejercito.get(i).setNivelVida(Aleatorio(1, 5));
            Ejercito.get(i).setFila(Aleatorio(1, 10));
            Ejercito.get(i).setColumna(Aleatorio(1, 10));
            }
        }
    }


    
}

