package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class BaseClass {
	public WebDriver driver;
	public Logger loggers;
	public Properties prop;

	@BeforeClass
	@Parameters({ "os", "browser" })
	public void setup() throws IOException {
		loggers = LogManager.getLogger(this.getClass());

//		switch (browser.toLowerCase()) {
//		case "chrome":
//			driver = new ChromeDriver();
//			break;
//		case "firefox":
//			driver = new FirefoxDriver();
//			break;
//		case "edge":
//			driver = new EdgeDriver();
//			break;
//		default:
//			System.out.println("Invalid browser name");
//			return;
//		}
		driver = new ChromeDriver();
		FileReader file = new FileReader("./src/test/resources/config.properties");
		prop = new Properties();
		prop.load(file);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("appURL"));
		driver.manage().window().maximize();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public String randomString() {
		String generateString = RandomStringUtils.randomAlphabetic(5);
		return generateString;
	}

	public String randomNumber() {
		String generateNumber = RandomStringUtils.randomNumeric(10);
		return generateNumber;
	}

	public String randomAlphaNumeric() {
		String generateString = RandomStringUtils.randomAlphabetic(5);
		String generateNumber = RandomStringUtils.randomAlphabetic(5);

		return (generateString + generateNumber + "@");
	}

}
