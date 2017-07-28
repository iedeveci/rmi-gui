package DemoRMI;

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
	
	public static EventCal deserialize(String pValue, String p1, String p2) {
	
		String[] s = pValue.split(":");

		int nEventType = Integer.parseInt(s[0]);
		
		p2 = DemoClient.input1;
		p1 = DemoClient.input2;
		
		int t1 = Integer.parseInt(p1);
		int t2 = Integer.parseInt(p2);

		return new EventCal (nEventType, t1 * t2);
	}
}