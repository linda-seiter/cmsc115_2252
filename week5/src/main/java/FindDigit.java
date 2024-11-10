
/**
 * Reads in a number i and does a countdown from i to 1 
 * 
 * There is an infinite loop error.
 */
import java.util.Scanner;

public class FindDigit {
    /** Main method */
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);
        System.out.println("Product Code:");

        String product = input.nextLine();
        int i = 0;
        char c = product.charAt(i);
        while (!Character.isDigit(c) && i < product.length() - 1) {
            i++;
            c = product.charAt(i);
        }
        if (Character.isDigit(c)) {
            System.out.println("Valid, found digit " + c);
        } else {
            System.out.println("Invalid product code");
        }

    }
}