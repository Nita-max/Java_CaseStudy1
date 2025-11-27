package practiceworkjava;
import java.util.Date;
 class Transaction {
     int transactionId;
     Date transactionDate;
     String transactionType;
     double amount;
     double updatedBalance;

     Transaction(int transactionId, Date transactionDate, String transactionType, double amount,
            double updatedBalance) {
        this.transactionId = transactionId;
        this.transactionDate = transactionDate;
        this.transactionType = transactionType;
        this.amount = amount;
        this.updatedBalance = updatedBalance;
    }//parameterized comstructor
     
//setters and getters
     int getTransactionId() {
        return transactionId;
    }

     Date getTransactionDate() {
        return transactionDate;
    }

     String getTransactionType() {
        return transactionType;
    }

     double getAmount() {
        return amount;
    }

     double getUpdatedBalance() {
        return updatedBalance;
    }

    public String toString() {
        return "Id=" + this.transactionId + ", date=" + this.transactionDate + ", type=" + this.transactionType + ", amount="
                + this.amount + ", balance=" + this.updatedBalance;
    }
}//transaction class ends here
