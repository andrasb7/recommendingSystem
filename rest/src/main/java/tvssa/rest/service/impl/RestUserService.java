package tvssa.rest.service.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;

import tvssa.common.dao.UserDAO;
import tvssa.common.entities.UserE;
import tvssa.rest.dto.UserDTO;

import tvssa.rest.service.IRestUserService;

@Stateless
public class RestUserService implements IRestUserService{

	
	@Inject
	UserDAO userDAO;


	@Override
	public UserDTO findById(Long id) {
		UserE userE = userDAO.findById(id);
		return createDTOFromEntity(userE);
	}

	@Override
	public UserDTO findByUserNameAndPassword(String name, String password) {
		UserE userE = userDAO.findByUserNameAndPassword(name, password);
		return createDTOFromEntity(userE);
	}

	@Override
	public boolean register(UserDTO userDTO) {
		UserE userE = createEntityFromDTO(userDTO);
		if (userE != null) {
			userDAO.create(userE);
			return true;
		}
		return false;
	}
	
	private UserDTO createDTOFromEntity(UserE userE) {
		
		if (userE != null) {
			
			UserDTO userDTO = new UserDTO();
			userDTO.setId(userE.getId());
			userDTO.setName(userE.getName());
			userDTO.setSurName(userE.getSurName());
			userDTO.setUserName(userE.getUserName());
			userDTO.setBirthYear(userE.getBirtYear());
			userDTO.setGender(userE.getGender());
			userDTO.setNation(userE.getNation());
			userDTO.setPassword(userE.getPassword());
			
			return userDTO;
		}
		return null;
	}
	private UserE createEntityFromDTO(UserDTO userDTO) {
		
		if (userDTO != null && validUserName(userDTO.getUserName())) {
			UserE userE = new UserE();
			userE.setName(userDTO.getName());
			userE.setSurName(userDTO.getSurName());
			userE.setUserName(userDTO.getUserName());
			userE.setBirtYear(userDTO.getBirthYear());
			userE.setGender(userDTO.getGender());
			userE.setNation(userDTO.getNation());
			userE.setPassword(userDTO.getPassword());
			
			return userE;
		}
		return null;
	}
	
	private boolean validUserName(String name) {
		return (userDAO.findByUserName(name) == null);
	}
	
	private UserE updateEntityFromDTO(UserDTO userDTO, UserE userE) {
		
		if (userDTO != null && userE != null) {
			userE.setName(userDTO.getName());
			userE.setSurName(userDTO.getSurName());
			userE.setUserName(userDTO.getUserName());
			userE.setBirtYear(userDTO.getBirthYear());
			userE.setGender(userDTO.getGender());
			userE.setNation(userDTO.getNation());
			userE.setPassword(userDTO.getPassword());
			
			return userE;
		}
		return null;
	}

	@Override
	public boolean updateUser(UserDTO userDTO) {
		UserE userE= userDAO.findById(userDTO.getId());
		if (updateEntityFromDTO(userDTO, userE) != null) {
			userDAO.update(userE);
			return true;
		}
		return false;
	}

}
