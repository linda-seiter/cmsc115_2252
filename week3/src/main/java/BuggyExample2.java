import java.util.Scanner;

public class BuggyExample2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = input.nextInt();
        boolean isEven = true; // Initialization error
        if (num % 2 == 0)
            isEven = true;
        System.out.println(num + " is even : " + isEven);
    }
}
