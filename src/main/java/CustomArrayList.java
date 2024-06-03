import java.util.*;

/**
 * A custom implementation of an ArrayList with fixed initial capacity.
 *
 * @param <E> the type of elements in this list
 */
public class CustomArrayList<E>{
    private Object[] array;
    private int size;
    private final int capacity;

    /**
     * Constructs an empty list with an initial capacity of 10.
     */
    public CustomArrayList() {
        this.size = 0;
        this.capacity = 10;
        this.array = new Object[capacity];
    }

    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param capacity the initial capacity of the list
     * @throws IllegalArgumentException if the specified initial capacity is zero or is negative
     */
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

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int size() {
        return size;
    }

    /**
     * Returns the current capacity of this list.
     *
     * @return the current capacity of this list
     */
    public int getCapacity() {
        return array.length;
    }

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param e element to be appended to this list
     */
    public void add(E e) {
        if (e != null) {
            if (size == array.length) {
                grow();
            }
            array[size++] = e;
        }
    }

    /**
     * Inserts the specified element at the specified position in this list.
     *
     * @param index index at which the specified element is to be inserted
     * @param e element to be inserted
     * @throws IllegalArgumentException if the index is out of range (index < 0 || index > size)
     */
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

    /**
     * Appends all of the elements in the specified list to the end of this list.
     *
     * @param list list containing elements to be added to this list
     */
    public void addAll(CustomArrayList<? extends E> list) {
        while ((size + list.size > array.length)) {
            grow();
        }
        for (int i = 0; i < list.array.length; i++) {
            add(list.get(i));
        }
    }

    /**
     * Appends all of the elements in the specified array to the end of this list.
     *
     * @param list array containing elements to be added to this list
     */
    public void addAllFromArray(E[] list) {
        while ((size + list.length > array.length)) {
            grow();
        }
        for (E e : list) {
            if (e != null) {
                add(e);
            }
        }
    }

    /**
     * Appends all of the elements in the specified collection to the end of this list.
     *
     * @param list collection containing elements to be added to this list
     */
    public void addAllCollection(Collection<? extends E> list) {
        addAllFromArray((E[]) list.toArray());
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param index index of the element to replace
     * @param e element to be stored at the specified position
     * @throws IllegalArgumentException if the index is out of range (index < 0 || index > size)
     */
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Illegal index: " + index);
        }
        array[index] = e;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     */
    public E get(int index) {
        return (E) array[index];
    }

    /**
     * Removes the element at the specified position in this list.
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     * @throws IllegalArgumentException if the index is out of range (index < 0 || index > size)
     */
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

    /**
     * Removes all of the elements from this list.
     * The list will be empty after this call returns.
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    /**
     * Returns an array containing all of the elements in this list in proper sequence (from first to last element).
     *
     * @return an array containing all of the elements in this list in proper sequence
     */
    public Object[] toArray() {
        return array;
    }

    /**
     * Increases the capacity of this list, if necessary, to ensure that it can hold at least the number of elements specified.
     */
    private void grow() {
        Object[] newArray = new Object[array.length * 2];
        newArray = Arrays.copyOf(array, newArray.length);
        array = newArray;
    }

    /**
     * Returns a string representation of this list.
     *
     * @return a string representation of this list
     */
    @Override
    public String toString() {
        return "CustomArrayList{" +
                Arrays.toString(array) +
                '}';
    }

}