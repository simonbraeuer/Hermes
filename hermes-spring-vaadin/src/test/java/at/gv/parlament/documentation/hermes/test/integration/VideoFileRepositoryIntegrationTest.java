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

import at.gv.parlament.documentation.hermes.dao.PersistenceContext;
import at.gv.parlament.documentation.hermes.dao.VideoFileEntity;
import at.gv.parlament.documentation.hermes.dao.VideoFileRepository;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceContext.class })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
@DatabaseSetup("hermesIntegrationTestData.xml")
public class VideoFileRepositoryIntegrationTest {

	@Autowired
	private VideoFileRepository repository;

	@Test
	public void findByName_NoVideoFileEntriesFound_ShouldReturnEmptyList() {
		List<VideoFileEntity> fileLocatorEntries = repository.findByName("not existing");
		assertThat(fileLocatorEntries.size(), is(0));
	}

	@Test
	public void findByName_OneVideoFileEntryFound_ShouldReturnAListOfOneEntry() {
		List<VideoFileEntity> fileLocatorEntries = repository.findByName("hermes");

		assertThat(fileLocatorEntries.size(), is(1));
		assertThat(
				fileLocatorEntries.get(0),
				allOf(hasProperty("id", is(1L)),
						hasProperty("name", is("hermes")),
						hasProperty("contentType", is("video/mp4"))));
		
	}

}
