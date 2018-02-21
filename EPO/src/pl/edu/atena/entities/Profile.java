package pl.edu.atena.entities;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "EPO_PROFILE",
schema = "public"
)

public class Profile {

		@Id
		@GeneratedValue
		private Long id;
		private String nazwa;
		
		@ManyToMany
		private List<Policy> policies;
		
		

}
