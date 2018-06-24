package pl.edu.atena.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
	
	public List<Person> select(){
		Query query = em.createQuery("select p from Person p");
		return query.getResultList();
	}
	
	public List<Person> findPesel (String pesel) {
		Query query = em.createQuery("select p from Person p "
				+ "where p.pesel = :pesel");
		query.setParameter("pesel", pesel);
		return query.getResultList();
	}
	
	/*public Person dodajPolise(Long id, Policy polisa) {
		Person ubezp = find(id);
		ubezp.setPolisa(polisa);
		return ubezp;
	}*/
}