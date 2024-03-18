/**
 * @Classname OffByN
 * @Description A class for off-by-N comparators.
 * @Date 2024/3/18 14:41
 * @Created by Peng
 */
public class OffByN implements CharacterComparator {
    private int offset;

    public OffByN() {
        offset = 0;
    }

    public OffByN(int N) {
        offset = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int difference = Math.abs(x - y);

        return difference == offset;
    }
}
