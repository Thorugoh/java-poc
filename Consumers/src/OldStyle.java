import java.util.function.Consumer;


class OldStyle {
    static Consumer<String> oldStyle = new Consumer<String>() {
        @Override
        public void accept(String s) {
            System.out.println("Old style consumer: " + s);
        }
    };


    public static void main(String[] args) {
        oldStyle.accept("Hello, World!");
    }
}