import java.util.*;
public class DemoBatalla {
    public static void main(String[] args) {
        Nave[] misNaves = new Nave[8];
        Scanner nay = new Scanner(System.in);
        String nombre;
        String col;
        int fil, punt;
        boolean est;
        for (int i = 0; i < misNaves.length; i++) {
            System.out.println("Nave " + (i + 1));
            System.out.print("Nombre: ");
            nombre = nay.next();
            System.out.print("Fila: ");
            fil = nay.nextInt();
            System.out.print("Columna: ");
            col = nay.next();
            System.out.print("Estado (true/false): ");
            est = nay.nextBoolean();
            System.out.print("Puntos: ");
            punt = nay.nextInt();

            misNaves[i] = new Nave(); 
            misNaves[i].setNombre(nombre);
            misNaves[i].setFila(fil);
            misNaves[i].setColumna(col);
            misNaves[i].setEstado(est);
            misNaves[i].setPuntos(punt);
        }

        System.out.println("\nNaves creadas:");
        mostrarNaves(misNaves);
        mostrarPorNombre(misNaves);
        mostrarPorPuntos(misNaves);
        System.out.println("\nNave con mayor número de puntos: " + mostrarMayorPuntos(misNaves));

        System.out.print("Ingrese el nombre de la nave a buscar: ");
        nombre = nay.next();
        int pos = busquedaLinealNombre(misNaves, nombre);
        if (pos == -1) {
            System.out.println("Nave no encontrada");
        } else {
            System.out.println("Nave encontrada: " + misNaves[pos]);
        }

        ordenarPorPuntosBurbuja(misNaves);
        mostrarNaves(misNaves);
        ordenarPorNombreBurbuja(misNaves);
        mostrarNaves(misNaves);

        System.out.print("Ingrese el nombre de la nave para búsqueda binaria: ");
        String nombreBuscado = nay.next();
        pos = busquedaBinariaNombre(misNaves, nombreBuscado);
        if (pos == -1) {
            System.out.println("Nave no encontrada");
        } else {
            System.out.println("Nave encontrada: " + misNaves[pos]);
        }

        ordenarPorPuntosSeleccion(misNaves);
        mostrarNaves(misNaves);
        ordenarPorNombreSeleccion(misNaves);
        mostrarNaves(misNaves);
        ordenarPorPuntosInsercion(misNaves);
        mostrarNaves(misNaves);
        ordenarPorNombreInsercion(misNaves);
        mostrarNaves(misNaves);
    }

    // Método para mostrar todas las naves
    public static void mostrarNaves(Nave[] flota) {
        for (Nave nave : flota) {
            System.out.println("Nave: " + nave.getNombre() + ", Puntos: " + nave.getPuntos());
        }
    }

    // Método para mostrar todas las naves de un nombre que se pide por teclado
    public static void mostrarPorNombre(Nave[] flota) {
        Scanner nay = new Scanner(System.in);
        System.out.print("Ingrese el nombre de una Nave que desea buscar en la flota: ");
        String nombreBuscar = nay.next();
        boolean encontrado = false;

        for (Nave nave : flota) {
            if (nave.getNombre().equals(nombreBuscar)) {
                System.out.println("Nave encontrada: " + nave);
                encontrado = true;
                break; // Salir del bucle si se encuentra
            }
        }

        if (!encontrado) {
            System.out.println("Nave no encontrada");
        }
    }

