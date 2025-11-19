import java.util.Arrays;
import java.util.Scanner;

public class RotadorMatriz {
    private int[][] matriz;
    private int filas;
    private int columnas;

    public RotadorMatriz(int[][] matriz) {
        this.matriz = matriz;
        this.filas = matriz.length;
        this.columnas = matriz[0].length;
    }

    public void rotarDerecha() {
        int[][] nuevaMatriz = new int[columnas][filas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                nuevaMatriz[j][filas - 1 - i] = matriz[i][j];
            }
        }

        int temp = filas;
        filas = columnas;
        columnas = temp;
        matriz = nuevaMatriz;
    }

    public void rotarMultiplesVeces(int giros) {
        giros = giros % 4; // optimización 4 giros completan un ciclo
        for (int i = 0; i < giros; i++) {
            rotarDerecha();
        }
    }

    public void imprimirMatriz() {
        for (int[] fila : matriz) {
            for (int elemento : fila) {
                System.out.print(elemento + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el número de filas:");
        int filas = scanner.nextInt();
        System.out.println("Ingrese el número de columnas:");
        int columnas = scanner.nextInt();

        int[][] matriz = new int[filas][columnas];

        System.out.println("Ingrese los elementos de la matriz:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Número de giros a realizar:");
        int giros = scanner.nextInt();

        RotadorMatriz rotador = new RotadorMatriz(matriz);

        System.out.println("\nMatriz original:");
        rotador.imprimirMatriz();

        rotador.rotarMultiplesVeces(giros);

        System.out.println("\nMatriz después de " + giros + " giro(s):");
        rotador.imprimirMatriz();
    }
}