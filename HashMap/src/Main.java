import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<HashAndKey, String> map = new HashMap<>();

        var key1 = new HashAndKey(1, "name");
        map.put(key1, "Victor Hugo");
        map.put(new HashAndKey(2, "age"), "29");
        map.put(new HashAndKey(3, "city"), "Florianopolis");

        System.out.println(map.get(key1));

    }
}