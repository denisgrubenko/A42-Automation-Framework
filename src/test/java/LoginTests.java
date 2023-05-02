import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test(enabled = true)
    public void successfulLoginTest() {

        LoginPage loginPage = new LoginPage(basePage.getDriver());
        HomePage homePage = new HomePage(basePage.getDriver());

        loginPage.login();
        WebElement av = homePage.GetUserAvatar();
        Assert.assertTrue(av.isDisplayed());

    }

    @Test(enabled = true)
    public void wrongPasswordLoginTest() {

        LoginPage loginPage = new LoginPage(basePage.getDriver());

        loginPage.login("demo@class.com", "te$t$tuden");
        loginPage.isNotSuccess();

    }

    @Test(enabled = true)
    public void emptyPasswordLoginTest() {
        LoginPage loginPage = new LoginPage(basePage.getDriver());

        loginPage.login("demo@class.com", "");
        loginPage.isNotSuccess();
    }
}
