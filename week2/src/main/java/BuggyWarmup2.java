import java.util.Scanner;

/**
 * BuggyWarmup2 computes 3 iterations of viral spread given a particular R0.
 */
public class BuggyWarmup2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter R0: ");
        int r0 = input.nextInt();
        int iterations = 3;

        int infected = (int) Math.pow(iterations, r0);

        System.out.println(iterations + " iterations result in " + infected + " infections");
    }
}
