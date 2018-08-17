package pl.edu.atena.biz.polisa;

import pl.edu.atena.entities.MessageType;
import pl.edu.atena.entities.Policy;
import pl.edu.atena.entities.PolicyState;

public class PolicySetStatusMethod {
	
	public void setStatus(Policy policy) {
		policy.setStatus(PolicyState.ZATWIERDZONA);
		if(policy.getPolicyMessages().stream().anyMatch(mess->mess.getType().equals(MessageType.ERROR.toString()))) {
			policy.setStatus(PolicyState.ZAWIESZONA);
		}
	}

}
