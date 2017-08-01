package DemoRMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("unused")

public class DemoServer implements IDemoButton {
	
	public DemoServer() {

	}

	public static void main(String[] args) {

		try {

			DemoServer obj = new DemoServer();

			IDemoButton stub = (IDemoButton) UnicastRemoteObject.exportObject(obj, 0);

			Registry registry = LocateRegistry.createRegistry(1099);

			registry.bind("Button", stub);

			System.err.println("Server ready");

		} catch (Exception e) {

			System.err.println("Server exception: " + e.toString());

			e.printStackTrace();

		}
		while (true) {
		}
	}

	public String doaction(String ss) {

		if (ss.contains("TYPE3:")) {

			String s1 = DemoClient.input2;

			String s2 = DemoClient.input1;

			EventCal cEvent = EventCal.deserialize(ss, s1, s2);

			Response cResponse = DemoServer.handleEvent(null, cEvent);

			return cResponse.serialize().toString();
			


		} else {

			Event iEvent = Event.deserialize(ss);

			Response iResponse = DemoServer.handleEvent(iEvent, null);

			return iResponse.serialize().toString();
		}
	}

	public static Response handleEvent(Event iEvent, EventCal cEvent) {

		if (iEvent == null) {

			String c = cEvent.cserialize().toString();

			Writer cWrite = Writer.writeToFile(c);

			return new Response(cEvent.eventType, true);

		} else if (cEvent == null) {

			String i = iEvent.serialize().toString();

			Writer iWrite = Writer.writeToFile(i);

			return new Response(iEvent.EventType, true);

		} else {
			
			return null;
			
		}
	}
}