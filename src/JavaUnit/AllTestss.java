package JavaUnit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AllTests.class, DemoUnit.class, doActionTest.class, EventTest.class, junitdeneme.class,
		ParametreTest.class })
public class AllTestss {

}
