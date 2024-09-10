import java.util.Scanner;

/**
 * YearsToMinutes reads years from user input and prints the equivalent quantity
 * in minutes.
 */
public class YearsToMinutes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the number of years
        System.out.print("Enter the number of years: ");
        int years = input.nextInt();

        // Convert years -> days -> hours -> minutes
        int days = years * 365;
        int hours = days * 24;
        int minutes = hours * 60;

        System.out.println(minutes + " minutes");
    }
}
