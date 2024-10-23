import java.util.Scanner;

public class TransactionFee {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Transactions: ");
        int transactions = input.nextInt();

        int fee = 0; // 1st 5 transactions are free

        // $2 per transaction above the limit of 5
        if (transactions > 5)
            fee = transactions * 2; // ERROR
        System.out.println(fee);
    }
}
