import java.util.Scanner;

public class Example4Compound {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Cash: ");
        double cash = input.nextDouble();
        System.out.print("Hungry: ");
        boolean isHungry = input.nextBoolean();
        if ((cash > 50) && (isHungry = true)) { // Operator error = vs ==
            System.out.print("Order a pizza");
        } else {
            System.out.println("Keep studying");
        }
    }
}
