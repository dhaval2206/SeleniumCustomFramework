package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;

public class TC0002_LoginTest extends BaseClass {

	@Test
	public void verify_Login() {
		try {
			loggers.info("***********Start execution***********");
			HomePage hp = new HomePage(driver);
			hp.clickOnMyAccount();
			hp.clickOnLogin();
			loggers.info("***********Home page activity is done***********");
			loggers.info("***********Login activity is started***********");
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(prop.getProperty("email"));
			lp.setPassword(prop.getProperty("password"));
			lp.clickOnLoginButton();
			loggers.info("***********Login activity is done***********");
			loggers.info("***********My Account page activity is done***********");
			MyAccount macc = new MyAccount(driver);
			boolean target = macc.isMyAccountPageExitst();
			Assert.assertTrue(target);
		} catch (Exception e) {
			Assert.fail();
		}
	}

}
