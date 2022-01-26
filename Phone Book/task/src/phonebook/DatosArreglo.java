package phonebook;

public class DatosArreglo<T> {
    private final T cadena;
    private final long key;

    public DatosArreglo(long key, T cadena) {
        this.key = key;
        this.cadena = cadena;
    }
    public long getKey() {
        return key;
    }
    public T getCadena() {
        return cadena;
    }
}
