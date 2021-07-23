package usersmanagement.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginWithEmailDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String email;
	private String password;

}
