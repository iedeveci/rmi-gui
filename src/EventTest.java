

import static org.junit.Assert.*;

import org.junit.Test;

import DemoRMI.DemoClient;

public class EventTest {

	@Test
	public void multiplicationtest() {
		int sonuc = DemoClient.multiplication("5", "8");
		assertEquals(40, sonuc);
	}

}
