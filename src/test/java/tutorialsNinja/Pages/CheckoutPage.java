package tutorialsNinja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	public WebDriver driver;

	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchBoxField;

	@FindBy(xpath = "//button[@type='button' and @class='btn btn-default btn-lg' ]")
	private WebElement searchButton;

	@FindBy(xpath = "//img[@alt='HP LP3065']")
	private WebElement validProductDisplayed;

	@FindBy(id = "button-cart")
	private WebElement addToCartButton;

	@FindBy(id = "cart-total")
	private WebElement itemsButton;

	@FindBy(linkText = "Checkout")
	private WebElement CheckoutLink;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterValidProduct(String validProduct) {
		searchBoxField.sendKeys(validProduct);
	}

	public void clickOnSearchButton() {
		searchButton.click();
	}

	public boolean verifyValidProductPresence() {
		boolean displayStatus = validProductDisplayed.isDisplayed();
		return displayStatus;
	}

	public void clickOnDissplayedProduct() {
		validProductDisplayed.click();
	}

	public void clickOnAddToCartButton() {
		addToCartButton.click();
	}

	public void clickOnItemsButton() {
		itemsButton.click();
	}

	public void clickOnCheckoutLink() {
		CheckoutLink.click();
	}

}