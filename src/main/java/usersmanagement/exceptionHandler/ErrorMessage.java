package usersmanagement.exceptionHandler;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ErrorMessage {

	private Integer status;
	private LocalDateTime date;
	private String title;
}
