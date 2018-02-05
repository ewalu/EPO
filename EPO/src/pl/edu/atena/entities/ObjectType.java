package pl.edu.atena.entities;

public enum ObjectType {
	VEHICLE (1),
	ESTATE (2),
	LIFE (3),
	OTHER (4);
	
	private int code;
	
	private ObjectType(int code) {
		this.code = code;
	}
	
	private int getCode() {
		return code;
	}

}
