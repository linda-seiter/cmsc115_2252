import java.util.Scanner;

/**
 * IndoorComfort reads in a value representing the humidity and determines
 * whether it falls in the comfortable range of 40 - 60.
 * 
 * There is an error in the code.
 */
public class IndoorComfort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Humidity: ");
        int humidity = input.nextInt();

        boolean comfyHumidity = humidity > 40 && humidity < 60;

        if (comfyHumidity) {
            System.out.println("Comfortable");
        } else {
            System.out.println("Uncomfortable");
        }
    }
}
