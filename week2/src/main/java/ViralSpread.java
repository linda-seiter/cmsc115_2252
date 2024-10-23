import java.util.Scanner;

/**
 * Computes 3 iterations of viral spread given a particular R0.
 * There is an error in the calculation.
 */
public class ViralSpread {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter R0: ");
        int r0 = input.nextInt();
        int iterations = 3;
        int infected = (int) Math.pow(iterations, r0); // ERROR
        System.out.println(iterations + " iterations result in " + infected + " infections");
    }
}
