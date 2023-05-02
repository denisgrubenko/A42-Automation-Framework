import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PlaylistPage;
import pages.SongsPage;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() {

        LoginPage loginPage = new LoginPage(basePage.getDriver());
        HomePage homePage = new HomePage(basePage.getDriver());
        PlaylistPage playlistPage = new PlaylistPage(basePage.getDriver());
        SongsPage songsPage = new SongsPage(basePage.getDriver());
        String namePlaylist = "MyPlaylist";

        loginPage.login();
        playlistPage.deletePlaylist(namePlaylist);
        homePage.clickOnSuccessBanner();
        playlistPage.createPlaylist(namePlaylist);
        homePage.clickOnSuccessBanner();
        homePage.goToAllSongs();
        songsPage.clickOnFirstSong();
        playlistPage.addToMyPlaylist(namePlaylist);

        Assert.assertTrue(homePage.GetIsSuccess().isDisplayed());

    }
}
