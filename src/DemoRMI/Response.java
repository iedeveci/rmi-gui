package DemoRMI;

public class Response {

	public int EventType;
	public boolean IsSuccessful;

	public Response(int pEventType, boolean pIsSuccessful) {
		this.EventType = pEventType;
		this.IsSuccessful = pIsSuccessful;
	}

	public String serialize() {
		return EventType + ":" + Boolean.toString(IsSuccessful);
	}

	public static Response deserialize(String pValue) {
		String[] s = pValue.split(":");

		int nEventType = Integer.parseInt(s[0]);
		boolean bSuccess = Boolean.parseBoolean(s[1]);

		return new Response(nEventType, bSuccess);

	}

}
