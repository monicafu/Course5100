/* Good WOrk
 * Total score 10
*/
package INFO5100.Assignment8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Year;
import java.util.ArrayList;

public class MyJson {
	
	/**
	 * read from a file and return collection of Vehicle objects
	 * @param file object
	 * @return a ArrayList of Vehicles*/
	private static ArrayList<Vehicle> readAndGetVehicles(File file) throws IOException{
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String str = br.readLine();
		String[] line = new String[10];
		ArrayList<Vehicle> vehs = new ArrayList<>();
		while(true) {
			str =br.readLine();
			if (str == null) break;	
			//System.out.println(str);
			line = str.split("~");
			vehs.add(new Vehicle(line));			
		}
		br.close();
		fr.close();
		return vehs;
	}
	
	/** convert vehicles to a json string 
	 * @param ArrayList of vehicles of the particular dealer
	 * @return json string*/
	public static String getJsonString(ArrayList<Vehicle> vehicles) {
		StringBuilder sb = new StringBuilder();
		sb.append("{\n\"gmps-camino\":[\n");
		for (Vehicle veh: vehicles) {
			sb.append(veh.toString());
		}
		sb.append("]\n}");
		return sb.toString();
	}
	public static void writeToFile(String inputToWrite, String filePath) throws IOException {
		
		FileWriter fw = new FileWriter(filePath+"/Question3_write.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(inputToWrite);
		bw.close();
		fw.close();
	}

	public static void main(String[] args) throws IOException {
		
		File file = new File("src/INFO5100/Assignment8/Question3_camino.txt");
	    ArrayList<Vehicle> vehicles = readAndGetVehicles(file);
	    String s = getJsonString(vehicles);
	    writeToFile(s, file.getParent());
	}
}	

class Vehicle{

	    String id;
	    String webId;
	    Category category;
	    Year year;
	    String make;
	    String model;
	    String trim;
	    String type;
	    double price;
	    URL photo;

	    Vehicle(String[] arr){
	        this.id = arr[0];
	        this.webId = arr[1];
	        this.category = Category.getCategory(arr[2].toLowerCase());
	        this.year = Year.parse(arr[3]);
	        this.make = arr[4];
	        this.model = arr[5];
	        this.trim = arr[6];
	        this.type = arr[7];
	        this.price = Double.parseDouble(arr[8]);
	        try {
	            this.photo = new URL(arr[9]);
	        } catch (MalformedURLException e) {
	            e.printStackTrace();
	        }
	    }
	    public String toString() {
	    		StringBuilder sb = new StringBuilder();
	    		sb.append("{\n");
	    		sb.append("\"id\" : \"" + this.id + "\"\n");
	    		sb.append("\"category\" : \"" + this.category + "\"\n");
	    		sb.append("\"year\" : \"" + this.year + "\"\n");
	    		sb.append("\"make\" : \"" + this.make + "\"\n");
	    		sb.append("\"model\" : \"" + this.model + "\"\n");
	    		sb.append("\"trim\" : \"" + this.trim + "\"\n");
	    		sb.append("\"type\" : \"" + this.type + "\"\n");
	    		sb.append("\"price\" : \"" + this.price + "\"\n");
	    		sb.append("\"photo\" : \"" + this.photo + "\"\n},\n");
	    		return sb.toString();
	    }
	}

	enum Category{
	    NEW , USED, CERTIFIED;

	    public static Category getCategory(String cat){
	       switch (cat){
	           case "used": return USED;
	           case "new": return NEW;
	           case "certified": return CERTIFIED;
	           default: throw new IllegalArgumentException();
	       }
	    }

	    @Override
	    public String toString() {
	        switch (this){
	            case NEW: return "NEW";
	            case USED: return "USED";
	            case CERTIFIED: return "CERTIFIED";
	            default: throw new IllegalArgumentException();
	        }
	    }
}
