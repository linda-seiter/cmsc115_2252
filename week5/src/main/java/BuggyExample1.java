import java.util.Scanner;

public class BuggyExample1 {

    public static void main(String[] args) {
        int x, y, smallest;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter two numbers: ");
        x = input.nextInt();
        y = input.nextInt();
        if (x <= y) {
            smallest = x;
        } else {
            smallest = x; // error, should be y
        }
        System.out.println("smallest is " + smallest);
    }
}
