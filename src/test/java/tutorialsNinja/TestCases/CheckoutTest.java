package tutorialsNinja.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import tutorialsNinja.Pages.CheckoutPage;
import tutorialsNinja.TestBase.TestBase;

public class CheckoutTest extends TestBase {
	public WebDriver driver;
	public CheckoutPage checkoutPage;

	public CheckoutTest() throws Exception {
		super();
	}

	@BeforeMethod
	public void checkoutSetUp() {
		driver = openingApplicationWithAnyBrowser(prop.getProperty("browser"));
		checkoutPage = new CheckoutPage(driver);
	}

	@Test(priority = 1)
	public void searchValidProduct() {
		checkoutPage.enterValidProduct(dataProp.getProperty("validProduct"));
		checkoutPage.clickOnSearchButton();
		Assert.assertTrue(checkoutPage.verifyValidProductPresence());
		checkoutPage.clickOnDissplayedProduct();
		checkoutPage.clickOnAddToCartButton();
		checkoutPage.clickOnItemsButton();
		checkoutPage.clickOnCheckoutLink();

	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
}
