package JavaUnit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import DemoRMI.DemoServer;


public class doActionTest {
	public static final String TYPE1 ="1";

	@Test
	public void test() {
		DemoServer server = new DemoServer();
		Event iEvent = new Event(Event.TYPE1, " " + "A Button");
		String response = server.doaction(iEvent.serialize());
		assertEquals("1:true", response);
	}

}
