package com.tn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	public WebDriver Driver;

	@FindBy(linkText = "Samsung Galaxy Tab 10.1")
	private WebElement validProducts;
	
	@FindBy(linkText = "Samsung Galaxy Tab 10.1")
	private WebElement clickOnGalaxyTab;
	
	public SearchPage(WebDriver driver) {
		this.Driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyValidProducts() {
		boolean presenceValidProducts = validProducts.isDisplayed();
		return presenceValidProducts;
	}
	
	public void chooseGalaxyTab() {
		clickOnGalaxyTab.click();
	}
}
