package at.gv.parlament.documentation.hermes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import at.gv.parlament.documentation.hermes.service.ILoginService;

@SpringBootApplication
public class HermesSpringVaadinApplication {

    public static void main(String[] args) {
        SpringApplication.run(HermesSpringVaadinApplication.class, args);
    }
    
}
