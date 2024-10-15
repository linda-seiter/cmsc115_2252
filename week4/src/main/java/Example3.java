import java.util.Scanner;

public class Example3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Weekend (true/false)? ");
        boolean isWeekend = input.nextBoolean();
        if (isWeekend) {
            System.out.print("Outdoor temperature?");
            int temperature = input.nextInt();
            if (temperature < 50) {
                System.out.println("Sleep late");
            } else {
                System.out.println("Sunrise at beach");
            }
        } else {
            System.out.println("Go to work");
        }
    }
}
