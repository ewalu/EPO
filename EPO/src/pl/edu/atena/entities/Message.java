package pl.edu.atena.entities;

public enum Message {
	POLICY_NUMBER_NO_DATA(0, "Brak numeru polisy"),
	NEGATIVE_PREMIUM(1,"Niepoprawna skladka"),
	INCORECT_PERIOD(2, "Niepoprawny okres ochorony");
	
	int code;
	String text;
	
	private Message(int code, String text) {
		this.code = code;
		this.text = text;
	}
	
	public int returnCode() {
		return code;
	}
	
	public String returnText() {
		return text;
	}

}
