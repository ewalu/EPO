package pl.edu.atena.biz.polisa;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;

//import org.jboss.resteasy.logging.Logger;

@Stateful
@StatefulTimeout(unit = TimeUnit.SECONDS, value =5)
@LocalBean
public class RyzykoBean {
	
	//private Logger log = Logger.getLogger(RyzykoBean.class);
	
	@Resource (mappedName = "java:comp/env/startRiskSymbol")
	private String symbol;
	
	public int dodajRyzyko(int param1, int param2) {
		return param1*param2;
	}
	
	@Asynchronous
	public void dzialaj() {
		try {
			//log.info("Dzia�am...");
			Thread.sleep(10000);
			//log.info("Ju� koniec!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@PostActivate
	private void activate() {
		//log.info("Aktywowa�em si�");
	}
	
	@PrePassivate
	private void pass() {
		//log.info("Pasywowa�em si�");
	}
	
	@PostConstruct
	private void init() {
		//log.info("Powsta�em jako: "+symbol);
	}
	
	@PreDestroy
	private void destroy() {
		//log.info("�egnam ozi�ble");
	}

}
