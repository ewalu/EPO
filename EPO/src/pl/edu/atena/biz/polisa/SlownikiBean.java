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
	
	private List<String> studenci = new ArrayList<>();
	
	@PostConstruct
	private void init() {
		studenci.add("Aleks");
		studenci.add("Ewa");
		studenci.add("Robert");
		studenci.add("Wiesia");
		studenci.add("Krystian B");
		studenci.add("Krystian D");
		studenci.add("Arek");
		studenci.add("Marian");
		
		log.info(studenci);
		
	}
	
	@Lock(LockType.READ)
	public List<String> studenci(){
		return studenci;
	}

}
 