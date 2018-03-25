package pl.edu.atena.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pl.edu.atena.entities.Person;
import pl.edu.atena.entities.Policy;

@Stateless
public class PolisyDao {
	@PersistenceContext(unitName = "PolisaPU")
	private EntityManager em;
	
	public void create (Policy polisa) {
		em.persist(polisa);
	}
	
	public Policy find(Long id) {
		return em.find(Policy.class,id);
	}
	
	public Policy update(Long id, Person insurer) {
		Policy polisaup = find(id);
		polisaup.setInsured(insurer);
		return polisaup;
	}
	
	public void delete(Long id) {
		Policy polisa = find(id);
		System.out.println(em.contains(polisa));
		if (polisa != null) {
			em.remove(polisa);
		}
	}
	

}
