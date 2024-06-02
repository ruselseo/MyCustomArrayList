import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayListTest {

    CustomArrayList<Oranges> list;
    Oranges orange1;
    Oranges orange2;
    Oranges orange3;
    Oranges orange4;
    Oranges orange5;

    @BeforeEach
    public void setUp(){
        list = new CustomArrayList<Oranges>();
        orange1 = new Oranges();
        orange2 = new Oranges();
        orange3 = new Oranges();
        orange4 = new Oranges();
    }

    @Test
    public void testGetCapacity() {
        assertEquals(10, list.getCapacity());
    }

    @Test
    public void testListInit(){
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
        assertEquals(10, list.getCapacity());
    }

    @Test
    public void testListInitWithCustomCapacity(){
        list = new CustomArrayList<>(11);
        assertTrue(list.isEmpty());
        assertEquals(11, list.getCapacity());
    }

    @Test
    public void testInvalidCapacityInsert(){
        assertThrows(IllegalArgumentException.class, () -> list = new CustomArrayList<>(-1));
    }

    @Test
    public void testAddElements() {
        list.add(orange1);
        list.add(orange2);
        list.add(orange3);

        list.add(null);
        list.add(orange4);

        assertEquals(4, list.size());
        assertNotNull(list.get(3));
        assertFalse(list.isEmpty());
    }

    @Test
    public void testAddElementsById() {
        list.add(orange1);
        list.add(orange2);
        list.add(orange3);

        list.add(2,null);

        assertEquals(orange1, list.get(0));
        assertEquals(orange2, list.get(1));
        assertEquals(orange3, list.get(2));

        assertEquals(3, list.size());
        assertNotNull(list.get(2));
        assertFalse(list.isEmpty());

        assertThrows(IllegalArgumentException.class, () -> list.add(-1, orange4));
    }

    @Test
    public void testSet(){
        list.add(orange1);
        list.add(orange2);
        list.add(orange3);

        list.set(1, orange5);

        assertEquals(orange1, list.get(0));
        assertEquals(orange5, list.get(1));
        assertEquals(orange3, list.get(2));

        assertThrows(IllegalArgumentException.class, () -> list.set(-1, orange4));
    }

    @Test
    public void testGet() {
        list.add(orange1);
        list.add(orange2);
        list.add(orange3);

        assertEquals(orange2, list.get(1));
    }

    @Test
    public void testRemove() {
        list.add(orange1);
        list.add(orange2);
        list.add(orange3);

        assertEquals(orange2, list.remove(1));
        assertEquals(orange3, list.get(1));
        assertTrue(list.size() == 2);

        assertThrows(IllegalArgumentException.class, () -> list.remove(-1));
    }

    @Test
    public void testClear() {
        list.add(orange1);
        list.add(orange2);
        list.add(orange3);

        list.clear();

        assertEquals(null, list.get(0));
        assertTrue(list.isEmpty());
    }

    @Test
    public void testToArray() {
        list = new CustomArrayList<Oranges>(15);

        assertEquals(15, list.toArray().length);
    }

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
