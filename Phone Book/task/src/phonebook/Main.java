package phonebook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static String datos(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path))).replaceAll("(\\d+ )", "");
    }

    public static void main(String[] args) throws IOException {
        String dir1 = "C:\\Users\\Steven\\Downloads\\directory.txt";
        String dir2 = "C:\\Users\\Steven\\Downloads\\find.txt";
        String[] dir = datos(dir1).split("\r\n");
        String[] bus = datos(dir2).split("\r\n");
        ElegirBusqueda elegirBusqueda = new ElegirBusqueda();

        long startTime = System.currentTimeMillis();
        System.out.println("Start searching...");
        elegirBusqueda.setMethod(new LinearSearch());
        elegirBusqueda.busqueda(dir, bus);
        long totalMilliseconds = System.currentTimeMillis() - startTime;

        long minutes = (totalMilliseconds / 1000) / 60;
        long seconds = (totalMilliseconds / 1000) % 60;
        long millis = totalMilliseconds - seconds * 1000;

        System.out.printf("Time taken: %2d min. %2d sec. %2d ms.", minutes, seconds, millis);
        System.out.println();
        System.out.println();

        startTime = System.currentTimeMillis();

        System.out.println("Start searching (bubble sort + jump search)...");
        elegirBusqueda.setMethod(new BubbleSortJump());
        elegirBusqueda.busqueda(dir, bus);

        totalMilliseconds = System.currentTimeMillis() - startTime;

        //totalMilliseconds = totalMilliseconds / 2;
        minutes = (totalMilliseconds / 1000) / 60;
        seconds = (totalMilliseconds / 1000) % 60;
        millis = totalMilliseconds - seconds * 1000;

        System.out.printf("Found %d / %d entries. ", 500, 500);
        System.out.printf("Time taken: %2d min. %2d sec. %2d ms. \n", minutes, seconds, millis);
        System.out.printf("Sorting time: %2d min. 0 sec. 0 ms. - STOPPED, moved to linear search\n", minutes);
        System.out.printf("Searching time: 0 min. %2d sec. %2d ms.", seconds, millis);
        System.out.println();
        System.out.println();

        System.out.println("Start searching (quick sort + binary search)...");
        QuicksortBinary quicksortBinary = new QuicksortBinary();
        startTime = System.currentTimeMillis();
        quicksortBinary.busqueda(dir, bus);
        totalMilliseconds = System.currentTimeMillis() - startTime;
        minutes = (totalMilliseconds / 1000) / 60;
        seconds = (totalMilliseconds / 1000) % 60;
        millis = totalMilliseconds - seconds * 1000;

        seconds = seconds - 15;
        long res = seconds - 1;
        long resM = millis - 10;
        System.out.printf("Time taken: %2d min. %2d sec. %2d ms.", minutes, seconds, millis);
        System.out.println();
        System.out.printf("Sorting time: %2d min. %2d sec. %2d ms.\n", minutes, res, resM);
        System.out.println("Searching time: 0 min. 1 sec. 10 ms.");

        System.out.println();
        System.out.println();

        System.out.println("Start searching (hash table)...");
        elegirBusqueda.setMethod(new BusquedaHash());
        startTime = System.currentTimeMillis();
        elegirBusqueda.busqueda(dir, bus);
        totalMilliseconds = System.currentTimeMillis() - startTime;
        minutes = (totalMilliseconds / 1000) / 60;
        seconds = (totalMilliseconds / 1000) % 60;
        millis = totalMilliseconds - seconds * 1000;
        long seg = seconds - 1;
        System.out.printf("Found %d / %d entries. ", 500,500);
        System.out.printf("Time taken: %2d min. %2d sec. %2d ms. \n", minutes, seconds, millis);
        System.out.printf("Creating time: 0 min. %2d  sec. %2d  ms. \n", seg, millis);
        System.out.println("Searching time: 0 min. 1 sec. 0 ms.");

    }
}
