package pl.edu.atena.entities;

public enum RiskSymbol {
	AC ("Autocasco"),
	OC ("Odpowiedzialność Cywilna");
	
	private String name;
	
	private RiskSymbol(String name) {
		this.name = name;
	}
	
	private String getName() {
		return this.name;
	}

}
