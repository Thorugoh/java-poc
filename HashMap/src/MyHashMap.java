public class MyHashMap<K, V>{
    private Node<K, V>[] table;
    private int capacity = 16;
    private int size = 0;

    public MyHashMap(int capacity) {
        this.capacity = capacity;
        table = new Node[capacity];
    }

    private int getHash(K key) {
        return (key == null) ? 0 : Math.abs(key.hashCode());
    }

    private int getIndex(K key) {
        return getHash(key) % capacity;
    }

    private void resize(){
        int oldCapacity = capacity;
        capacity = oldCapacity * 2;

        Node<K, V>[] oldTable = table;
        table = new Node[capacity];

        size = 0;

        for(int i = 0; i < oldCapacity; i++){
            Node<K, V> current = oldTable[i];

            while(current != null) {
                put(current.key, current.value);
                current = current.next;
            }
        }
    }

    public V get(K key) {
        int index = getIndex(key);
        int hash = getHash(key);

        Node<K, V> current = table[index];

        while (current != null) {
            if(current.hash == hash && (current.key == key || current.key.equals(key))) {
                return current.value;
            }
            current = current.next;
        }

        return null;
    }

    public void put(K key, V value) {
        if (size >= capacity * 0.75) {
            resize();
        }

        int index = getIndex(key);
        int hash = getHash(key);

        if(table[index] == null) {
            table[index] = new Node<>(hash, key, value, null);
            size++;
        } else {
            Node<K, V> current = table[index];
           while (current != null) {
               if (current.hash == hash && current.key.equals(key)) {
                   current.value = value;
                   return;
               }
               if(current.next == null) {
                   current.next = new Node<>(hash, key, value, null);
                   size++;
                   return;
               }
               current = current.next;
           }
        }
    }
}

class HashMapExample {
    public static void main(String[] args) {
        MyHashMap<String, String> map = new MyHashMap<>(4);

        map.put("name", "Victor Hugo");
        map.put("age", "29");
        map.put("city", "Florianopolis");
        map.put("gender", "Male");

        System.out.println(map.get("name"));
    }
}