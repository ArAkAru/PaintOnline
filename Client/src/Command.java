import java.io.Serializable;

public class Command implements Serializable {
	private double coordinateX;
	private double coordinateY;
	private String macAddress;
	private String step;
	private int color;
	private static final long serialVersionUID = 4254099144542132318L;

	public Command(String mac, String action, double x, double y, int color) {
		this.coordinateX = x;
		this.coordinateY = y;
		this.step = action;
		this.color = color;
		this.macAddress = mac;
		
	}
	public String getStep() {
		return step;
	}

	

	public double getcoordinateX() {
		return coordinateX;
	}

	

	public double getcoordinateY() {
		return coordinateY;
	}

	

	public int getColor() {
		return color;
	}

	
}
