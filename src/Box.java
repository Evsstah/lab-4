public class Box<T> {
    private T number;

    public Box() {
        this.number = null;
    }

    public void setNumber(T number) {
        if (this.number != null) {
            throw new IllegalStateException("Коробка не пуста.");
        }
        this.number = number;
    }

    public T getNumber() {
        if (this.number == null) {
            throw new IllegalStateException("Коробка пуста.");
        }
        T temp = this.number;
        this.number = null;
        return temp;
    }

    public boolean isEmpty() {
        return this.number == null;
    }


    @Override
    public String toString() {
        return "[ " + number + " ]";
    }
}
