
/**
 * Prompts for #people and reads in that many ages.  Outputs the average age.
 * 
 * There are errors in the code for 0 or 2+ iterations
 */
import java.util.Scanner;

public class AgvAge {
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);
        int sum = 0;
        int count = 0;

        System.out.print("# people: ");
        int max = input.nextInt();
        for (int i = 0; i < max; i++) {
            System.out.print("age: ");
            sum = input.nextInt();
            count++;
        }

        System.out.println("Average age: " + sum / count);

    }
}