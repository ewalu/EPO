package pl.edu.atena.biz.polisa;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.jboss.logging.Logger;

@Startup
@Singleton
public class SlownikiBean {
	
	private Logger log = Logger.getLogger(SlownikiBean.class);
	
	private List<String> miasta = new ArrayList<>();
	
	@PostConstruct
	private void init() {
		miasta.add("Gdynia");
		miasta.add("Sopot");
		
		log.info(miasta);
		
	}
	
	@Lock(LockType.READ)
	public List<String> miasta(){
		return miasta;
	}

}
 