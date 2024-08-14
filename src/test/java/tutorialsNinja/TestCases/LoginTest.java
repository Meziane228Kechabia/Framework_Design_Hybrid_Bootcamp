package tutorialsNinja.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import tutorialsNinja.Pages.LoginPage;
import tutorialsNinja.TestBase.TestBase;

public class LoginTest extends TestBase {
	private WebDriver driver;
	private LoginPage loginPage;

	public LoginTest() throws Exception {
		super();
	}

	@BeforeMethod
	public void loginSetUp() {
		driver = openingApplicationWithAnyBrowser(prop.getProperty("browser"));
		loginPage = new LoginPage(driver);
		loginPage.combiningTwoActionsToNavigateToLoginPage();
	}

	@Test(priority = 1)
	public void loginWithValidCredentials() {
		loginPage.enterEmail(prop.getProperty("validEmail"));
		loginPage.enterPassword(prop.getProperty("validPassword"));
		loginPage.clickOnLoginButton();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
