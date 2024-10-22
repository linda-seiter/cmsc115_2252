import java.util.Scanner;

public class BuggyHotelBill {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Room 1=full,2=queen,3=king: ");
        int roomType = input.nextInt();
        System.out.print("Age: ");
        int age = input.nextInt();

        int price = 0;
        switch (roomType) {
            case 1: // full
                price = 89;
                break;
            case 2: // queen
                price = 129;
                break;
            case 3: // king
                price = 159;
                break;
        }

        // $10 senior discount for queen or king room.
        // ERROR: operator precedence
        if (age >= 65 && roomType == 2 || roomType == 3) {
            price -= 10;
        }
        System.out.println("Price: $" + price);

    }
}
