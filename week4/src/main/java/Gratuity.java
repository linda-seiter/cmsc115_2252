
/**
 * Gratuity reads a tip rate and number of customers 
 * and increases the rate 5% for large parties (>= 8 customers)
 * 
 * There is an error in the code.
 */
import java.util.Scanner;

public class Gratuity {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("%tip and #customers: ");
        int tip = input.nextInt();
        int customers = input.nextInt();
        boolean largeParty = customers > 8;
        if (largeParty = true) {
            tip += 5;
        }
        System.out.println("%Tip: " + tip);
    }
}
