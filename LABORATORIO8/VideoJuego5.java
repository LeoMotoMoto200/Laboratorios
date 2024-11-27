import java.util.*;

public class VideoJuego5 {
    public static void main(String[] args) {
        Scanner nay = new Scanner(System.in);
        Soldado[][] Tablero = new Soldado[10][10]; // Array Bidimensional para el tablero
        HashMap<String, Soldado> Ejercito1 = new HashMap<>();
        HashMap<String, Soldado> Ejercito2 = new HashMap<>();

        for (;;) {
            // Creamos el tablero
            inicializarTablero(Tablero);

            // Llenamos los ejércitos
            LlenarEjercito(Ejercito1, 1);
            LlenarEjercito(Ejercito2, 2);

            // Colocamos los soldados en el tablero
            LlenarTablero(Tablero, Ejercito1, Ejercito2);

            // Imprimimos el tablero
            imprimirTablero(Tablero);

            // Mostramos las estadísticas y decidimos al ganador
            mostrarEstadisticas(Ejercito1, Ejercito2);

            System.out.print("¿Desea crear otra batalla? (S/N): ");
            String rpta = nay.nextLine().toUpperCase();
            if (rpta.equals("N")) {
                break;
            }
        }
    }

    public static void inicializarTablero(Soldado[][] Tablero) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Tablero[i][j] = null; // Inicializamos con posiciones vacías
            }
        }
    }

    public static int Aleatorio(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public static void LlenarEjercito(HashMap<String, Soldado> Ejercito, int banda) {
        for (int i = 0; i < Aleatorio(5, 10); i++) {
            String id = (banda == 1 ? "X" : "Y") + i; // IDs únicos para cada soldado
            String nombre = "Soldado" + id;
            int nivelVida = Aleatorio(1, 5);
            Ejercito.put(id, new Soldado(nombre, nivelVida, -1, -1)); // Añadimos al HashMap
        }
    }

    public static void LlenarTablero(Soldado[][] Tablero,
                                     HashMap<String, Soldado> Ejercito1,
                                     HashMap<String, Soldado> Ejercito2) {
        for (Soldado s : Ejercito1.values()) {
            colocarSoldado(Tablero, s);
        }
        for (Soldado s : Ejercito2.values()) {
            colocarSoldado(Tablero, s);
        }
    }

    public static void colocarSoldado(Soldado[][] Tablero, Soldado s) {
        int fila, columna;
        do {
            fila = Aleatorio(0, 9);
            columna = Aleatorio(0, 9);
        } while (Tablero[fila][columna] != null); // Buscamos una posición vacía

        s.setFila(fila);
        s.setColumna(columna);
        Tablero[fila][columna] = s; // Colocamos el soldado en el tablero
    }

    public static void imprimirTablero(Soldado[][] Tablero) {
        System.out.println("\nTablero de soldados:");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Soldado soldado = Tablero[i][j];
                if (soldado != null) {
                    System.out.print("| " + soldado.getNombre().charAt(8) + " ");
                } else {
                    System.out.print("| _ ");
                }
            }
            System.out.println("| ");
        }
    }

    public static void mostrarEstadisticas(HashMap<String, Soldado> Ejercito1, HashMap<String, Soldado> Ejercito2) {
        System.out.println("\nEjército 1:");
        for (Soldado s : Ejercito1.values()) {
            System.out.println(s.getNombre() + " - Nivel de vida: " + s.getNivelVida());
        }

        System.out.println("\nEjército 2:");
        for (Soldado s : Ejercito2.values()) {
            System.out.println(s.getNombre() + " - Nivel de vida: " + s.getNivelVida());
        }

        // Calculamos los promedios
        double promedioEj1 = calcularPromedio(Ejercito1);
        double promedioEj2 = calcularPromedio(Ejercito2);

        System.out.println("\nPromedio de nivel de vida del Ejército 1: " + promedioEj1);
        System.out.println("Promedio de nivel de vida del Ejército 2: " + promedioEj2);

        if (promedioEj1 > promedioEj2) {
            System.out.println("\nEl Ejército 1 gana la batalla.");
        } else if (promedioEj2 > promedioEj1) {
            System.out.println("\nEl Ejército 2 gana la batalla.");
        } else {
            System.out.println("\nEs un empate.");
        }
    }

    public static double calcularPromedio(HashMap<String, Soldado> Ejercito) {
        int suma = 0;
        for (Soldado s : Ejercito.values()) {
            suma += s.getNivelVida();
        }
        return (double) suma / Ejercito.size();
    }
}
