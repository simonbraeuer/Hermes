package at.gv.parlament.documentation.hermes.view;

import org.springframework.beans.factory.annotation.Autowired;
import at.gv.parlament.documentation.hermes.controller.HermesSessionController;
import at.gv.parlament.documentation.hermes.domain.LoginCredentials;
import com.vaadin.data.validator.AbstractValidator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.spring.navigator.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;

@SpringView(LoginView.NAME)
public class LoginView extends AbstractHermesApplicationView implements
		Button.ClickListener, View {

	private static final long serialVersionUID = -6688889426505096293L;
	
	public static final String NAME = "";

	@Autowired
	private HermesSessionController sessionController;
	
	private final TextField user;

	private final PasswordField password;

	private final Button loginButton;
	
	
	public LoginView() {
		setSizeFull();

		// Create the user input field
		user = new TextField("User:");
		user.setWidth("300px");
		user.setRequired(true);
		user.setInputPrompt("Your username (eg. joe@email.com)");
		user.addValidator(new UserNameValidator());
		user.setInvalidAllowed(false);

		// Create the password input field
		password = new PasswordField("Password:");
		password.setWidth("300px");
		password.addValidator(new PasswordValidator());
		password.setRequired(true);
		password.setValue("");
		password.setNullRepresentation("");

		// Create login button
		loginButton = new Button("Login", this);

		// Add both to a panel
		VerticalLayout fields = new VerticalLayout(user, password, loginButton);
		fields.setCaption("Please login to access the application. (test@test.com/passw0rd)");
		fields.setSpacing(true);
		fields.setMargin(new MarginInfo(true, true, true, false));
		fields.setSizeUndefined();

		// The view root layout
		VerticalLayout viewLayout = new VerticalLayout(fields);
		viewLayout.setSizeFull();
		viewLayout.setComponentAlignment(fields, Alignment.MIDDLE_CENTER);
		viewLayout.setStyleName(Reindeer.LAYOUT_BLUE);
		setCompositionRoot(viewLayout);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		getSession().setAttribute(SESSIONCONTROLLER, sessionController);
		// focus the username field when user arrives to the login view
		user.focus();
		
	}

	// Validator for validating the passwords
	private static final class PasswordValidator extends
			AbstractValidator<String> {

		/**
		 * 
		 */
		private static final long serialVersionUID = -8004170734592806321L;

		public PasswordValidator() {
			super("The password provided is not valid");
		}

		@Override
		protected boolean isValidValue(String value) {
			//
			// Password must be at least 8 characters long and contain at least
			// one number
			//
			if (value != null
					&& (value.length() < 8 || !value.matches(".*\\d.*"))) {
				return false;
			}
			return true;
		}

		@Override
		public Class<String> getType() {
			return String.class;
		}
	}
	
	// Validator for validating the username
	private static final class UserNameValidator extends
			AbstractValidator<String> {

		/**
		 * 
		 */
		private static final long serialVersionUID = -4360873621656985691L;

		public UserNameValidator() {
			super("Der Benutzername muss aus mindestens 3 Zeichen bestehen!");
		}

		@Override
		protected boolean isValidValue(String value) {
			if (value != null
					&& (value.length() < 3 )) {
				return false;
			}
			return true;
		}

		@Override
		public Class<String> getType() {
			return String.class;
		}
	}

	@Override
	public void buttonClick(ClickEvent event) {

		if (!user.isValid() || !password.isValid()) {
			return;
		}

		String username = user.getValue();
		String password = this.password.getValue();

		if (getSessionController().login(new LoginCredentials(username, password))) {
			// Navigate to main view
			getUI().getNavigator().navigateTo(MainView.NAME);
		} else {
			this.password.setValue(null);
			this.password.focus();

		}
	}
	

}
