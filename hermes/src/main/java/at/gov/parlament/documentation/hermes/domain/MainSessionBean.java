package at.gov.parlament.documentation.hermes.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Component
@Scope("session")
public class MainSessionBean {
	@Getter @Setter private String activeModule;
	
}
