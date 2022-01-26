import java.util.*;

public class Main {
    static int con = 0;
    public static int jumpSearch(int[] array, int target) {
        int currentRight = 0; // right border of the current block
        int prevRight = 0; // right border of the previous block

        /* If array is empty, the element is not found */
        if (array.length == 0) {
            return -1;
        }

        /* Check the first element */
        if (array[currentRight] == target) {
            return 1;
        }

        /* Calculating the jump length over array elements */
        int jumpLength = (int) Math.sqrt(array.length);

        /* Finding a block where the element may be present */
        while (currentRight < array.length - 1) {

            /* Calculating the right border of the following block */
            currentRight = Math.min(array.length - 1, currentRight + jumpLength);

            if (array[currentRight] >= target) {
                con++;
                break; // Found a block that may contain the target element
            }
            con++;
            prevRight = currentRight; // update the previous right block border
        }

        /* If the last block is reached and it cannot contain the target value => not found */
        if (currentRight == array.length - 1 && target > array[currentRight]) {
            return ++con;
        }

        /* Doing linear search in the found block */
        return backwardSearch(array, target, prevRight, currentRight);
    }

    public static int backwardSearch(int[] array, int target, int leftExcl, int rightIncl) {
        for (int i = rightIncl; i > leftExcl; i--) {
            if (target >= array[i]) {
                return ++con;
            }
            con++;
        }
        return con;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] matriz = new int[num];

        for (int i = 0; i < num; i++) {
            matriz[i] = scanner.nextInt();
        }
        int index = scanner.nextInt();
        System.out.println(jumpSearch(matriz, index));
    }
}