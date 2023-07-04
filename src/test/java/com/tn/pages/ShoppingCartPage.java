package com.tn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
	public WebDriver driver;
	
	@FindBy(linkText = "Tablets")
	private WebElement clickOnTablet;
	
	@FindBy(linkText = "Samsung Galaxy Tab 10.1")
	private WebElement clickOnGalaxyTab;
	
	@FindBy(css = "button.btn.btn-primary.btn-lg.btn-block")
	private WebElement clickOnAddToCart;
	
	@FindBy(xpath = "//td[normalize-space()='SAM1']")
	private WebElement validProduct;
	
	public ShoppingCartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickTablet() {
		clickOnTablet.click();
	}
	public void clickGalaxyTab() {
		clickOnGalaxyTab.click();
	}
	public void clickAddToCart() {
		clickOnAddToCart.click();
	}
	public boolean verifyStatusOfProduct() {
		boolean presenceValidProduct = validProduct.isDisplayed();
		return presenceValidProduct;
	}
}
