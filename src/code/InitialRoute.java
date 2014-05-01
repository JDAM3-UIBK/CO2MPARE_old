package code;

public class InitialRoute {
	
	/**
	 * 
	 * This is the object the server generates for the application for comparing purposes.
	 * 
	 */
	
	
	String vehicle;
	float distance;
	int money;
	int time;
	int co2;
		
	public InitialRoute(String vehicle, float distance, int money, int time, int co2){
		setVehicle(vehicle);
		setDistance(distance);
		setMoney(money);
		setTime(time);
		setCo2(co2);
	}

	public void setVehicle(String vehicle){
		this.vehicle=vehicle;
	}
	
	public String getVehicle(){
		return vehicle;
	}
	
	
	public float getDistance() {
		return distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getCo2() {
		return co2;
	}

	public void setCo2(int co2) {
		this.co2 = co2;
	}
	
}
