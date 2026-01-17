package application;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import application.port.NotificationSenderPort;
import application.usecase.SendBulkNotificationUseCase;
import domain.Notification;
import domain.NotificationTemplate;

class SendBulkNotificationUseCaseTest {

	@Test
	void shouldSendOneNotificationPerRecipient() {
		NotificationSenderPort sender = Mockito.mock(NotificationSenderPort.class);
		NotificationTemplate template = new NotificationTemplate("Alert", "Email");
		Notification notification = new Notification(
				UUID.randomUUID(),
				template,
				"base@company.com",
				"Base message");
		SendBulkNotificationUseCase usecase = new SendBulkNotificationUseCase(sender);
		List<String> recipients = List.of("a@a.com","b@b.com","c@c.com");
		usecase.execute(notification, recipients, "Common Message");
		Mockito.verify(sender, Mockito.times(3)).send(Mockito.any(Notification.class));
	}

}
