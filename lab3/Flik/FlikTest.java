import static org.junit.Assert.*;

import org.junit.Test;
/**
 * @Classname FlikTest
 * @Description Test Flik Class
 * @Date 2024/3/2 21:32
 * @Created by Peng
 */
public class FlikTest {
    @Test
    public void testIsSameNumber() {
        int a = 128;
        int b = 128;
        boolean result = Flik.isSameNumber(a, b);
        assertTrue(result);
    }
}
