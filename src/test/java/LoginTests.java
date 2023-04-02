import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test(enabled = true)
    public void successfulLoginTest() {
        login("demo@class.com", "te$t$tudent");
        WebElement avatar = findElement("a .avatar");
        Assert.assertTrue(avatar.isDisplayed());
    }

    @Test(enabled = true)
    public void wrongPasswordLoginTest() {
        login("demo@class.com", "te$t$tuden");
        WebElement submitLoginButton = findElement("button[type='submit']");
        Assert.assertTrue(submitLoginButton.isDisplayed());
    }

    @Test(enabled = true)
    public void emptyPasswordLoginTest() {
        login("demo@class.com", "");
        WebElement submitLoginButton = findElement("button[type='submit']");
        Assert.assertTrue(submitLoginButton.isDisplayed());
    }

}
