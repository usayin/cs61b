/**
 * @Classname OffByOne
 * @Description A class for off-by-1 comparators.
 * @Date 2024/3/18 14:41
 * @Created by Peng
 */
public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        int difference = Math.abs(x - y);

        return difference == 1;
    }
}
