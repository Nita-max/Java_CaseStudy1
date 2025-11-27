package practiceworkjava;
interface AccountOperation {

     void deposit(double amount);
     void withdraw(double amount);
     void showDetails();

     double getBalance();
     void setBalance(double balance);

     long getAccountNumber();
     void setAccountNumber(long accountNumber);

     String getAccountHolderName();
     void setAccountHolderName(String accountHolderName);
 }//account operation end here
  