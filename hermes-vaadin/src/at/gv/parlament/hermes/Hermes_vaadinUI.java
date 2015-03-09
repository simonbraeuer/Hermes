package at.gv.parlament.hermes;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
@SpringUI("")
@Theme("hermes_vaadin")
public class Hermes_vaadinUI extends UI {
	
	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = Hermes_vaadinUI.class)
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