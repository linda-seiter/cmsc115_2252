import java.util.Scanner;

/**
 * YearsToMinutes reads the number of years from user input and prints the
 * equivalent number of minutes.
 */
public class YearsToMinutes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter years: ");
        int years = input.nextInt();
        int minutes = years * 365 * 24 * 60; // ERROR: Overflow
        System.out.println(minutes + " minutes");
    }
}
