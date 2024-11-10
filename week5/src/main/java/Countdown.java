
/**
 * Reads in a number i and does a countdown from i to 1 
 * 
 * There is an infinite loop error.
 */
import java.util.Scanner;

public class Countdown {
    /** Main method */
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);

        System.out.println("Countdown from: ");
        int i = input.nextInt();
        while (i > 0)
            ;
        {
            System.out.println(i);
            i--;
        }

        System.out.println("Blastoff!");

    }
}