    // Método para mostrar todas las naves con un número de puntos inferior o igual
    // al número de puntos que se pide por teclado
    public static void mostrarPorPuntos(Nave[] flota) {
        Scanner nay = new Scanner(System.in);
        System.out.print("Ingrese una cantidad de puntos para buscar en la flota: ");
        int puntosBuscar = nay.nextInt();

        boolean encontrado = false;
        for (Nave nave : flota) {
            if (nave.getPuntos() <= puntosBuscar) {
                System.out.println("Nave: " + nave.getNombre() + ", Puntos: " + nave.getPuntos());
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No hay naves con puntos menores o iguales a " + puntosBuscar);
        }
    }

    // Método que devuelve la Nave con mayor número de Puntos
    public static Nave mostrarMayorPuntos(Nave[] flota) {
        Nave mayorNave = flota[0];
        for (Nave nave : flota) {
            if (nave.getPuntos() > mayorNave.getPuntos()) {
                mayorNave = nave;
            }
        }
        return mayorNave;
    }

    // Método para buscar la primera nave con un nombre que se pidió por teclado
    public static int busquedaLinealNombre(Nave[] flota, String s) {
        for (int i = 0; i < flota.length; i++) {
            if (flota[i].getNombre().equals(s)) {
                return i; // Retorna la posición de la nave encontrada
            }
        }
        return -1; // Si no se encuentra, retorna -1
    }

    // Método que ordena por número de puntos de menor a mayor
    public static void ordenarPorPuntosBurbuja(Nave[] flota) {
        Nave aux;
        for (int i = 0; i < flota.length - 1; i++) {
            for (int j = 0; j < flota.length - 1 - i; j++) {
                if (flota[j].getPuntos() > flota[j + 1].getPuntos()) {
                    // Intercambiar las naves completas
                    aux = flota[j];
                    flota[j] = flota[j + 1];
                    flota[j + 1] = aux;
                }
            }
        }
    }

    // Método que ordena por nombre de A a Z
    public static void ordenarPorNombreBurbuja(Nave[] flota) {
        Nave aux;
        for (int i = 0; i < flota.length - 1; i++) {
            for (int j = 0; j < flota.length - 1 - i; j++) {
                if (flota[j].getNombre().compareTo(flota[j + 1].getNombre()) > 0) {
                    // Intercambiar las naves completas
                    aux = flota[j];
                    flota[j] = flota[j + 1];
                    flota[j + 1] = aux;
                }
            }
        }
    }

    // Método para buscar la primera nave con un nombre que se pidió por teclado
    public static int busquedaBinariaNombre(Nave[] flota, String nombreBuscado) {
        ordenarPorNombreBurbuja(flota); // Asegurarse de que el arreglo está ordenado
        int izquierda = 0;
        int derecha = flota.length - 1;

        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            int comparacion = flota[medio].getNombre().compareTo(nombreBuscado);

            if (comparacion == 0) {
                return medio; // Se encontró el nombre
            } else if (comparacion < 0) {
                izquierda = medio + 1; // Buscar en la mitad derecha
            } else {
                derecha = medio - 1; // Buscar en la mitad izquierda
            }
        }

        return -1; // No se encontró el nombre
    }

    // Método que ordena por número de puntos de menor a mayor
    public static void ordenarPorPuntosSeleccion(Nave[] flota) {
        int n = flota.length;

        for (int i = 0; i < n - 1; i++) {
            int indiceMin = i;
            for (int j = i + 1; j < n; j++) {
                if (flota[j].getPuntos() < flota[indiceMin].getPuntos()) {
                    indiceMin = j;
                }
            }

            // Intercambiar la nave con el mínimo valor con la nave en la posición i
            if (i != indiceMin) {
                Nave temp = flota[i];
                flota[i] = flota[indiceMin];
                flota[indiceMin] = temp;
            }
        }
    }

    // Método que ordena por nombre de A a Z
    public static void ordenarPorNombreSeleccion(Nave[] flota) {
        int n = flota.length;

        for (int i = 0; i < n - 1; i++) {
            int indiceMin = i;
            for (int j = i + 1; j < n; j++) {
                if (flota[j].getNombre().compareTo(flota[indiceMin].getNombre()) < 0) {
                    indiceMin = j;
                }
            }

            // Intercambiar la nave con el mínimo valor con la nave en la posición i
            if (i != indiceMin) {
                Nave temp = flota[i];
                flota[i] = flota[indiceMin];
                flota[indiceMin] = temp;
            }
        }
    }

    // Método que ordena por número de puntos de menor a mayor
    public static void ordenarPorPuntosInsercion(Nave[] flota) {
        for (int i = 1; i < flota.length; i++) {
            Nave clave = flota[i];
            int j = i - 1;

            while (j >= 0 && flota[j].getPuntos() > clave.getPuntos()) {
                flota[j + 1] = flota[j];
                j--;
            }
            flota[j + 1] = clave;
        }
    }

    // Método que ordena por nombre de A a Z
    public static void ordenarPorNombreInsercion(Nave[] flota) {
        for (int i = 1; i < flota.length; i++) {
            Nave clave = flota[i];
            int j = i - 1;

            while (j >= 0 && flota[j].getNombre().compareTo(clave.getNombre()) > 0) {
                flota[j + 1] = flota[j];
                j--;
            }
            flota[j + 1] = clave;
        }
    }
}
