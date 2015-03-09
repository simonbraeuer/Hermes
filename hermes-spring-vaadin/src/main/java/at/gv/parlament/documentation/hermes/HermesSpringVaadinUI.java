package at.gv.parlament.documentation.hermes;

import javax.servlet.annotation.WebServlet;

import at.gv.parlament.documentation.hermes.view.EmptyContentPage;
import at.gv.parlament.documentation.hermes.view.MainPage;
import at.gv.parlament.documentation.hermes.view.SearchContentPage;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
@SpringUI("")
@Theme("valo")
public class HermesSpringVaadinUI extends UI {
	
	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = HermesSpringVaadinUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		MainPage page = new MainPage();
		page.addMenuEntry("Suche", new SearchContentPage());
		page.addMenuEntry("Aufnahme", new EmptyContentPage());
		setContent(page);
	}

}