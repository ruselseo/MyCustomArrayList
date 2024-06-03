import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link CustomArrayList} class.
 */
public class CustomArrayListTest {

    CustomArrayList<Oranges> list;
    Oranges orange1;
    Oranges orange2;
    Oranges orange3;
    Oranges orange4;
    Oranges orange5;

    /**
     * Sets up the test environment before each test method is executed.
     * Initializes the list and oranges used in the tests.
     */
    @BeforeEach
    public void setUp() {
        list = new CustomArrayList<>();
        orange1 = new Oranges();
        orange2 = new Oranges();
        orange3 = new Oranges();
        orange4 = new Oranges();
        orange5 = new Oranges();
    }

    /**
     * Tests the default capacity of the list.
     */
    @Test
    public void testGetCapacity() {
        assertEquals(10, list.getCapacity());
    }

    /**
     * Tests the initialization state of the list.
     */
    @Test
    public void testListInit() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
        assertEquals(10, list.getCapacity());
    }

    /**
     * Tests the initialization state of the list with a custom capacity.
     */
    @Test
    public void testListInitWithCustomCapacity() {
        list = new CustomArrayList<>(11);
        assertTrue(list.isEmpty());
        assertEquals(11, list.getCapacity());
    }

    /**
     * Tests that an invalid capacity throws an {@link IllegalArgumentException}.
     */
    @Test
    public void testInvalidCapacityInsert() {
        assertThrows(IllegalArgumentException.class, () -> list = new CustomArrayList<>(-1));
    }

    /**
     * Tests adding elements to the list.
     */
    @Test
    public void testAddElements() {
        list.add(orange1);
        list.add(orange2);
        list.add(orange3);

        list.add(null);  // Adding null should not affect the list size
        list.add(orange4);

        assertEquals(4, list.size());
        assertNotNull(list.get(3));
        assertFalse(list.isEmpty());
    }

    /**
     * Tests adding elements to the list by index.
     */
    @Test
    public void testAddElementsById() {
        list.add(orange1);
        list.add(orange2);
        list.add(orange3);

        list.add(2, null);  // Adding null at a valid index should not affect the list

        assertEquals(orange1, list.get(0));
        assertEquals(orange2, list.get(1));
        assertEquals(orange3, list.get(2));

        assertEquals(3, list.size());
        assertFalse(list.isEmpty());

        // Test adding at an invalid index
        assertThrows(IllegalArgumentException.class, () -> list.add(-1, orange4));
    }

    /**
     * Tests setting an element at a specific index.
     */
    @Test
    public void testSet() {
        list.add(orange1);
        list.add(orange2);
        list.add(orange3);

        list.set(1, orange5);

        assertEquals(orange1, list.get(0));
        assertEquals(orange5, list.get(1));
        assertEquals(orange3, list.get(2));

        // Test setting at an invalid index
        assertThrows(IllegalArgumentException.class, () -> list.set(-1, orange4));
    }

    /**
     * Tests getting an element from the list by index.
     */
    @Test
    public void testGet() {
        list.add(orange1);
        list.add(orange2);
        list.add(orange3);

        assertEquals(orange2, list.get(1));
    }

    /**
     * Tests removing an element from the list by index.
     */
    @Test
    public void testRemove() {
        list.add(orange1);
        list.add(orange2);
        list.add(orange3);

        assertEquals(orange2, list.remove(1));
        assertEquals(orange3, list.get(1));
        assertEquals(2, list.size());

        // Test removing at an invalid index
        assertThrows(IllegalArgumentException.class, () -> list.remove(-1));
    }

    /**
     * Tests clearing all elements from the list.
     */
    @Test
    public void testClear() {
        list.add(orange1);
        list.add(orange2);
        list.add(orange3);

        list.clear();

        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    /**
     * Tests converting the list to an array.
     */
    @Test
    public void testToArray() {
        list = new CustomArrayList<>(15);

        assertEquals(15, list.toArray().length);
    }

    /**
     * Tests the growth of the list when its capacity is exceeded.
     */
    @Test
    public void testGrow() {
        list = new CustomArrayList<>(2);
        list.add(orange1);
        list.add(orange2);
        assertEquals(2, list.getCapacity());
        list.add(orange3);
        assertEquals(4, list.getCapacity());
    }
}