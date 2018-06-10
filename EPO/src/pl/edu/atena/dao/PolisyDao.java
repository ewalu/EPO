package pl.edu.atena.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pl.edu.atena.entities.Person;
import pl.edu.atena.entities.Policy;
import pl.edu.atena.entities.PolicyState;

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
	
	public Policy szukajPoNumerze (String numer) {
		Query query = em.createQuery("select p from Policy p "
				//+"join fetch p.agenci "
				+ "where p.numerPolisy = :numerPolisy");
		query.setParameter("numerPolisy", numer);
		return (Policy) query.getSingleResult();
	}
	
	public List<Policy> szukajPoStatusie (PolicyState status) {
		Query query = em.createQuery("select p from Policy p where p.status = :statusPolisy");
		query.setParameter("statusPolisy", status);
		return (List<Policy>) query.getResultList();
	}
	
	public String ilePolis () {
		Query query = em.createQuery("select count(*) from Policy p");
		return query.getResultList().toString();
	}
	public List<Policy> select(){
		Query query = em.createQuery("select p from Policy p");
		return query.getResultList();
}
	

}
