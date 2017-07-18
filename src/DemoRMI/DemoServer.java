package DemoRMI;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.AbstractButton;
import javax.swing.JButton;

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
			continue;
		}
	}

	public String doaction(String ss) {

		Event iEvent = Event.deserialize(ss);

		Response iResponse = this.handleEvent(iEvent);

		return iResponse.serialize();
	}

	private Response handleEvent(Event iEvent) {

		Writer iWrite = Writer.writeToFile(iEvent);
		
		return new Response(iEvent.EventType, true);

	}
}
