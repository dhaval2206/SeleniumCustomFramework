package testCases;

import org.apache.logging.log4j.core.config.Loggers;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC0001_AccountRegistrationPage extends BaseClass {

	
	@Test
	public void verify_account_registration() throws InterruptedException {
		loggers.info("***********Start execution***********");
		HomePage hp = new HomePage(driver);
		hp.clickOnMyAccount();
		hp.clickOnRegister();
		loggers.info("***********Home page activity is done***********");
		loggers.info("***********Account Registration activity is started***********");
		AccountRegistrationPage rp = new AccountRegistrationPage(driver);
		rp.setFirstName(randomString().toUpperCase());
		rp.setLastName(randomString().toUpperCase());
		rp.setEmail(randomString()+"@yopmail.com");
		rp.setTelephone(randomNumber());
		String password = randomAlphaNumeric();
		rp.setPassword(password);
		rp.setCnfPassword(password);
		rp.setPrivacyPolicy();
		rp.clickContinueButton();
		loggers.info("***********Account Registration activity is done***********");

		String cnfMessage = rp.getConfirmationmsg();
		Assert.assertEquals(cnfMessage, "Your Account Has Been Created!");
	}

}
