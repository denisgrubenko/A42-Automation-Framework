import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest {

    @Test(enabled = true)
    public void successfulLoginTest() {
        loginPage.login("demo@class.com", "te$t$tudent");
        profilePage.openProfile();
        profilePage.enterCurrentPassword("te$t$tudent");
        profilePage.enterCurrentEmail("demo@class.com");
        String newName = profilePage.generateRandomName();
        profilePage.enterNewName(newName);
        profilePage.saveProfile();
        basePage.getDriver().navigate().refresh();
        String name = profilePage.getProfileName();
        Assert.assertEquals(newName, name);
    }
}
