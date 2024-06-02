import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class OrangesTest {

    @Test
    public void testOrangeConstructor() {
        Oranges orange1 = new Oranges();

        assertTrue(orange1.getSize() > 0);
        assertTrue(orange1.getSize() < 11);
    }

    @Test
    public void testCompare() {
        Oranges orange1 = new Oranges(5);
        Oranges orange2 = new Oranges(7);

        assertEquals(-2, orange1.compare(orange1, orange2));
    }

    @Test
    public void testToString() {
        Oranges orange1 = new Oranges(5);

        assertEquals("Oranges{size=5}", orange1.toString());
    }
}
