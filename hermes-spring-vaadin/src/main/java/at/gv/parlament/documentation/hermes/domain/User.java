package at.gv.parlament.documentation.hermes.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class User implements Serializable{
	private String name;
	private String email;
}
