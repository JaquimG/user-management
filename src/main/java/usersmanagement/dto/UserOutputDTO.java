package usersmanagement.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import usersmanagement.entity.Address;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserOutputDTO implements Serializable{

	private static final long serialVersionUID = 1;
	

	private Long id;	
	private String name;
	private String email;
	private Address address;
	private Long pis;
	private String cpf;
		
}
