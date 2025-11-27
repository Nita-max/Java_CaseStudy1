package practiceworkjava;
import java.util.Date;
abstract class BankAccount implements AccountOperation {

      long accountNumber;
      String accountHoldername;
      double balance;
      long accountHolderAadhar;
      long nomineeAadhar;
      boolean accountStatus;
      Transaction[] transactions = new Transaction[100];
      int transactionCount = 0;
      
       BankAccount() {
          this.accountNumber = 00;
          this.accountHoldername = "not given";
          this.balance = 0.0;
          this.accountHolderAadhar = 000;
          this.nomineeAadhar = 000;
          this.accountStatus = true;
      }//default constructor

       BankAccount(long accountNumber, String accountHoldername, double balance, long accountHolderAadhar,
              long nomineeAadhar) {
          this.accountNumber = accountNumber;
          this.accountHoldername = accountHoldername;
          this.balance = balance;
          this.accountHolderAadhar = accountHolderAadhar;
          this.nomineeAadhar = nomineeAadhar;
          this.accountStatus = true;
      }//parameterized constructor

       
      @Override   //methods are declared inside an interface and interface methods must be public
      public long getAccountNumber() {
          return this.accountNumber;
      }

      @Override
      public void setAccountNumber(long accountNumber) {
          this.accountNumber = accountNumber;
      }

      @Override
      public String getAccountHolderName() {
          return this.accountHoldername;
      }

      @Override
      public void setAccountHolderName(String accountHoldername) {
          this.accountHoldername = accountHoldername;
      }

      @Override
      public double getBalance() {
          return this.balance;
      }

      @Override
      public void setBalance(double balance) {
          this.balance = balance;
      }

       long getAccountHolderAadhar() {
          return this.accountHolderAadhar;
      }

       void setAccountHolderAadhar(long accountHolderAadhar) {
          this.accountHolderAadhar = accountHolderAadhar;
      }

       long getNomineeAadhar() {
          return this.nomineeAadhar;
      }

       void setNomineeAadhar(long nomineeAadhar) {
          this.nomineeAadhar = nomineeAadhar;
      }

       boolean isAccountStatus() {
          return this.accountStatus;
      }

       void setAccountStatus(boolean accountStatus) {
          this.accountStatus = accountStatus;
      }

       Transaction[] getTransactions() { 
          return this.transactions; 
      }

      @Override
      public void deposit(double amount) {
          if (amount <= 0) {
              System.out.println("Deposit amount must be positive.");
              return;
          }
          this.balance =this.balance + amount;
          transactions[transactionCount++] =
                  new Transaction(this.transactionCount, new Date(), "Deposit", amount, this.balance);

          System.out.println("Deposited " + amount + ". New balance = " + this.balance);
      }

      @Override
      public abstract void withdraw(double amount);

       void addTransaction(String type, double amount) {
          transactions[transactionCount++] =
                  new Transaction(this.transactionCount, new Date(), type, amount, this.balance);
      }

      @Override
      public void showDetails() {
          System.out.println(this.toString());
      }

      @Override
      public String toString() {
          return "Account Number       : " + this.accountNumber + "\n" +
                 "Account Holder Name  : " + this.accountHoldername + "\n" +
                 "Balance              : " + this.balance + "\n" +
                 "Aadhar Number        : " + this.accountHolderAadhar + "\n" +
                 "Nominee Aadhar       : " + this.nomineeAadhar + "\n" +
                 "Account Status       : " + (this.accountStatus ? "Active" : "Inactive");
      }
  }//BankAccount ends here