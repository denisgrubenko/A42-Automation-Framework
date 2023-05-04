package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import pages.HomePage;
import pages.LoginPage;

public class LoginStepDefinition {

    private WebDriver driver;

    @Given("I open browser")
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        System.out.println(driver);
    }

    @And("I open login page")
    public void iOpenLoginPage() {
        driver.get("https://bbb.testpro.io/");
    }

    @When("I enter email {string}")
    public void iEnterEmail(String arg0) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("denis.grubenko@gmail.com");
    }

    @And("I enter password {string}")
    public void iEnterPassword(String arg0) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPassword("te$t$tudent");
    }

    @And("I submit")
    public void iSubmit() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSubmitButton();
    }

    @Then("I am logged in")
    public void iAmLoggedIn() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.GetUserAvatar().isDisplayed());
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
