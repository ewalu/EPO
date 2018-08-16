package pl.edu.atena.biz.polisa;

import pl.edu.atena.entities.Message;
import pl.edu.atena.entities.Policy;

import java.math.BigDecimal;
import java.util.Objects;

public class PolicyValidateMethod {
	
	public void validatePolicy(Policy policy) {
		if(!Objects.isNull(policy)) {
		
			if(policy.getPolicyNumber().isEmpty()) {
				policy.addMessageToPolicy(Message.POLICY_NUMBER_NO_DATA);
			}
			this.validatePremium(policy);
			this.validatePeriod(policy);
			
		}
		
	}
	
	private void validatePremium(Policy policy) {
		if(policy.getPremium().equals(null) || policy.getPremium().compareTo(BigDecimal.ZERO)<0) {
			policy.addMessageToPolicy(Message.NEGATIVE_PREMIUM);
		}
	}
	
	private void validatePeriod(Policy policy) {
		if(policy.getInsuranceEndDate().equals(null) || policy.getInsuranceStartDate().equals(null)) {
			policy.addMessageToPolicy(Message.PERIOD_DATE_NO_DATA);
		} else if(policy.getInsuranceEndDate().compareTo(policy.getInsuranceStartDate())<0) {
			policy.addMessageToPolicy(Message.INCORECT_PERIOD);
		}
	}

}
