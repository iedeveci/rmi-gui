package JavaUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import DemoRMI.DemoClient;

public class EventTest {

	@Test
	public void test() {
		int sonuc = DemoClient.multiplication("5", "8");
		
		assertEquals(40, sonuc);
		sonuc = DemoClient.multiplication("5", "8");
		assertEquals(41, sonuc);
	}
	@Test
	public void test2() {
		int sonuc = DemoClient.multiplication("5", "8");
	
		
		assertEquals(41, sonuc);
	}
}
