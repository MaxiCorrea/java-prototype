package domain;

import java.util.UUID;

public class Notification implements Prototype<Notification> {

	private final UUID uuid;
	private final NotificationTemplate template;
	private String recipient;
	private String message;
	
	public Notification(
			final UUID uuid,
			final NotificationTemplate template,
			final String recipient,
			final String message) {
		this.uuid = uuid;
		this.template = template;
		this.recipient = recipient;
		this.message = message;
	}
	
	@Override
	public Notification copy() {
		return new Notification(
				UUID.randomUUID(), 
				template.copy(), 
				recipient, 
				message);
	}

	public final void changeRecipient(
			final String newValue) {
		this.recipient = newValue;
	}
	
	public final void changeMessage(
			final String newValue) {
		this.message = newValue;
	}
	
	public UUID getUuid() {
		return uuid;
	}
	
	public String getRecipient() {
		return recipient;
	}
	
	public String getMessage() {
		return message;
	}

	public NotificationTemplate getTemplate() {
		return template;
	}	
}
