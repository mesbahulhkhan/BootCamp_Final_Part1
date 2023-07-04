package com.tn.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tn.pages.HomePage;
import com.tn.pages.SearchPage;
import com.tn.testBase.TestBase;

public class SearchProductTest extends TestBase{
	
	public WebDriver driver;
	public SoftAssert softassert = new SoftAssert();
	public SearchPage searchpage;
	
	public SearchProductTest() throws Exception {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		driver = openApplication(prop.getProperty("browser"));
	}
	
	@Test
	public void verifySearchProduct() {
		HomePage homepage = new HomePage(driver);
		homepage.enterProductDetails(dataProp.getProperty("productName"));
		searchpage = homepage.clickOnSearchButton();
		softassert.assertTrue(searchpage.verifyValidProducts());
		softassert.assertAll();	
		searchpage.chooseGalaxyTab();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
