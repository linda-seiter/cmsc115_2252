import java.util.Scanner;

public class BuggyExample3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("How much cash in wallet? ");
        double cash = input.nextDouble();
        System.out.print("Is it raining? (true/false)");
        boolean isRaining = input.nextBoolean();
        if (cash >= 50) {
            if (isRaining == true)
                System.out.println("Indoor movie");
            else
                System.out.println("Outdoor concert");
        } else {
            if (isRaining = true) // Error, assigns isRaining to true
                System.out.println("Watch TV");
            else
                System.out.println("Bike ride");
        }
    }
}
