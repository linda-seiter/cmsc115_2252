
/**
 * A valid password contains a digit and an upper case letter
 * 
 * There are logic errors in the code.
 */
import java.util.Scanner;

public class ValidPassword {
    /** Main method */
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter password
        System.out.print("Password: ");
        String password = input.nextLine();
        boolean hasDigit = false;
        boolean hasUpper = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isDigit(c))
                hasDigit = true;
            else
                hasDigit = false;
            if (c >= 'A' && c <= 'Z')
                hasUpper = true;
            else
                hasUpper = false;
        }

        if (hasDigit && hasUpper)
            System.out.println("Valid");
        else
            System.out.println("Invalid");
    }
}