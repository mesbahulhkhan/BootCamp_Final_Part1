package com.tn.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tn.pages.AccountSuccessPage;
import com.tn.pages.HomePage;
import com.tn.pages.RegisterPage;
import com.tn.testBase.TestBase;
import com.tn.utils.Utilities;

public class RegisterTest extends TestBase{
	
	public WebDriver driver;
	public SoftAssert softassert = new SoftAssert();
	public RegisterPage registerpage;
	public AccountSuccessPage accountsuccesspage;
	
	public RegisterTest() throws Exception {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		driver = openApplication(prop.getProperty("browser"));
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		registerpage = homepage.clickOnRegister();
	}
	
	@Test
	public void verifyRegistrationWithValidCredentials() {
		registerpage.enterFirstNameField(dataProp.getProperty("firstName"));
		registerpage.enterLastNameField(dataProp.getProperty("lastName"));
		registerpage.enterEmailField(Utilities.emailDateTimeStamp());
		registerpage.enterTelephoneField(dataProp.getProperty("mobileNumber"));
		registerpage.enterPasswordField(prop.getProperty("validPassword"));
		registerpage.enterConfirmPasswordField(prop.getProperty("validPassword"));
		registerpage.checkPrivacyPolicy();
		accountsuccesspage = registerpage.clickOnContinueButton();
		
		String actualMessage = accountsuccesspage.retrieveAccountCreatedMessage();
		String expectedMessage = dataProp.getProperty("accountSuccessMessage");
		softassert.assertTrue(actualMessage.equals(expectedMessage));
		softassert.assertAll();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
