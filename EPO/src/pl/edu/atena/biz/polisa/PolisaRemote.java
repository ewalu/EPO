package pl.edu.atena.biz.polisa;

import javax.ejb.Remote;

@Remote
public interface PolisaRemote {
	
	int dodaj(int param1, int param2);

}
