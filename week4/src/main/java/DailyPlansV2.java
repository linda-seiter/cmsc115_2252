//https://www.onlinegdb.com/blog/brief-guide-on-how-to-use-onlinegdb-debugger/

/**
 * DailyPlans prints what to do based on the day (weekend or not) and temperature.
 * 
 * There is an error in the code
 */
import java.util.Scanner;

public class DailyPlansV2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Weekend and Temperature: ");
        boolean isWeekend = input.nextBoolean();
        int temperature = input.nextInt();
        if (isWeekend = false) {
            System.out.println("Go to work");
        } else if (temperature < 50) {
            System.out.println("Sleep late");
        } else {
            System.out.println("Sunrise at beach");
        }

    }
}
