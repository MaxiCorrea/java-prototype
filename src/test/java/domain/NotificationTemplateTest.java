package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import org.junit.jupiter.api.Test;

class NotificationTemplateTest {

	private static final String TITLE = "Alert";
	private static final String CHANNEL = "Team 1";

	@Test
	void shouldCreateIndependentCopy() {
		NotificationTemplate original = new NotificationTemplate(TITLE, CHANNEL);
		NotificationTemplate copy = original.copy();
		assertNotSame(original, copy);
		assertEquals(original, copy);
	}

}
