import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {


    @Test(enabled = true)
    public void successfulLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        Assert.assertTrue(homePage.GetUserAvatar().isDisplayed());
    }

    @Test(enabled = true)
    public void wrongPasswordLoginTest() {
       LoginPage loginPage = new LoginPage(driver);
       loginPage.login("demo@class.com", "te$t$tuden");
       loginPage.isNotSuccess();
    }

    @Test(enabled = true)
    public void emptyPasswordLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("demo@class.com", "");
        loginPage.isNotSuccess();
    }

}
