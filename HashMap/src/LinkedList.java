public class LinkedList<K, V>{
    private Node <K, V> head;
    private int size;

    public void addOrUpdate(int hash, K key, V value) {
        Node<K, V> current = head;
        while (current != null) {
            if (current.hash == hash && current.key.equals(key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }
        head = new Node<>(hash, key, value, head);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<K, V> current = head;
        while (current != null) {
            sb.append("[").append(current.key).append(": ").append(current.value).append("] -> ");
            current = current.next;
        }
        sb.append("null");
        return sb.toString();
    }
}

class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<String, String> list = new LinkedList<>();
        list.addOrUpdate(1, "name", "Victor");
        list.addOrUpdate(2, "age", "29");
        list.addOrUpdate(3, "city", "Florianopolis");
        list.addOrUpdate(1, "name", "Hugo");

        System.out.println("LinkedList operations completed." + list);
    }
}
