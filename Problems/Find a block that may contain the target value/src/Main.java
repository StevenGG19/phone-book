import java.util.Scanner;

class Main {
    public static String jump(int num, int[] matriz, int index) {
        int indexIzq = 0;
        int cantidadSaltos = 0;
        if (matriz.length <= 0) {
            return "-1";
        }
        int saltos = (int) Math.sqrt(num);

        while (indexIzq + 1 < num) {
            indexIzq = Math.min(num - 1, cantidadSaltos + saltos - 1);
            if (matriz[indexIzq] >= index) {
                return cantidadSaltos + " " + indexIzq;
            }
            cantidadSaltos += saltos;
        }
        return "-1";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] matriz = new int[num];

        for (int i = 0; i < num; i++) {
            matriz[i] = scanner.nextInt();
        }

        int valor = scanner.nextInt();

        System.out.println(jump(num, matriz, valor));
    }
}