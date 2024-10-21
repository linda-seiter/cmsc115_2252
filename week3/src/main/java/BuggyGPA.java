import java.util.Scanner;

public class BuggyGPA {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("gpa: ");
        double gpa = input.nextDouble();

        // ERROR: Missing test for minimum value 0.0
        if (gpa <= 4.0) {
            System.out.println(gpa + " is valid");
        } else {
            System.out.println(gpa + " is invalid");
        }
    }
}
