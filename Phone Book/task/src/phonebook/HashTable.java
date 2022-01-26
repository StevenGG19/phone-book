package phonebook;

public class HashTable<T> {
    private DatosArreglo[] table;
    private final int size;

    public HashTable(int size) {
        this.size = size;
        this.table = new DatosArreglo[size];
    }
    public boolean put(long key, T cadena) {
        int id = findKey(key);
        if (id == -1) {
            return false;
        }
        table[id] = new DatosArreglo(key, cadena);
        return true;
    }
    public T get(int key) {
        int id = findKey(key);
        if (table[id] == null || id == -1) {
            return null;
        }
        return (T) table[id].getCadena();
    }
    public int findKey(long key) {
       int hash = (int) (key % size);
        while (!(table[hash] == null || table[hash].getKey() == key)) {
           hash = (hash + 1) % size;
           if (hash == key % size) {
               return -1;
           }
       }
        return hash;
    }
}
