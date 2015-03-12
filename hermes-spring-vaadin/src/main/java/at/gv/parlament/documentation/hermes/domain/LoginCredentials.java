package at.gv.parlament.documentation.hermes.domain;

import java.io.Serializable;

import lombok.Data;
import lombok.NonNull;

@Data
public class LoginCredentials implements Serializable{
	@NonNull private String userName;
	@NonNull private String password;
}
