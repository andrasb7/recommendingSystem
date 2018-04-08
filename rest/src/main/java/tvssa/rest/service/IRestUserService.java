package tvssa.rest.service;

import tvssa.rest.dto.UserDTO;

public interface IRestUserService {
	
	UserDTO findByUserNameAndPassword(String name, String password);
	UserDTO findById(Long id);
	boolean register(UserDTO userDTO);
	boolean updateUser(UserDTO userDTO);
}
