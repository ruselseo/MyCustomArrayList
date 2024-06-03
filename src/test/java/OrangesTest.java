import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link Oranges} class.
 */
public class OrangesTest {

    /**
     * Tests the default constructor of the {@link Oranges} class.
     * Verifies that the size of the orange is within the expected range (1 to 10).
     */
    @Test
    public void testOrangeConstructor() {
        Oranges orange1 = new Oranges();

        assertTrue(orange1.getSize() > 0);
        assertTrue(orange1.getSize() < 11);
    }

    /**
     * Tests the compare method of the {@link Oranges} class.
     * Verifies that the comparison is done correctly based on the size of the oranges.
     */
    @Test
    public void testCompareTo() {
        Oranges orange1 = new Oranges(5);
        Oranges orange2 = new Oranges(7);

        assertEquals(-2, orange1.compareTo(orange2));
    }

    /**
     * Tests the toString method of the {@link Oranges} class.
     * Verifies that the string representation of an orange is as expected.
     */
    @Test
    public void testToString() {
        Oranges orange1 = new Oranges(5);

        assertEquals("Oranges{size=5}", orange1.toString());
    }
}