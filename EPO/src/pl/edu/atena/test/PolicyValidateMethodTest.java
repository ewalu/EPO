package pl.edu.atena.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.junit.Test;
import org.mockito.*;

import junit.framework.Assert;
import pl.edu.atena.biz.polisa.PolicyValidateMethod;
import pl.edu.atena.entities.Message;
import pl.edu.atena.entities.Policy;

public class PolicyValidateMethodTest {
	
	private static String POLICY_NUMBER = "EWA123";
	
	private static BigDecimal PREMIUM = BigDecimal.valueOf(100);
	
	private static Date START_DATE = Date.from(Instant.now());
	private static Date END_DATE = Date.from(Instant.now().plus(8, ChronoUnit.DAYS));
	
	private PolicyValidateMethod policyValidateMethod = new PolicyValidateMethod();

	@Test
	public void shouldValidateNoMessages() {
		Policy policy = new Policy();
		policy.setPolicyNumber(POLICY_NUMBER);
		policy.setPremium(PREMIUM);
		policy.setInsuranceEndDate(END_DATE);
		policy.setInsuranceStartDate(START_DATE);
		policyValidateMethod.validatePolicy(policy);
		Assert.assertEquals(policy.getPolicyMessages().size(), 1);
		Assert.assertTrue(policy.getPolicyMessages()
				.stream().anyMatch(mess->mess.getMessage().equals(Message.VALID_POLICY_DATA)));
	}
	
	@Test
	public void shouldNotValidateNull() {
		Policy policy = null;
		policyValidateMethod.validatePolicy(policy);
	}
	
	@Test
	public void shouldValidate() {
		Policy policy = new Policy();
		policyValidateMethod.validatePolicy(policy);
		Assert.assertFalse(policy.getPolicyMessages().isEmpty());
		Assert.assertEquals(policy.getPolicyMessages().size(), 3);
		Assert.assertTrue(policy.getPolicyMessages()
				.stream().noneMatch(mess->mess.getMessage().equals(Message.VALID_POLICY_DATA)));
		Assert.assertTrue(policy.getPolicyMessages()
				.stream().anyMatch(mess->mess.getMessage().equals(Message.POLICY_NUMBER_NO_DATA)));
		Assert.assertTrue(policy.getPolicyMessages()
				.stream().noneMatch(mess->mess.getMessage().equals(Message.INCORECT_PERIOD)));
		Assert.assertTrue(policy.getPolicyMessages()
				.stream().anyMatch(mess->mess.getMessage().equals(Message.PERIOD_DATE_NO_DATA)));
		Assert.assertTrue(policy.getPolicyMessages()
				.stream().anyMatch(mess->mess.getMessage().equals(Message.NEGATIVE_PREMIUM)));
	}
	
	@Test
	public void shouldPeriod() {
		Policy policy = new Policy();
		policy.setPolicyNumber(POLICY_NUMBER);
		policy.setPremium(PREMIUM);
		policy.setInsuranceEndDate(START_DATE);
		policy.setInsuranceStartDate(END_DATE);
		policyValidateMethod.validatePolicy(policy);
		Assert.assertFalse(policy.getPolicyMessages().isEmpty());
		Assert.assertEquals(policy.getPolicyMessages().size(), 1);
		Assert.assertTrue(policy.getPolicyMessages()
				.stream().noneMatch(mess->mess.getMessage().equals(Message.VALID_POLICY_DATA)));
		Assert.assertTrue(policy.getPolicyMessages()
				.stream().noneMatch(mess->mess.getMessage().equals(Message.POLICY_NUMBER_NO_DATA)));
		Assert.assertTrue(policy.getPolicyMessages()
				.stream().anyMatch(mess->mess.getMessage().equals(Message.INCORECT_PERIOD)));
		Assert.assertTrue(policy.getPolicyMessages()
				.stream().noneMatch(mess->mess.getMessage().equals(Message.PERIOD_DATE_NO_DATA)));
		Assert.assertTrue(policy.getPolicyMessages()
				.stream().noneMatch(mess->mess.getMessage().equals(Message.NEGATIVE_PREMIUM)));
	}


}
