package usersmanagement.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import usersmanagement.dto.UserDTO;
import usersmanagement.entity.User;
import usersmanagement.repository.UserRepository;
import usersmanagement.service.CRUDService;

@Service
public class UserServiceImpl implements CRUDService<UserDTO, User>{
	
	@Autowired
	ModelMapper modelMapper;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public List<UserDTO> listAll() {
		return userRepository.findAll()
				.stream()
				.map(this::toUserDTO)
				.collect(Collectors.toList());
	}

	@Override
	public UserDTO getById(Long id) {
		User user = userRepository.getById(id);
		UserDTO userDTO = this.toUserDTO(user);
		return userDTO;
	}

	@Override
	@Transactional
	public User saveOrUpdate(UserDTO userDTO) {
		User savedUser = this.toUser(userDTO);
		savedUser.setPassword(passwordEncoder.encode(savedUser.getPassword()));
		savedUser = userRepository.save(savedUser);
		return savedUser;
	}

	@Override
	public void delete(Long id) {
		User deletedUser = userRepository.getById(id);
		userRepository.delete(deletedUser);
	}
	

	private UserDTO toUserDTO(User user) {
		return modelMapper.map(user, UserDTO.class);
	}
	
	private User toUser(UserDTO userDTO) {
		return modelMapper.map(userDTO, User.class);
	}
}
