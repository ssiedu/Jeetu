package googleLocator;

import org.openqa.selenium.By;

public class GoogleSignupLocator {

	public static By emailid = By.cssSelector("#identifierId");
	public static By password = By.cssSelector("#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input");
 public static By next1 = By.cssSelector("#identifierNext > content > span");
	public static By next2 = By.xpath("//*[@id='passwordNext']/content/span");
	public static By compose = By.xpath("//*[@id=':ir']/div/div");
}
