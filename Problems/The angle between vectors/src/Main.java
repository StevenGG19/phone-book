import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        double num = scanner.nextDouble();
        double num2 = scanner.nextDouble();
        double num3 = scanner.nextDouble();
        double num4 = scanner.nextDouble();

        double v1 = Math.hypot(num, num2);
        double v2 = Math.hypot(num3, num4);

        double ab = num * num3 + num2 * num4;

        double valor = ab / (v1 * v2);

        System.out.println(Math.toDegrees(Math.acos(valor)));
    }
}