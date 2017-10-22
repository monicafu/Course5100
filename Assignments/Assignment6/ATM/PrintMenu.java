package INFO5100.Assignment6.ATM;
/*This class print some instructions to guide user use the ATM*/
public class PrintMenu {
	
	
	public static void enterMenu() {
		System.out.println("=============================================");
		System.out.println("| Hello, welcome to ABC Bank                |");
		System.out.println("| Please choose from the following options  |");
		System.out.println("| [1]. Current User         [2]. New User   |");
		System.out.println("| [3]. ForgotPassword       [4]. Exit       |");
		System.out.println("|                                 ABC Bank  |");
		System.out.println("=============================================");
	}
	
	public static void cantFindMenu() {
		System.out.println("=============================================");
		System.out.println("| Sorry, Can't find your account            |");
		System.out.println("| Please choose exit or input again       |");
		System.out.println("| [1]. Exit                   [2]. Input    |");
		System.out.println("|                                 ABC Bank  |");
		System.out.println("=============================================");		
		
	}
	
	public static void mainMenu() {

		System.out.println("===========================================");
		System.out.println("| You are login, Dear User :               |");
		System.out.println("| Please choose from the following options |");
		System.out.println("| [1]. ChangePassword     [2]. Exit        |");
		System.out.println("| [3]. Balance            [4]. Transaction |");
		System.out.println("| [5]. Deposite           [6]. Withdrawal  |");
		System.out.println("|                                 ABC Bank |");
		System.out.println("===========================================");
	}
	
	public static void createUser() {
		System.out.println("===========================================");
		System.out.println("| Please fill in the following information:|");
		System.out.println("| 1. UserName   (LasName_FirstName)        |");
		System.out.println("| 2. Password   (4 digits)                 |");
		System.out.println("| 3. Birthday   (DD/MM/YYYY)               |");
		System.out.println("| 4. PhoneNumber(10 digits)                |");
		System.out.println("| 5. Address    (Street,City,State,Zip)    |");
		System.out.println("|                                 ABC Bank |");
		System.out.println("===========================================");
	}
	
	public static void changePassword() {
		System.out.println("===========================================");
		System.out.println("| Reset your new password                  |");
		System.out.println("| First we want you to answer questions    |");
		System.out.println("| 1. New Password:     (4 digits)          |");
		System.out.println("| 2. Confirm Password: (4 digits)          |");
		System.out.println("|                                 ABC Bank |");
		System.out.println("===========================================");
	}
	
	public static void exit() {
		System.out.println("===========================================");
		System.out.println("| Thanks you for using                     |");
		System.out.println("| Have a nice day                          |");
		System.out.println("|                                 ABC Bank |");
		System.out.println("===========================================");
	}

	public static void banlance() {
		System.out.println("===========================================");
		System.out.println("| You are login, Dear User :               |");
		System.out.println("| Here are the balance of your account     |");
		System.out.println("|                                 ABC Bank |");
		System.out.println("===========================================");
	}
	public static void transaction() {
		System.out.println("===========================================");
		System.out.println("| You are login, Dear User :               |");
		System.out.println("| Here are the recent transactions         |");
		System.out.println("|                                 ABC Bank |");
		System.out.println("===========================================");
	}
	
	
	public static void deposite() {

		System.out.println("===========================================");
		System.out.println("| You are login, Dear User :               |");
		System.out.println("| Please input your money into ATM         |");
		System.out.println("| Value accepted:   5 10 20 50 100         |");
		System.out.println("|                                 ABC Bank |");
		System.out.println("===========================================");
	}
	public static void withdrawal() {

		System.out.println("===========================================");
		System.out.println("| You are login, Dear User :               |");
		System.out.println("| Please input your withdrawal amount      |");
		System.out.println("| Value accepted :   5 10 20 50 100        |");
		System.out.println("|                                 ABC Bank |");
		System.out.println("===========================================");
	}

	
}
