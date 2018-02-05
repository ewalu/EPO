package pl.edu.atena.entities;

public enum PersonRole {
	INSURER (1),
	INSURED (2),
	OWNER (3);
	
	private int code;
	
	private PersonRole(int code) {
		this.code = code;
	}
	
	private int getCode() {
		return code;
	}

}
