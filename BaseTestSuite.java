import static org.junit.Assert.assertEquals;	
import java.util.regex.Pattern;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class BaseTestSuite {
	
      private WebDriver driver;
	  private static String bookTitle;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  
	  /*
	   * Here we declare the random values that stay constant for whole test suite
	   */
	  
	  @BeforeClass 
	  public static void setUpOnlyOnce() {
		  Date date = new Date();		
		  DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HHmmss");		
		  bookTitle="Testing Journal " + sdf.format(date);
	  }
	  
	  
	  @Before
	  public void setUp() throws Exception {
		 
		System.setProperty("webdriver.gecko.driver", "C:/geckodriver-v0.19.1-win64/geckodriver.exe");
		driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	     
	  }
	  
  
	  @After	  
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	
	  /*
	  * LBT-001 This test adds a new book with randomly generated title
	  */
	  @Test
	  public void AddNewBook() throws Exception {
		//String BookTitle = new String ("Random book title");
		driver.get("https://raamatukogu.herokuapp.com/catalog/book/create");
		System.out.println(bookTitle);
	  }	  
	  
	  /*
	  * LBT-002 This test verifies that new book with randomly generated title is added
	  */
	  @Test
	  public void VerifyNewBookAdded() throws Exception {
		//String BookTitle = new String ("Random book title");
		driver.get("https://raamatukogu.herokuapp.com/catalog/book/create");
		System.out.println(bookTitle);
	  }	 

	  	
}		