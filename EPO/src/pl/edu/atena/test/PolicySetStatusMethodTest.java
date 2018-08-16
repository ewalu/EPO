package pl.edu.atena.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.junit.Test;

import junit.framework.Assert;
import pl.edu.atena.biz.polisa.PolicySetStatusMethod;
import pl.edu.atena.biz.polisa.PolicyValidateMethod;
import pl.edu.atena.entities.Message;
import pl.edu.atena.entities.Policy;
import pl.edu.atena.entities.PolicyState;

public class PolicySetStatusMethodTest {

private static String POLICY_NUMBER = "EWA123";
	
	private static BigDecimal PREMIUM = BigDecimal.valueOf(100);
	
	private static Date START_DATE = Date.from(Instant.now());
	private static Date END_DATE = Date.from(Instant.now().plus(8, ChronoUnit.DAYS));

	private PolicyValidateMethod policyValidateMethod  = new PolicyValidateMethod();
	
	private PolicySetStatusMethod policySetStatusMethod  = new PolicySetStatusMethod();
	
	@Test
	public void shouldChangeStatus() {
		Policy policy = new Policy();
		policy.setPolicyNumber(POLICY_NUMBER);
		policy.setPremium(PREMIUM);
		policy.setInsuranceEndDate(START_DATE);
		policy.setInsuranceStartDate(END_DATE);
		policy.setStatus(PolicyState.ZATWIERDZONA);
		policyValidateMethod.validatePolicy(policy);
		policySetStatusMethod.setStatus(policy);
		Assert.assertFalse(policy.getPolicyMessages().isEmpty());
		Assert.assertEquals(policy.getPolicyMessages().size(), 1);
		Assert.assertEquals(policy.getStatus(), PolicyState.ZAWIESZONA);
		Assert.assertTrue(policy.getPolicyMessages()
				.stream().noneMatch(mess->mess.getCode().equals(Message.VALID_POLICY_DATA.getCode())));
		Assert.assertTrue(policy.getPolicyMessages()
				.stream().noneMatch(mess->mess.getCode().equals(Message.POLICY_NUMBER_NO_DATA.getCode())));
		Assert.assertTrue(policy.getPolicyMessages()
				.stream().anyMatch(mess->mess.getCode().equals(Message.INCORECT_PERIOD.getCode())));
		Assert.assertTrue(policy.getPolicyMessages()
				.stream().noneMatch(mess->mess.getCode().equals(Message.PERIOD_DATE_NO_DATA.getCode())));
		Assert.assertTrue(policy.getPolicyMessages()
				.stream().noneMatch(mess->mess.getCode().equals(Message.NEGATIVE_PREMIUM.getCode())));
	
	}

}
