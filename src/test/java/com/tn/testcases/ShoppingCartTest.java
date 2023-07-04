package com.tn.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tn.pages.HomePage;
import com.tn.pages.ShoppingCartPage;
import com.tn.testBase.TestBase;

public class ShoppingCartTest extends TestBase{
	
	public WebDriver driver;
	public SoftAssert softassert = new SoftAssert();
	public ShoppingCartPage shoppingcartpage;
	
	public ShoppingCartTest() throws Exception {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		driver = openApplication(prop.getProperty("browser"));
		HomePage homepage = new HomePage(driver);
		shoppingcartpage = homepage.clickOnShoppingCart();
	}
	
	@Test
	public void verifyAddProductToCart() {
		shoppingcartpage.clickTablet();
		shoppingcartpage.clickGalaxyTab();
		shoppingcartpage.clickAddToCart();
		HomePage homepage = new HomePage(driver);
		shoppingcartpage = homepage.clickOnShoppingCart();
		softassert.assertTrue(shoppingcartpage.verifyStatusOfProduct());
		softassert.assertAll();	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
