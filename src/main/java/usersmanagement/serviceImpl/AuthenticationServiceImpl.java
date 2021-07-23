package usersmanagement.serviceImpl;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import usersmanagement.dto.LoginWithEmailDTO;
import usersmanagement.entity.User;
import usersmanagement.repository.UserRepository;

@Service
public class AuthenticationServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);
//		LoginWithEmailDTO login = toLoginWithEmailDTO(user);
		if(user!=null){
			
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
	}
	
	
	private LoginWithEmailDTO toLoginWithEmailDTO(User user) {
		return modelMapper.map(user, LoginWithEmailDTO.class);
	}

}
