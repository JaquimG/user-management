package usersmanagement.entity;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {
	
	private String country;
	private String state;
	private String city;
	private String zipCode;
	private String street;
	private String number;
	private String complement;
	
	
	
}
