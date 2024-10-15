import java.util.Scanner;

public class BuggyGPA {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("gpa: ");
        double gpa = input.nextDouble();

        // ERROR, missing invalid gpa > 4.0
        if (gpa < 0.0) {
            System.out.println(gpa + " is invalid");
        } else if (gpa < 1.0) {
            System.out.println("F");
        } else if (gpa < 2.0) {
            System.out.println("D");
        } else if (gpa < 3.0) {
            System.out.println("C");
        } else if (gpa < 4.0) {
            System.out.println("B");
        } else {
            System.out.println("A");
        }
    }
}
