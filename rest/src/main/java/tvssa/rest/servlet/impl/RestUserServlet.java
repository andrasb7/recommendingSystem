package tvssa.rest.servlet.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import tvssa.rest.dto.UserDTO;
import tvssa.rest.service.IRestUserService;
import tvssa.rest.servlet.IRestUserServlet;

@Stateless
public class RestUserServlet implements IRestUserServlet {
	
	@Inject
	IRestUserService service;

	@Override
	public Response getUserByUserNameAndPassword(String name, String password) {
		UserDTO userDTO = service.findByUserNameAndPassword(name, password);
		if (userDTO != null) {
			return Response.ok()
					.entity(userDTO).build();
		}
		return Response.serverError().build();
	}

	@Override
	public Response getUserById(Long id) {
		UserDTO userDTO = service.findById(id);
		if (userDTO != null) {
			return Response.ok()
					.entity(userDTO).build();
		}
		return Response.noContent().build();
	}

	@Override
	public Response register(UserDTO userDTO) {
		if (service.register(userDTO)) {
			return Response.ok().entity(userDTO).build();
		}
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
	}

	@Override
	public Response update(UserDTO userDTO) {
		if (service.updateUser(userDTO)) {
			return Response.ok().entity(userDTO).build();
		}
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
	}

}
