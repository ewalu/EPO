package pl.edu.atena.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Mockito.*;

import junit.framework.Assert;
import pl.edu.atena.biz.polisa.PolicyTarifficationMethod;
import pl.edu.atena.biz.polisa.PolicyValidateDataMethod;
import pl.edu.atena.biz.polisa.PolicyValidateStatusMethod;
import pl.edu.atena.entities.Person;
import pl.edu.atena.entities.Policy;

public class PolicyTarifficationMethodTest {
	
	private PolicyValidateDataMethod policyValidateDataMethod = new PolicyValidateDataMethod();
	
	private PolicyValidateStatusMethod policyValidateStatusMethod = new PolicyValidateStatusMethod();
	
	private PolicyTarifficationMethod policyTarifficationMethod = new PolicyTarifficationMethod();
	
	private static String POLICY_NUMBER = "EWA123";
	
	private static String NAME = "EWA";
	
	private static BigDecimal PREMIUM = BigDecimal.valueOf(100);
	
	private static Date START_DATE = Date.from(Instant.now());
	private static Date END_DATE = Date.from(Instant.now().plus(8, ChronoUnit.DAYS));

	@Test
	public void shouldNotTarrificate() {
		Policy policy = new Policy();
		policy.setPolicyNumber(POLICY_NUMBER);
		policy.setPremium(PREMIUM.multiply(BigDecimal.valueOf(-1)));
		policy.setInsuranceEndDate(END_DATE);
		policy.setInsuranceStartDate(START_DATE);
		
		policyValidateDataMethod.validate(policy);
		policyValidateStatusMethod.validate(policy);
		policyTarifficationMethod.tarifficate(policy);
		
		Assert.assertEquals(policy.getPremium(), PREMIUM.multiply(BigDecimal.valueOf(-1)));
	}
	
	@Test
	public void shouldNoTarrificateNoBirthdayDate() {
		Policy policy = new Policy();
		Person person = new Person();
		person.setFirstName(NAME);
		policy.setPolicyNumber(POLICY_NUMBER);
		policy.setPremium(PREMIUM);
		policy.setInsuranceEndDate(END_DATE);
		policy.setInsuranceStartDate(START_DATE);
		policy.setInsured(person);
		
		policyValidateDataMethod.validate(policy);
		policyValidateStatusMethod.validate(policy);
		policyTarifficationMethod.tarifficate(policy);
		
		Assert.assertEquals(policy.getPremium(), PREMIUM);
	}
	
	@Test
	public void shouldTarrificate() {
		Policy policy = new Policy();
		Person person = new Person();
		person.setFirstName(NAME);
		person.setBirthDate(Date.from(Instant.now()));
		policy.setPolicyNumber(POLICY_NUMBER);
		policy.setPremium(PREMIUM);
		policy.setInsuranceEndDate(END_DATE);
		policy.setInsuranceStartDate(START_DATE);
		policy.setInsured(person);
		
		policyValidateDataMethod.validate(policy);
		policyValidateStatusMethod.validate(policy);
		policyTarifficationMethod.tarifficate(policy);
		
		Assert.assertEquals(policy.getPremium(), PREMIUM.multiply(BigDecimal.valueOf(1.9)));
		
		person.setBirthDate(Date.from(Instant.now().minus(60*365, ChronoUnit.DAYS)));
		policy.setPremium(PREMIUM);
		
		policyValidateDataMethod.validate(policy);
		policyValidateStatusMethod.validate(policy);
		policyTarifficationMethod.tarifficate(policy);
		
		Assert.assertEquals(policy.getPremium(), PREMIUM.multiply(BigDecimal.valueOf(1.1)));
	}

}
