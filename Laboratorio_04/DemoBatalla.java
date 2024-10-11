import java.util.*; 
public class DemoBatalla { 
 
 public static void main(String [] args){ 
     Nave [] misNaves = new Nave[8]; 
     Scanner sc = new Scanner(System.in); 
     String nombre, col; 
    int fil, punt; 
    boolean est; 
             
        for (int i = 0; i < misNaves.length; i++) { 
              System.out.println("Nave " + (i+1)); 
                System.out.print("Nombre: "); 
           nombre = sc.next(); 
           System.out.println("Fila "); 
           fil = sc.nextInt(); 
           System.out.print("Columna: "); 
           col = sc.next(); 
           System.out.print("Estado: "); 
           est = sc.nextBoolean(); 
           System.out.print("Puntos: "); 
           punt = sc.nextInt(); 
     
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
 
 
//leer un nombre 
//mostrar los datos de la nave con dicho nombre, mensaje de “no encontrado” en caso contrario 
int pos=busquedaLinealNombre(misNaves,nombre); 
 
ordenarPorPuntosBurbuja(misNaves); 
mostrarNaves(misNaves); 
ordenarPorNombreBurbuja(misNaves); 
mostrarNaves(misNaves);

//mostrar los datos de la nave con dicho nombre, mensaje de “no encontrado” en caso contrario 
pos=busquedaBinariaNombre(misNaves,nomb); 
 
ordenarPorPuntosSeleccion(misNaves); 
mostrarNaves(misNaves); 
ordenarPorNombreSeleccion(misNaves); 
mostrarNaves(misNaves); 
ordenarPorPuntosInsercion(misNaves); 
mostrarNaves(misNaves); 
ordenarPorNombreInsercion(misNaves); 
mostrarNaves(misNaves); 
 } 
 
 //Método para mostrar todas las naves 
public static void mostrarNaves(Nave[] flota){ 
    for(int i = 0; i < flota.length; i++){
        System.out.println(flota);
    }      
//REUTILIZAR 
     } 
        
 //Método para mostrar todas las naves de un nombre que se pide por teclado 
public static void mostrarPorNombre(Nave[] flota){ 
    Scanner nay = new Scanner(System.in);
    String nombreBuscar;
    System.out.print("Ingrese el nombre de una Nave que desea buscar en la flota: ");
    nombreBuscar = nay.next();
    for(int i = 0; i < flota.length; i++){
        if(flota[i].getNombre().equals(nombreBuscar)){
            System.out.println(flota[i]);
        }else{
            System.out.println("Nave no encontrada");
        }

    }
//REUTILIZAR 
} 
   
//Método para mostrar todas las naves con un número de puntos inferior o igual 
//al número de puntos que se pide por teclado 
public static void mostrarPorPuntos(Nave[] flota){ 
    Scanner nay = new Scanner(System.in);
    int puntosBuscar;
    System.out.print("Ingrese una cantidad de puntos para buscar en la flota: ");
    puntosBuscar = nay.nextInt();
    for(int i = 0; i < flota.length; i++){
        if(flota[i].getPuntos() < puntosBuscar || flota[i].getPuntos() == puntosBuscar){
            System.out.println(flota[i]);
        }
    }
//REUTILIZAR 
} 
    
//Método que devuelve la Nave con mayor número de Puntos 
public static Nave mostrarMayorPuntos(Nave[] flota){
    int mayor = flota[0].getPuntos();
    int nuevoMayor = 0; 
    for(int i = 0; i < flota.length; i++){
        if(mayor < flota[i].getPuntos()){
            nuevoMayor = i;
        }
    }
    return flota[nuevoMayor];

//REUTILIZAR 
} 
 
//Método para buscar la primera nave con un nombre que se pidió por teclado 
public static void busquedaLinealNombre(Nave[] flota, String s){ 
    for(int i = 0; i < flota.length; i++){
        if(flota[i].getNombre().substring(0, 1).equals(s)){
            System.out.println(flota[i]);
            break;
        }else{
            System.out.println("Nave no encontrada");
        }
    }
} 
 
//Método que ordena por número de puntos de menor a mayor 
public static void ordenarPorPuntosBurbuja(Nave[] flota){ 
    int aux;
    for(int i = 0; i < (flota.length - 1); i++){
        for(int j = 0; j < (flota.length - 1 - i); i++){
            if(flota[j].getPuntos() > flota[j + 1].getPuntos()){


            }

        }
    }
 
} 
 
//Método que ordena por nombre de A a Z 
public static void ordenarPorNombreBurbuja(Nave[] flota){ 
 
} 
 
//Método para buscar la primera nave con un nombre que se pidió por teclado 
public static int busquedaBinariaNombre(Nave[] flota, String s){ 
 
} 
 
//Método que ordena por número de puntos de menor a mayor 
public static void ordenarPorPuntosSeleccion(Nave[] flota){ 
 
} 
 
//Método que ordena por nombre de A a Z 
public static void ordenarPorNombreSeleccion(Nave[] flota){ 
 
} 
 
//Método que muestra las naves ordenadas por número de puntos de mayor a menor 
public static void ordenarPorPuntosInsercion(Nave[] flota){ 
 
} 
 
//Método que muestra las naves ordenadas por nombre de Z a A 
public static void ordenarPorNombreInsercion(Nave[] flota){ 
 
} 
} 