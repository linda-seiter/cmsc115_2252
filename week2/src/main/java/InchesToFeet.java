import java.util.Scanner;

/**
 * InchesToFeet reads the number of inches from user input and prints the
 * equivalent number of feet.
 */
public class InchesToFeet {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter inches: ");
        int inches = input.nextInt();
        double feet = inches / 12; // ERROR: integer division
        System.out.println(inches + " inches = " + feet + " feet");
    }
}
