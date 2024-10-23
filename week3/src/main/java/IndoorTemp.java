import java.util.Scanner;

public class IndoorTemp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Humidity and Temperature: ");
        int humidity = input.nextInt();
        int temperature = input.nextInt();

        boolean comfyHumidity = humidity >= 40 || humidity <= 60; // ERROR
        boolean comfyTemp = temperature >= 65 && temperature <= 75;

        if (comfyTemp && comfyHumidity) {
            System.out.println("Comfy");
        } else {
            System.out.println("Uncomfy");
        }
    }
}
