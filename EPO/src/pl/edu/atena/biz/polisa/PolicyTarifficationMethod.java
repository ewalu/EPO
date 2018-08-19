package pl.edu.atena.biz.polisa;

import java.math.BigDecimal;
import java.util.Objects;

import org.jboss.logging.Logger;

import pl.edu.atena.entities.Policy;
import pl.edu.atena.entities.PolicyState;

public class PolicyTarifficationMethod {
	
	private Logger log = Logger.getLogger(PolicyTarifficationMethod.class);
	
	public void tarifficate(Policy policy) {
		if(!Objects.isNull(policy.getInsured()) && policy.getStatus().equals(PolicyState.ZATWIERDZONA) && !Objects.isNull(policy.getInsured().getBirthDate())) {
			BigDecimal premium = policy.getPremium();
			policy.setPremium(premium.multiply(BigDecimal.valueOf(policy.getInsured().calculatePersonFactor())));
			log.info(policy.getPolicyNumber()+": "+premium+"->"+policy.getPremium().toString());
		}
	}

}
