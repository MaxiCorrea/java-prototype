package application;

import java.util.List;

import domain.Notification;
import domain.NotificationSenderPort;

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
