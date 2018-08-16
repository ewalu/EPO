package pl.edu.atena.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "EPO_MESSAGE",
schema = "public"
)
public class PolicyMessage {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	private Policy polisa;
	
	private Integer code;
	
	private String message;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Policy getPolisa() {
		return polisa;
	}

	public void setPolisa(Policy polisa) {
		this.polisa = polisa;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
