package INFO5100.Assignment6.ATM;

import java.util.ArrayList;

public class UserData extends User{
	
	private int password;
	private double avialiableBalance;
	private ArrayList<String> recentTransaction;
	
	public UserData(){
		
	}
	
	public UserData(String name, String birth,String address,String phone,int bankNum,int pwd, double balance,ArrayList<String> transaction){
		super(name,birth,address,phone,bankNum);
		this.password = pwd;
		this.avialiableBalance = balance;
		this.setRecentTransaction(transaction);
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public double getAvialiableBalance() {
		return avialiableBalance;
	}

	public void setAvialiableBalance(double avialiableBalance) {
		this.avialiableBalance = avialiableBalance;
	}

	public ArrayList<String> getRecentTransaction() {
		return recentTransaction;
	}

	public void setRecentTransaction(ArrayList<String> recentTransaction) {
		this.recentTransaction = recentTransaction;
	}


}
