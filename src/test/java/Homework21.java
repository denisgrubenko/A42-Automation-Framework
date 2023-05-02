import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PlaylistPage;

public class Homework21 extends BaseTest {

    @Test(priority = 100)
    public void renamePlaylist() {

        LoginPage loginPage = new LoginPage(basePage.getDriver());
        HomePage homePage = new HomePage(basePage.getDriver());
        PlaylistPage playlistPage = new PlaylistPage(basePage.getDriver());
        String namePlaylist = "MyPlaylist";
        WebElement elementMyPlaylist;

        loginPage.login();
        homePage.GetUserAvatar();
        elementMyPlaylist = playlistPage.findCreatePlaylist(namePlaylist);
        String newName = elementMyPlaylist.getText() + 1;
        playlistPage.inputReName(elementMyPlaylist, newName);

        Assert.assertTrue(homePage.GetIsSuccess().isDisplayed());

    }
}
