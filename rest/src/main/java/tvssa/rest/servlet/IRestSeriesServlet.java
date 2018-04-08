package tvssa.rest.servlet;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tvssa.rest.dto.UserSeriesDTO;

@Path("/series")
public interface IRestSeriesServlet {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/findById/{id}")
	Response getSeriesById(@PathParam("id") Long id);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/findByName/{name}")
	Response getSeriesByName(@PathParam("name") String name);
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/findAllByName/{name}")
	Response getAllSeriesByName(@PathParam("name") String name);
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/findAllByUserId/{id}")
	Response getAllSeriesByUserId(@PathParam("id") Long id);
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/findAllTest")
	Response getAllTest();
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/addSeriesToUser")
	Response addSeriesToUser(UserSeriesDTO userSeriesDTO);
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/removeSeriesFromUser")
	Response removeSeriesFromUser(UserSeriesDTO userSeriesDTO);
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/getobj")
	Response testGet();
}
