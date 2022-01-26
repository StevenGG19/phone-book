package phonebook;

public class ElegirBusqueda {
    private Algoritmo algoritmo;

    public void setMethod(Algoritmo algoritmo) {
        this.algoritmo = algoritmo;
    }

    public void busqueda(String[] dato, String[] dato2) {
        this.algoritmo.busqueda(dato, dato2);
    }
}
