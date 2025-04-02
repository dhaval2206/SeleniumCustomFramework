package testBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC0001_AccountRegistrationPage {

	public WebDriver driver;

	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void verify_account_registration() {
		HomePage hp = new HomePage(driver);
		hp.clickOnMyAccount();
		hp.clickOnRegister();

		AccountRegistrationPage rp = new AccountRegistrationPage(driver);
		rp.setFirstName("Dhaval");
		rp.setLastName("Soni");
		rp.setEmail("dhaval@yopmail.com");
		rp.setTelephone("9825499787");
		rp.setPassword("New@123");
		rp.setCnfPassword("New@123");
		rp.setPrivacyPolicy();
		rp.clickContinueButton();
		rp.getConfirmationmsg();

	}

}
