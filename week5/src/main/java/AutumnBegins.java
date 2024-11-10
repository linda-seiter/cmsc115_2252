
/**
 * It feels like a Spring thaw when the average temperature reaches at least 7C or 45F for 3 days in a row.
 * The program reads in temperatures until it is a Spring thaw.
 * 
 * There is a logic error in maintaining the count.
 */
import java.util.Scanner;

public class AutumnBegins {
    public static void main(String[] args) {
        final int THRESHOLD_F = 45;
        final int THRESHOLD_C = 7;
        // Create a Scanner
        Scanner input = new Scanner(System.in);
        int temperature;
        int days = 0;
        System.out.print("Celsius(true) or Fahrenheit(false):");
        boolean celsius = input.nextBoolean();
        while (days < 3) {
            System.out.print("Temperature: ");
            temperature = input.nextInt();
            if ((celsius && temperature >= THRESHOLD_C) || (!celsius && temperature >= THRESHOLD_F)) {
                days++;
            }
        }

        System.out.println("Spring thaw");

    }
}