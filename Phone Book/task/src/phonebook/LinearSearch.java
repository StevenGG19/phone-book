package phonebook;

public class LinearSearch implements Algoritmo{
    @Override
    public void busqueda(String[] directorio, String[] personas) {
        int con = 0;
        for (String dato : personas) {
            for (String inf : directorio) {
                if (inf.equals(dato)) {
                    con++;
                    break;
                }
            }
        }
        System.out.printf("Found %d / %d entries. ", con, personas.length);
    }
}
