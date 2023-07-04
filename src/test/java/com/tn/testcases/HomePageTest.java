package com.tn.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tn.pages.HomePage;
import com.tn.testBase.TestBase;

public class HomePageTest extends TestBase{
	
	public WebDriver driver;
	public SoftAssert softassert = new SoftAssert();
	public HomePage homepage;

	public HomePageTest() throws Exception {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		driver = openApplication(prop.getProperty("browser"));
	}
	
	@Test
	public void verifyPresenceOfElements() {
		HomePage homepage = new HomePage(driver);
		homepage.verifyPresenceOfDesktops();
		softassert.assertTrue(homepage.verifyPresenceOfDesktops());
		homepage.verifyPresenceOfLaptops();
		softassert.assertTrue(homepage.verifyPresenceOfLaptops());
		homepage.verifyPresenceOfComponents();
		softassert.assertTrue(homepage.verifyPresenceOfComponents());
		homepage.verifyPresenceOfTablets();
		softassert.assertTrue(homepage.verifyPresenceOfTablets());
		homepage.verifyPresenceOfSoftware();
		softassert.assertTrue(homepage.verifyPresenceOfSoftware());
		homepage.verifyPresenceOfPhonesPDA();
		softassert.assertTrue(homepage.verifyPresenceOfPhonesPDA());
		homepage.verifyPresenceOfCameras();
		softassert.assertTrue(homepage.verifyPresenceOfCameras());
		homepage.verifyPresenceOfMP3Players();
		softassert.assertTrue(homepage.verifyPresenceOfMP3Players());
		homepage.clickOnMyAccount();
		homepage.clickOnRegister();
		softassert.assertAll();		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
