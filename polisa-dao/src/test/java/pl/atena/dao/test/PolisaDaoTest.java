package pl.atena.dao.test;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Random;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.OrderingComparison.greaterThan;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pl.atena.core.connectors.DB;
import pl.atena.dao.polisa.PolisaDao;
import pl.atena.domain.polisa.Polisa;
import pl.atena.domain.polisa.PolisaFiltr;

public class PolisaDaoTest {

	private PolisaDao dao;

	@BeforeClass
	public static void runOnceBeforeClass() throws SQLException {
		DB.get();
	}

	@AfterClass
	public static void runOnceAfterClass() throws SQLException {
		DB.close();
	}

	@Before
	public void runOnceBeforeTestMethod() {
		dao = new PolisaDao();
	}

	@Test
	public void testCreate() throws SQLException {
		Random r = new Random();
		Polisa polisa = new Polisa();
		polisa.setNrPolisy("EWA"+LocalDate.now()+-+r.nextInt(1000));
		polisa.setdPodpisania(LocalDate.now());
		polisa.setdRozpoczecia(LocalDateTime.now());
		polisa.setdKonca(LocalDateTime.now().plusYears(1));
		polisa.setSkladka(BigDecimal.valueOf(r.nextInt(1000)));
		dao.create(polisa);
		assertTrue(polisa.getId() != null);
		assertThat(polisa.getId().intValue(), greaterThan(0));
	}

	@Test(expected = SQLException.class)
	public void testCreateException() throws SQLException {
		Polisa polisa = new Polisa();
		polisa.setdPodpisania(LocalDate.now());
		polisa.setdRozpoczecia(LocalDateTime.now());
		polisa.setdKonca(LocalDateTime.now().plusYears(1));
		dao.create(polisa);
	}
	
	@Test
	public void testDelete() throws SQLException {
		Polisa polisa = new Polisa();
		polisa.setNrPolisy("EWA2017-12-17-612344151");
		dao.delete(polisa);
		//assertTrue(polisa.getId() != null);
		//assertThat(polisa.getId().intValue(), greaterThan(0));
	}
	
	@Test
	public void testUpdate() throws SQLException {
		Polisa polisa = new Polisa();
		polisa.setNrPolisy("EWA2018-01-13-500");
		polisa.setdPodpisania(LocalDate.now().plusDays(1));
		polisa.setdRozpoczecia(LocalDateTime.now());
		polisa.setdKonca(LocalDateTime.now().plusYears(1).plusDays(1));
		polisa.setSkladka(BigDecimal.valueOf(666.69));
		dao.update(polisa);
		assertTrue(polisa.getId() != null);
		assertThat(polisa.getId().intValue(), greaterThan(0));
	}

	@Test (expected = SQLException.class)
	public void testUpdateException() throws SQLException {
		Polisa polisa = new Polisa();
		polisa.setNrPolisy("10534535435");
		polisa.setdPodpisania(LocalDate.now());
		polisa.setdRozpoczecia(LocalDateTime.now());
		polisa.setdKonca(LocalDateTime.now().plusYears(1));
		polisa.setSkladka(null);
		dao.update(polisa);
	}
	
	@Test
	public void testRetrieve() throws SQLException {
		Polisa polisa = new Polisa();
		polisa.setNrPolisy("10534535435");
		dao.retrieve(polisa);
	}
	
	@Test (expected = SQLException.class)
	public void testRetrieveException() throws SQLException {
		Polisa polisa = new Polisa();
		dao.retrieve(polisa);
	}
	
	@Test
	public void testSelect() throws SQLException {
		PolisaFiltr filtr = new PolisaFiltr();
		filtr.setSkladka(BigDecimal.valueOf(500.06));
		dao.select(filtr);
	}
	@Test (expected = SQLException.class)
	public void testSelectException() throws SQLException {
			PolisaFiltr filtr = new PolisaFiltr();
			filtr.setSkladka(BigDecimal.valueOf(1500.06));
			dao.select(filtr);
	}
}
