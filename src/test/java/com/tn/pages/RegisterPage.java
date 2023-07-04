package com.tn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	public WebDriver driver;
	
	@FindBy(id = "input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id = "input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id = "input-email")
	private WebElement emailField;
	
	@FindBy(id = "input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id = "input-password")
	private WebElement passwordField;
	
	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordField;
	
	@FindBy(name = "agree")
	private WebElement privacyPolicyCheckbox;
	
	@FindBy(css = "input.btn.btn-primary")
	private WebElement continueButton;
	
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterFirstNameField(String firstNameText) {
		firstNameField.sendKeys(firstNameText);
	}
	
	public void enterLastNameField(String lastNameText) {
		lastNameField.sendKeys(lastNameText);
	}
	
	public void enterEmailField(String emailText) {
		emailField.sendKeys(emailText);
	}
	
	public void enterTelephoneField(String telephoneText) {
		telephoneField.sendKeys(telephoneText);
	}
	
	public void enterPasswordField(String passwordText) {
		passwordField.sendKeys(passwordText);
	}
	
	public void enterConfirmPasswordField(String confirmPasswordText) {
		confirmPasswordField.sendKeys(confirmPasswordText);
	}
	
	public void checkPrivacyPolicy() {
		privacyPolicyCheckbox.click();
	}
	
	public AccountSuccessPage clickOnContinueButton() {
		continueButton.click();
		return new AccountSuccessPage(driver);
	}
}
