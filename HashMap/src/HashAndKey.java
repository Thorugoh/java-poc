public class HashAndKey {
    int hash;
    String key;

    HashAndKey(int hash, String key) {
        this.hash = hash;
        this.key = key;
    }

    @Override
    public int hashCode() {
        System.out.println("calling hashCode for key: " + key + " with hash: " + hash);
        return this.hash;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("calling equals for key: " + key + " and obj: " + obj);
        return key.equals(obj.toString());
    }
}
