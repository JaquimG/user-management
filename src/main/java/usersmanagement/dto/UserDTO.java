package usersmanagement.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

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
public class UserDTO implements Serializable{

	private static final long serialVersionUID = 1;
	

	@Column
	@NotNull
	private String name;
	
	@Email
	@NotNull
	@Column(unique=true)
	private String email;
	
	private Address address;
	
	@NotNull
	@Column(unique=true)
	private Long pis;
	
	@NotNull
	@Column(unique=true)
	private String cpf;
	
	@Column
	@NotNull
	private String password;

	
	
}
