package kjlasdhf;

import java.io.Serializable;

public class Command implements Serializable {
	
	String name;
	double value;
	
	public Command(String name, double value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	

}
