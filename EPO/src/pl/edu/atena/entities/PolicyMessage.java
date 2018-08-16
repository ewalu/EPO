package pl.edu.atena.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "EPO_POLICY_MESSAGE",
uniqueConstraints = {@UniqueConstraint(columnNames= {"id"})},
schema = "public",
indexes = {@Index(columnList = "id")}
)
public class PolicyMessage {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private Message message;

}
