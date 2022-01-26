package phonebook;

public class QuicksortBinary implements Algoritmo{
    @Override
    public void busqueda(String[] directorio, String[] personas) {
        directorio = quickSort(directorio, 0, directorio.length - 1);
        int con = 0;
        for (int i = 0; i < personas.length; i++) {
            int left = 0;
            int right = directorio.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2; // the index of the middle element

                if (personas[i].equals(directorio[mid])) {
                    con++;
                    break;
                } else if (personas[i].compareTo(directorio[mid]) < 0) {
                    right = mid - 1; // go to the left subarray
                } else {
                    left = mid + 1;  // go the the right subarray
                }
            }
        }
        System.out.printf("Found %d / %d entries. ", con, personas.length);
    }
    public static String[] quickSort(String[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(array, left, right); // the pivot is already on its place
            quickSort(array, left, pivotIndex - 1);  // sort the left subarray
            quickSort(array, pivotIndex + 1, right); // sort the right subarray
        }
        return array;

    }
    private static int partition(String[] array, int left, int right) {
        String pivot = array[right];  // choose the rightmost element as the pivot
        int partitionIndex = left; // the first element greater than the pivot

        /* move large values into the right side of the array */
        for (int i = left; i < right; i++) {
            if (array[i].compareTo(pivot) <= -1) { // may be used '<' as well
                swap(array, i, partitionIndex);
                partitionIndex++;
            }
        }

        swap(array, partitionIndex, right); // put the pivot on a suitable position

        return partitionIndex;
    }

    private static void swap(String[] array, int i, int j) {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

