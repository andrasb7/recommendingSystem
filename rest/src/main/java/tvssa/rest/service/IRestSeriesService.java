package tvssa.rest.service;


import java.util.List;

import tvssa.rest.dto.SeriesDTO;
import tvssa.rest.dto.UserSeriesDTO;

public interface IRestSeriesService {

	SeriesDTO findByName(String name);
	
	SeriesDTO findById(Long id);

	List<SeriesDTO> findAllByName(String name);
	
	List<SeriesDTO> findAllByUserId(Long id);
	
	List<SeriesDTO> findAllTest();
	
	boolean addSeriesToUser(UserSeriesDTO userSeriesDTO);
	
	boolean removeSeriesFromUser(UserSeriesDTO userSeriesDTO);
}
