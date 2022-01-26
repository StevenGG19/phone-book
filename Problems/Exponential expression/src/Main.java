import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        double num = scanner.nextDouble();
        double re = Math.pow(num, 3.0) + Math.pow(num, 2.0) + num + 1;

        System.out.println(re);
    }
}