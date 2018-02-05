package pl.edu.atena.entities;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "EPO_RISK",
schema = "public"
)

public class Risk {
	@Id
	@GeneratedValue
	private Long id;
	private String nazwa;
	private BigDecimal premium;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date wr = Date.from(Instant.now());
	
	@Temporal(TemporalType.DATE)
	private Date vf;
	
	@Temporal(TemporalType.DATE)
	private Date vt;
	
	@OneToOne
	private Policy polisa;
	
	@OneToOne
	private Person insured;
	
	@OneToOne
	private Object object;

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