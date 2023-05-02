import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PlaylistPage;

public class Homework19 extends BaseTest {

    @Test(enabled = true)
    public void testDeletePlaylist() {

        LoginPage loginPage = new LoginPage(basePage.getDriver());
        HomePage homePage = new HomePage(basePage.getDriver());
        PlaylistPage playlistPage = new PlaylistPage(basePage.getDriver());
        String namePlaylist = "MyPlaylist";

        loginPage.login();
        homePage.GetUserAvatar();
        playlistPage.findCreatePlaylist(namePlaylist);
        playlistPage.deletePlaylist(namePlaylist);
        Assert.assertTrue(homePage.GetIsSuccess().isDisplayed());

    }
}
