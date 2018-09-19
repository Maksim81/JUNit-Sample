package ui.tests;
import org.junit.runner.RunWith;		
import org.junit.runners.Suite;		

@RunWith(Suite.class)				
@Suite.SuiteClasses({				
  ServiceSuite.class,
  BaseTestSuite.class  
})		

public class FullTestSuite {				
			// This class remains empty, it is used only as a holder for the above annotations		
}
