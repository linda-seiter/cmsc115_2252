
/**
 * A palindrome is a string that reads the same backwards as forwards.
 * 
 * There is a logic error for even-length palindromes.
 */
import java.util.Scanner;

public class Palindrome {
    /** Main method */
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.print("String: ");
        String str = input.nextLine();

        // Two indices, one at the beginning of the string, the other at the end
        int left = 0;
        int right = str.length() - 1;

        char leftChar, rightChar;

        // Assume it is a palindrome
        boolean isPalindrome = true;

        // While indices haven't reached the middle and the characters match
        while (left != right && isPalindrome) {
            leftChar = str.charAt(left);
            rightChar = str.charAt(right);
            if (leftChar != rightChar) {
                // character don't match, it's not a palindrome
                isPalindrome = false;
            } else {
                // Move the indices towards each other
                left++;
                right--;
            }
        }

        if (isPalindrome)
            System.out.println(str + " is a palindrome");
        else
            System.out.println(str + " is not a palindrome");
    }
}