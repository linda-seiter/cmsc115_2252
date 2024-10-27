import java.util.Scanner;

/**
 * YearsToMinutes reads the number of years from user input and prints the
 * equivalent number of minutes.
 * 
 * An overflow error may occur when the number of years is large.
 */
public class YearsToMinutes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter years: ");
        int years = input.nextInt();
        int minutes = years * 365 * 24 * 60;
        System.out.println(minutes + " minutes");
    }
}
