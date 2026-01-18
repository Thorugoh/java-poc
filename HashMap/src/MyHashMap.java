public class MyHashMap<K, V>{
    private Node<K, V>[] table;
    private int capacity = 16;
    private int size = 0;

    public MyHashMap(int capacity) {
        table = new Node[capacity];
    }

    private int getHash(K key) {
        return (key == null) ? 0 : Math.abs(key.hashCode());
    }

    private int getIndex(K key) {
        return getHash(key) % capacity;
    }

    public void put(K key, V value) {
        int index = getIndex(key);

        Node<K, V> head = table[index];
        if(head == null) {
            table[index] = new Node<>(getHash(key), key, value, null);
            size++;
        } else {
           while (head != null) {
               if (head.hash == getHash(key) && head.key.equals(key)) {
                   head.value = value;
                   return;
               }
               if(head.next == null) {
                   head.next = new Node<>(getHash(key), key, value, null);
                   size++;
                   return;
               } else {
                   head = head.next;
               }
           }
        }
    }
}
