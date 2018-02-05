package pl.edu.atena.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pl.edu.atena.entities.Policy;
import pl.edu.atena.entities.Person;

@Stateless
public class PersonDao {
	@PersistenceContext(unitName = "PolisaPU")
	private EntityManager em;
	
	public void create (Person ubezp) {
		em.persist(ubezp);
	}
	
	public Person find(Long id) {
		return em.find(Person.class,id);
	}
	
	public void refresh(Person ubezp) {
		em.refresh(ubezp);
	}
	
	/*public Person dodajPolise(Long id, Policy polisa) {
		Person ubezp = find(id);
		ubezp.setPolisa(polisa);
		return ubezp;
	}*/
}