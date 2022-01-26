import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static boolean isVowel(char ch) {
        // write your code here
        String vocal = String.valueOf(ch).toLowerCase();
        if (Objects.equals(vocal, "a") || Objects.equals(vocal, "e") || Objects.equals(vocal, "i") || Objects.equals(vocal, "o") || Objects.equals(vocal, "u")) {
            return true;
        }else {
            return false;
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char letter = scanner.nextLine().charAt(0);
        System.out.println(isVowel(letter) ? "YES" : "NO");
    }
}