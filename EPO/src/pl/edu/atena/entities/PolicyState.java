package pl.edu.atena.entities;

public enum PolicyState {
	ZATWIERDZONA (1000),
	ZAWIESZONA (2000),
	ROZWIAZANA (4000),
	ANULOWANA (5000);
	
	private int code;
	
	private PolicyState(int code) {
		this.code = code;
	}
	
	private int getCode() {
		return code;
	}
}
