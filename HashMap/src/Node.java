public class Node<K, V> {
    K key;
    V value;
    Node<K, V> next;
    final int hash;

    Node(int hash, K key, V value, Node<K, V> next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }
}
