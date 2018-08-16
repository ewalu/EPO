package pl.edu.atena.entities;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "EPO_POLICY",
uniqueConstraints = {@UniqueConstraint(columnNames= {"policyNumber"})},
schema = "public",
indexes = {@Index(columnList = "policyNumber")}
)
public class Policy {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String policyNumber;
	private BigDecimal premium;
	
	@OneToOne
	private Person insured;
	
	/*@ManyToMany
	private List<Profile> profiles;
	
	@OneToMany
	private List<Risk> risks;*/
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date wr = Date.from(Instant.now());
	
	@Temporal(TemporalType.DATE)
	private Date signDate = Date.from(Instant.now());
	
	@Temporal(TemporalType.DATE)
	private Date insuranceStartDate;
	
	@Temporal(TemporalType.DATE)
	private Date insuranceEndDate;
	
	@Enumerated(EnumType.STRING)
	private PolicyState status = PolicyState.ZATWIERDZONA;
	
	/*public Polisa() {
		Random r = new Random();
		this.numerPolisy = "EWA"+LocalDate.now()+-+r.nextInt(1000);
		this.skladka = BigDecimal.valueOf(r.nextInt(1000));
	}*/
	
	public Long getId() {
		return id;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public BigDecimal getPremium() {
		return premium;
	}

	public void setPremium(BigDecimal premium) {
		this.premium = premium;
	}

	public Date getWr() {
		return wr;
	}

	public void setWr(Date wr) {
		this.wr = wr;
	}

	public Date getSignDate() {
		return signDate;
	}

	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}

	public PolicyState getStatus() {
		return status;
	}

	public void setStatus(PolicyState status) {
		this.status = status;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Person getInsured() {
		return insured;
	}

	public void setInsured(Person insured) {
		this.insured = insured;
	}

	public Date getInsuranceStartDate() {
		return insuranceStartDate;
	}

	public void setInsuranceStartDate(Date insuranceStartDate) {
		this.insuranceStartDate = insuranceStartDate;
	}

	public Date getInsuranceEndDate() {
		return insuranceEndDate;
	}

	public void setInsuranceEndDate(Date insuranceEndDate) {
		this.insuranceEndDate = insuranceEndDate;
	}


	/*public List<Risk> getRisks() {
		return risks;
	}

	public void setRisks(List<Risk> risks) {
		this.risks = risks;
	}*/
	

}
