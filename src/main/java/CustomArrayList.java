import java.util.*;


public class CustomArrayList<E> {
    private Object[] array;
    private int size;
    private final int capacity;

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

    public int size() {
        return size;
    }

    public int getCapacity() { return array.length; }

    public boolean isEmpty() {
        return size == 0;
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
        addAllFromArray((E[]) list.toArray());
    }

    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Illegal index: " + index);
        }
        array[index] = e;
    }

    public E get(int index) {
        return (E) array[index];
    }

    public Object remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Illegal index: " + index);
        }
        Object removedObject = array[index];
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return removedObject;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    public Object[] toArray() {
        return array;
    }

    private void grow() {
        Object[] newArray = new Object[array.length * 2];
        newArray = Arrays.copyOf(array, newArray.length);
        array = newArray;
    }

    @Override
    public String toString() {
        return "CustomArrayList{" +
                Arrays.toString(array) +
                '}';
    }

}

