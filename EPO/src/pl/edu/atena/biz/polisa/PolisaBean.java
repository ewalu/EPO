package pl.edu.atena.biz.polisa;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.jboss.logging.Logger;

@Stateless (name = "PolisaDobra")
@LocalBean
public class PolisaBean implements PolisaLocal, PolisaRemote{
	
	private Logger log = Logger.getLogger(PolisaBean.class);
	
	public int dodaj(int param1, int param2) {
		return param1+param2;
	}
	
	@Asynchronous
	public void dzialaj() {
		try {
			log.info("Dzia�am...");
			Thread.sleep(9000);
			log.info("Ju� koniec!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@PostConstruct
	private void init() {
		log.info("Powsta�em");
	}
	
	@PreDestroy
	private void destroy() {
		log.info("�egnam");
	}

}
