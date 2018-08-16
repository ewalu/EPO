package pl.edu.atena.entities;

public enum Message {
	POLICY_NUMBER_NO_DATA(0, "Brak numeru polisy"),
	NEGATIVE_PREMIUM(1,"Niepoprawna skladka"),
	INCORECT_PERIOD(2, "Niepoprawny okres ochorony"),
	PERIOD_DATE_NO_DATA(3, "Brak jedenej z dat okresu ochrony");
	
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
