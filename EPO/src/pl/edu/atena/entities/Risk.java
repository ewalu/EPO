package pl.edu.atena.entities;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
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
	private RiskSymbol riskSymbol;
	//private BigDecimal premium;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date wr = Date.from(Instant.now());
	
	/*@Temporal(TemporalType.DATE)
	private Date vf;
	
	@Temporal(TemporalType.DATE)
	private Date vt;
	
	@ManyToOne
	private Policy polisa;
	
	@OneToOne
	private Person insured;
	
	@OneToOne
	private Person insurer;
	
	@OneToOne
	private Object object;*/

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

	/*public Policy getPolisa() {
		return polisa;
	}

	public void setPolisa(Policy polisa) {
		this.polisa = polisa;
	}

	public BigDecimal getPremium() {
		return premium;
	}

	public void setPremium(BigDecimal premium) {
		this.premium = premium;
	}*/

	public Date getWr() {
		return wr;
	}

	public void setWr(Date wr) {
		this.wr = wr;
	}

	public RiskSymbol getRiskSymbol() {
		return riskSymbol;
	}

	public void setRiskSymbol(RiskSymbol riskSymbol) {
		this.riskSymbol = riskSymbol;
	}

	/*public Date getVf() {
		return vf;
	}

	public void setVf(Date vf) {
		this.vf = vf;
	}

	public Date getVt() {
		return vt;
	}

	public void setVt(Date vt) {
		this.vt = vt;
	}

	public Person getInsured() {
		return insured;
	}

	public void setInsured(Person insured) {
		this.insured = insured;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}*/

}