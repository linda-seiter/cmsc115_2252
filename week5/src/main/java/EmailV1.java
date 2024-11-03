import java.util.Scanner;

public class EmailV1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Email: ");
        String email = input.next();
        String atUmgcEdu = "@umgc.edu";
        boolean isUmgc = email.toLowerCase().endsWith(atUmgcEdu);
        String userid = email.substring(0, email.indexOf(atUmgcEdu));
        System.out.println(userid);
        // Valid email has format first.last@umgc.edu
        if (email.endsWith(atUmgcEdu) && userid.contains(".")) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
