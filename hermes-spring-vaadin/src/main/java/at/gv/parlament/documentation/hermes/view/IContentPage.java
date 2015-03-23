package at.gv.parlament.documentation.hermes.view;

import at.gv.parlament.documentation.hermes.controller.NotificationType;

import com.vaadin.ui.Component;

public interface IContentPage extends Component {
	public void onDisplayPage();
	public void showNotification(NotificationType type, String header, String text);
}
