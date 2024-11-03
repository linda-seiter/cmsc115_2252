import java.util.Scanner;

public class Email {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Email: ");
        String email = input.next();
        String umgcEdu = "@umgc.edu";
        boolean isUmgc = email.toLowerCase().endsWith(umgcEdu);
        int indexUmgc = email.indexOf(umgcEdu);
        String userid = email.substring(indexUmgc); // ERROR, 0, indexUmgc
        if (isUmgc && userid.contains(".")) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
