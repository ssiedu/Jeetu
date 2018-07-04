package demo.test;

import java.net.MalformedURLException;
import org.openqa.selenium.chrome.ChromeDriver;
import common.Driverutil;

public class TestBase extends Driverutil{
	
	
	
	
	public static void creatNewSession() throws MalformedURLException {		
System.setProperty("webdriver.chrome.driver", "E:\\javaproject\\sumeettestproject\\chromedriver.exe");
driver = new ChromeDriver();
driver.get("https://accounts.google.com/ServiceLogin");
	}

	
}
