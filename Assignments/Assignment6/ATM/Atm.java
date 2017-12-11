/* Good Work
 * Score 9 + extra credit 0; Total score 9
 * Unite test for ATM are missing
 */
package INFO5100.Assignment6.ATM;

import java.util.*;
import java.io.*;
/* ATM: current user login; create user; change password; 
 * show balance; deposit; withdrawal; show recent transaction.
 * @author: Jing Fu
 * @date : 10/19/2017
 * */
public class Atm {
	private static double START_AMOUNT = 1000;
	private static double FEE_PER_TRANSACTION = 0.1;
	private static int START_ACCOUNT = 80081000;//new account is +1
	private double availableAmountInMachine;
	private double transactionFee;
	private boolean isLogin = false;
	//use hashmap to store list of the accountNumber and userdata
	HashMap<Integer,UserData> allUsers;
	private UserData currentUser;
	
	public Atm() {
		//set the default states of atm
		this.availableAmountInMachine = START_AMOUNT;
		this.transactionFee = FEE_PER_TRANSACTION;
		this.allUsers = new HashMap<>();
		this.allUsers.put(80088008, new UserData("Monica", "08/15/2005", "301 Minor ave,Seattle,WA,98018", "2068881234", 80088008, 1234, 2000, new ArrayList<String>()));
		this.allUsers.put(80088010, new UserData("jing", "09/09/2008", "855 price ave,Seattle,WA,98011", "4808881234", 80088010, 4321, 500, new ArrayList<String>()));
	}
	
	/* ********************************************************
	 * the enter menu of ATM 
	 * get the user choice and validate user(current/new ) 
	 * current user: check the hashmap of allusers 
	 * new user: create user and write to allusers
	 * */
	public void enterMenuChoice() throws Exception{
		//ask user to choose new or current: 
		PrintMenu.enterMenu();
		//choose 1: current, 2: new 
		while(true) {	//can't set the exit 		
			Scanner scanner = new Scanner(System.in);
			System.out.println("Please input option: ");
			int input = scanner.nextInt();
			switch(input) {
			case 1:
				currentUser(); 
				break;
			case 2:
				createNewUser();
				break;
			case 3:
				changePassword();
				break;
			case 4:
				PrintMenu.exit();
				isLogin = false;
				break;
			default: 
				System.out.println("Please choose the right option.");
				continue;
			}
		}
	}
	/* ********************************************************
	 * the main menu of ATM 
	 * let user choose the option and go to matched method
	 * */
	public void mainMenuChoice() throws Exception{
		
		while( isLogin==true ) {
			PrintMenu.mainMenu();
			Scanner scanner = new Scanner(System.in);
			System.out.println("Please input your choice: ");
			int input = scanner.nextInt();
			switch (input) {
			case 1:
				changePassword();
				break;
			case 2:
				exit();
				return;
			case 3:
				getBalance();
				break;
			case 4:
				showTransaction();
				break;
			case 5:				
				depositMoney();
				break;
			case 6:
				withdrawalMoney();
				break;
			default:
				System.out.println("Please choose the right option.");
				continue;
			}			
		}			
	}
	
	
	private void withdrawalMoney() throws Exception {
		System.out.println("Welcome, "+currentUser.getName());
		PrintMenu.withdrawal();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please input your deposite amount: ");
		double money = scanner.nextDouble();
		if(availableAmountInMachine >= money & currentUser.getAvialiableBalance() >= money) {
			availableAmountInMachine = availableAmountInMachine-money;
			double balance = currentUser.getAvialiableBalance()-money-transactionFee;
			currentUser.setAvialiableBalance(balance);
			String s = "\n TransactionName: WithDrawal|*| Amount : $"+String.valueOf(money)
					+"|*| AvaliableBalance is: $"+(float)balance+"\n";
			currentUser.getRecentTransaction().add(s);
			System.out.println("Withdrawal successfully, transaction fee is $0.1/tran, your balance is : $"+(float)balance);
			mainMenuChoice();
		}else if(availableAmountInMachine < money) {
			System.out.println("Sorry, ATM avaliable money is not enough, withdrawal failed.");
		}else {
			System.out.println("Sorry, Your avaliable money  is not enough, withdrawal failed.");
		}
		
	}

	private void depositMoney() throws Exception {
		System.out.println("Welcome, "+currentUser.getName());
		PrintMenu.deposite();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please input your deposite amount: ");
		double money = scanner.nextDouble();
		//scanner.close();
		availableAmountInMachine += money;
		double balance = currentUser.getAvialiableBalance()+money-transactionFee;
		currentUser.setAvialiableBalance(balance);
		String s = "\n TransactionName: Deposit|*| Amount :$"+String.valueOf(money)
					+"|*| AvaliableBalance is: $"+(float)balance+"\n";;
		currentUser.getRecentTransaction().add(s);
		System.out.println("Deposited successfully, transaction fee is $0.1/tran, your balance is : $"+(float)balance);
		mainMenuChoice();
	}
	

