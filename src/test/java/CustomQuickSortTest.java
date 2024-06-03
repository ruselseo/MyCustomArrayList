import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link CustomQuickSort} class.
 */
public class CustomQuickSortTest {

    /**
     * Tests the quickSort method with an empty list.
     * Verifies that the sorted list is also empty.
     */
    @Test
    public void QuickSortEmptyListTest() {
        CustomArrayList<Oranges> emptyList = new CustomArrayList<>();
        CustomArrayList<Oranges> sortedList = CustomQuickSort.quickSort(emptyList, Oranges::compareTo);
        assertTrue(sortedList.isEmpty());
    }

    /**
     * Tests the quickSort method with a single-element list.
     * Verifies that the sorted list contains the same single element.
     */
    @Test
    public void QuickSortSingleElementListTest() {
        Oranges orange = new Oranges(5); // Example constructor
        CustomArrayList<Oranges> singleElementList = new CustomArrayList<>();
        singleElementList.add(orange);
        CustomArrayList<Oranges> sortedList = CustomQuickSort.quickSort(singleElementList, Oranges::compareTo);
        assertEquals(1, sortedList.size());
        assertEquals(orange, sortedList.get(0));
    }

    /**
     * Tests the quickSort method with a multiple-element list.
     * Verifies that the elements are sorted correctly.
     * Assuming Oranges are sorted by their size or some other attribute
     */
    @Test
    public void QuickSortMultipleElementsTest() {
        Oranges orange1 = new Oranges(5);
        Oranges orange2 = new Oranges(2);
        Oranges orange3 = new Oranges(8);

        CustomArrayList<Oranges> unsortedList = new CustomArrayList<>();
        unsortedList.add(orange1);
        unsortedList.add(orange2);
        unsortedList.add(orange3);

        CustomArrayList<Oranges> sortedList = CustomQuickSort.quickSort(unsortedList, Oranges::compareTo);

        assertEquals(orange2, sortedList.get(0));
        assertEquals(orange1, sortedList.get(1));
        assertEquals(orange3, sortedList.get(2));

        assertEquals("CustomArrayList{[Oranges{size=2}, Oranges{size=5}, Oranges{size=8}," +
                " null, null, null, null, null, null, null]}", sortedList.toString());


        CustomArrayList<Oranges> expectedList = new CustomArrayList<>();
        expectedList.add(orange2);
        expectedList.add(orange1);
        expectedList.add(orange3);

        assertEquals(expectedList.size(), sortedList.size());
        for (int i = 0; i < expectedList.size(); i++) {
            assertEquals(expectedList.get(i), sortedList.get(i));
        }
    }

    /**
     * Tests the quickSort method with an already sorted list.
     * Verifies that the sorted list remains unchanged.
     */
    @Test
    public void QuickSortAlreadySortedTest() {
        Oranges orange1 = new Oranges(2);
        Oranges orange2 = new Oranges(5);
        Oranges orange3 = new Oranges(8);

        CustomArrayList<Oranges> sortedList = new CustomArrayList<>();
        sortedList.add(orange1);
        sortedList.add(orange2);
        sortedList.add(orange3);

        CustomArrayList<Oranges> result = CustomQuickSort.quickSort(sortedList, Oranges::compareTo);

        assertEquals(orange1, result.get(0));
        assertEquals(orange2, result.get(1));
        assertEquals(orange3, result.get(2));

        assertEquals("CustomArrayList{[Oranges{size=2}, Oranges{size=5}, Oranges{size=8}," +
                " null, null, null, null, null, null, null]}", result.toString());

        assertEquals(sortedList.size(), result.size());
        for (int i = 0; i < sortedList.size(); i++) {
            assertEquals(sortedList.get(i), result.get(i));
        }
    }


    /**
     * Tests the quickSort method with a list of Integers.
     */
    @Test
    public void SortIntegerListTest() {
        CustomArrayList intList = new CustomArrayList<>();
        intList.add(3);
        intList.add(1);
        intList.add(4);
        intList.add(1);
        intList.add(5);
        intList.add(9);
        Comparator<Integer> intComparator = Integer::compareTo;
        CustomArrayList<Integer> sortedIntList = CustomQuickSort.quickSort(intList, intComparator);
        assertEquals("CustomArrayList{[1, 1, 3, 4, 5, 9, null, null, null, null]}", sortedIntList.toString());
    }

    @Test
    public void SortStringListTest() {
        CustomArrayList stringList = new CustomArrayList<>();
        stringList = new CustomArrayList<>();
        stringList.add("banana");
        stringList.add("apple");
        stringList.add("cherry");

        Comparator<String> stringComparator = String::compareTo;
        CustomArrayList<String> sortedStringList = CustomQuickSort.quickSort(stringList, stringComparator);
        assertEquals("CustomArrayList{[apple, banana, cherry, null, null, null, null, null, null, null]}", sortedStringList.toString());
    }
}