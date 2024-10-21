import java.util.Scanner;

/**
 * BuggyWarmup1 reads two numbers and prints the average.
 */
public class BuggyWarmup1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter 2 numbers: ");
        int num1 = input.nextInt();
        int num2 = input.nextInt();
        double avg = num1 + num2 / 2.0;
        System.out.println("Average = " + avg);
    }
}
