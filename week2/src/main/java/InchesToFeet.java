import java.util.Scanner;

/**
 * InchesToFeet reads the number of inches from user input and prints the
 * equivalent number of feet.
 * 
 * There is an error in the code.
 */
public class InchesToFeet {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter inches: ");
        int inches = input.nextInt();
        double feet = inches / 12;
        System.out.println(inches + " inches = " + feet + " feet");
    }
}
