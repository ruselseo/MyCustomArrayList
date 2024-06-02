import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class CustomQuickSortTest {

    @Test
    public void QuickSortEmptyListTest() {
        CustomArrayList<Oranges> emptyList = new CustomArrayList<>();
        CustomArrayList<Oranges> sortedList = CustomQuickSort.quickSort(emptyList);
        assertTrue(sortedList.isEmpty());
    }

    @Test
    public void QuickSortSingleElementListTest() {
        Oranges orange = new Oranges(5); // Example constructor
        CustomArrayList<Oranges> singleElementList = new CustomArrayList<>();
        singleElementList.add(orange);
        CustomArrayList<Oranges> sortedList = CustomQuickSort.quickSort(singleElementList);
        assertEquals(1, sortedList.size());
        assertEquals(orange, sortedList.get(0));
    }

    @Test
    public void QuickSortMultipleElementsTest() {
        Oranges orange1 = new Oranges(5);
        Oranges orange2 = new Oranges(2);
        Oranges orange3 = new Oranges(8);

        CustomArrayList<Oranges> unsortedList = new CustomArrayList<>();
        unsortedList.add(orange1);
        unsortedList.add(orange2);
        unsortedList.add(orange3);

        CustomArrayList<Oranges> sortedList = CustomQuickSort.quickSort(unsortedList);

        assertEquals(orange2, sortedList.get(0));
        assertEquals(orange1, sortedList.get(1));
        assertEquals(orange3, sortedList.get(2));

        assertEquals("CustomArrayList{[Oranges{size=2}, Oranges{size=5}, Oranges{size=8}," +
                " null, null, null, null, null, null, null]}", sortedList.toString());

        // Assuming Oranges are sorted by their weight or some other attribute
        CustomArrayList<Oranges> expectedList = new CustomArrayList<>();
        expectedList.add(orange2);
        expectedList.add(orange1);
        expectedList.add(orange3);

        assertEquals(expectedList.size(), sortedList.size());
        for (int i = 0; i < expectedList.size(); i++) {
            assertEquals(expectedList.get(i), sortedList.get(i));
        }
    }

    @Test
    public void QuickSortAlreadySortedTest() {
        Oranges orange1 = new Oranges(2);
        Oranges orange2 = new Oranges(5);
        Oranges orange3 = new Oranges(8);

        CustomArrayList<Oranges> sortedList = new CustomArrayList<>();
        sortedList.add(orange1);
        sortedList.add(orange2);
        sortedList.add(orange3);

        CustomArrayList<Oranges> result = CustomQuickSort.quickSort(sortedList);

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
}
