/**
 * @Classname Palindrome
 * @Description A class for palindrome operations.
 * @Date 2024/3/18 14:41
 * @Created by Peng
 */
public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        if (word == null) {
            return null;
        }

        Deque<Character> deque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            deque.addLast(character);
        }

        return deque;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> wordDeque = wordToDeque(word);

        while (!wordDeque.isEmpty() && wordDeque.size() != 1) {
            // palindromes are case-ignored, so move all the chars to lowercase for simplicity.
            Character first = Character.toLowerCase(wordDeque.removeFirst());
            /*
            bug here!
            if there is only one character left, wordDeque.removeLast will return null.

            bug fix:
            1. when deque.size is 1, it is always a palindrome, jump out and return true.
             */
            Character last = Character.toLowerCase(wordDeque.removeLast());
            if (!first.equals(last)) {
                return false;
            }
        }

        return true;
    }

    private boolean isPalindromeRecursion(Deque<Character> wordDeque, CharacterComparator cc) {
        // base case
        if (wordDeque.isEmpty() || wordDeque.size() == 1) {
            return true;
        }

        // compare the first and the last character in the deque
        Character first = wordDeque.removeFirst();
        Character last = wordDeque.removeLast();

        if (cc.equalChars(first, last)) {
            return isPalindromeRecursion(wordDeque, cc);
        } else {
            return false;
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> deque = wordToDeque(word);

        return isPalindromeRecursion(deque, cc);
    }
}
