import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome1() {
        String input = "cat";
        assertFalse(palindrome.isPalindrome(input));
    }

    @Test
    public void testIsPalindrome2() {
        String input = "";
        assertTrue(palindrome.isPalindrome(input));
    }

    @Test
    public void testIsPalindrome3() {
        String input = "aa";
        assertTrue(palindrome.isPalindrome(input));
    }

    @Test
    public void testIsPalindrome4() {
        String input = "accabacca";
        assertTrue(palindrome.isPalindrome(input));
    }

    @Test
    public void testIsPalindrome5() {
        String input = "accaBACCA";
        assertTrue(palindrome.isPalindrome(input));
    }

    @Test
    public void testIsPalindromeObo1() {
        String input = "";
        CharacterComparator cc = new OffByOne();
        assertTrue(palindrome.isPalindrome(input, cc));
    }

    @Test
    public void testIsPalindromeObo2() {
        String input = "abb";
        CharacterComparator cc = new OffByOne();
        assertTrue(palindrome.isPalindrome(input, cc));
    }

    @Test
    public void testIsPalindromeObo3() {
        String input = "abB";
        CharacterComparator cc = new OffByOne();
        assertFalse(palindrome.isPalindrome(input, cc));
    }

    @Test
    public void testIsPalindromeObo4() {
        String input = "aa";
        CharacterComparator cc = new OffByOne();
        assertFalse(palindrome.isPalindrome(input, cc));
    }

    @Test
    public void testIsPalindromeObo5() {
        String input = "flake";
        CharacterComparator cc = new OffByOne();
        assertTrue(palindrome.isPalindrome(input, cc));
    }
}
