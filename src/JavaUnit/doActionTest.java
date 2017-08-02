package JavaUnit;
import static org.junit.Assert.*;

import org.junit.Test;

import DemoRMI.DemoServer;
import DemoRMI.Event;

public class doActionTest {
	public static final String TYPE1 ="1";

	@Test
	public void test() {
		DemoServer server = new DemoServer();
		Event iEvent = new Event(Event.TYPE1, " " + "A Button");
<<<<<<< HEAD
		String response = null;
		try {
			response = server.doaction(iEvent.serialize());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
=======
		String response = server.doaction(iEvent.serialize());
>>>>>>> 304b0cebf8c907f80b46c44fe19b51b6f81229f3
		assertEquals("1:true", response);
	}

}
