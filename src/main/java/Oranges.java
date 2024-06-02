import java.util.Comparator;
import java.util.Objects;

public class Oranges implements Comparator<Oranges>{
    private final int size;

    public Oranges() {
        size = (int) (10 * Math.random()+1);
    }

    public Oranges(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }


    @Override
    public String toString() {
        return "Oranges{" +
                "size=" + size +
                '}';
    }


    @Override
    public int compare(Oranges o1, Oranges o2) {
        return o1.getSize()-o2.getSize();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Oranges oranges = (Oranges) o;
        return getSize() == oranges.getSize();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getSize());
    }

}