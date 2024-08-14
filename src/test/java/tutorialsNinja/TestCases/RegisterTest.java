package tutorialsNinja.TestCases;

//import org.apache.poi.xdgf.util.Util;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import tutorialsNinja.Pages.RegisterPage;
import tutorialsNinja.TestBase.TestBase;
import tutorialsNinja.Utilities.Util;

public class RegisterTest extends TestBase {
	public RegisterTest() throws Exception {
		super();
	}

	public WebDriver driver;
	public RegisterPage registerPage;

	@BeforeMethod
	public void registerSetUp() {
		driver = openingApplicationWithAnyBrowser(prop.getProperty("browser"));
		registerPage = new RegisterPage(driver);
		registerPage = registerPage.dropDownMenuAndRegisterLink();
	}

	@Test(priority = 1)
	public void verifyRegisterWithAllDetails() {
		registerPage = registerPage.combiningMandatoryDetailsToNavigateToAccountSuccessPage(
				dataProp.getProperty("firstname"), dataProp.getProperty("lastname"), Util.emailWithDateTimeStamp(),
				dataProp.getProperty("telephone"), prop.getProperty("validPassword"),
				prop.getProperty("validPassword"));

		registerPage = new RegisterPage(driver);
		Assert.assertTrue(registerPage.verifyNewAccountSuccesfulyCreatedMessage());

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
