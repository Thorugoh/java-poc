// Different from a consumer which takes in a value and returns nothing
// or a function which takes in a value and returns another value
// A supplier takes in nothing and returns a value

// Structure of a Supplier
@FunctionalInterface
public interface Supplier<T> {
    T get();
}
