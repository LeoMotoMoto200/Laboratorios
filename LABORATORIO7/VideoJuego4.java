import java.util.*;
public class VideoJuego4 {
    public static void main(String[] args) {
        Scanner nay = new Scanner(System.in);
        Soldado [][] Tablero = new Soldado[10][10]; //Ahora usamos un Array Bidimensional   
        ArrayList<Soldado> Ejercito1 = new ArrayList<>();
        ArrayList<Soldado> Ejercito2 = new ArrayList<>();

        for(;;){
        // Creamos el Tablero
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

        System.out.print("Desea crear otra batalla? (S/N): ");
        String rpta = nay.nextLine().toUpperCase();
        if(rpta.equals("N")){
            break;
        }
        }
    }

    public static void inicializarTablero(Soldado [][] Tablero) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Tablero[i][j] = null; // Inicializamos con posiciones vacías
            }
        }
    }

    public static int Aleatorio(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public static void LlenarEjercito(ArrayList<Soldado> Ejercito, int banda) {
        for (int i = 0; i < Aleatorio(1, 10); i++) {
            String nombre;
            if (banda == 1) {
                nombre = "SoldadoX" + i; // Soldados del Ejército 1
            } else {
                nombre = "SoldadoY" + i; // Soldados del Ejército 2
            }
            int nivelVida = Aleatorio(1, 5);
            Ejercito.add(new Soldado(nombre, nivelVida, -1, -1)); // Asignamos fila y columna posteriormente
        }
    }
    
    public static void LlenarTablero(Soldado [][] Tablero, 
        ArrayList<Soldado> Ejercito1, 
        ArrayList<Soldado> Ejercito2) {
        for (Soldado s : Ejercito1) {
            colocarSoldado(Tablero, s);
        }
        for (Soldado s : Ejercito2) {
            colocarSoldado(Tablero, s);
        }
    }

    public static void colocarSoldado(Soldado [][] Tablero, Soldado s) {
        int fila, columna;
        do {
            fila = Aleatorio(0, 9);
            columna = Aleatorio(0, 9);
        } while (Tablero[fila][columna] != null); // Buscamos una posición vacía

        s.setFila(fila);
        s.setColumna(columna);
        Tablero[fila][columna] = s; // Colocamos el soldado en el tablero
    }

    public static void imprimirTablero(Soldado [][] Tablero) {
        System.out.println("\nTablero de soldados:");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Soldado soldado = Tablero[i][j];
                if (soldado != null) {
                    // Si el soldado pertenece al Ejército X (su nombre contiene 'X')
                    if (soldado.getNombre().contains("X")) {
                        System.out.print("|  SX"); // SX para soldados del Ejército X
                    } 
                    // Si el soldado pertenece al Ejército Y (su nombre contiene 'Y')
                    else if (soldado.getNombre().contains("Y")) {
                        System.out.print("|  SY"); // SY para soldados del Ejército Y
                    }
                } else {
                    System.out.print("|  _ "); // _ para espacio vacío
                }
            }
            System.out.println("| ");
        }
    }
    
    public static void mostrarEstadisticas(ArrayList<Soldado> Ejercito1, ArrayList<Soldado> Ejercito2) {
        // Ordenamos ambos ejércitos por nivel de vida usando burbuja
        burbuja(Ejercito1);
        burbuja(Ejercito2);

        // Mostramos con burbuja
        System.out.println("\nEjército 1 ordenado por nivel de vida (Burbuja):");
        for (Soldado s : Ejercito1) {
            System.out.println(s.getNombre() + " - Nivel de vida: " + s.getNivelVida());
        }
        System.out.println("\nEjército 2 ordenado por nivel de vida (Burbuja):");
        for (Soldado s : Ejercito2) {
            System.out.println(s.getNombre() + " - Nivel de vida: " + s.getNivelVida());
        }

        // Ordenamos ambos ejércitos por nivel de vida usando selección
        seleccion(Ejercito1);
        seleccion(Ejercito2);

        // Mostramos con selección
        System.out.println("\nEjército 1 ordenado por nivel de vida (Selección):");
        for (Soldado s : Ejercito1) {
            System.out.println(s.getNombre() + " - Nivel de vida: " + s.getNivelVida());
        }
        System.out.println("\nEjército 2 ordenado por nivel de vida (Selección):");
        for (Soldado s : Ejercito2) {
            System.out.println(s.getNombre() + " - Nivel de vida: " + s.getNivelVida());
        }

        // Decide al ganador
        double promedioEj1 = calcularPromedio(Ejercito1);
        double promedioEj2 = calcularPromedio(Ejercito2);
        System.out.println("\nPromedio de nivel de vida del Ejército 1: " + promedioEj1);
        System.out.println("Promedio de nivel de vida del Ejército 2: " + promedioEj2);

        //Decidimos al ganador por su promedio
        if (promedioEj1 > promedioEj2) {
            System.out.println("\nEl Ejército 1 gana la batalla.");
        } else if (promedioEj2 > promedioEj1) {
            System.out.println("\nEl Ejército 2 gana la batalla.");
        } else {
            System.out.println("\nEs un empate.");
        }
    }

    // Método burbuja
    public static void burbuja(ArrayList<Soldado> soldados) {
        int n = soldados.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (soldados.get(j).getNivelVida() > soldados.get(j + 1).getNivelVida()) {
                    // Intercambiar
                    Soldado temp = soldados.get(j);
                    soldados.set(j, soldados.get(j + 1));
                    soldados.set(j + 1, temp);
                }
            }
        }
    }

    // Método de selección
    public static void seleccion(ArrayList<Soldado> soldados) {
        int n = soldados.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (soldados.get(j).getNivelVida() < soldados.get(minIndex).getNivelVida()) {
                    minIndex = j;
                }
            }
            // Intercambiamos
            Soldado temp = soldados.get(minIndex);
            soldados.set(minIndex, soldados.get(i));
            soldados.set(i, temp);
        }
    }

    // Método para calcular el promedio de vida
    public static double calcularPromedio(ArrayList<Soldado> Ejercito) {
        int suma = 0;
        for (Soldado s : Ejercito) {
            suma += s.getNivelVida();
        }
        return (double) suma / Ejercito.size();
    }
}