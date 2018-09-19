package ui.tests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;		

public class ServiceSuite {
	 
	  private StringBuffer verificationErrors = new StringBuffer();
	  private boolean acceptNextAlert = true;
	  private WebElement element;
	  private WebDriver driver;
	  private String baseUrl;
	  
	  @Before
	  public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:/geckodriver-v0.19.1-win64/geckodriver.exe");
		driver = new FirefoxDriver();
	    baseUrl = "https://www.katalon.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	/*
	 * Service test to check that JUNIT works correctly	 * 
	 */
	@Test		
    public void JunitAlive(){					
        String str= "JUnit is working fine";					
        assertEquals("JUnit is working fine",str);					
    }	
	
	/*
	 * Service test to check that site is alive	 * 
	 */
	@Test
	  public void SiteAlive() throws Exception {
	    driver.get("https://raamatukogu.herokuapp.com");
	    WebElement Home = driver.findElement(By.xpath("/html/body/div/div/div[1]/ul/li[1]/a"));
	    assertEquals(Home.getText(),"Home");
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
	
}	