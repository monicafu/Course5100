package INFO5100.Assignment7.Controller;



/**
 * monitor the device
 * */
public class Sensor extends Thread{
	
    private final Device device;
    private double value;

	public Sensor(Device device) {
        this.device = device;
    }
    public double getValue() {
        return value;
    }
    public void updateValue() { 
    		//double increase = (double)(Math.random());
        //this.value += increase; // you check with other values here and see how it works
    	     this.value += 0.01;
    }
    
    /**
     * update the value of sensor*/
	public void run() {
		while (true) {
			synchronized(device) {
				this.updateValue();
				device.notify();
				if ((this.getName() == "heat"&& getValue() > 70) ||
						(this.getName() == "pressure") && getValue() >100 ) {
						break;// exit
				}
			}
		}
	}
}

