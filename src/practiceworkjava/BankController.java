package practiceworkjava;
import java.util.Scanner;
import java.util.Date;

public class BankController {

    BankAccount[] accounts = new BankAccount[100];
    int accountCount = 0;
    long nextAccountNumber = 1001;
    Scanner sc = new Scanner(System.in);
    BankView view = new BankView();

    public void start() {
        int choice = -1;

        while (choice != 9) {
            view.showMenu();
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: createAccountMenu(); break;
                case 2: depositFlow(); break;
                case 3: withdrawFlow(); break;
                case 4: displayAccountDetails(); break;
                case 5: displayAllAccounts(); break;
                case 6: showTransactionHistory(); break;
                case 7: calculateInterestFlow(); break;
                case 8: endOfDayReport(); break;
                case 9: view.print("Exiting."); break;
                default: view.print("Invalid choice.");
            }
        }
    }

    public void createAccountMenu() {
        System.out.println("\n1. Saving Account");
        System.out.println("2. Current Account");
        System.out.println("3. Salary Account");
        System.out.println("4. Loan Account");
        System.out.print("Enter choice: ");

        int t = sc.nextInt();
        sc.nextLine();

        if (t < 1 || t > 4) {
            System.out.println("Invalid option.");
            return;
        }

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter initial balance: ");
        double bal = sc.nextDouble();

        System.out.print("Enter Aadhar: ");
        long aadhar = sc.nextLong();

        System.out.print("Enter nominee Aadhar: ");
        long nominee = sc.nextLong();

        long accNo = nextAccountNumber++;
        BankAccount acc = null;

        switch (t) {
            case 1:
                acc = new SavingAccount(accNo, name, bal, aadhar, nominee,
                        10000.0, SavingAccount.getSavingInterestRate());
                break;
            case 2:
                acc = new CurrentAccount(accNo, name, bal, aadhar, nominee,
                        7000.0, 0.0);
                break;
            case 3:
                acc = new SalaryAccount(accNo, name, bal, aadhar, nominee,
                        SalaryAccount.getInterestRate());
                break;
            case 4:
                System.out.print("Enter loan amount: ");
                double loanAmt = sc.nextDouble();
                acc = new LoanAccount(accNo, name, bal, aadhar, nominee,
                        loanAmt, loanAmt);
        }

        accounts[accountCount++] = acc;
        System.out.println("Account created: " + accNo);
    }

    public void depositFlow() {
        BankAccount acc = selectAccount();
        if (acc == null) return;

        System.out.print("Enter amount to deposit: ");
        double amt = sc.nextDouble();
        acc.deposit(amt);
    }

    public void withdrawFlow() {
        BankAccount acc = selectAccount();
        if (acc == null) return;

        System.out.print("Enter amount to withdraw: ");
        double amt = sc.nextDouble();
        acc.withdraw(amt);
    }

    public BankAccount selectAccount() {
        System.out.print("Enter account number: ");
        long accNo = sc.nextLong();
        return findAccount(accNo);
    }

    public BankAccount findAccount(long accNo) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber() == accNo)
                return accounts[i];
        }
        System.out.println("Account not found.");
        return null;
    }

    public void displayAccountDetails() {
        BankAccount acc = selectAccount();
        if (acc != null) acc.showDetails();
    }

    public void displayAllAccounts() {
        System.out.println("\n--- All Accounts ---");
        for (int i = 0; i < accountCount; i++) {
            accounts[i].showDetails();
        }
    }

    public void showTransactionHistory() {
        BankAccount acc = selectAccount();
        if (acc == null) return;

        if (!acc.isAccountStatus()) {
            System.out.println("Warning: This account is frozen.");
        }

        Transaction[] tx = acc.getTransactions();
        System.out.println("\n--- Transaction History for Account " + acc.getAccountNumber() + " ---");

        if (acc.transactionCount == 0) {
            System.out.println("No transactions yet.");
            return;
        }

        for (int i = 0; i < acc.transactionCount; i++) {
            System.out.println(tx[i]);
        }
    }

    public void calculateInterestFlow() {
        System.out.println("\nApplying interest..");
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i] instanceof SavingAccount) {
                SavingAccount sa = (SavingAccount) accounts[i];
                double interest = sa.getBalance() * SavingAccount.getSavingInterestRate() / 100.0;
                sa.setBalance(sa.getBalance() + interest);
                sa.addTransaction("Interest", interest);
                System.out.println("Interest added to: " + sa.getAccountNumber());
            }
        }
    }

    public void endOfDayReport() {
        System.out.println("\n====== END OF DAY REPORT ======");
        System.out.println("Total accounts: " + accountCount);

        for (int i = 0; i < accountCount; i++) {
            System.out.println("\nAccount No.: " + accounts[i].getAccountNumber());
            System.out.println("Balance: " + accounts[i].getBalance());
        }
    }
}
