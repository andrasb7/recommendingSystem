package tvssa.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import tvssa.common.dao.SeriesDAO;
import tvssa.common.dao.UserDAO;
import tvssa.common.entities.SeriesE;
import tvssa.common.entities.UserE;
import tvssa.rest.dto.SeriesDTO;
import tvssa.rest.dto.UserSeriesDTO;
import tvssa.rest.service.IRestSeriesService;

@Stateless
public class RestSeriesService implements IRestSeriesService {

	@Inject
	SeriesDAO seriesDAO;
	
	@Inject
	UserDAO userDAO;

	@Override
	public SeriesDTO findByName(String name) {
		SeriesE seriesE = seriesDAO.findByName(name);
		return createDTOFromEntity(seriesE);
	}
	
	@Override
	public SeriesDTO findById(Long id) {
		SeriesE seriesE = seriesDAO.findById(id);
		return createDTOFromEntity(seriesE);
	}

	@Override
	public List<SeriesDTO> findAllByName(String name) {
		List<SeriesE> seriesList = seriesDAO.findAllByName(name);
		if (seriesList != null && !seriesList.isEmpty()) {
			List<SeriesDTO> seriesDTOList = new ArrayList<SeriesDTO>();
			seriesList.forEach(seriesE -> {
				SeriesDTO seriesDTO = createDTOFromEntity(seriesE);
				seriesDTOList.add(seriesDTO);
			});
			return seriesDTOList;
		}
		return null;
	}

	@Override
	public List<SeriesDTO> findAllByUserId(Long id) {
		List<SeriesE> seriesList = seriesDAO.findAllByUserId(id);
		if (seriesList != null && !seriesList.isEmpty()) {
			List<SeriesDTO> seriesDTOList = new ArrayList<SeriesDTO>();
			seriesList.forEach(seriesE -> {
				SeriesDTO seriesDTO = createDTOFromEntity(seriesE);
				seriesDTOList.add(seriesDTO);
			});
			return seriesDTOList;
		}
		return null;
	}
	
	private SeriesDTO createDTOFromEntity(SeriesE seriesE) {

		if (seriesE != null) {
			SeriesDTO seriesDTO = new SeriesDTO();
			seriesDTO.setId(seriesE.getId());
			seriesDTO.setName(seriesE.getName());
			if (seriesE.getPremiere() != null) {
				seriesDTO.setPremiere(seriesE.getPremiere().toString());
			}
			seriesDTO.setRuntime(seriesE.getRuntime());
			seriesDTO.setPictureUrl(seriesE.getPictureUrl());
			seriesDTO.setTvMazeUrl(seriesE.getTvmazeURL());
			seriesDTO.setAvarageRating(seriesE.getAvarageRating());

			return seriesDTO;
		}
		return null;
	}

	@Override
	public List<SeriesDTO> findAllTest() {
		List<SeriesE> seriesList = seriesDAO.findAllByName("girls");
		if (seriesList != null && !seriesList.isEmpty()) {
			List<SeriesDTO> seriesDTOList = new ArrayList<SeriesDTO>();
			seriesList.forEach(seriesE -> {
				SeriesDTO seriesDTO = createDTOFromEntity(seriesE);
				seriesDTOList.add(seriesDTO);
			});
			return seriesDTOList;
		}
		return null;
	}

	@Override
	public boolean addSeriesToUser(UserSeriesDTO userSeriesDTO) {
		UserE userE = userDAO.findById(userSeriesDTO.getUserId());
		SeriesE seriesE = seriesDAO.findById(userSeriesDTO.getSeriesId());
		if (userE != null && seriesE != null) {
			if (userE.getUserSeries() != null) {
				if(!userE.getUserSeries().stream().anyMatch(s -> s.equals(seriesE))) {
					userE.addSeries(seriesE);
					System.out.println("Series added to User: " + seriesE.getName());
				}
			} else {
				userE.setUserSeries(new ArrayList<>());
				userE.addSeries(seriesE);
			}
			userDAO.update(userE);
			return true;
		}
		return false;
	}

	@Override
	public boolean removeSeriesFromUser(UserSeriesDTO userSeriesDTO) {
		UserE userE = userDAO.findById(userSeriesDTO.getUserId());
		SeriesE seriesE = seriesDAO.findById(userSeriesDTO.getSeriesId());
		if (userE != null && seriesE != null) {
			if (userE.getUserSeries() != null && !userE.getUserSeries().isEmpty()) {
				if (userE.getUserSeries().stream().anyMatch(s -> s.equals(seriesE))) {
					userE.removeSeries(seriesE);
					System.out.println("Series removed from User: " + seriesE.getName());
					userDAO.update(userE);
					return true;
				}
			}
		}
		return false;
	}

}
