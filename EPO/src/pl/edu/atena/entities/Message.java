package pl.edu.atena.entities;

public enum Message {
	VALID_POLICY_DATA(0, "Poprawna Polisa"),
	POLICY_NUMBER_NO_DATA(1, "Brak numeru polisy"),
	NEGATIVE_PREMIUM(2,"Niepoprawna skladka"),
	INCORECT_PERIOD(3, "Niepoprawny okres ochorony"),
	PERIOD_DATE_NO_DATA(4, "Brak jedenej z dat okresu ochrony");
	
	
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
