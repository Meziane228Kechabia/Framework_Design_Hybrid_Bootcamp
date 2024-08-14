package tutorialsNinja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	public WebDriver driver;

	@FindBy(linkText = "My Account")
	private WebElement myAccountDropDown;

	@FindBy(linkText = "Register")
	private WebElement registerLink;

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

	@FindBy(xpath = "//input[@type='radio' and @value='0']")
	private WebElement newsLetterSubscrib;

	@FindBy(xpath = "//input[@type='checkbox' and @value='1']")
	private WebElement agreePrivacyPolicyCheckBox;

	@FindBy(linkText = "Privacy Policy")
	private WebElement continueButton;
	
	@FindBy(xpath="//div[@id='content']")
	private WebElement newAccountSuccesfulyCreatedMessage;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public RegisterPage dropDownMenuAndRegisterLink() {
		myAccountDropDown.click();
		registerLink.click();
		return new RegisterPage(driver);
	}

	public void enterFirstName(String firstnameText) {
		firstNameField.sendKeys(firstnameText);
	}

	public void enterLastName(String lastnameText) {
		lastNameField.sendKeys(lastnameText);
	}

	public void enterEmail(String emailText) {
		emailField.sendKeys(emailText);
	}

	public void enterTelephone(String telephoneText) {
		telephoneField.sendKeys(telephoneText);
	}

	public void enterPassword(String passwordText) {
		passwordField.sendKeys(passwordText);
	}

	public void enterConfirmPassword(String confirmPasswordText) {
		confirmPasswordField.sendKeys(confirmPasswordText);
		;
	}

	public void clickNoSubscribeButton() {
		newsLetterSubscrib.click();
	}

	public void clickYesAgreePrivacyPolicy() {
		agreePrivacyPolicyCheckBox.click();
	}

	public void clickOnContinueButton() {
		continueButton.click();
	}

	public RegisterPage combiningMandatoryDetailsToNavigateToAccountSuccessPage(String firstnameText,
			String lastnameText, String emailText, String telephoneText, String passwordText,
			String confirmpasswordText) {
		firstNameField.sendKeys(firstnameText);
		lastNameField.sendKeys(lastnameText);
		emailField.sendKeys(emailText);
		telephoneField.sendKeys(telephoneText);
		passwordField.sendKeys(passwordText);
		confirmPasswordField.sendKeys(confirmpasswordText);
		newsLetterSubscrib.click();
		agreePrivacyPolicyCheckBox.click();
		continueButton.click();
		return new RegisterPage(driver);
	}
	
	public boolean verifyNewAccountSuccesfulyCreatedMessage() {
		boolean displayStatus = newAccountSuccesfulyCreatedMessage.isDisplayed();
		return displayStatus;
	}

}
