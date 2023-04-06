import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProfilePage;

public class ProfileTests extends BaseTest {

    @Test(enabled = true)
    public void successfulLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        loginPage.login("demo@class.com", "te$t$tudent");
        profilePage.openProfile();
        profilePage.enterCurrentPassword("te$t$tudent");
        profilePage.enterCurrentEmail("demo@class.com");
        String newName = profilePage.generateRandomName();
        profilePage.enterNewName(newName);
        profilePage.saveProfile();
        driver.navigate().refresh();
        String name = profilePage.getProfileName();
        Assert.assertEquals(newName, name);
    }

}
