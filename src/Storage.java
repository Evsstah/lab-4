public class Storage<T> {
    private final T number;

    public Storage(T number) {
        this.number = number;
    }

    public T getNumberOrDefault(T defaultNumber) {
        if (number != null) {
            return number;
        } else {
            return defaultNumber;
        }
    }
}