import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SongsPage;

public class Homework18 extends BaseTest {

    @Test(enabled = true)
    public void playSong() {

        LoginPage loginPage = new LoginPage(basePage.getDriver());
        HomePage homePage = new HomePage(basePage.getDriver());
        SongsPage songsPage = new SongsPage(basePage.getDriver());

        loginPage.login();
        homePage.goToAllSongs();
        songsPage.clickOnFirstSong();
        homePage.pressPlay();
        homePage.moveMouseToPlayButton();

        Assert.assertTrue(homePage.getPauseButton().isDisplayed());
    }
}
