package tutorialsNinja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;

    @FindBy(linkText = "My Account")
    private WebElement myAccountDropdown;

    @FindBy(linkText = "Login")
    private WebElement loginOption;

    @FindBy(id = "input-email")
    private WebElement emailField;

    @FindBy(id = "input-password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@type='submit' and @value='Login']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void combiningTwoActionsToNavigateToLoginPage() {
        myAccountDropdown.click();
        loginOption.click();
    }

    public void enterEmail(String emailText) {
        emailField.sendKeys(emailText);
    }

    public void enterPassword(String passwordText) {
        passwordField.sendKeys(passwordText);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }
}
