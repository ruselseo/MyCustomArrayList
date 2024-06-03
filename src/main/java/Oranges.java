import java.util.Comparator;
import java.util.Objects;

/**
 * Represents an orange with a specified size. This class implements {@link Comparator}
 * to compare oranges based on their size.
 */
public class Oranges implements Comparator<Oranges> {
    private final int size;

    /**
     * Constructs an orange with a random size between 1 and 10 (inclusive).
     */
    public Oranges() {
        size = (int) (10 * Math.random() + 1);
    }

    /**
     * Constructs an orange with the specified size.
     *
     * @param size the size of the orange
     */
    public Oranges(int size) {
        this.size = size;
    }

    /**
     * Returns the size of this orange.
     *
     * @return the size of this orange
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns a string representation of this orange.
     *
     * @return a string representation of this orange
     */
    @Override
    public String toString() {
        return "Oranges{" +
                "size=" + size +
                '}';
    }

    /**
     * Compares two oranges based on their size.
     *
     * @param o1 the first orange to be compared
     * @param o2 the second orange to be compared
     * @return a negative integer, zero, or a positive integer as the first orange
     *         is less than, equal to, or greater than the second orange
     */
    @Override
    public int compare(Oranges o1, Oranges o2) {
        return o1.getSize() - o2.getSize();
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o the reference object with which to compare
     * @return {@code true} if this object is the same as the obj
     *         argument; {@code false} otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Oranges oranges = (Oranges) o;
        return getSize() == oranges.getSize();
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(getSize());
    }
}