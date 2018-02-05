package pl.edu.atena.entities;

import java.time.Instant;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity

@Table(name = "EPO_PERSON",
schema = "public"
)
public class Person {
	@Id
	@GeneratedValue
	private Long id;
	private String nazwa;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date wr = Date.from(Instant.now());

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

}
