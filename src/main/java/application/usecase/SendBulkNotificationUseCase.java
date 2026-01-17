package application.usecase;

import java.util.List;

import application.port.NotificationSenderPort;
import domain.Notification;

public class SendBulkNotificationUseCase {

	private final NotificationSenderPort sender;
	
	public SendBulkNotificationUseCase(
			final NotificationSenderPort sender) {
		this.sender = sender;
	}
	
	public void execute(
			final Notification prototype,
			final List<String> recipients,
			final String message) {
		for(String recipient : recipients) {
			Notification notification = prototype.copy();
			notification.changeRecipient(recipient);
			notification.changeMessage(message);
			sender.send(notification);
		}
	}
	
}
