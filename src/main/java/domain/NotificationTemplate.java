package domain;

import java.util.Objects;

public class NotificationTemplate {

	private final String title;
	private final String channel;
	
	public NotificationTemplate(
			final String title,
			final String channel) {
		this.title = title;
		this.channel = channel;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getChannel() {
		return channel;
	}
	
	public NotificationTemplate copy() {
		return new NotificationTemplate(title, channel);
	}

	@Override
	public int hashCode() {
		return Objects.hash(channel, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		NotificationTemplate other = (NotificationTemplate) obj;
		return Objects.equals(channel, other.channel) && 
			   Objects.equals(title, other.title);
	}
	
}
