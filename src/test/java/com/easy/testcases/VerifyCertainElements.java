package com.easy.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyCertainElements {
	
	public WebDriver driver;
	public SoftAssert softassert = new SoftAssert();
	
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo");
	}
	
	@Test
	public void verifyCertainElementsInAPage() {
		driver.findElement(By.linkText("Cameras")).click();
		WebElement canonCamera = driver.findElement(By.linkText("Canon EOS 5D"));
		softassert.assertTrue(canonCamera.isDisplayed());
		System.out.println("1st Camera : "+ canonCamera.getText());
		WebElement nikonCamera = driver.findElement(By.linkText("Nikon D300"));
		System.out.println("2nd Camera : "+ nikonCamera.getText());
		softassert.assertTrue(nikonCamera.isDisplayed());
		softassert.assertAll();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
