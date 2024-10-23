package Laboratorio5;
public class VideoJuego2 {
    public static void main(String[] args) {
        Soldado[][] Tablero = new Soldado[10][10];  // Creamos un tablero de 10x10
        int cantidadSoldados = Aleatorio(1, 10);  // Generar cantidad de soldados aleatoria entre 1 y 10

        llenarTablero(Tablero, cantidadSoldados);
        mostrarTablero(Tablero);
        mostrarEstadisticas(Tablero, cantidadSoldados);
    }

    public static int Aleatorio(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public static void llenarTablero(Soldado[][] Tablero, int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            String nombre = "Soldado" + i;
            int nivelVida = Aleatorio(1, 5);//Generamos un aleatorio entre 1 y 5
            int fila, columna;

            // Asegurarse de que la posición esté vacía
            do {
                fila = Aleatorio(0, 9);
                columna = Aleatorio(0, 9);
            } while (Tablero[fila][columna] != null);  // Repetir hasta encontrar una posición vacía

            // Crear el soldado y colocarlo en el tablero
            Soldado soldado = new Soldado(nombre, nivelVida, fila, columna);
            Tablero[fila][columna] = soldado;
        }
    }

    public static void mostrarTablero(Soldado[][] Tablero) {
        System.out.println("\nTablero de soldados:");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (Tablero[i][j] != null) {
                    System.out.print("| S ");  // S para indicar la presencia de un soldado
                } else {
                    System.out.print("| _ ");  // _ para espacios vacíos
                }
            }
            System.out.println("|");
        }
    }

    public static void mostrarEstadisticas(Soldado[][] Tablero, int cantidadSoldados) {
        System.out.println("\nEstadísticas de los soldados:");

        // Soldado con mayor nivel de vida
        Soldado soldadoMaxVida = encontrarSoldadoMayorVida(Tablero);
        if (soldadoMaxVida != null) {
            System.out.println("Soldado con mayor nivel de vida: " + soldadoMaxVida.getNombre() +
                               " con " + soldadoMaxVida.getNivelVida() + " puntos de vida.");
        }

        // Promedio de nivel de vida
        double promedioVida = calcularPromedioNivelVida(Tablero, cantidadSoldados);
        System.out.println("Promedio de nivel de vida: " + promedioVida);

        // Nivel de vida total del ejército
        int vidaTotal = calcularNivelVidaTotal(Tablero);
        System.out.println("Nivel de vida total del ejército: " + vidaTotal);

        // Ordenar soldados por nivel de vida por el método Burbuja
        Soldado[] soldados = obtenerSoldados(Tablero, cantidadSoldados);
        burbuja(soldados);
        System.out.println("\nSoldados ordenados por nivel de vida (Burbuja):");
        for (Soldado s : soldados) {
            System.out.println(s.getNombre() + " - Nivel de vida: " + s.getNivelVida());
        }

        // Ordenar soldados por nivel de vida por el método de Selección
        seleccion(soldados);
        System.out.println("\nSoldados ordenados por nivel de vida (Selección):");
        for (Soldado s : soldados) {
            System.out.println(s.getNombre() + " - Nivel de vida: " + s.getNivelVida());
        }
    }

    // Método para encontrar el soldado con mayor nivel de vida 
    public static Soldado encontrarSoldadoMayorVida(Soldado[][] Tablero) {
        Soldado soldadoMaxVida = null;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (Tablero[i][j] != null) {
                    if (soldadoMaxVida == null || Tablero[i][j].getNivelVida() > soldadoMaxVida.getNivelVida()) {
                        soldadoMaxVida = Tablero[i][j];
                    }
                }
            }
        }
        return soldadoMaxVida;
    }

    // Método para calcular el promedio de nivel de vida de todos los soldados
    public static double calcularPromedioNivelVida(Soldado[][] Tablero, int cantidadSoldados) {
        int sumaNivelVida = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (Tablero[i][j] != null) {
                    sumaNivelVida += Tablero[i][j].getNivelVida();
                }
            }
        }
        return (double) sumaNivelVida / cantidadSoldados;
    }

    // Método para calcular el nivel de vida total del ejército 
    public static int calcularNivelVidaTotal(Soldado[][] Tablero) {
        int sumaNivelVida = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (Tablero[i][j] != null) {
                    sumaNivelVida += Tablero[i][j].getNivelVida();
                }
            }
        }
        return sumaNivelVida;
    }

    // Método burbuja
    public static void burbuja(Soldado[] soldados) {
        int n = soldados.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (soldados[j].getNivelVida() > soldados[j + 1].getNivelVida()) {
                    // Intercambiar
                    Soldado temp = soldados[j];
                    soldados[j] = soldados[j + 1];
                    soldados[j + 1] = temp;
                }
            }
        }
    }

    // Método de selección
    public static void seleccion(Soldado[] soldados) {
        int n = soldados.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (soldados[j].getNivelVida() < soldados[minIndex].getNivelVida()) {
                    minIndex = j;
                }
            }
            // Intercambiamos   
            Soldado temp = soldados[minIndex];
            soldados[minIndex] = soldados[i];
            soldados[i] = temp;
        }
    }

    // Método para obtener un arreglo de soldados a partir del tablero
    public static Soldado[] obtenerSoldados(Soldado[][] Tablero, int cantidadSoldados) {
        Soldado[] soldados = new Soldado[cantidadSoldados];
        int index = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (Tablero[i][j] != null) {
                    soldados[index++] = Tablero[i][j];
                }
            }
        }
        return soldados;
    }
}
