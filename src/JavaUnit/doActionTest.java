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
		String response = null;
		try {
			response = server.doaction(iEvent.serialize());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("1:true", response);
	}

}
