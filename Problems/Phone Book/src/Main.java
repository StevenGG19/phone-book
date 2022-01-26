import java.util.Scanner;

public class Main {
    private static class TableEntry<T> {
        private final int key;
        private final T value;
        private boolean removed;

        public TableEntry(int key, T value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public T getValue() {
            return value;
        }

        public void remove() {
            removed = true;
        }

        public boolean isRemoved() {
            return removed;
        }
    }

    private static class HashTable<T> {
        private int size;
        private TableEntry[] table;

        public HashTable(int size) {
            this.size = size;
            table = new TableEntry[size];
        }

        public boolean put(int key, T value) {
            int idx = findKey(key);

            if (idx == -1) {
                return false;
            }

            table[idx] = new TableEntry(key, value);
            return true;
        }

        public T get(int key) {
            int idx = findKey(key);

            if (idx == -1 || table[idx] == null) {
                return null;
            }

            return (T) table[idx].getValue();
        }

        public void remove(int key) {
            int idx = findKey(key);
            if (idx != -1 || table[idx] != null) {
                table[idx] = null;
            }
        }

        private int findKey(int key) {
            int hash = key % size;

            while (!(table[hash] == null || table[hash].getKey() == key)) {
                hash = (hash + 1) % size;

                if (hash == key % size) {
                    return -1;
                }
            }

            return hash;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        HashTable<String> table = new HashTable<>(num);
        String[] action = new String[num + 1];

        for (int i = 0; i < action.length; i++) {
            action[i] = scanner.nextLine();
        }

        for (String datos : action) {
            String[] inf = datos.split(" ");
            if (inf[0].equals("put")) {
                table.put(Integer.parseInt(inf[1]), inf[2]);
            } else if (inf[0].equals("get")) {
                String valor = table.get(Integer.parseInt(inf[1]));
                System.out.println(valor == null ? -1 : valor);
            } else if (inf[0].equals("remove")) {
                table.remove(Integer.parseInt(inf[1]));
            }
        }
    }
}