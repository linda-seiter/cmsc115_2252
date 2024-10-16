import java.util.Scanner;

public class BuggyIndoorTemp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Temperature: ");
        int temperature = input.nextInt();
        System.out.println("Humidity: ");
        int humidity = input.nextInt();

        boolean comfyTemp = temperature >= 65 && temperature <= 75;
        boolean comfyHumidity = humidity >= 40 && humidity <= 60;

        if (comfyTemp && comfyHumidity) {
            System.out.println("Comfortable");
        } else {
            System.out.println("Uncomfortable");
        }
    }
}
