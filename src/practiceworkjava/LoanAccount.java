package practiceworkjava;
class LoanAccount extends BankAccount {
       double loanAmount;
       double outstanding;

       public LoanAccount(long accountNumber, String accountHoldername, double balance, long accountHolderAadhar,
               long nomineeAadhar, double loanAmount, double outstanding) {
           super(accountNumber, accountHoldername, balance, accountHolderAadhar, nomineeAadhar);
           this.loanAmount = loanAmount;
           this.outstanding = loanAmount;
       }//parameterized constructor

       void setLoanAmount(double loanAmount) {
   		this.loanAmount = loanAmount;
   	}

   	void setOutstanding(double outstanding) {
   		this.outstanding = outstanding;
   	}
   	
        double getLoanAmount() {
           return this.loanAmount;
       }

        double getOutstanding() {
           return this.outstanding;
       }

       @Override
       public void deposit(double amount) {
           if (amount <= 0) {
               System.out.println("Repayment amount must be positive.");
               return;
           }

           double prevOutstanding = this.outstanding;
           this.outstanding = this.outstanding-amount;

           if (this.outstanding < 0) {
               double extra = -this.outstanding;
               this.outstanding = 0;
               setBalance(getBalance() + extra);
           }

           addTransaction("Repayment", amount);
           System.out.println("Repayment " + amount + ". Previous outstanding=" + prevOutstanding + ", New outstanding="
                   + this.outstanding + ", balance=" + getBalance());
       }

       
	@Override
       public void withdraw(double amount) {
           System.out.println("Cannot withdraw from loan account.");
           return;
       }

       @Override
       public String toString() {
           return "LoanAccount " + super.toString() + ", loanAmount=" + this.loanAmount + ", outstanding=" + this.outstanding;
       }
   }//loan account ends here