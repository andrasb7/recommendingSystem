package tvssa.rest.servlet.impl;



import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import tvssa.rest.dto.SeriesDTO;
import tvssa.rest.dto.UserSeriesDTO;
import tvssa.rest.service.IRestSeriesService;
import tvssa.rest.servlet.IRestSeriesServlet;

@Stateless
public class RestSeriesServlet implements IRestSeriesServlet {
	
	@Inject
	IRestSeriesService service;

	@Override
	public Response testGet() {
		System.out.println("CALLED GET");
		
		return Response.ok().entity("TESZT OK").build();
	}
	
	@Override
	public Response getSeriesByName(String name) {
		SeriesDTO seriesDTO = service.findByName(name);
		if (seriesDTO != null) {
			return Response.ok()
					.entity(seriesDTO).build();
		}
		return Response.noContent().build();

	}
	@Override
	public Response getAllSeriesByName(String name) {
		List<SeriesDTO> listOfSeries = service.findAllByName(name);
		if (listOfSeries != null) {
		GenericEntity<List<SeriesDTO>> list = new GenericEntity<List<SeriesDTO>>(listOfSeries) {};
			return Response.ok()
					.entity(list).build();
		}
		return Response.noContent().build();

	}

	@Override
	public Response getAllSeriesByUserId(Long id) {
		List<SeriesDTO> listOfSeries = service.findAllByUserId(id);
		if (listOfSeries != null && !listOfSeries.isEmpty()) {
		GenericEntity<List<SeriesDTO>> list = new GenericEntity<List<SeriesDTO>>(listOfSeries) {};
			return Response.ok()
					.entity(list).build();
		}
		return Response.noContent().build();
	}

	@Override
	public Response getSeriesById(Long id) {
		SeriesDTO seriesDTO = service.findById(id);
		if (seriesDTO != null) {
			return Response.ok()
					.entity(seriesDTO).build();
		}
		return Response.noContent().build();
	}

	@Override
	public Response getAllTest() {
		List<SeriesDTO> listOfSeries = service.findAllTest();
		GenericEntity<List<SeriesDTO>> list = new GenericEntity<List<SeriesDTO>>(listOfSeries) {};
		if (listOfSeries != null) {
			return Response.ok()
					.entity(list).build();
		}
		return Response.noContent().build();
	}

	@Override
	public Response addSeriesToUser(UserSeriesDTO userSeriesDTO) {
		if(service.addSeriesToUser(userSeriesDTO)) {
			return Response.ok().entity(userSeriesDTO).build();
		}
		return Response.noContent().build();
	}

	@Override
	public Response removeSeriesFromUser(UserSeriesDTO userSeriesDTO) {
		if(service.removeSeriesFromUser(userSeriesDTO)) {
			return Response.ok().entity(userSeriesDTO).build();
		}
		return Response.noContent().build();
	}


}
