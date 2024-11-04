import java.util.Scanner;

public class Email {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Email: ");
        String email = input.next();
        String atUmgcEdu = "@umgc.edu";
        // Valid email has format userid@umgc.edu and userid is not empty
        if (email.length() > atUmgcEdu.length() && email.endsWith(atUmgcEdu)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
