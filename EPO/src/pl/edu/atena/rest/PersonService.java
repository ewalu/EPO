package pl.edu.atena.rest;

import java.math.BigDecimal;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import pl.edu.atena.dao.PolisyDao;
import pl.edu.atena.dao.PersonDao;
import pl.edu.atena.entities.Policy;
import pl.edu.atena.entities.Person;

@Path("/ubezpieczony")
public class PersonService {
	
	//@Resource
	//private SessionContext context;
	
	@EJB PersonDao ubezpDao;
	@EJB PolisyDao polisaDao;
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(Person ubezp) {
		ubezpDao.create(ubezp);
		return Response.status(200).entity(ubezp).build();
	}
	//http://localhost:8080/EJBSzkol/api/polisa/create
	@GET
	@Path("/create/{nazwa}")
	@Produces(MediaType.APPLICATION_JSON)
	public Person create2(@PathParam("nazwa") String nazwa) {
				Person ubezp = new Person();
				ubezp.setNazwa(nazwa);
				return ubezp;
	}
	
	/*@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/update/{id_pol}/{id_ubezp}")
	public Response update(@PathParam("id_pol") Long id_pol, @PathParam("id_ubezp") Long id_ub) {
		Policy polisa = polisaDao.find(id_pol);
		Person ubezp = ubezpDao.dodajPolise(id_ub, polisa);
		return Response.status(200).entity(ubezp).build();
	}*/
}