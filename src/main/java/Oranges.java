import java.util.Comparator;
import java.util.Objects;

public class Oranges implements Comparator<Oranges>{
    private final int size;

    public Oranges() {
        size = (int) (10 * Math.random()+1);
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


//    public static int compareTo(Oranges o1, Oranges o2) {
//        return o1.getSize() - o2.getSize();
//
//    }



    public static void main(String[] args) {
        Oranges orange1 = new Oranges();
        Oranges orange2 = new Oranges();
        Oranges orange3 = new Oranges();
        Oranges orange4 = new Oranges();
        Oranges orange5 = new Oranges();
        Oranges orange6 = new Oranges();
        Oranges orange7 = new Oranges();
        Oranges orange8 = new Oranges();
        System.out.println(orange1.getSize());
        System.out.println(orange2.getSize());
        CustomArrayList<Oranges> list = new CustomArrayList<>();
        list.add(orange1);
        list.add(orange2);
        list.add(orange3);
        list.add(orange4);
        list.add(orange5);
        list.add(orange6);
        list.add(orange7);
        list.add(orange8);
        list.add(orange8);
        list.add(orange8);
        list.add(orange8);
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(CustomQuickSort.quickSort(list));
        CustomArrayList<Oranges> list1 = CustomQuickSort.quickSort(list);
        System.out.println(list1);
    }
}