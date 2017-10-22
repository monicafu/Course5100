package INFO5100.Assignment6.ATM;

public class User {
	
	private String name; 
	private String birthDate;
	private String address;
	private String phoneNumber;
	private int bankAccountNumber;
	
	public User() {
		
	}
	
	public User(String name,String birthDate,String address,String phoneNumber,int bankAccountNumber) {
		this.name = name;
		this.birthDate = birthDate;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhonenNumber() {
		return phoneNumber;
	}

	public void setPhonenNumber(String phonenNumber) {
		this.phoneNumber = phonenNumber;
	}

	public int getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(int bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}
	
	

}
