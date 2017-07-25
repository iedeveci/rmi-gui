package Methods;

public class EventCal {
	public static final int TYPE3 = 3;

	public int eventType;
	public int result;

	public EventCal(int cEventType, int cResult) {
		this.eventType = cEventType;
		this.result = cResult;
	}

	public String cserialize() {
		return eventType + ":" + result;
	}

}
