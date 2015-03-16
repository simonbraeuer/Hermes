package at.gv.parlament.documentation.hermes.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import at.gv.parlament.documentation.hermes.HermesSpringVaadinApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HermesSpringVaadinApplication.class)
@WebAppConfiguration
public class HermesSpringVaadinApplicationTests {

	@Test
	public void contextLoads() {
	}

}
