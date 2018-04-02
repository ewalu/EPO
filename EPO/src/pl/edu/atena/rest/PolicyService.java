package pl.edu.atena.rest;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import pl.edu.atena.dao.PolisyDao;
import pl.edu.atena.entities.Policy;
import pl.edu.atena.entities.PolicyState;

@Path("/polisa")
public class PolicyService {
	
	//@Resource
	//private SessionContext context;
	
	@EJB PolisyDao polisaDao;
	
	//http://localhost:8080/EPO-0.0.1-SNAPSHOT/api/polisa/create/ewa001/ewa/1/ZAWIESZONA
	@GET
	@Path("/create/{numerPolisy}/{ubezpieczajacy}/{skladka}/{status}")
	@Produces(MediaType.APPLICATION_JSON)
	public Policy create2(@PathParam("numerPolisy") String nrPolisy, 
			@PathParam("ubezpieczajacy") String ubezpieczajacy, 
			@PathParam("skladka") BigDecimal skladka,
			@PathParam("status") PolicyState status) {
				Policy polisa = new Policy();
				polisa.setPolicyNumber(nrPolisy);
				//polisa.setInsured(ubezpieczajacy);
				polisa.setPremium(skladka);
				polisa.setStatus(status);
				polisaDao.create(polisa);
				return polisa;
	}
	//http://localhost:8080/EJBSzkol/api/polisa/update
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/update")
	public Response update(Policy polisa) {
		Policy pol = polisaDao.update(polisa.getId(), polisa.getInsured());
		return Response.status(200).entity(pol).build();
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/delete/{id}")
	public Response delete(@PathParam("id") Long id) {
		polisaDao.delete(id);
		return Response.status(200).build();
	}

	
	
	

}
