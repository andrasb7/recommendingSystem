package tvssa.rest.servlet;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tvssa.rest.dto.UserDTO;

@Path("/user")
public interface IRestUserServlet {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/findByUserName/{name}/{password}")
	Response getUserByUserNameAndPassword(@PathParam("name") String name, @PathParam("password") String password);
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/findById/{id}")
	Response getUserById(@PathParam("id") Long id);

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/register")
	Response register(UserDTO userDTO);
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/update")
	Response update(UserDTO userDTO);
	

}
