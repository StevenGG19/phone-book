package phonebook;

public class BusquedaHash implements Algoritmo{
    @Override
    public void busqueda(String[] directorio, String[] personas) {
        long[] dir = ids(directorio);
        long [] per = ids(personas);
        HashTable<String> hashTable = new HashTable<>(dir.length);
        HashTable<String> hashTable2 = new HashTable<>(dir.length);
        int con = 0;
        for (int i = 0; i < directorio.length; i++) {
            hashTable.put(dir[i], directorio[i]);
        }

        for (int i = 0; i < per.length; i++) {
            hashTable2.put(per[i], personas[i]);
        }


    }

    public long[] ids(String[] inf) {
        String valor = " ";
        long[] datos = new long[inf.length];
        for (int i = 0; i < inf.length; i++) {
            String[] nombre = inf[i].split(" ");
            if (nombre[0].length() > 1) {
                valor += nombre[0].codePointAt(0);
                valor += nombre[0].codePointAt(1);
            } else {
                valor += nombre[0].codePointAt(0);
            }
            if (nombre.length == 2) {
                valor += nombre[1].codePointAt(0);
                valor += nombre[1].codePointAt(1);
            }
            datos[i] = Long.parseLong(valor.trim());
            valor = " ";
        }
        return datos;
    }
}
