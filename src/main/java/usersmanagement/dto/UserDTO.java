package usersmanagement.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import usersmanagement.entity.Address;


@Getter
@Setter
public class UserDTO  implements Serializable{

	private static final long serialVersionUID = 1;
	

	private Long id;	
	private String name;
	private String email;
	private Address address;
	private Long pis;
	private String password;
	

	
	
}
