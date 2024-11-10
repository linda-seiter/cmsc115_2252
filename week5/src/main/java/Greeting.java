
/**
 * Prompts for name and outputs a greeting until "quit" is entered.
 * 
 * There is an infinite loop error.
 */
import java.util.Scanner;

public class Greeting {
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);
        System.out.print("Name or quit: ");
        String name = input.next();
        while (name != "quit") {
            System.out.println("Hello " + name);
            System.out.print("Name: ");
            name = input.next();
        }

        System.out.println("Goodbye");
    }
}