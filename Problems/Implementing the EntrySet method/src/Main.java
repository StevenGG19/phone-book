import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static class TableEntry<T> {
        private final int key;
        private final T value;

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

        public List<TableEntry> entrySet() {
            List<TableEntry> iterated = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (table[i] != null) {
                    iterated.add((TableEntry<T>) table[i]);
                }
            }
            return iterated;
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

        private void rehash() {
            // put your code here
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        HashTable<List<String>> userHash = new HashTable<>(size);
        for (int i = 0; i < size; i++) {
            int id = scanner.nextInt();
            String userName = scanner.next();
            List<String> existUser = userHash.get(id);
            if (existUser != null) {
                List<String> addingList = new ArrayList<>(existUser);
                addingList.add(userName);
                userHash.put(id, addingList);
            } else {
                userHash.put(id, List.of(userName));
            }
        }

        for (TableEntry<List<String>> entry : userHash.entrySet()) {
            String output = String.format("%d: %s", entry.getKey(),
                    String.join(" ", entry.getValue()));
            System.out.println(output);
        }
    }
}