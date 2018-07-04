package demo.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@google", plugin = { "json", "json:target/cucumber.json" }, features = { "." }, strict = true)
public class TestRun {

	@BeforeClass
	public static void setUp() throws Exception {
TestBase.creatNewSession();


	}

	@AfterClass
	public static void tearDown() throws Exception {
TestBase.driver.close();
	}

}
