import java.util.Scanner;

public class Main {
    public static int busqueda(int index, int[] matriz) {
        int right = matriz.length - 1;
        int left = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (index == matriz[mid]) {
                return mid + 1;
            } else if (index < matriz[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] matriz = new int[num];

        for (int i = 0; i < num; i++) {
            matriz[i] = scanner.nextInt();
        }

        int num2 = scanner.nextInt();
        int[] matriz2 = new int[num2];

        for (int i = 0; i < num2; i++) {
            matriz2[i] = scanner.nextInt();
        }

        for (int valor : matriz2) {
            System.out.print(busqueda(valor, matriz) + " ");
        }
    }
}