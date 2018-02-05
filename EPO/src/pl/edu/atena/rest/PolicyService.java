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

@Path("/polisa")
public class PolicyService {
	
	//@Resource
	//private SessionContext context;
	
	@EJB PolisyDao polisaDao;
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/create")
	public Response create(Policy polisa) {
		polisaDao.create(polisa);
		return Response.status(200).entity(polisa).build();
	}
	//http://localhost:8080/EJBSzkol/api/polisa/create
	@GET
	@Path("/create/{numerPolisy}/{ubezpieczajacy}/{skladka}")
	@Produces(MediaType.APPLICATION_JSON)
	public Policy create2(@PathParam("numerPolisy") String nrPolisy, 
			@PathParam("ubezpieczajacy") String ubezpieczajacy, 
			@PathParam("skladka") BigDecimal skladka) {
				Policy polisa = new Policy();
				polisa.setPolicyNumber(nrPolisy);
				polisa.setInsurer(ubezpieczajacy);
				polisa.setPremium(skladka);
				polisaDao.create(polisa);
				return polisa;
	}
	//http://localhost:8080/EJBSzkol/api/polisa/update
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/update")
	public Response update(Policy polisa) {
		Policy pol = polisaDao.update(polisa.getId(), polisa.getInsurer());
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
