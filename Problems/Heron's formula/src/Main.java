import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scaner = new Scanner(System.in);
        int num = scaner.nextInt();
        int num2 = scaner.nextInt();
        int num3 = scaner.nextInt();
        double p = (num + num2 + num3) / 2.0;

        System.out.println(Math.sqrt(p * ((p - num) * (p - num2) * (p - num3))));
    }
}