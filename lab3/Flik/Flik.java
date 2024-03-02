/** An Integer tester created by Flik Enterprises. */
public class Flik {
    public static boolean isSameNumber(Integer a, Integer b) {
        /**
         * Bug Here!
         * Integer use auto-boxing to compare with ==
         * and it will only work for Integer between -128 and 127
         *
         * Fix:
         *  - Use Object.equals() to compare two Objects rather than == for primitives
         */
        return a == b;
    }
}
