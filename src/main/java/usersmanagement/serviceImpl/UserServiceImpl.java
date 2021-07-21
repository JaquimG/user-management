package usersmanagement.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import usersmanagement.entity.User;
import usersmanagement.repository.UserRepository;
import usersmanagement.service.CRUDService;

@Service
public class UserServiceImpl implements CRUDService<User>{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<User> listAll() {
		List<User> users = userRepository.findAll();
		return users;
	}

	@Override
	public User getById(Long id) {
		User user = userRepository.getById(id);
		return user;
	}

	@Override
	public User saveOrUpdate(User user) {
		User savedUser = userRepository.save(user);
		return savedUser;
	}

	@Override
	public void delete(Long id) {
		User deletedUser = userRepository.getById(id);
		userRepository.delete(deletedUser);
	}

}
