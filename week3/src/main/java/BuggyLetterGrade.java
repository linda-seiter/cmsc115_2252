import java.util.Scanner;

public class BuggyLetterGrade {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Score: ");
        int score = input.nextInt();

        if (score < 0) {
            System.out.println("Invalid");
        } else if (score < 60) {
            System.out.println("F");
        } else if (score < 70) {
            System.out.println("D");
        } else if (score < 80) {
            System.out.println("C");
        } else if (score < 90) {
            System.out.println("B");
        } else {
            System.out.println("A");
        }
    }
}
