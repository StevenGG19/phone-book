import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] matriz = new int[num];
        boolean valor = false;

        for (int i = 0; i < num; i++) {
            matriz[i] = scanner.nextInt();
        }

        int right = num - 1;
        int left = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid == matriz[mid]) {
                valor = true;
                break;
            } else if (mid < matriz[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(valor);
    }
}