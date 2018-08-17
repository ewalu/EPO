package pl.edu.atena.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pl.edu.atena.biz.polisa.PolicyValidateStatusMethod;
import pl.edu.atena.biz.polisa.PolicyTarifficationMethod;
import pl.edu.atena.biz.polisa.PolicyValidateDataMethod;
import pl.edu.atena.entities.Person;
import pl.edu.atena.entities.Policy;
import pl.edu.atena.entities.PolicyState;

@Stateless
public class PolicyDao {
	@PersistenceContext(unitName = "PolisaPU")
	private EntityManager em;
	
	@Inject
	private PolicyValidateDataMethod policyValidatDataeMethod;
	
	@Inject
	private PolicyValidateStatusMethod policyValidateStatusMethod;
	
	@Inject
	private PolicyTarifficationMethod policyTarifficationMethod;
	
	public void create (Policy polisa) {
		policyValidatDataeMethod.validate(polisa);
		policyValidateStatusMethod.validate(polisa);
		policyTarifficationMethod.tarifficate(polisa);
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
