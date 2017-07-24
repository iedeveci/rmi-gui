package DemoRMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("unused")
public class DemoServer implements IDemoButton {

	/***
	 * this is a javadoc
	 */
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

	public String doaction(String s) {
		
		Event iEvent = Event.deserialize(s);
		
		Response iResponse = this.handleEvent(iEvent);

		return iResponse.serialize();
	}

	private Response handleEvent(Event iEvent) {

		Writer iWrite = Writer.writeToFile(iEvent);

		return new Response(iEvent.EventType, true);

	}
}
