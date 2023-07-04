package com.tn.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tn.pages.AccountPage;
import com.tn.pages.HomePage;
import com.tn.pages.LoginPage;
import com.tn.testBase.TestBase;
import com.tn.testData.ExcelData;

public class LoginTest extends TestBase{
	
	public WebDriver driver;
	public SoftAssert softassert = new SoftAssert();
	public LoginPage loginpage;
	public AccountPage accountpage;
	
	public LoginTest() throws Exception {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		driver = openApplication(prop.getProperty("browser"));
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		loginpage = homepage.selectLoginOption();
	}
	
	@Test(dataProvider = "tutorialsNinja", dataProviderClass = ExcelData.class)
	public void verifyLoginWithValidCredentials(String username, String password) {
		loginpage.enterEmail(username);
		loginpage.enterPassword(password);
		accountpage = loginpage.clickOnLoginButton();
		softassert.assertTrue(accountpage.verifyLogin());
		softassert.assertAll();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
