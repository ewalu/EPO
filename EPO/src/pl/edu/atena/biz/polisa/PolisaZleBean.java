package pl.edu.atena.biz.polisa;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import org.jboss.logging.Logger;

@Stateless (name = "PolisaZla")
@LocalBean
public class PolisaZleBean implements PolisaLocal, PolisaRemote {
	
private Logger log = Logger.getLogger(PolisaBean.class);

@Resource
private SessionContext context;


	
	public int dodaj(int param1, int param2) {
		
		//wstrzykiwanie polisy dobrej do z³ej
		//PolisaLocal polisac = (PolisaLocal) context.lookup("java:global/EJBSzkol/PolisaDobra!pl.edu.atena.biz.polisa.PolisaLocal");
		
		//return polisac.dodaj(param1, param2);
		return param1-param2;
	}
	
	@PostConstruct
	private void init() {
		log.info("Powsta³em");
	}
	
	@PreDestroy
	private void destroy() {
		log.info("¯egnam");
	}
}
