import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Busqueda {

    public static void main(String[] args) {
        int[] arreglo = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int elementoBuscado = 17;

        // Busqueda binaria
        int indiceBinario = busquedaBinaria(arreglo, elementoBuscado);
        if (indiceBinario != -1) {
            System.out.println("El elemento " + elementoBuscado + " fue encontrado en la posición " + indiceBinario + " (busqueda binaria).");
        } else {
            System.out.println("El elemento " + elementoBuscado + " no fue encontrado (busqueda binaria).");
        }

        // Busqueda secuencial
        int indiceSecuencial = busquedaSecuencial(arreglo, elementoBuscado);
        if (indiceSecuencial != -1) {
            System.out.println("El elemento " + elementoBuscado + " fue encontrado en la posición " + indiceSecuencial + " (busqueda secuencial).");
        } else {
            System.out.println("El elemento " + elementoBuscado + " no fue encontrado (busqueda secuencial).");
        }

        // Leer y mostrar el contenido del archivo de pseudocódigo
        try {
            File file = new File("algoritmos_busqueda.txt");
            Scanner scanner = new Scanner(file);
            System.out.println("\nPseudocódigo de los algoritmos de búsqueda:\n");
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error al abrir el archivo: " + e.getMessage());
        }
    }

    // Implementación del método de búsqueda binaria
    public static int busquedaBinaria(int[] arreglo, int elemento) {
        int inicio = 0;
        int fin = arreglo.length - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;

            if (arreglo[medio] == elemento) {
                return medio; // El elemento fue encontrado
            }

            if (arreglo[medio] < elemento) {
                inicio = medio + 1; // El elemento está en la mitad derecha
            } else {
                fin = medio - 1; // El elemento está en la mitad izquierda
            }
        }

        return -1; // El elemento no fue encontrado
    }

    // Implementación del método de búsqueda secuencial
    public static int busquedaSecuencial(int[] arreglo, int elemento) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == elemento) {
                return i; // El elemento fue encontrado
            }
        }

        return -1; // El elemento no fue encontrado
    }
}
