import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTests extends BaseTest {

    @Test(enabled = true)
    public void successfulLoginTest() {
        loginPage.login();
        Assert.assertTrue(homePage.GetUserAvatar().isDisplayed());
    }

    @Test(enabled = true)
    public void wrongPasswordLoginTest() {
       loginPage.login("demo@class.com", "te$t$tuden");
       loginPage.isNotSuccess();
    }

    @Test(enabled = true)
    public void emptyPasswordLoginTest() {
        loginPage.login("demo@class.com", "");
        loginPage.isNotSuccess();
    }
}
