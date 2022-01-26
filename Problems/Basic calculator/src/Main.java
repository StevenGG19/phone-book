import java.util.Scanner;

class Problem {

    public static void main(String[] args) {
        switch (args[0]) {
            case "+":
                int suma = Integer.parseInt(args[1]) + Integer.parseInt(args[2]);
                System.out.println(suma);
                break;
            case "-":
                int resta = Integer.parseInt(args[1]) - Integer.parseInt(args[2]);
                System.out.println(resta);
                break;
            case "*":
                int multi = Integer.parseInt(args[1]) * Integer.parseInt(args[2]);
                System.out.println(multi);
                break;
            default:
                System.out.println("Unknown operator");

        }
    }
}