package JavaUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DemoUnit {

	@Test
	public void test_deneme() {
		 //execute only once, in the starting 
		  System.out.println("DemoUnit.test()");
		
	}
	 @BeforeClass
	   public static void beforeClass() {
	      System.out.println("in before class");
	   }

	   //execute only once, in the end
	   @AfterClass
	   public static void  afterClass() {
	      System.out.println("in after class");
	   }

	   //execute for each test, before executing test
	   @Before
	   public void before() {
	      System.out.println("in before");
	   }
		
	   //execute for each test, after executing test
	   @After
	   public void after() {
	      System.out.println("in after");
	   }
		
	   //test case 1
	   @Test
	   public void test_deneme2() {
	      System.out.println("in test case 1");
	   }

	   //test case 2
	   @Test
	   public void test_deneme3() {
	      System.out.println("in test case 2");
	   }
}
