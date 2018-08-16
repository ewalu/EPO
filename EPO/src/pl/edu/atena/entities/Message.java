package pl.edu.atena.entities;

public enum Message {
	VALID_POLICY_DATA(0, "Poprawna Polisa", MessageType.SUCCESS),
	POLICY_NUMBER_NO_DATA(1, "Brak numeru polisy", MessageType.ERROR),
	NEGATIVE_PREMIUM(2,"Niepoprawna skladka", MessageType.ERROR),
	INCORECT_PERIOD(3, "Niepoprawny okres ochorony", MessageType.ERROR),
	PERIOD_DATE_NO_DATA(4, "Brak jedenej z dat okresu ochrony", MessageType.ERROR);
	
	
	int code;
	String text;
	MessageType type;
	
	private Message(int code, String text, MessageType type) {
		this.code = code;
		this.text = text;
		this.type = type;
	}
	
	public int returnCode() {
		return code;
	}
	
	public MessageType ReturnType() {
		return type;
		
	}
	
	public String returnText() {
		return text;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

}
