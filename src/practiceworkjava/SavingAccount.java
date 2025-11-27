package practiceworkjava;
class SavingAccount extends BankAccount {
         final double minimum_balance = 10000.0;
         static double savingInterestRate = 8.0;

          SavingAccount(long accountNumber, String accountHoldername, double balance, long accountHolderAadhar,
                 long nomineeAadhar,double minimum_balance,double savingInterestRate) {
             super(accountNumber, accountHoldername, balance, accountHolderAadhar, nomineeAadhar);
         }

         static double getSavingInterestRate() {
			return savingInterestRate;
		}

        static void setSavingInterestRate(double savingInterestRate) {
			SavingAccount.savingInterestRate = savingInterestRate;
		}

		double getMinimum_balance() {
			return this.minimum_balance;
		}

		@Override
         public void withdraw(double amount) {
             if (amount <= 0) {
                 System.out.println("Withdraw amount must be positive.");
                 return;
             }

             double newBal = getBalance() - amount;

             if (newBal < minimum_balance) {
                 System.out.println("Cannot withdraw. Minimum balance " + this.minimum_balance + " must be maintained.");
                 return;
             }

             setBalance(newBal);
             addTransaction("Withdraw", amount);
             System.out.println("Withdrawn " + amount + ". New balance = " + getBalance());
         }

         @Override
         public String toString() {
             return "SavingAccount " + super.toString() + ", minBalance=" + this.minimum_balance;
         }
     }//saving account ends here
      