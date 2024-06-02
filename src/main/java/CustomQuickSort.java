

public class CustomQuickSort {

    public static CustomArrayList<Oranges> quickSort(CustomArrayList<Oranges> list)
    {
        if (list.isEmpty())
            return list; // start with recursion base case
        CustomArrayList<Oranges> sorted;  // this will be the sorted list to return, no need to initialise
        CustomArrayList<Oranges> smaller = new CustomArrayList<>(); // Oranges smaller than pivot
        CustomArrayList<Oranges> greater = new CustomArrayList<>(); // Oranges greater than pivot
        Oranges pivot = list.get(0);  // first Oranges in list, used as pivot
        int i;
        Oranges j;     // Variable used for Oranges in the loop
        for (i=1;i<list.size();i++)
        {
            j=list.get(i);
            if (j.compare(j, pivot) < 0)
                smaller.add(j);
            else
                greater.add(j);
        }
        smaller=quickSort(smaller);  // capitalise 's'
        greater=quickSort(greater);  // sort both halfs recursively
        smaller.add(pivot);          // add initial pivot to the end of the (now sorted) smaller Oranges
        smaller.addAll(greater);     // add the (now sorted) greater Oranges to the smaller ones (now smaller is essentially your sorted list)
        sorted = smaller;            // assign it to sorted

        return sorted;
    }

}


