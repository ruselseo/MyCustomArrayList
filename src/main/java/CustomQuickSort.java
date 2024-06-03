/**
 * A utility class that provides a custom implementation of the QuickSort algorithm for sorting a list of Oranges.
 */
public class CustomQuickSort {

    /**
     * Sorts the specified list of Oranges using the QuickSort algorithm.
     *
     * @param list the list of Oranges to be sorted
     * @return the sorted list of Oranges
     */
    public static CustomArrayList<Oranges> quickSort(CustomArrayList<Oranges> list) {
        if (list.isEmpty()) {
            return list; // Start with recursion base case
        }

        CustomArrayList<Oranges> sorted;  // This will be the sorted list to return, no need to initialize
        CustomArrayList<Oranges> smaller = new CustomArrayList<>(); // Oranges smaller than pivot
        CustomArrayList<Oranges> greater = new CustomArrayList<>(); // Oranges greater than pivot

        Oranges pivot = list.get(0);  // First Oranges in list, used as pivot

        // Partition the list into smaller and greater lists
        for (int i = 1; i < list.size(); i++) {
            Oranges j = list.get(i);
            if (j.compare(j, pivot) < 0) {
                smaller.add(j);
            } else {
                greater.add(j);
            }
        }

        // Recursively sort both halves
        smaller = quickSort(smaller);
        greater = quickSort(greater);

        // Combine the sorted halves with the pivot
        smaller.add(pivot);          // Add initial pivot to the end of the (now sorted) smaller Oranges
        smaller.addAll(greater);     // Add the (now sorted) greater Oranges to the smaller ones (now smaller is essentially your sorted list)
        sorted = smaller;            // Assign it to sorted

        return sorted;
    }
}