package pl.edu.atena.rest;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
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
	
	//http://localhost:8080/EPO-0.0.1-SNAPSHOT/api/polisa/policy
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(Policy policy) {
		Objects.nonNull(policy);
		polisaDao.create(policy);
		return Response.status(200).entity(policy).build();
}
	
	//http://localhost:8080/EPO-0.0.1-SNAPSHOT/api/polisa/create/ewa001/ewa/1/ZAWIESZONA
	@GET
	@Path("/create/{policyNumber}/{signDate}/{premium}/{status}")
	@Produces(MediaType.APPLICATION_JSON)
	public Policy create2(@PathParam("policyNumber") String policyNumber, 
			@PathParam("signDate") Date signDate, 
			@PathParam("premium") BigDecimal premium,
			@PathParam("status") PolicyState status) {
				Policy polisa = new Policy();
				polisa.setPolicyNumber(policyNumber);
				polisa.setPremium(premium);
				polisa.setStatus(status);
				polisa.setSignDate(signDate);
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
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/find/getpolicies")
	public List<Policy> select() {
				List<Policy> polisy = polisaDao.select();
				Response.status(200).entity(polisy).build();
				return polisy;
	}


	
	
	

}
