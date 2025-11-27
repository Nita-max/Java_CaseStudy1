package practiceworkjava;
import java.util.Date;

class SalaryAccount extends BankAccount {
        static double interestRate = 4.5;
        Date lastTransactionDate;  

        SalaryAccount(long accountNumber, String accountHoldername, double balance, long accountHolderAadhar,
                      long nomineeAadhar, double interestRate) {
            super(accountNumber, accountHoldername, balance, accountHolderAadhar, nomineeAadhar);
            this.lastTransactionDate = new Date();
        }

        static void setInterestRate(double interestRate) {
            SalaryAccount.interestRate = interestRate;
        }

        @Override
        public void withdraw(double amount) {
            if (!isAccountActive()) return;  // check freeze before withdrawing

            if (amount <= 0) {
                System.out.println("Withdraw amount must be positive.");
                return;
            }

            if (amount > getBalance()) {
                System.out.println("Insufficient balance.");
                return;
            }

            setBalance(getBalance() - amount);
            addTransaction("Withdraw", amount);
            lastTransactionDate = new Date(); 
            System.out.println("Withdrawn " + amount + ". New balance = " + getBalance());
        }

        @Override
        public void deposit(double amount) {
            if (!isAccountActive()) 
            	return;  // check freeze before deposit

            super.deposit(amount);         
            lastTransactionDate = new Date(); 
        }

        // check if inactive for more than 2 months
        public boolean isAccountActive() {
            //  current date
            Date today = new Date();

            //  difference in days
            long daysSinceLastTx = (today.getTime() - lastTransactionDate.getTime()) / (24 * 60 * 60 * 1000);

            if (daysSinceLastTx > 60) {
                setAccountStatus(false);
                System.out.println("Account frozen due to 2 months inactivity!");
                return false;
            }

            return true;
        }
        
        static double getInterestRate() {
            return interestRate;
        }

        @Override
        public String toString() {
            return "SalaryAccount " + super.toString() + ", lastTransactionDate=" + lastTransactionDate;
        }
    }//salary account class ends here
