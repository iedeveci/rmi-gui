package DemoRMI;

public class Event {

	public static final int TYPE1 = 1;
	public static final int TYPE2 = 2;

	public int EventType;
	String EventText;

	public Event(int pEventType, String pEventText) {
		this.EventText = pEventText;
		this.EventType = pEventType;
	}

	public String serialize() {
		return EventType + ":" + EventText;
	}

	public static Event deserialize(String pValue) {
		String[] s = pValue.split(":");

		int nEventType = Integer.parseInt(s[0]);

		return new Event(nEventType, s[1]);
	}

}
