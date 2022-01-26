import java.util.*;

public class Main {
    public static int burbuja(int[] matriz) {
        int intercambio;
        int con = 0;
        for (int i = 0; i < matriz.length - 1; i++) {
            for (int j = 0; j < matriz.length - i - 1; j++) {
                if (matriz[j] < matriz[j + 1]) {
                    intercambio = matriz[j + 1];
                    matriz[j + 1] = matriz[j];
                    matriz[j] = intercambio;
                    con++;
                }
            }
        }
        return con;
    }

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        String[] num = scanner.nextLine().split("\\s+");
        int[] array = new int[num.length];

        for (int i = 0; i < num.length; i++) {
            array[i] = Integer.parseInt(num[i]);
        }

        System.out.println(burbuja(array));
    }
}