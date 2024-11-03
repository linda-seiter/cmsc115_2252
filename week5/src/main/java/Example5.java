import java.util.Scanner;

public class Example5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Product: ");
        String product = input.next();
        if (product.length() > 0 && Character.isLetter(product.charAt(0))) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
