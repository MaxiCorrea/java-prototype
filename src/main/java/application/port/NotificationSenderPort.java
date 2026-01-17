package application.port;

import domain.Notification;

public interface NotificationSenderPort {

	void send(Notification notification);
	
}
