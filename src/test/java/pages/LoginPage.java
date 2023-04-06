package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage extends BasePage {


    String submitLoginButtonLocator = "button[type='submit']";
    String passwordFieldLocator = "[type='password']";
    String emailFieldLocator = "//input[@type='email']";

    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
    }

    public WebElement clickSubmitButton() {
        return getAndClick(submitLoginButtonLocator);
    }



    public void isNotSuccess() {
        WebElement submitLoginButton = clickSubmitButton();
        Assert.assertTrue(submitLoginButton.isDisplayed());
    }


    protected void enterPassword(String password) {
        inputText(passwordFieldLocator,password);
    }

    protected void enterEmail(String email) {
        inputText(emailFieldLocator,email);
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickSubmitButton();
    }

    public void login(String email) {
        enterEmail(email);
        enterPassword("te$t$tudent");
        clickSubmitButton();
    }

    public void login() {
        enterEmail("denis.grubenko@gmail.com");
        enterPassword("te$t$tudent");
        clickSubmitButton();
    }


}
