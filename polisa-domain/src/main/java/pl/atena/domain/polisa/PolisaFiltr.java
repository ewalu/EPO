package pl.atena.domain.polisa;
import java.math.BigDecimal;
import java.time.LocalDate;

public class PolisaFiltr {

	private String nrPolisy;
	private LocalDate data;
	private BigDecimal skladka;

	public String getNrPolisy() {
		return nrPolisy;
	}

	public void setNrPolisy(String nrPolisy) {
		this.nrPolisy = nrPolisy;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public BigDecimal getSkladka() {
		return skladka;
	}

	public void setSkladka(BigDecimal skladka) {
		this.skladka = skladka;
	}

}
