import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;


public class CustomArrayList<E> {
    private Object[] array;
    private int size;
    private final int capacity;

    @Override
    public String toString() {
        return "CustomArrayList{" +
                Arrays.toString(array) +
                '}';
    }

    public CustomArrayList() {
        this.size = 0;
        this.capacity = 10;
        this.array = new Object[capacity];
    }

    public CustomArrayList(int capacity) throws IllegalArgumentException {
        this.size = 0;
        this.capacity = capacity;

        if (capacity > 0) {
            this.array = new Object[capacity];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: Capacity should be greater than 0," +
                    " your capacity is: " + capacity);
        }
    }

    public void add(E e) {
        if (e != null) {
            if (size == array.length) {
                grow();
            }
            array[size++] = e;
        }

    }

    public void add(int index, E e) throws IllegalArgumentException {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Illegal index: " + index);
        }
        if (e != null) {
            if (size == array.length) {
                grow();
            }
            for (int i = size; i >= index; i--) {
                array[i + 1] = array[i];
            }
            array[index] = e;
            size++;
        }
    }

    public void addAll(CustomArrayList<? extends E> list) {
        while ((size + list.size > array.length)) {
            grow();
        }
        for (int i = 0; i < list.array.length; i++) {
            add(list.get(i));
        }
    }

    public void addAllFromArray(E[] list) {
        while ((size + list.length > array.length)) {
            grow();
        }
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                add((list[i]));
            }
        }
    }

    public void addAllCollection(Collection<? extends E> list) {
//        E[] list1 = (E[]) list.toArray();
        addAllFromArray((E[]) list.toArray());
    }

    public E get(int index) {
        return (E) array[index];
    }

    public void remove(int index) {
        array[index] = null;
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        array[size--] = null;
    }

    public void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
            size--;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Object[] toArray(CustomArrayList<E> a) {
        return a.array;
    }

    private void grow() {
        Object[] newArray = new Object[array.length * 2];
        newArray = Arrays.copyOf(array, newArray.length);
        array = newArray;
    }

    public static void main(String[] args) {


        List<String> list = List.of("12", "213", "12", "12", "43");
        System.out.println();
        CustomArrayList<Integer> intList = new CustomArrayList<>(1);
        System.out.println(intList.size);
        System.out.println(intList.array.length);
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        System.out.println(intList.size);
        System.out.println(intList.array.length);
//        System.out.println("Get "+intList.array[0]);
//
//        System.out.println(intList.isEmpty());
//        System.out.println(intList.size());
//        intList.remove(3);
//        System.out.println(intList.size());
        for (int i = 0; i < intList.size(); i++) {
            System.out.println("NUMBER "+ intList.get(i));}
        System.out.println("______________________________-");
        intList.add(2, 10);
        for (int i = 0; i < intList.size(); i++) {
            System.out.println("NUMBER "+ intList.get(i));}
        System.out.println("______________________________-");
        intList.remove(1);
        for (int i = 0; i < intList.size(); i++) {
            System.out.println("NUMBER "+ intList.get(i));}
        CustomArrayList<Integer> toAddList = new CustomArrayList<>(5);
        toAddList.add(1);
        toAddList.add(2);
        toAddList.add(3);
        toAddList.add(4);
        toAddList.add(5);
        System.out.println(intList.size());
        Integer[] array = {1, 2, 3, 4, 5};
        List<Integer> list1 = List.of(10, 20, 30);
        Set<Integer> set = Set.of(25, 35, 45);
        String[] string = {"asd", "sad", "asd", "4", "5"};
        intList.addAllFromArray(array);
        System.out.println("intList"+intList.size());
        intList.addAllCollection(list1);
        intList.addAllCollection(set);
        System.out.println("intList"+intList.size());
        for (int i = 0; i < intList.size(); i++) {
            System.out.println("NUMBERS "+ intList.get(i));}
        System.out.println("size"+toAddList.size());
        toAddList.clear();
        System.out.println("size"+toAddList.size());
        for (int i = 0; i < toAddList.size; i++) {
            System.out.println("number "+ toAddList.get(i));
        }
        intList.addAll(toAddList);
        System.out.println("intList"+intList.size());
        intList.remove(5);
        System.out.println("intList"+intList.size());


        System.out.println(intList.array.length);
        intList.add(5);
        intList.add(5);
        System.out.println(intList.size);
        System.out.println(intList.array.length);
    }
}

