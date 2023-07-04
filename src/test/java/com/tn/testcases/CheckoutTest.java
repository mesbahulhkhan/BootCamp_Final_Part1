package com.tn.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tn.pages.CheckoutPage;
import com.tn.pages.HomePage;
import com.tn.testBase.TestBase;

public class CheckoutTest extends TestBase{
	
	public WebDriver driver;
	public SoftAssert softassert = new SoftAssert();
	public CheckoutPage checkoutpage;
	
	public CheckoutTest() throws Exception {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		driver = openApplication(prop.getProperty("browser"));
		HomePage homepage = new HomePage(driver);
		checkoutpage = homepage.clickOnCart();
	}
	
	@Test
	public void verifyCorrectProductDuringCheckout() {
		checkoutpage.clickTablet();
		checkoutpage.clickGalaxyTab();
		checkoutpage.clickAddToCart();
		checkoutpage.clickCheckout();
		softassert.assertTrue(checkoutpage.verifyStatusOfProduct());
		softassert.assertAll();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
