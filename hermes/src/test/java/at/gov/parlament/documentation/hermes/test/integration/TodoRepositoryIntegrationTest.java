package at.gov.parlament.documentation.hermes.test.integration;

import java.util.List;

import org.hamcrest.Matcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import at.gov.parlament.documentation.hermes.dao.PersistenceContext;
import at.gov.parlament.documentation.hermes.dao.Todo;
import at.gov.parlament.documentation.hermes.dao.TodoRepository;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;


import static org.hamcrest.CoreMatchers.allOf;
//import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceContext.class})
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
@DatabaseSetup("todoData.xml")
public class TodoRepositoryIntegrationTest {

    @Autowired
    private TodoRepository repository;

    @Test
    public void search_NoTodoEntriesFound_ShouldReturnEmptyList() {
        List<Todo> todoEntries = repository.search("NOT FOUND");
        assertThat(todoEntries.size(), is(0));
    }

    @Test
    public void search_OneTodoEntryFound_ShouldReturnAListOfOneEntry() {
        List<Todo> todoEntries = repository.search("foo");

        assertThat(todoEntries.size(), is(1));
        assertThat(todoEntries.get(0), allOf(
                hasProperty("id", is(1L)),
                hasProperty("title", is("Foo")),
                hasProperty("description", is("Lorem ipsum"))
        ));
    }

    @Test
    public void search_TwoTodoEntriesFound_ShouldReturnAListOfTwoEntries() {
        List<Todo> todoEntries = repository.search("Ips");

        assertThat(todoEntries.size(), is(2));
        assertThat(todoEntries, contains(
                allOf(
                        hasProperty("id", is(1L)),
                        hasProperty("title", is("Foo")),
                        hasProperty("description", is("Lorem ipsum"))
                ),
                allOf(
                        hasProperty("id", is(2L)),
                        hasProperty("title", is("Bar")),
                        hasProperty("description", is("Lorem ipsum"))
                )
        ));
    }
}
