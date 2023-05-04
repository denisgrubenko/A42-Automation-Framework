package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css="button[type='submit']")
    private WebElement submitLoginButtonLocator;
    @FindBy(css="[type='password']")
    private WebElement passwordFieldLocator;
    @FindBy(xpath="//input[@type='email']")
    private WebElement emailFieldLocator;

    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
    }

    public LoginPage clickSubmitButton() {
        getAndClick(submitLoginButtonLocator);
        return this;
    }

    public void isNotSuccess() {
        Assert.assertTrue(submitLoginButtonLocator.isDisplayed());
    }

    public LoginPage enterPassword(String password) {
        inputText(passwordFieldLocator,password);
        return this;
    }

    public LoginPage enterEmail(String email) {
        inputText(emailFieldLocator,email);
        return this;
    }

    public void login(String email, String password) {
        enterEmail(email).enterPassword(password).clickSubmitButton();
    }

    public void login(String email) {
        enterEmail(email).enterPassword("te$t$tudent").clickSubmitButton();
    }

    public void login() {
        enterEmail("denis.grubenko@gmail.com").enterPassword("te$t$tudent").clickSubmitButton();
    }

}
