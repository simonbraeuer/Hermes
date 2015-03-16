package at.gv.parlament.documentation.hermes.test.integration;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import at.gv.parlament.documentation.hermes.dao.FileLocator;
import at.gv.parlament.documentation.hermes.dao.FileLocatorRepository;
import at.gv.parlament.documentation.hermes.dao.PersistenceContext;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceContext.class })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
@DatabaseSetup("hermesIntegrationTestData.xml")
public class FileLocatorRepositoryIntegrationTest {

	@Autowired
	private FileLocatorRepository repository;

	@Test
	public void findByLink_NoFileLocatorEntriesFound_ShouldReturnEmptyList() {
		List<FileLocator> fileLocatorEntries = repository.findByLink("not existing");
		assertThat(fileLocatorEntries.size(), is(0));
	}

	@Test
	public void findByLink_OneFileLocatorEntryFound_ShouldReturnAListOfOneEntry() {
		List<FileLocator> fileLocatorEntries = repository.findByLink("/files/hermes.mp4");

		assertThat(fileLocatorEntries.size(), is(1));
		assertThat(
				fileLocatorEntries.get(0),
				allOf(hasProperty("id", is(1L)),
						hasProperty("hashValue", is("hermesHashvalue")),
						hasProperty("link", is("/files/hermes.mp4")),
						hasProperty("filePath", is("/opt/files/hermes.mp4"))));
	}

}
