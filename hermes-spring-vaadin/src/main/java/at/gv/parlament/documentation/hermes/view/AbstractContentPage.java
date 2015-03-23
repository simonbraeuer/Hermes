package at.gv.parlament.documentation.hermes.view;

import java.util.Hashtable;

import at.gv.parlament.documentation.hermes.controller.NotificationType;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Notification;

@SuppressWarnings("serial")
public abstract class AbstractContentPage extends CustomComponent implements IContentPage{
	private Hashtable<NotificationType, Notification.Type> notificationTypeMapping;

	@Override
	public void showNotification(NotificationType type, String header,
			String text) {
		if(getNotificationTypeMapping().containsKey(type)) {
			Notification.show(header, text, getNotificationTypeMapping().get(type));
		}
	}
	
	@Override
	public void onDisplayPage() {
		// Do nothing on display per default
	}
	
	private Hashtable<NotificationType, Notification.Type> getNotificationTypeMapping() {
		if(notificationTypeMapping == null) {
			notificationTypeMapping = new Hashtable<>();
			notificationTypeMapping.put(NotificationType.ERROR, Notification.Type.ERROR_MESSAGE);
			notificationTypeMapping.put(NotificationType.WARN, Notification.Type.WARNING_MESSAGE);
			notificationTypeMapping.put(NotificationType.HUMAN, Notification.Type.HUMANIZED_MESSAGE);
			notificationTypeMapping.put(NotificationType.TRAY, Notification.Type.TRAY_NOTIFICATION);
		}
		return notificationTypeMapping;
	}
}
