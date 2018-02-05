package pl.edu.atena.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Risk {
	@Id
	@GeneratedValue
	private Long id;
	private String nazwa;
	
	@OneToOne
	private Policy polisa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public Policy getPolisa() {
		return polisa;
	}

	public void setPolisa(Policy polisa) {
		this.polisa = polisa;
	}

}