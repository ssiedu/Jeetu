package demo.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;



import common.Driverutil;

public class TestBase extends Driverutil{
	
	
	
	
	public static void creatNewSession() throws MalformedURLException {		
//System.setProperty("webdriver.chrome.driver", "E:\\javaproject\\sumeettestproject\\chromedriver.exe");
//driver = new ChromeDriver();
//driver.get("https://accounts.google.com/ServiceLogin");
		 DesiredCapabilities capabilities;
		   System.out.println("sauce lab setup started...");
		   DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		   String selenium_browser = System.getenv("SELENIUM_BROWSER");
			desiredCapabilities.setBrowserName(selenium_browser);
			String selenium_version = System.getenv("SELENIUM_VERSION");
			desiredCapabilities.setVersion(selenium_version);
			String platform = System.getenv("SELENIUM_PLATFORM");
			desiredCapabilities.setCapability("platform", platform);
		   String sauceUserName = System.getProperty("sauceUserName");
		   String sauceAccessKey = System.getProperty("sauceAccessKey");
		   System.out.println("with sauce capabilities =" + capabilities);
		   
		   driver = new RemoteWebDriver(new URL(MessageFormat.format("http://{0}:{1}@ondemand.saucelabs.com:80/wd/hub", sauceUserName, sauceAccessKey)),
		     capabilities);
		  String sessionId = (((RemoteWebDriver) driver).getSessionId()).toString();
		   System.setProperty("sessionId", sessionId);
		   Object jobName = capabilities.getCapability("name");
		   String message = String.format("SauceOnDemandSessionID=%1$s job-name=%2$s", sessionId, jobName);
		   System.out.println(">>**>>" + message);
		   System.out.println("sauce lab setup completed");
	}

	
}
