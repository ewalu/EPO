package pl.edu.atena.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.ForeignKey;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "EPO_MESSAGE",
schema = "public"
)
public class PolicyMessage {
	
	@Id
	@GeneratedValue
	private Long id;
	
	/*@ManyToOne
	@JoinColumn(name = "POL_ID", foreignKey = @ForeignKey(name = "FK_MESSAGE_TO_POLICY"), insertable = true)
	
	private Policy policy;*/
	
	private Integer code;
	
	private String message;
	
	private String type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return this.type+" "+this.message;
	}

}
