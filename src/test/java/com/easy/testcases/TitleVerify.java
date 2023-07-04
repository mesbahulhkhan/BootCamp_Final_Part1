package com.easy.testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TitleVerify {
	
	public WebDriver driver;
	public SoftAssert softassert = new SoftAssert();
	
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	@Test
	public void verifyTitleOfPage() {
		driver.get("https://rediff.com");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Rediff.com: News | Rediffmail | Stock Quotes | Shopping";
		softassert.assertTrue(actualTitle.contains(expectedTitle));
		softassert.assertAll();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
