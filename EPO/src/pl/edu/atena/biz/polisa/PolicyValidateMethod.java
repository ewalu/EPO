package pl.edu.atena.biz.polisa;

import pl.edu.atena.entities.Message;
import pl.edu.atena.entities.Policy;

import java.util.Objects;

public class PolicyValidateMethod {
	
	public void validatePolicy(Policy policy) {
		if(!Objects.isNull(policy)) {
		
			if(policy.getPolicyNumber().isEmpty()) {
				policy.addMessageToPolicy(Message.POLICY_NUMBER_NO_DATA);
			}
			
		}
		
	}

}
