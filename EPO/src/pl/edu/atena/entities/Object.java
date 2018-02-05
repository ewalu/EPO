package pl.edu.atena.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Object {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	@OneToOne
	private Policy policy;

	public Policy getPolisa() {
		return policy;
	}

	public void setPolisa(Policy polisa) {
		this.policy = polisa;
	}

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