package pl.edu.atena.entities;

import java.time.Instant;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity

@Table(name = "EPO_OBJECT",
schema = "public"
)

public class Object {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date wr = Date.from(Instant.now());
	
	@Enumerated(EnumType.STRING)
	private ObjectType type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}