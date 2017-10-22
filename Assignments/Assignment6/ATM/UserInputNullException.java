package INFO5100.Assignment6.ATM;

public class UserInputNullException extends Exception {
	
	private String msg;
	
	public UserInputNullException() {
		super();
	}
	
	public UserInputNullException(String message) {
		super(message);
		msg = message;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
