package practiceworkjava;
class CurrentAccount extends BankAccount {
       final double minimum_balance = 7000.0;
       double overdraftlimit = 000.0;

        CurrentAccount(long accountNumber, String accountHoldername, double balance, long accountHolderAadhar,
               long nomineeAadhar,double minimum_balance,double overdraftlimit ) {
           super(accountNumber, accountHoldername, balance, accountHolderAadhar, nomineeAadhar);
       }//parameterized constructor

        double getOverdraftlimit() {
           return this.overdraftlimit;
       }

       public void setOverdraftlimit(double overdraftlimit) {
           this.overdraftlimit = overdraftlimit;
       }

       @Override
       public void withdraw(double amount) {
           if (amount <= 0) {
               System.out.println("Withdraw amount must be positive.");
               return;
           }

           double allowed = getBalance() + this.overdraftlimit;

           if (amount > allowed) {
               System.out.println("Exceeded overdraft limit. Max withdrawable = " + allowed);
               return;
           }

           setBalance(getBalance() -  amount);
           addTransaction("Withdraw", amount);
           System.out.println("Withdrawn " + amount + ". New balance = " + getBalance());
       }

       @Override
       public String toString() {
           return "CurrentAccount " + super.toString() + ", overdraft=" + this.overdraftlimit;
       }
   }//current account class ends here
   