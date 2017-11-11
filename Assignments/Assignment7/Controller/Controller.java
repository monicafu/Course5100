package INFO5100.Assignment7.Controller;

public class Controller extends Thread{
	Device device;
	Sensor heat;
	Sensor pressure;
	
	public Controller(Device device,Sensor heat,Sensor pressure) {
		this.device = device;
		this.heat = heat;
		this.pressure = pressure;
	}
	/**
	 * controller is used to start/shutdown device from monitor the sensor*/
	@Override 
	public  void run() {
		device.startup();
		synchronized(device){
			while(true) {
				try {
					device.wait();
				}catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("heat -> " +String.format("%.2f",heat.getValue())+ "  , pressure -> "+String.format("%.2f",pressure.getValue()));
				if (heat.getValue() > 70 || pressure.getValue() > 100) {
					device.shutdown();
					break;
				}
			}
		}
	}
}
