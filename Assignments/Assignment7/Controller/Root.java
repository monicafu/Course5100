package INFO5100.Assignment7.Controller;

public class Root {

	public static void main(String[] args) throws InterruptedException {
		
	        Device device = new Device();
	        
	        Sensor heat = new Sensor(device);
	        Sensor pressure = new Sensor(device);
	        Controller controller = new Controller(device,heat,pressure);
	        
	        heat.setName("heat");
	        pressure.setName("pressure");
	        controller.start();
	        heat.start();
	        pressure.start();
	    }
}
