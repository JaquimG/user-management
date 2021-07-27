package usersmanagement.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import usersmanagement.dto.UserDTO;
import usersmanagement.dto.UserOutputDTO;
import usersmanagement.entity.User;
import usersmanagement.repository.UserRepository;
import usersmanagement.service.CRUDService;

@Service
public class UserServiceImpl implements CRUDService<UserDTO, User, UserOutputDTO>{
	
	@Autowired
	ModelMapper modelMapper;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public List<UserOutputDTO> listAll() {
		return userRepository.findAll()
				.stream()
				.map(this::toUserOutputDTO)
				.collect(Collectors.toList());
	}

	@Override
	public UserOutputDTO getById(Long id) {
		User user = userRepository.getById(id);
		UserOutputDTO userDTO = this.toUserOutputDTO(user);
		return userDTO;
	}

	@Override
	@Transactional
	public UserOutputDTO saveOrUpdate(UserDTO userDTO) {
		User savedUser = this.toUser(userDTO);
		savedUser.setPassword(passwordEncoder.encode(savedUser.getPassword()));
		savedUser = userRepository.save(savedUser);
		UserOutputDTO userOutput = toUserOutputDTO(savedUser);
		return userOutput;
	}

	@Override
	public void delete(Long id) {
		User deletedUser = userRepository.getById(id);
		userRepository.delete(deletedUser);
	}
		
	private UserOutputDTO toUserOutputDTO(User user) {
		return modelMapper.map(user, UserOutputDTO.class);
	}
	
	private User toUser(UserDTO userDTO) {
		return modelMapper.map(userDTO, User.class);
	}
}