	/*recentTransaction should display the last 10 trasactions,
	 *  in a format of transactionName - amount. 
	 *  (transactionName is withDrawal or deposit)
	 *  */
	private void showTransaction() throws Exception {
		System.out.println("Welcome, "+currentUser.getName());
		PrintMenu.transaction();
		if( currentUser.getRecentTransaction().isEmpty()) { 
			System.out.println("Sorry, You have no recent transaction.");
			mainMenuChoice();
			}
		if( currentUser.getRecentTransaction().size() <= 10) {
			for (String s : currentUser.getRecentTransaction()) {
				System.out.println(s);
			}
		}else {
			for( int i = 0; i < 10;i++) {
				System.out.println(currentUser.getRecentTransaction().get(i));
			}
		}
		mainMenuChoice();
	}

	private void getBalance() throws Exception {
		System.out.println("Welcome, "+currentUser.getName());
		PrintMenu.banlance();
		System.out.println("Avaliable balance:                 $"+(float)(currentUser.getAvialiableBalance()));
		mainMenuChoice();
		
	}

	private void exit() {
		System.out.println("Bye, "+currentUser.getName());
		PrintMenu.exit();
		isLogin = false;
		return;
	}
	
	/* ask user input userName birthday and phoneNumber to check if the user is right
	 * valid user can change password
	 * update userdata and hashmap 
	 * */
	private void changePassword() throws Exception {
		//new user to get the info 
		PrintMenu.changePassword();
		Scanner scanner = new Scanner(System.in);
		while(true) {			
			System.out.println("Please input your name: ");
			String name = scanner.nextLine();
			System.out.println("Please input your birth: ");
			String birth = scanner.nextLine();
			System.out.println("Please input your phoneNumber: ");
			String phone = scanner.nextLine();
			while(true) {
				if(name.equalsIgnoreCase(currentUser.getName()) && birth.equals(currentUser.getBirthDate()) && phone.equals(currentUser.getPhonenNumber()))
				{
					System.out.println("Please input your new password: ");
					int pwd1 = scanner.nextInt();
					System.out.println("Please input your new password twice: ");
					int pwd2 = scanner.nextInt();
					if( pwd1 == pwd2) {
						currentUser.setPassword(pwd1);
						allUsers.put(currentUser.getBankAccountNumber(), currentUser);
						System.out.println("Your password has been changed.");
						mainMenuChoice();
						return;
					}else {
						System.out.println("Password not matched,please input again.");
						System.out.println("=========================================");
						continue;
						}
				}else {
					System.out.println("User information is not matched.");
					System.out.println("Please input again.");
					System.out.println("=====================================");
					break;
					}
				}
			}
		}

	/*  ask user input AccountNumber and password, and validate the User
	 *  update the user and userdata and hashmap
	 * @ param: 
	 * @ return: 
	 * */
	private void currentUser() throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please input your AccountNumber( 8 digits ): ");
		int accountNumber = scanner.nextInt();
		System.out.println("Please input your password ( 4 digits ): ");
		int pwd = scanner.nextInt();
		for(int i = 0; i< allUsers.size();i++) {
			if(allUsers.containsKey(accountNumber) && allUsers.get(accountNumber).getPassword() == pwd) {
				isLogin = true;
				currentUser = allUsers.get(accountNumber);
				System.out.println("Welcome: "+allUsers.get(accountNumber).getName());
				mainMenuChoice();
				return;
			}else {
				continue;
			}
		}
		//can't find user
		PrintMenu.cantFindMenu();
		while(true) {
			scanner = new Scanner(System.in);
			int input = scanner.nextInt();
			if( input == 1) {
				PrintMenu.exit();;
				break;
			}else if( input == 2){
				currentUser();
				break;
			}
		}  
		
	}
		
	/* create a new user and update the Userdata class 
	 * @ param: 
	 * @ return: 
	 * */
	public void createNewUser() throws Exception {
		PrintMenu.createUser();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please input your UserName:");
		String userName = scanner.nextLine();
		System.out.println("Please input your PhoneNumber:");
		String phone = scanner.nextLine();
		System.out.println("Please input your Birthday:");
		String birth = scanner.nextLine();
		System.out.println("Please input your Address:");
		String address = scanner.nextLine();
		System.out.println("Please input your Password:");
		int password = scanner.nextInt();
		//feedback to user
		System.out.println("Thanks, your account is successfully created:");
		int newAccoutNum = START_ACCOUNT +1;		
		System.out.println("Your accountNumber is: "+newAccoutNum);
		//backend store logic
		//1.new userdata class, set data
		//user = new User(userName, birth, address, phone, newAccoutNum);
		this.currentUser = new UserData(userName,birth,address,phone,newAccoutNum, password, 0.00, new ArrayList<String>());
		this.allUsers.put(newAccoutNum, currentUser);
		isLogin = true;
		mainMenuChoice();
		}


}
