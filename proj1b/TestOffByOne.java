import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testEqualChars1() {
        OffByOne obo = new OffByOne();
        assertTrue(obo.equalChars('a', 'b'));
    }

    @Test
    public void testEqualChars2() {
        OffByOne obo = new OffByOne();
        assertFalse(obo.equalChars('a', 'c'));
    }

    @Test
    public void testEqualChars3() {
        OffByOne obo = new OffByOne();
        assertFalse(obo.equalChars('a', 'a'));
    }

    @Test
    public void testEqualChars4() {
        OffByOne obo = new OffByOne();
        assertTrue(obo.equalChars('i', 'j'));
    }

    @Test
    public void testEqualChars5() {
        OffByOne obo = new OffByOne();
        assertFalse(obo.equalChars('A', 'b'));
    }

    @Test
    public void testEqualChars6() {
        OffByOne obo = new OffByOne();
        assertTrue(obo.equalChars('A', 'B'));
    }
}
