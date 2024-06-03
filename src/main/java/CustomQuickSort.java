import java.util.Comparator;

/**
 * A utility class that provides a custom implementation of the QuickSort algorithm for sorting a list of any type.
 */
public class CustomQuickSort {

    /**
     * Sorts the parametrized list using the QuickSort algorithm.
     *
     * @param list the list of Oranges to be sorted
     * @param comparator compares list's type of object based on it's Comparator.
     * @return the sorted list of Oranges
     */
    public static <E> CustomArrayList<E> quickSort(CustomArrayList<E> list, Comparator<E> comparator) {
        if (list.isEmpty()) {
            return list; // Start with recursion base case
        }

        CustomArrayList<E> sorted;  // This will be the sorted list to return, no need to initialize
        CustomArrayList<E> smaller = new CustomArrayList<>(); // Oranges smaller than pivot
        CustomArrayList<E> greater = new CustomArrayList<>(); // Oranges greater than pivot

        E pivot = list.get(0);  // First Oranges in list, used as pivot

        // Partition the list into smaller and greater lists
        for (int i = 1; i < list.size(); i++) {
            E j = list.get(i);
            if (comparator.compare(j, pivot) < 0) {
                smaller.add(j);
            } else {
                greater.add(j);
            }
        }

        // Recursively sort both halves
        smaller = quickSort(smaller, comparator);
        greater = quickSort(greater, comparator);

        // Combine the sorted halves with the pivot
        smaller.add(pivot);          // Add initial pivot to the end of the (now sorted) smaller Oranges
        smaller.addAll(greater);     // Add the (now sorted) greater Oranges to the smaller ones (now smaller is essentially your sorted list)
        sorted = smaller;            // Assign it to sorted

        return sorted;
    }

    public static <E extends Comparable<E>> CustomArrayList<E> quickSort(CustomArrayList<E> list) {
        if (list.isEmpty()) {
            return list; // base case for recursion
        }
        CustomArrayList<E> sorted; // this will be the sorted list to return, no need to initialize
        CustomArrayList<E> smaller = new CustomArrayList<>(); // elements smaller than pivot
        CustomArrayList<E> greater = new CustomArrayList<>(); // elements greater than pivot
        E pivot = list.get(0); // first element in list, used as pivot
        for (int i = 1; i < list.size(); i++) {
            E element = list.get(i);
            if (element.compareTo(pivot) < 0) {
                smaller.add(element);
            } else {
                greater.add(element);
            }
        }
        smaller = quickSort(smaller); // sort both halves recursively
        greater = quickSort(greater);
        smaller.add(pivot); // add initial pivot to the end of the (now sorted) smaller elements
        smaller.addAll(greater); // add the (now sorted) greater elements to the smaller ones (now smaller is essentially your sorted list)
        sorted = smaller; // assign it to sorted

        return sorted;
    }
}