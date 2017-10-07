package INFO5100.Assignment4;

public class IpAddress {
	private String dottleDecimal;//"216.27.6.136"
	private int firstOctet;
	private int secondOctet;
	private int thirdOctet;
	private int fourthOctet;
	
	protected IpAddress(String dottleDecimal) {
		//checkVaild
		if(checkVaild(dottleDecimal) == true)
			this.dottleDecimal = dottleDecimal;
		else
			//System.out.println(dottleDecimal +": input is not vaild.");
			throw new IllegalArgumentException(dottleDecimal +" : input is not vaild.");
	}
	
	
	private  boolean checkVaild(String dottleDecimal) {
		
		int[] octet = splitDottleDecimalToOctet(dottleDecimal);
		int i = 0;
		while(i<octet.length) {
			if( octet[i] >= 0 && octet[i] <= 255)
				i++;
			else 
				return false;
		}
		return true;
	}
	private  int[] splitDottleDecimalToOctet(String dottleDecimal) {
		int[] octet = new int[4];
		for(int i = 0; i< dottleDecimal.length(); i++) {
			int firstDottle = dottleDecimal.indexOf('.', 1);
				octet[0] = Integer.parseInt(dottleDecimal.substring(0, firstDottle));
			int secondDottle = dottleDecimal.indexOf('.', firstDottle+1);
				octet[1] = Integer.parseInt(dottleDecimal.substring(firstDottle+1, secondDottle));
			int thirdDottle = dottleDecimal.indexOf('.', secondDottle+1);
				octet[2] = Integer.parseInt(dottleDecimal.substring(secondDottle+1, thirdDottle));
			int fourthDottle = dottleDecimal.length();
				octet[3] = Integer.parseInt(dottleDecimal.substring(thirdDottle+1, fourthDottle));				
		}
		return octet;
	}
	
	private int getOctet(int i) {
		int[] octet = splitDottleDecimalToOctet(dottleDecimal);
		this.firstOctet = octet[0];
		this.secondOctet = octet[1];
		this.thirdOctet = octet[2];
		this.fourthOctet = octet[3];
		
			
		switch(i) {
		case 1:
			return firstOctet;
		case 2:
			return secondOctet;
		case 3:
			return thirdOctet;
		case 4:
			return fourthOctet;
		}
		return 0;
	}


	private char[] getDottedDecimal() {
		
			return dottleDecimal.toCharArray();			
	}
	
	public static void main(String args[]) {
		
		IpAddress ip = new IpAddress("216.27.6.136");
		System.out.println(ip.getDottedDecimal());
		System.out.println(ip.getOctet(4));
		System.out.println(ip.getOctet(1));
		System.out.println(ip.getOctet(3));
		System.out.println(ip.getOctet(2));
	}



}
