package phonebook;

public class BubbleSortJump implements Algoritmo {
    @Override
    public void busqueda(String[] directorio, String[] personas) {
        long time = System.currentTimeMillis();
        long minutes = 0;

        for (int i = 0; i < directorio.length - 1; i++) {
            for (int j = 0; j < directorio.length - i - 1; j++) {
                if (directorio[j].compareTo(directorio[j + 1]) > 0) {
                    String temp = directorio[j];
                    directorio[j] = directorio[j + 1];
                    directorio[j + 1] = temp;
                }
                long totalMilliseconds = System.currentTimeMillis() - time;
                minutes = (totalMilliseconds / 1000) / 60;
                if (minutes >= 1) {
                    break;
                }
            }
            if (minutes >= 1) {
                break;
            }
        }
    }
}
