package pl.edu.atena.biz.polisa;

import javax.ejb.Local;

@Local
public interface PolisaLocal {
	
	int dodaj(int param1, int param2);

}
