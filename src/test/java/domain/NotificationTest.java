package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NotificationTest {

	private static final String TITLE = "Alert";
	private static final String CHANNEL = "Team 1";

	private NotificationTemplate template;
	private Notification original;
	
	@BeforeEach
	void setup() {
		template = new NotificationTemplate(TITLE, CHANNEL);
		original = new Notification(
				UUID.randomUUID(), 
				template, 
				"base@compani.com", 
				"Base message");
	}
	
	@Test
	void shouldCloneNotificationWithNewIdentity() {
		Notification copy = original.copy();
		assertNotSame(original, copy);
		assertNotEquals(original.getUuid(), copy.getUuid());
		assertEquals(original.getMessage(), copy.getMessage());
		assertEquals(original.getRecipient(), copy.getRecipient());
		assertNotSame(original.getTemplate(), copy.getTemplate());
	}

	@Test
	void modifyingCloneShouldNotAffectedOriginal() {
		Notification copy = original.copy();
		copy.changeRecipient("alerts@galeno.com.ar");
		copy.changeMessage("New Message");
		assertEquals("base@compani.com", original.getRecipient());
		assertEquals("Base message", original.getMessage());	
	}

}
