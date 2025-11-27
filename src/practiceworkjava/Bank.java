package practiceworkjava;
import java.util.*;
import java.util.Date;

public class Bank {
     int branchId;
     String bankName;
     String branchName;
     String bankLocation;
     int totalAccountcount;
     String IfscCode;

    public Bank() {
        this.branchId = 101;
        this.bankName = "HDFC";
        this.branchName = "Pune";
        this.bankLocation = "Deccan";
        this.totalAccountcount = 0;
        this.IfscCode = "HDFC0001";
    }//default constructor

    public Bank(int branchId, String bankName, String branchName, String bankLocation, int totalAccountcount,
            String ifscCode) {
        this.branchId = branchId;
        this.bankName = bankName;
        this.branchName = branchName;
        this.bankLocation = bankLocation;
        this.totalAccountcount = totalAccountcount;
        IfscCode = ifscCode;
    }//parameterized
    
//setter and getter
	int getBranchId() {
		return this.branchId;
	}

	void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	String getBankName() {
		return this.bankName;
	}

	void setBankName(String bankName) {
		this.bankName = bankName;
	}

	String getBranchName() {
		return this.branchName;
	}

	void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	String getBankLocation() {
		return this.bankLocation;
	}

	void setBankLocation(String bankLocation) {
		this.bankLocation = bankLocation;
	}

	int getTotalAccountcount() {
		return this.totalAccountcount;
	}

	void setTotalAccountcount(int totalAccountcount) {
		this.totalAccountcount = totalAccountcount;
	}

	String getIfscCode() {
		return this.IfscCode;
	}

	void setIfscCode(String ifscCode) {
		IfscCode = ifscCode;
	}


    public String toString() {
        return "Bank [branchId=" +  this.branchId + ", bankName=" +  this.bankName + ", branchName=" + this.branchName
                + ", bankLocation=" + this.bankLocation + ", totalAccountcount=" + this.totalAccountcount + ", IfscCode="
                + this.IfscCode + "]";
    }
    
}//bank class ends here
