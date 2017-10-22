package INFO5100.Assignment6.Exceptions;

public class MyIndexOutOfBoundException extends Exception {
	
	private int lowerBound = 0;
	private int upperBound = 9;
	private int index;
	
	
	
	private MyIndexOutOfBoundException() {
		super();
	}

	private MyIndexOutOfBoundException(String message) {
		super(message);
	}

	@Override
	public String toString() {
		return "Error Message: Index: " +index+" , but Lower bound: "+ lowerBound + ", Upper bound : " + upperBound;
	}



	public static void main(String args[]) {
		
		int index = 10;
		
		try {
			if( index < 0 || index > 9 ) {
				MyIndexOutOfBoundException exception = new MyIndexOutOfBoundException();
				exception.setIndex(index);
				throw exception;
			}
			
		} catch (MyIndexOutOfBoundException e) {
			e.printStackTrace();
			
		}
	}

	public int getLowerBound() {
		return lowerBound;
	}

	public void setLowerBound(int lowerBound) {
		this.lowerBound = lowerBound;
	}

	public int getUpperBound() {
		return upperBound;
	}

	public void setUpperBound(int upperBound) {
		this.upperBound = upperBound;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
}
