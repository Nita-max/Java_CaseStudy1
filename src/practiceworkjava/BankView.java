package practiceworkjava;
import java.util.Scanner;

public class BankView {
    Scanner sc = new Scanner(System.in);

    public void showMenu() {
        System.out.println("\n1. Create Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Display Account Details");
        System.out.println("5. Display All Accounts");
        System.out.println("6. Transaction History");
        System.out.println("7. Calculate Interest");
        System.out.println("8. End Of Day Report");
        System.out.println("9. Exit");
        System.out.print("Choose option: ");
    }

    public void print(String message) {
        System.out.println(message);
    }
}
